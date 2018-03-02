/*
 * build.gradle.kts
 * Security/buildSrc
 */

plugins {
    `kotlin-dsl`
    id("org.jetbrains.kotlin.jvm") version "1.2.30"
}

repositories {
    jcenter()
}

dependencies {
    compile("at.phatbl:shellexec:1.1.0")
}
