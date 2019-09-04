tasks.register("hello") {
    group = "Greetings"
    doLast { println("Hello from ${project.name}") }
}
