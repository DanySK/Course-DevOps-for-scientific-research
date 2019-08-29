plugins {
    application
    kotlin("jvm") version "1.3.50"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.omertron:thetvdbapi:[1.6, 1.7]")
    runtimeOnly("javax.xml.ws:jaxws-api:+")
}

application {
    mainClassName = "it.unibo.ci.PrintSeriesKt"
}
