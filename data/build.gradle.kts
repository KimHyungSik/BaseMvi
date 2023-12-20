plugins {
    id("android.library.core")
}

android {
    namespace = "com.mvi.skeleton.data"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":library:pref"))
}