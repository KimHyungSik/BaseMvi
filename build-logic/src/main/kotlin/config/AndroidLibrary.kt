package config

import gradle.kotlin.dsl.accessors._a568f78b412045bc377fc4283b656e34.implementation
import libs
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidLibrary() {
    val libs = extensions.libs
    with(pluginManager) {
        apply("com.android.library")
        apply("kotlin-android")
        apply("kotlinx-serialization")
    }

    configureKotlinAndroid()

    dependencies {
        add("implementation" , libs.findLibrary("okhttp").get())
        add("implementation", libs.findLibrary("retrofit").get())
        add("implementation", libs.findLibrary("retrofit.kotlin.serialization.converter").get())
    }

}