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
buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
}
