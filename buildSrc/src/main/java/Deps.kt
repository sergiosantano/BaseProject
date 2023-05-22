/**
 * To define dependencies
 */
object Deps {

    // Coroutines
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"

    // AndroidX
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val ktxCore = "androidx.core:core-ktx:${Versions.ktx_core}"
    val ktxLifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ktx_lifecycle}"
    val ktxViewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ktx_lifecycle}"
    val ktxRoom = "androidx.room:room-ktx:${Versions.room}"
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val navigation = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val ktxNavigation = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val splashScreen = "androidx.core:core-splashscreen:${Versions.splashScreen}"

    // UI
    val material = "com.google.android.material:material:${Versions.material}"

    // Glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Koin
    val koin = "io.insert-koin:koin-android:${Versions.koin}"

    // Network
    val okHttp = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    // Tests
    val junit = "junit:junit:${Versions.junit}"
    val testCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    val junitExtensions = "androidx.test.ext:junit:${Versions.junitExtensions}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

}