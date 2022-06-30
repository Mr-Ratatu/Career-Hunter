plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        create("BuildManager") {
            id = "com.work.found.plugin"
            implementationClass = "BuildManager"
            version = "1.0.0"
        }
    }
}

repositories {
    mavenCentral()
}