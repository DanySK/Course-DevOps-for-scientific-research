plugins {
    java
    scala
    groovy
    // External plugin:
    kotlin("jvm") version "1.3.50"
}
repositories { mavenCentral() }

dependencies {
    implementation("org.codehaus.groovy:groovy:2.3.7")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.50")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.3.50")
    implementation("org.scala-lang:scala-library:2.12.2")
}
