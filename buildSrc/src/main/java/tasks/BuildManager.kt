package tasks

import org.gradle.api.Plugin
import org.gradle.api.Project

class BuildManager: Plugin<Project> {

    override fun apply(target: Project) {
        target.tasks.register("moveFile", ManageApk::class.java) {
            dependsOn("build")
        }
    }
}