# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3329c90e1f1ced70ca008d6a277b00c3"

SRC_URI = "git://github.com/enoriel/SmartGreenHouse.git;protocol=https"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "f2fac26ba5c0b0b95cf229d69f4099f22424099d"

S = "${WORKDIR}/git"

DEPENDS = "qtbase qtserialport qtdeclarative"

inherit qmake5

