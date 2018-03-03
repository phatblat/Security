package at.phatbl.macos.security.tasks

import org.gradle.api.tasks.Input

/**
 * Lists keychains on the search list.
 */
open class ListKeychainsTask: SecurityExec() {
    @Input
    var domain = "user"

    init {
        description = "Displays the keychain search list."
        command = "security list-keychains -d $domain"
    }
}
