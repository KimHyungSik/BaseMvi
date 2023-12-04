plugins {
    id("android.library.feature")
}

android {
    namespace = "com.example.mviskeletonapp.feature.main"
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":library:mvi"))
    implementation(project(":library:account"))
}

