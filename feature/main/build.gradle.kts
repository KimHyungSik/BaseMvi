plugins {
    id("android.library.feature")
}

android {
    namespace = "com.example.mviskeletonapp.feature.main"
}

dependencies {
    implementation(project(":di"))
    implementation(project(":domain"))
    implementation(project(":library:mvi"))
    implementation(project(":library:account"))
    implementation(project(":library:pref"))
}

