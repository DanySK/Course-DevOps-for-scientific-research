tasks.register("projectName") {
    doLast {
        println("The project is named \"${project.name}\"")
    }
}
