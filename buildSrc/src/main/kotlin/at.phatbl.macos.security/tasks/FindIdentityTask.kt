package at.phatbl.macos.security.tasks

import at.phatbl.shellexec.ShellExec

/**
 * Lists code signing identities on the system.
 */
open class FindIdentityTask: ShellExec() {
    init {
        command = "security find-identity -p codesigning"
    }
}