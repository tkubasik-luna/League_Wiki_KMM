plugins {
    kotlin("multiplatform")
    id("io.realm.kotlin") version "1.9.0"
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
                implementation("io.realm.kotlin:library-base:_")


                implementation(project(":domain"))
                implementation(project(":repository"))
            }
        }
    }
}