SUMMARY = "Initialize firewall"

LICENSE = "CLOSED"

SRC_URI += "file://init \
            file://firewall.rules"

PR = "r0"

S = "${WORKDIR}"

inherit update-rc.d
INITSCRIPT_NAME = "firewall"
INITSCRIPT_PARAMS = "start 60 S ."

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 init ${D}${sysconfdir}/init.d/firewall
    install -m 0744 firewall.rules ${D}${sysconfdir}
}

FILES_${PN} = "${sysconfdir}"

RDEPENDS_${PN} = "iptables"
