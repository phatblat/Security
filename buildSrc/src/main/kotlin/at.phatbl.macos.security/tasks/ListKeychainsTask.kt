package at.phatbl.macos.security.tasks

import at.phatbl.shellexec.ShellExec

/**
 * Lists user keychains on the system.
 */
open class ListKeychainsTask: ShellExec() {
    init {
        command = "security list-keychains -d user"
    }
}
