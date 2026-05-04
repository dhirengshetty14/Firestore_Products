plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.projs.templatesetup"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.projs.templatesetup"
        minSdk = 24
        targetSdk = 36
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
    buildFeatures {
        compose = true
    }
}

dependencies {
    // ---- Core + lifecycle ----
    implementation(libs.androidx.core.ktx)
    implementation(libs.bundles.lifecycle)

    // ---- Compose (BOM manages all compose-* versions) ----
    implementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // ---- Hilt (dependency injection) ----
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    // ---- Room (local persistence) ----
    implementation(libs.bundles.room)
    ksp(libs.room.compiler)

    // ---- Networking: Retrofit + OkHttp + Moshi ----
    implementation(libs.bundles.network)

    // ---- Coroutines + Flow ----
    implementation(libs.bundles.coroutines)

    // ---- Local storage (DataStore, replaces SharedPreferences) ----
    implementation(libs.androidx.datastore.preferences)

    // ---- Splash screen (Android 12+ compat API) ----
    implementation(libs.androidx.core.splashscreen)

    // ---- Logging ----
    implementation(libs.timber)

    // ---- Image loading ----
    implementation(libs.glide)
    implementation(libs.picasso)

    // ---- Unit tests ----
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)

    // ---- Android / Instrumentation tests ----
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
}
