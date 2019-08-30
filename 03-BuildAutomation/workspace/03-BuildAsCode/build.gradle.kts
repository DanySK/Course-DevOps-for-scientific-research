val hello by tasks.register("hello") {
    doLast {
        println("Hello world!")
    }
} 
hello.doFirst {
    (0..10).reversed().forEach { print("$it ") }
    println()
}
hello.doLast {
    (0..10).forEach { print("$it ") }
    println()
}
