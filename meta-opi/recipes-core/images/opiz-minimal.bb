SUMMARY = "Small console image for Orange Pi Zero"
IMAGE_LINGUAS = "en-us"

inherit core-image

CORE_OS = " \
  openssh openssh-keygen \
  kernel-modules \
  xradio \
  term-prompt \
  tzdata \
"

WIFI_SUPPORT = " \
  wpa-supplicant \
"

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    g++ \
    g++-symlinks \
    gdb \
    gdbserver \
    gcc \
    gcc-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    perl-modules \
    pkgconfig \
    python-modules \
    python3-modules \
    python-pip \
    python-misc \
 "
 
DEV_EXTRAS = " \
    ntp \
    ntp-tickadj \
 "

EXTRA_TOOLS_INSTALL = " \
  init-ifupdown \
  mtd-utils \
  bzip2 \
  nano \
  less \
  unzip \
  util-linux \
  util-linux-blkid \
  wget \
  zip \
  vim \
"

MONO_BINARIES = "\ 
   mono \
"

PREFERRED_VERSION_mono = "5.4.%"
PREFERRED_VERSION_mono-native = "5.4.%"

IMAGE_INSTALL += " \
  ${CORE_OS} \
  ${EXTRA_TOOLS_INSTALL} \
  ${WIFI_SUPPORT} \
  ${DEV_SDK_INSTALL} \
  ${DEV_EXTRAS} \
  ${EXTRA_TOOLS_INSTALL} \  
  ${MONO_BINARIES} \  
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/UTC ${IMAGE_ROOTFS}/etc/localtime
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
 "

IMAGE_FEATURES += "package-management"
