plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.work.found.work.articles.impl"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        buildConfigField("String", "ARTICLES_ASSET_NAME", "\"articles.json\"")
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

    implementation(project(Modules.core_base))
    implementation(project(Modules.core_view))
    implementation(project(Modules.core_api))
    implementation(project(Modules.routing))
    implementation(project(Modules.articles_api))

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // DI
    implementation(Dependencies.dagger)
    kapt(Dependencies.daggerKapt)

    // Coroutines
    implementation(Dependencies.coroutinesAndroid)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.coroutinesCore)

    // UI
    implementation(Dependencies.coil)

    implementation(Dependencies.viewModel)
    implementation(Dependencies.lifecycleRuntime)
    implementation(Dependencies.fragmentKtx)
    implementation(Dependencies.gson)
}