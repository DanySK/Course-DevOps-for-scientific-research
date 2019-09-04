plugins {
    java
    checkstyle
    jacoco
    `build-dashboard`
    id("com.gradle.build-scan") version "2.4.1"
}
repositories { mavenCentral() }
dependencies {
    testImplementation("junit:junit:4.12")
}
buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
}
