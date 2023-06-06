plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("com.google.devtools.ksp")
    id("com.rickclephas.kmp.nativecoroutines") version "1.0.0-ALPHA-10"
    id("io.realm.kotlin") version "1.9.0"
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

kotlin {
    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(KotlinX.coroutines.core)
                implementation(Ktor.client.core)
                implementation(Ktor.client.serialization)
                implementation("io.ktor:ktor-serialization-kotlinx-json:_")
                implementation(Ktor.client.contentNegotiation)
                implementation(Ktor.client.logging)
                implementation("io.realm.kotlin:library-base:_")

                api(project(":domain"))
                implementation(project(":repository"))
                implementation(project(":remote"))
                implementation(project(":locale"))
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Ktor.client.android)

                // Hilt.
                implementation(Google.dagger.hilt.android)
                configurations.get("kapt").dependencies.add(
                    org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency(
                        "com.google.dagger",
                        "hilt-android-compiler",
                        "_"
                    )
                )
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Koin.core)
                implementation(Ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "com.lunabee.leaguewiki"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmToolchain(17)
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}


kotlin.sourceSets.all {
    languageSettings.optIn("kotlin.experimental.ExperimentalObjCName")
}

afterEvaluate {
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(JavaVersion.VERSION_17.toString()))
        }
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}