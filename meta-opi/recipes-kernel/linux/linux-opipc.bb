require linux-opi.inc

COMPATIBLE_MACHINE = "(orange-pi-pc)"

# 4.14
PV = "4.14+git${SRCPV}"
SRCREV = "cb31337027aaf606dc77cd423dc54197bb5ed16c"

SRC_URI = " \
  git://github.com/megous/linux.git;protocol=git;branch=orange-pi-4.14 \
  file://defconfig \
  file://Add-Mali-Node.patch \
"
