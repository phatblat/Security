package at.phatbl.macos.security

import at.phatbl.macos.security.tasks.FindIdentityTask
import at.phatbl.macos.security.tasks.ListKeychainsTask
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Plugin which set up the various security command tasks.
 */
class SecurityPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.create("listKeychains", ListKeychainsTask::class.java)
        project.tasks.create("findIdentity", FindIdentityTask::class.java)
    }
}
