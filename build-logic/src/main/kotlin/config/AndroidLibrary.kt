package config

import org.gradle.api.Project

internal fun Project.configureAndroidLibrary() {
    with(pluginManager) {
        apply("com.android.library")
        apply("kotlin-android")
    }

    configureKotlinAndroid()
}