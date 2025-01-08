plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.jetpackjourney"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.jetpackjourney"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core libraries
    implementation(libs.androidx.core.ktx) // AndroidX Core KTX for Kotlin extensions
    implementation(libs.androidx.lifecycle.runtime.ktx) // Lifecycle runtime for observing lifecycle events
    implementation(libs.androidx.activity.compose) // Compose support for activities

    // Jetpack Compose core libraries
    implementation(platform(libs.androidx.compose.bom)) // BOM for managing Compose versions
    implementation(libs.androidx.ui) // Compose UI toolkit
    implementation(libs.androidx.ui.graphics) // Compose graphics utilities
    implementation(libs.androidx.ui.tooling.preview) // Tooling support for UI previews in Compose
    implementation(libs.androidx.material3) // Material Design 3 components for Compose

    // Navigation
    implementation(libs.androidx.navigation.compose) // Jetpack Compose navigation library

    // Networking with Retrofit
    implementation(libs.retrofit) // Retrofit library for making HTTP requests
    implementation(libs.retrofit.converter.gson) // Gson converter for parsing JSON responses
    implementation(libs.okhttp.logging.interceptor) // Logging Interceptor for OkHttp
    implementation(libs.coil.compose) // Coil library for Jetpack Compose


    // Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.android) // Coroutines support for Android

    // ViewModel integration with Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose) // Compose ViewModel integration

    // Shimmer effect for loading placeholders (optional)
    implementation(libs.compose.shimmer) // Library for shimmer loading animations

    // Unit testing
    testImplementation(libs.junit) // JUnit for unit testing

    // Instrumentation testing
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit extensions for testing
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Compose BOM for test dependencies
    androidTestImplementation(libs.androidx.ui.test.junit4) // Compose JUnit4 testing utilities

    // Debugging tools
    debugImplementation(libs.androidx.ui.tooling) // Tooling for debugging and inspecting Compose UI
    debugImplementation(libs.androidx.ui.test.manifest) // Compose test manifest for debugging
}