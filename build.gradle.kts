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

/*`
find-identity [-h] [-p policy] [-s string] [-v] [keychain...]
Find an identity (certificate + private key) satisfying a given policy. If no policy arguments are provided, the X.509 basic policy is assumed. If no keychain arguments are provided, the default search list is used.

Options:
-p policy       Specify policy to evaluate (multiple -p options are allowed). Supported policies: basic, ssl-client, ssl-server, smime, eap, ipsec, ichat, codesigning, sys-default, sys-kerberos-kdc
-s string       Specify optional policy-specific string (e.g. a DNS hostname for SSL, or RFC822 email address for S/MIME)
-v              Show valid identities only (default is to show all identities)

Examples

security> find-identity -v -p ssl-client
Display valid identities that can be used for SSL client authentication

security> find-identity -p ssl-server -s www.domain.com
        Display identities for a SSL server running on the host 'www.domain.com'

security> find-identity -p smime -s user@domain.com
Display identities that can be used to sign a message from 'user@domain.com'
*/
val findIdentity by tasks.creating(ShellExec::class) {
    command = "security find-identity -p codesigning"
/*    preExec() {
        command += "security.keychain"
    }*/
}
