package tasks

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

class ManageApk: DefaultTask() {
    @TaskAction
    fun moveFile() {
        val previousPath = "/outputs/apk/release/"
        val targetPath = "/Users/renat/Downloads/downloads"
        val newApkName = "CareerHunter.apk"
        File("${project.buildDir.absoluteFile}/$previousPath/$newApkName").let { sourceFile ->
            try {
                sourceFile.copyTo(File("$targetPath/$newApkName"))
            } catch (e: Exception) {
                e.printStackTrace()
                val folder = File(targetPath)
                folder.mkdir()
            } finally {
                sourceFile.delete()
            }
        }
    }
}