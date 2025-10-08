plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)

}

android {
    namespace = "com.example.project"
    compileSdk = 36


    defaultConfig {
        applicationId = "com.example.project"
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


}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // ✅ Firebase BoM (จัดการเวอร์ชันให้อัตโนมัติ)
    implementation(platform("com.google.firebase:firebase-bom:${libs.versions.firebaseBom.get()}"))


    // ✅ Firebase libraries (ไม่ต้องใส่เวอร์ชัน)
    implementation(libs.firebase.auth)       // สำหรับ Login
    implementation(libs.firebase.database)   // Realtime Database
    implementation(libs.firebase.firestore)  // Firestore
    implementation(libs.firebase.storage)    // Storage
    implementation(libs.firebase.analytics)  // Analytics
    implementation(libs.okhttp)
    implementation(libs.mpandroidchart)
    implementation(libs.anychart.android)
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.13.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    implementation ("androidx.legacy:legacy-support-v4:1.0.0")



    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}