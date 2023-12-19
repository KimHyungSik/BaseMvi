plugins {
    id("android.library.core")
}

android {
    namespace = "com.mvi.skeleton.library.pref"
}

dependencies {
    implementation(libs.androidx.data.store)
}