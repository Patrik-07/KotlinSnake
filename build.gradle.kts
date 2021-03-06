plugins {
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.serialization") version "1.4.31"
    application
}

repositories {
    mavenCentral()
}

application {
    mainClassName = "patrik07.snake.SnakeApp"
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("no.tornado:tornadofx:1.7.20")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    testImplementation(kotlin("test-junit"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}