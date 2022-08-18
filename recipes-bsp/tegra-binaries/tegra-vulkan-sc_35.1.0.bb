L4T_DEB_COPYRIGHT_MD5 = "88f9be75a8947c1116ceddaead04dfc6"
DEPENDS = "tegra-libraries-core tegra-libraries-eglcore virtual/egl egl-wayland"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-vulkan-sc"

require tegra-debian-libraries-common.inc

SRC_SOC_DEBS += "nvidia-l4t-vulkan-sc-dev_${PV}_arm64.deb;subdir=${BP};name=dev"

MAINSUM = "775b933df963a5e4051147e3dea0d8c68b882ea2c591eb9078bb0040d0693eeb"
DEVSUM = "054d1acd91f9a731dd3ad00ef6bf93bf2b1562a011a944883e51ae3615c1b75a"
SRC_URI[dev.sha256sum] = "${DEVSUM}"

inherit features_check

REQUIRED_DISTRO_FEATURES = "vulkan opengl"

VULKAN_VERSION="1.3.203"

TEGRA_LIBRARIES_TO_INSTALL = "\
    tegra/libnvidia-vksc-core.so.${L4T_VERSION} \
"

do_install() {
    install_libraries
    
    # Dev package
    install -d ${D}/usr/include/VulkanSC/vulkan
    for f in ${S}/usr/include/VulkanSC/vulkan/*; do
        install -m 0644 $f ${D}${includedir}/VulkanSC/vulkan
    done
    install -d ${D}/usr/src/nvidia/vulkan-sc/pcc
    install -m 0644 ${S}/usr/src/nvidia/vulkan-sc/pcc/ReadMe.txt ${D}/usr/src/nvidia/vulkan-sc/pcc
    install -d ${D}/usr/bin
    install -m 0755 ${S}/usr/bin/pcc ${D}/usr/bin
}

FILES_SOLIBSDEV = ""
SOLIBS = ".so*"
FILES:${PN} += "/usr/lib/aarch64-linux-gnu"
FILES:${PN}-dev = "/usr/include/VulkanSC/vulkan /usr/bin/pcc /usr/src/nvidia/vulkan-sc/pcc"
RDEPENDS:${PN} = "tegra-libraries-nvsci"
