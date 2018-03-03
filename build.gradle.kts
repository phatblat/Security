/*
 * build.gradle.kts
 * Security
 */

/* -------------------------------------------------------------------------- */
// Imports must be before buildscript & plugins
/* -------------------------------------------------------------------------- */

import at.phatbl.macos.security.tasks.FindIdentityTask
import at.phatbl.macos.security.tasks.ListKeychainsTask
import at.phatbl.shellexec.ShellExec

/* -------------------------------------------------------------------------- */
// Properties
/* -------------------------------------------------------------------------- */

ext {
    group = "🔐 Security"
}

/* -------------------------------------------------------------------------- */
// Build Script
/* -------------------------------------------------------------------------- */

/*
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath("at.phatbl:shellexec:+")
    }
}
*/

/*plugins {
    id("at.phatbl.shellexec") version "1.1.0"
}*/

val removeBatchFile by tasks.creating(Delete::class) { delete("gradlew.bat") }

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "4.6"
        distributionType = Wrapper.DistributionType.ALL
        finalizedBy(removeBatchFile)
    }

    "listKeychains"(ListKeychainsTask::class) {
    }

    "findIdentity"(FindIdentityTask::class) {
    }
}
