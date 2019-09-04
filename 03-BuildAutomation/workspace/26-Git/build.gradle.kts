plugins {
    java
    id("org.danilopianini.git-sensitive-semantic-versioning") version "0.2.2"
}
gitSemVer {
    version = computeGitSemVer()
}
tasks.register("printVersion") {
    doLast {
        println("The project is at version: ${project.version}")
    }
}
