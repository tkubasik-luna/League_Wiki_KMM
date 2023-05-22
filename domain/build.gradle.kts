plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    iosX64()
    iosSimulatorArm64()
    iosArm32()
    iosArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
            }
        }
    }
}