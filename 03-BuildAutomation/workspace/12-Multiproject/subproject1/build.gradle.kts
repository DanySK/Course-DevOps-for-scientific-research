tasks.register("welcome") {
    group = "Greetings"
    doLast { println("${project.name} welcomes you") }
}
