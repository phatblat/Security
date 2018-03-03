package at.phatbl.macos.security.tasks

import at.phatbl.shellexec.ShellExec

abstract class SecurityExec: ShellExec() {
    init {
        group = "🔐  Security"
    }
}
