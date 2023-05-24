plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.lunabee.leaguewiki.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.lunabee.leaguewiki.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
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

dependencies {
    implementation(project(":shared"))
    // Compose
    implementation(AndroidX.compose.ui)
    implementation(AndroidX.Activity.compose)
    implementation(AndroidX.compose.foundation)
    implementation(AndroidX.compose.material)
    implementation(Google.accompanist.systemUiController)
    implementation(AndroidX.navigation.compose)
    implementation(COIL.compose)
    implementation(AndroidX.lifecycle.runtime.compose)
    debugImplementation(AndroidX.compose.ui.tooling)
    implementation(AndroidX.compose.ui.toolingPreview)
    implementation(Koin.core)
    implementation(Koin.android)
    implementation(Koin.compose)
    implementation(Koin.navigation)
}