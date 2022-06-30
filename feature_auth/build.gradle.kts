plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 24
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "WEB_CLIENT_ID", "\"1:111543080726:android:2be7a38d599a83e377e237\"")
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
}

dependencies {

    implementation(project(configs.Modules.core_base))
    implementation(project(configs.Modules.core_view))
    implementation(project(configs.Modules.core_api))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    platform("com.google.firebase:firebase-bom:30.1.0")

    // DI
    implementation(configs.Dependencies.dagger)
    kapt(configs.Dependencies.daggerKapt)

    // Coroutines
    implementation(configs.Dependencies.coroutinesAndroid)
    implementation(configs.Dependencies.lifecycleRuntime)
    implementation(configs.Dependencies.coroutinesCore)
    implementation(configs.Dependencies.coil)

    // Firebase
    implementation("com.google.firebase:firebase-auth:21.0.5")
    implementation("com.google.firebase:firebase-common-ktx:20.1.1")
    implementation("com.google.android.gms:play-services-auth:20.2.0")
}