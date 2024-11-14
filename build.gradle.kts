plugins {
    kotlin("jvm") version "2.0.21"
}

group = "com.gilpereda.examples"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey:1.1.1")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-kotlin:1.1.1")
    testImplementation("com.navercorp.fixturemonkey:fixture-monkey-jakarta-validation:1.1.1")
    testImplementation("org.assertj:assertj-core:3.25.3")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
