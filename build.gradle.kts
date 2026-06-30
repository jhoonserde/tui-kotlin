plugins {
    kotlin("jvm") version "2.3.0"
}

group = "org.trashcollection01.tuikotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    
    from({
        configurations.runtimeClasspath.get().filter {
            it.name.endsWith("jar") }.map { zipTree(it)
        }
    })
}
