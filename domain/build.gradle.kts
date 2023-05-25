plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    iosX64()
    iosSimulatorArm64()
    iosArm64()

    sourceSets {
        commonMain {
            dependencies {
                implementation(KotlinX.coroutines.core)
            }
        }
    }
}