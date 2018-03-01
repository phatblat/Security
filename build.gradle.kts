/*
 * build.gradle.kts
 * Security
 */


/* -------------------------------------------------------------------------- */
// Build Script
/* -------------------------------------------------------------------------- */

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
