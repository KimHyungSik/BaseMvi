plugins {
    id("android.library.core")
}

android {
    namespace = "com.example.mviskeletonapp.data"
}

dependencies {
    implementation(project(":domain"))
}