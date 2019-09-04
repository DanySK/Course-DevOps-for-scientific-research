plugins {
    java
    checkstyle
    jacoco
    `build-dashboard`
}

repositories { mavenCentral() }

dependencies {
    testImplementation("junit:junit:4.12")
}
