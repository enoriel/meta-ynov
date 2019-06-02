# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3329c90e1f1ced70ca008d6a277b00c3"

SRC_URI = "git://github.com/enoriel/SmartGreenHouse.git;protocol=https"

SRC_URI += " \
    file://${PN}.service \
"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "f2fac26ba5c0b0b95cf229d69f4099f22424099d"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtserialport qtdeclarative"

PACKAGECONFIG ?= ""
PACKAGECONFIG[desktop] = "-DDESKTOP_BUILD,,"

SYSTEMD_SERVICE_${PN} = "${PN}.service"

inherit qmake5 systemd

do_install() {
    install -d ${D}${datadir}/${P}
    install -Dm 0644 ${WORKDIR}/${PN}.service ${D}${systemd_system_unitdir}/${PN}.service
    #install -m 0755 ${B}/SmartGreenHouse ${D}${datadir}/${P}
    cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${datadir}/${P}
}

FILES_${PN} += "${datadir}"

INITSCRIPT_NAME = "smartgreenhouse"
