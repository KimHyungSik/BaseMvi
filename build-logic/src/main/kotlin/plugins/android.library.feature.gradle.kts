import config.configureAndroidCompose
import config.configureAndroidLibrary
import config.configureAndroidTest
import config.configureHiltAndroid
import config.configureKotlinTest
import gradle.kotlin.dsl.accessors._a568f78b412045bc377fc4283b656e34.implementation

configureAndroidLibrary()
configureAndroidCompose()
configureAndroidTest()
configureKotlinTest()
configureHiltAndroid()

dependencies{
    implementation(extensions.libs.findLibrary("okhttp"))
    implementation(extensions.libs.findLibrary("retrofit"))
    implementation(extensions.libs.findLibrary("retrofit.converter.gson"))
}