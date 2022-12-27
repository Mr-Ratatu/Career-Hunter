object Dependencies {

    // https://kotlinlang.org/docs/home.html
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlinVersion}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlinVersion}"

    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"

    // https://material.io/develop/android
    const val material = "com.google.android.material:material:${Versions.materialVersion}"

    // https://developer.android.com/training/testing/local-tests
    const val junit4 = "junit:junit:${Versions.junit4Version}"
    const val junit5 = "org.junit.jupiter:junit-jupiter:${Versions.junit5Version}"
    const val junit5Engine = "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5Version}"
    const val junitExtensions = "androidx.test.ext:junit:${Versions.junitExtensionsVersion}"
    const val junitExtensionsKtx = "androidx.test.ext:junit-ktx:${Versions.junitExtensionsVersion}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito_version}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito_version}"

    // https://developer.android.com/training/testing/espresso
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"

    // https://developer.android.com/guide/navigation/navigation-getting-started
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"

    // https://developer.android.com/topic/libraries/architecture/workmanager
    const val workManager = "androidx.work:work-runtime-ktx:${Versions.workManager}"

    // https://square.github.io/retrofit/
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    // https://square.github.io/okhttp/
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
    const val androidArchCoreTest = "androidx.arch.core:core-testing:${Versions.androidArchCoreTest}"

    // https://developer.android.com/kotlin/coroutines
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"

    // https://coil-kt.github.io/coil/
    const val coil = "io.coil-kt:coil:${Versions.coilVersion}"

    // https://developer.android.com/training/data-storage/room
    const val room = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.roomVersion}"

    // https://developer.android.com/topic/libraries/architecture/viewmodel
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"

    // https://developer.android.com/topic/libraries/architecture/livedata
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0"

    //https://developer.android.com/guide/components/activities/activity-lifecycle
    const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensionVersion}"
    const val lifecycle = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"
    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"

    // https://developer.android.com/training/dependency-injection/dagger-android
    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerKapt = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"

    // https://developer.android.com/guide/fragments
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"

    // https://github.com/airbnb/lottie-android
    const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"

    // https://github.com/JakeWharton/timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"

    // https://developer.android.com/reference/kotlin/androidx/recyclerview/widget/RecyclerView
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    // https://firebase.google.com/docs/android/setup
    const val firebaseCore = "com.google.firebase:firebase-core:21.0.0"
    const val firebaseBom = "com.google.firebase:firebase-bom:30.2.0"
    const val firebaseAuth = "om.google.firebase:firebase-auth-ktx"
    const val firebaseAuthService = "com.google.android.gms:play-services-auth:20.2.0"
}