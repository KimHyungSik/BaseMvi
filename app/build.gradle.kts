plugins {
    id("android.application.core")
}

android {
    namespace = "com.example.mviskeletonapp"
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":feature:main"))

    implementation(libs.okhttp)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
}