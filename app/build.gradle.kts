plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.training.login_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.training.login_app"
        minSdk = 24
        targetSdk = 35
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
}

dependencies {
    dependencies {
        implementation ("androidx.recyclerview:recyclerview:1.4.0")
        // For control over item selection of both touch and mouse driven selection
        implementation ("androidx.recyclerview:recyclerview-selection:1.1.0")
    }
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}