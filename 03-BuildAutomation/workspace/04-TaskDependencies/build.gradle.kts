val hello by tasks.register("hello") {
    doLast { println("Hello world!") }
}
tasks.register("prepare") {
    doLast { println("Preparing environment") }
}
hello.dependsOn("prepare") // Specify dependency out of task

tasks.register("complete") { // At task creation
    dependsOn(hello)
    doLast {
        println("Completed.")
    }
}
