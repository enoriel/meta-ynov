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
SRCREV = "3670d5b4354e02f5cc845f235ece3095083b7b22"

S = "${WORKDIR}/git"

DEPENDS =   "qtbase \
            qtserialport \
            qtdeclarative \
            qtquickcontrols2 \
            qtquickcontrols \
            qtvirtualkeyboard \
"

PACKAGECONFIG ?= ""
PACKAGECONFIG[desktop] = "-DDESKTOP_BUILD,,"

SYSTEMD_SERVICE_${PN} = "${PN}.service"



do_install() {
    install -d ${D}${datadir}/${P}
    install -Dm 0644 ${WORKDIR}/${PN}.service ${D}${systemd_system_unitdir}/${PN}.service
    install -d ${D}/opt/smartgreenhouse/bin/
    cp -R --no-dereference --preserve=mode,links ${S}/* ${D}${P}
}

FILES_${PN} += "/opt/smartgreenhouse/bin/"

INITSCRIPT_NAME = "smartgreenhouse"

inherit qmake5 systemd
