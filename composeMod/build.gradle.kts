plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "app.compose.composeMod"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

//    implementation("androidx.activity:activity-compose:1.9.0")
//    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
//    implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
//    implementation("androidx.compose.ui:ui-test-junit4")
//    implementation("androidx.compose.material3:material3:1.2.1")
//    implementation("androidx.lifecycle:lifecycle-runtime-compose-android:2.8.7")
//    implementation("androidx.navigation:navigation-runtime-ktx:2.8.5")
//    implementation("androidx.navigation:navigation-compose:2.8.5")




//    // Compose
//    implementation(platform(libs.compose.bom))
//    implementation(libs.compose.navigation)
//    implementation(libs.bundles.compose)
////    implementation("androidx.compose.compiler:compiler:1.5.0")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)








//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)



//    //implementation 'androidx.core:core-ktx:1.13.1'
//    implementation platform('org.jetbrains.kotlin:kotlin-bom:1.8.0')
//    //implementation 'androidx.appcompat:appcompat:1.7.0'
//    //implementation 'com.google.android.material:material:1.12.0'
//
//    //implementation("androidx.activity:activity-compose:1.9.0")
//    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
//    //implementation("androidx.compose.ui:ui")
//    implementation("androidx.compose.ui:ui-graphics")
//    implementation("androidx.compose.ui:ui-tooling")
//    implementation("androidx.compose.ui:ui-tooling-preview")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
//    implementation("androidx.compose.ui:ui-test-junit4")
//    implementation("androidx.compose.material3:material3:1.2.1")
//    implementation("androidx.fragment:fragment-ktx:1.8.1")
}