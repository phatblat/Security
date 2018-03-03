/*
 * build.gradle.kts
 * Security
 */

/* -------------------------------------------------------------------------- */
// Imports must be before buildscript & plugins
/* -------------------------------------------------------------------------- */

import at.phatbl.macos.security.tasks.FindIdentityTask
import at.phatbl.macos.security.tasks.ListKeychainsTask
import at.phatbl.macos.security.SecurityPlugin

/* -------------------------------------------------------------------------- */
// Properties
/* -------------------------------------------------------------------------- */

ext {
    group = "🔐 Security"
}

/* -------------------------------------------------------------------------- */
// Build Script
/* -------------------------------------------------------------------------- */

apply {
    plugin(SecurityPlugin::class.java)
}

val removeBatchFile by tasks.creating(Delete::class) { delete("gradlew.bat") }

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "4.6"
        distributionType = Wrapper.DistributionType.ALL
        finalizedBy(removeBatchFile)
    }
}
