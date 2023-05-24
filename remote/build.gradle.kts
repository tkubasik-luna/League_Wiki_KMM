plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
}

kotlin {
    jvm()
    iosX64()
    iosSimulatorArm64()
    iosArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":domain"))
                implementation(project(":repository"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
                implementation("io.ktor:ktor-client-core:2.3.0")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
            }
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}