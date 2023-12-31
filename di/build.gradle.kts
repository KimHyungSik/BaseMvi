plugins {
    id("android.library.core")
}

android {
    namespace = "com.mvi.skeleton.data"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":library:pref"))
    implementation(project(":library:account"))

    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization.converter)
}