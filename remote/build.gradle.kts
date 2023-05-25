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
                implementation(KotlinX.coroutines.core)
                implementation(Ktor.client.core)
                implementation(Ktor.client.serialization)
                implementation(KotlinX.serialization.json)
            }
        }
    }
}