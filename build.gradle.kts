/*
 * build.gradle.kts
 * Security
 */


/* -------------------------------------------------------------------------- */
// Imports must be before buildscript & plugins
/* -------------------------------------------------------------------------- */

import at.phatbl.shellexec.ShellExec

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

plugins {
    id("at.phatbl.shellexec") version "1.1.0"
}


val removeBatchFile by tasks.creating(Delete::class) { delete("gradlew.bat") }

tasks {
    "wrapper"(Wrapper::class) {
        gradleVersion = "4.6"
        distributionType = Wrapper.DistributionType.ALL
        finalizedBy(removeBatchFile)
    }
}

/* -------------------------------------------------------------------------- */
// Ad Hoc Tasks
/* -------------------------------------------------------------------------- */

/*
list-keychains [-h] [-d user|system|common|dynamic] [-s [keychain...]]
Display or manipulate the keychain search list.

-d user|system|common|dynamic
        Use the specified preference domain.
-s       Set the search list to the specified keychains.
*/
val listKeychains by tasks.creating(ShellExec::class) {
    command = "security list-keychains -d user"
}
