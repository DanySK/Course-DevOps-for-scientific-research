#!/usr/bin/env kscript
import java.io.File
import java.io.PrintWriter
import java.nio.file.Files
import kotlin.io.walk
import kotlin.io.createTempFile
import kotlin.system.exitProcess

object Constants {
    const val pdfLatex = "pdflatex -synctex=1 -interaction=nonstopmode -halt-on-error -shell-escape "
}

File(".").walk(FileWalkDirection.TOP_DOWN).forEach { file ->
    when {
        file.name == "${file.parentFile?.name}.tex" -> file.buildTex()
        file.name == "build.sh" -> "source build.sh".runScript(file.parentFile)
    }
}

fun File.buildTex() {
    val compileTex = Constants.pdfLatex + name
    println("Compiling $this")
    parentFile.script(compileTex)
    val auxFiles = parentFile.listFiles { _, fileName ->
        fileName.endsWith(".aux") && fileName.startsWith(name.substringBeforeLast("."))
    }
    if (auxFiles.isNotEmpty()) {
        if (auxFiles.size == 1) {
            val aux = auxFiles.first()
            if (Files.lines(aux.toPath()).anyMatch { it.contains("""\citation""") }) {
                with (parentFile) {
                    script("bibtex ${aux.name}")
                    script(compileTex)
                }
            } else {
                println("Aux file $aux does not contain any citation.")
            }
        } else {
            println("multiple auxiliary files: $auxFiles")
        }
    }
}

fun File.script(script: String) = script.runScript(this)

fun String.runScript(from: File = File(System.getProperty("user.dir"))) {
    val shell = ProcessBuilder("bash")
        .directory(from)
        .redirectError(ProcessBuilder.Redirect.INHERIT)
        .redirectOutput(createTempFile())
        .start()
    shell.inputStream.copyTo(System.out)
    PrintWriter(shell.outputStream).use {
        println("RUNNING in $from:\n$this");
        it.println("$this \n exit")
    }
    shell.waitFor().also {
        if (it != 0) {
            exitProcess(it)
        }
    }
}
