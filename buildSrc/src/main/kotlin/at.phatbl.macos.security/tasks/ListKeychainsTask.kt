package at.phatbl.macos.security.tasks
/**
 * Lists user keychains on the system.
 */
open class ListKeychainsTask: SecurityExec() {
    init {
        description = "Lists user keychains."
        command = "security list-keychains -d user"
    }
}
