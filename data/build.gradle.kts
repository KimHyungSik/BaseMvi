plugins {
    id("android.library.core")
}

android {
    namespace = "com.example.mviskeletonapp.data"
}

dependencies {
    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
}