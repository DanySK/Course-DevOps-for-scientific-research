val task0 by tasks.register("task0") {
    doLast { print("0 ") }
}
(1..100).forEach { n ->
    tasks.register("task$n") {
        dependsOn ("task${n-1}")
        doLast { print("$n ") }
    }
}
