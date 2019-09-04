val runAll by tasks.register("runAll") {
    doLast { println("Done.") }
}
// Evaluate sub-projects first
subprojects.forEach { rootProject.evaluationDependsOn(it.path) }
// Make runAll dependent on every subproject task
subprojects.forEach { sub ->
    sub.tasks
        .filter { it.group == "Greetings" }
        .forEach { runAll.dependsOn(it) }
}
