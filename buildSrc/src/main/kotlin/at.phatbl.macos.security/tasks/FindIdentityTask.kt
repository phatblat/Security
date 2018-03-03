package at.phatbl.macos.security.tasks

/**
 * Lists code signing identities on the system.
 */
open class FindIdentityTask: SecurityExec() {
    init {
        description = "Lists code signing identities."
        command = "security find-identity -p codesigning"
    }
}