plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.weatherappdagger"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.weatherappdagger"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


//        productFlavors {
//            create("appDevelopment").apply {
//                applicationIdSuffix = ".develop"
//                resValue("string", "app_name", "WeatherAppDagger")
//                // Добавьте ваши константы здесь
//                buildConfigField("String", "BASE_URL", "\"https://api.weatherapi.com/v1/\"")
//                buildConfigField("String", "FORECAST_END_POINT", "\"forecast.json\"")
//                buildConfigField("String", "API_KEY", "\"b389f319d27e4726b6c145920242903\"")
//            }
//        }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
     buildConfig = true
     dataBinding = true
    }
   viewBinding {
       enable = true
   }
}

dependencies {
    // ========================= DAGGER =========================
    implementation(libs.dagger)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.dagger.compiler)

    // ========================= NETWORK =========================
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.library)

    // ========================= COIL =========================
    implementation(libs.coil)
    implementation(libs.coil.svg)

    // ========================= GLIDE =========================
    implementation(libs.glide)
    implementation(libs.annotations)
    implementation(libs.okhttp3.integration)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.compiler)

    // ========================= CICERONE =========================
//    implementation(libs.cicerone)
    implementation(libs.terrakok.cicerone)

    // ========================= JETPACK =========================
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
}
