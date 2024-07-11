plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
    id("kotlin-kapt")

}

android {
    namespace = "com.example.compasstakehome"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.compasstakehome"
        minSdk = 29
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    viewBinding {
        enable = true
    }
}

dependencies {
    val vmVersion = "2.8.3"
    val roomVersion = "2.6.1"
    val retrofitVersion = "2.9.0"
    val hiltVersion = "2.46.1"

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Activity
    implementation ("androidx.activity:activity-ktx:1.9.0")
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$vmVersion")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$vmVersion")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    // Corrutina
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
    // Room
    implementation ("androidx.room:room-ktx:$roomVersion")
    kapt ("androidx.room:room-compiler:$roomVersion")
    // gson
    implementation ("com.google.code.gson:gson:2.10.1")
    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-scalars:$retrofitVersion")
    // DaggerHlt
    implementation ("com.google.dagger:hilt-android:$hiltVersion")
    annotationProcessor ("com.google.dagger:hilt-compiler:$hiltVersion")
    kapt ("com.google.dagger:hilt-compiler:$hiltVersion")

    testImplementation("junit:junit:4.13.2")
    testImplementation("io.mockk:mockk:1.12.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}