# Meta-Ynov
## Dependencies
    URI: git://git.yoctoproject.org/poky.git
    branch: thud

    URI: git://git.openembedded.org/meta-openembedded
    branch: thud

    URI: https://github.com/meta-qt5/meta-qt5.git
    branch: thud
    
    URI: http://git.yoctoproject.org/cgit/cgit.cgi/meta-ti
    branch: thud

## How to use
    cd ~
    git clone -b thud git://git.yoctoproject.org/poky.git poky-thud
    ~/poky-thud$ git clone -b thud git://git.openembedded.org/meta-openembedded
    ~/poky-thud$ git clone -b thud https://github.com/meta-qt5/meta-qt5.git
    ~/poky-thud$ git clone -b thud https://github.com/enoriel/meta-ynov

You need to configure the file build/conf/local.conf and add:
    MACHINE ?= "beaglebone"

Then your build/conf/bblayers.conf and configure like this (if you follow the example):

    BBLAYERS ?= " \
    ~/poky-thud/meta \
    ~/poky-thud/meta-poky \
    ~/poky-thud/meta-yocto-bsp \
    ~/poky-thud/meta-openembedded/meta-oe \
    ~/poky-thud/meta-openembedded/meta-networking \
    ~/poky-thud/meta-openembedded/meta-python \
    ~/poky-thud/meta-ti \
    ~/poky-thud/meta-qt5 \
    ~/poky-thud/meta-ynov \
    "

Once your done modifying the bblayers.conf you can build your image

    ~/poky-thud$ source oe-init-build-env ../build
    ~/build$ bitbake qt5-image

