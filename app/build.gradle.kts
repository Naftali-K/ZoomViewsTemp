plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.zoomviewstemp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.zoomviewstemp"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.otaliastudios:zoomlayout:1.9.0")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("com.github.MikeOrtiz:TouchImageView:1.4.1")
    implementation("com.github.chrisbanes:PhotoView:2.3.0")
    implementation("com.jsibbold:zoomage:1.3.1")
    implementation("io.github.imablanco:zoomy:1.0.0")
    implementation("com.google.android.exoplayer:exoplayer:2.15.0")
}