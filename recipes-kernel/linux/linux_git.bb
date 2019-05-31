# linux-yocto-custom.bb:
#
#   An example kernel recipe that uses the linux-yocto and oe-core
#   kernel classes to apply a subset of yocto kernel management to git
#   managed kernel repositories.
#
#   To use linux-yocto-custom in your layer, copy this recipe (optionally
#   rename it as well) and modify it appropriately for your machine. i.e.:
#
#     COMPATIBLE_MACHINE_yourmachine = "yourmachine"
#
#   You must also provide a Linux kernel configuration. The most direct
#   method is to copy your .config to files/defconfig in your layer,
#   in the same directory as the copy (and rename) of this recipe and
#   add file://defconfig to your SRC_URI.
#
#   To use the yocto kernel tooling to generate a BSP configuration
#   using modular configuration fragments, see the yocto-bsp and
#   yocto-kernel tools documentation.
#
# Warning:
#
#   Building this example without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   defconfig: When a defconfig is provided, the linux-yocto configuration
#              uses the filename as a trigger to use a 'allnoconfig' baseline
#              before merging the defconfig into the build. 
#
#              If the defconfig file was created with make_savedefconfig, 
#              not all options are specified, and should be restored with their
#              defaults, not set to 'n'. To properly expand a defconfig like
#              this, specify: KCONFIG_MODE="--alldefconfig" in the kernel
#              recipe.
#   
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition (for kernel v4.x only):
#            SRC_URI += "file://0001-linux-version-tweak.patch"
#   example feature addition (for kernel v4.x only):
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/enoriel/linux-bbb.git;protocol=git;nocheckout=1;name=machine"

LINUX_VERSION ?= "4.14.0-rc3"
LINUX_VERSION_EXTENSION_append = "-ynov"

SRCREV_machine= "d81fa669e3de7eb8a631d7d95dac5fbcb2bf9d4e"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE = "beaglebone"
# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   include/linux/license.h
#   tools/usb/usbip/COPYING
#   Documentation/networking/LICENSE.qla3xxx
#   Documentation/networking/LICENSE.qlge
#   Documentation/networking/LICENSE.qlcnic
#   Documentation/scsi/LICENSE.qla2xxx
#   Documentation/scsi/LICENSE.FlashPoint
#   Documentation/scsi/LICENSE.qla4xxx
#   fs/jffs2/LICENCE
#   drivers/net/LICENSE.SRC
#   drivers/net/wireless/marvell/libertas/LICENSE
#   drivers/staging/rtl8192e/license
#
# NOTE: multiple licenses have been detected; they have been separated with &
# in the LICENSE value for now since it is a reasonable assumption that all
# of the licenses apply. If instead there is a choice between the multiple
# licenses then you should change the value to separate the licenses with |
# instead of &. If there is any doubt, check the accompanying documentation
# to determine which situation is applicable.
LICENSE = "GPLv2 & Unknown & LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7 \
                    file://include/linux/license.h;md5=34bc4ac5c1331ab3f24806879f6138ee \
                    file://tools/usb/usbip/COPYING;md5=1f6f1c0be32491a0c8d2915607a28f36 \
                    file://Documentation/networking/LICENSE.qla3xxx;md5=ae5c998421760d17dd805a57f798a82b \
                    file://Documentation/networking/LICENSE.qlge;md5=6936a28c2f2dd5644139be15f271d7c7 \
                    file://Documentation/networking/LICENSE.qlcnic;md5=3252cba622a54474abf62e5eb9af6653 \
                    file://Documentation/scsi/LICENSE.qla2xxx;md5=5750f79fa0beb650f04f8035be89bd43 \
                    file://Documentation/scsi/LICENSE.FlashPoint;md5=ef7704635ba02fb27f5e524565d54c10 \
                    file://Documentation/scsi/LICENSE.qla4xxx;md5=adc31a736607fafceacc68c6f1b08a0f \
                    file://fs/jffs2/LICENCE;md5=fcd40f6cb09221b0782c1d09ba266911 \
                    file://arch/sparc/lib/COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://drivers/net/LICENSE.SRC;md5=e5e50f92b87d827b29e6e79e05432963 \
                    file://drivers/net/wireless/marvell/libertas/LICENSE;md5=4ea603c400089f5e404cc5e453d17bc5 \
                    file://drivers/staging/rtl8192e/license;md5=39aad0f4df1a741c8567b6bb87644f65"

