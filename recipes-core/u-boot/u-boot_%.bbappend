FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://0001-Customize-config-and-boot-command.patch \
            file://0001-am335x_evm-uEnv.txt-bootz-n-fixes.patch \
	    file://0002-U-Boot-BeagleBone-Cape-Manager.patch"

UBOOT_SUFFIX = "img"
SPL_BINARY = "MLO"
