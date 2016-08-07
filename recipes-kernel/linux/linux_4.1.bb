# Copyright (C) 2015 Romain Perier
# Released under the MIT license (see COPYING.MIT for the terms)

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-4.1.y"

SRCREV = "${AUTOREV}"
LINUX_VERSION = "4.1"
# Override local version in order to use the one generated by linux build system
# And not "yocto-standard"
LINUX_VERSION_EXTENSION = ""
PR = "r1"
PV = "${LINUX_VERSION}"

# Include only supported boards for now
COMPATIBLE_MACHINE = "(radxarock|marsboard-rk3066|firefly-rk3288)"
KERNEL_CONFIG_COMMAND = "oe_runmake -C ${S} O=${B} ${@d.getVar('KERNEL_DEFCONFIG', True) or ""}"
deltask kernel_configme