tasks.register("projectName") {
    group = "Informational"
    description = "Prints the current project name"
    doLast {
        println("The project is named \"${project.name}\"")
    }
}
