/**
 * Precompiled [android.application.core.gradle.kts][Android_application_core_gradle] script plugin.
 *
 * @see Android_application_core_gradle
 */
public
class Android_application_corePlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Android_application_core_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java, org.gradle.api.Project::class.java)
                .newInstance(target, target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
