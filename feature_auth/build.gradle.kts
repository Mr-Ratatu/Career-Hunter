plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 24
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField(
            "String",
            "WEB_CLIENT_ID",
            "\"111543080726-duh4d49mhv6eh9cg7958vp13ub3m1901.apps.googleusercontent.com\""
        )
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(Modules.core_base))
    implementation(project(Modules.core_view))
    implementation(project(Modules.core_api))
    implementation(project(Modules.routing))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    platform("com.google.firebase:firebase-bom:30.1.0")

    // DI
    implementation(Dependencies.dagger)
    kapt(Dependencies.daggerKapt)

    // Coroutines
    implementation(Dependencies.coroutinesAndroid)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coil)

    // Firebase
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")
    implementation("com.google.firebase:firebase-auth:21.1.0")
    implementation("com.google.firebase:firebase-common-ktx:20.2.0")
    implementation("com.google.android.gms:play-services-auth:20.3.0")
}