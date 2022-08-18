L4T_DEB_COPYRIGHT_MD5 = "9236b0ab266095c1e497e5a69cb145a2"
DEPENDS = "tegra-libraries-core tegra-libraries-eglcore virtual/egl egl-wayland"

L4T_DEB_TRANSLATED_BPN = "nvidia-l4t-libvulkan"

require tegra-debian-libraries-common.inc

SRC_SOC_DEBS += "nvidia-l4t-3d-core_${PV}_arm64.deb;subdir=${BP};name=core3d"

MAINSUM = "1ec2c61ed16b02102af30d971709e46dce8c973f9eaf52a9ab1c1b839ec8df8f"
CORE3DSUM = "b15da5df648ecda4a3b3fb0a2faca1025473f5f11a1fe2de641a1481ad833b1e"
SRC_URI[core3d.sha256sum] = "${CORE3DSUM}"

inherit features_check

REQUIRED_DISTRO_FEATURES = "vulkan opengl"

VULKAN_VERSION="1.3.203"

TEGRA_LIBRARIES_TO_INSTALL = "\
    tegra/libvulkan.so.${VULKAN_VERSION} \
    tegra/libnvidia-vulkan-producer.so \
"

do_install() {
    install_libraries
    install -d ${D}/usr/lib/aarch64-linux-gnu/tegra
    if ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'true', 'false', d)}; then
        install -m644 ${S}/usr/lib/aarch64-linux-gnu/tegra/nvidia_icd.json ${D}/usr/lib/aarch64-linux-gnu/tegra/
        install -d ${D}${sysconfdir}/vulkan/icd.d
        ln -sf /usr/lib/aarch64-linux-gnu/tegra/nvidia_icd.json ${D}${sysconfdir}/vulkan/icd.d/
    fi
}

FILES_SOLIBSDEV = ""
SOLIBS = ".so*"
FILES:${PN} += "/usr/lib/aarch64-linux-gnu"
CONTAINER_CSV_FILES:append = "${@bb.utils.contains('DISTRO_FEATURES', 'x11', ' ${sysconfdir}/vulkan/icd.d/* /usr/lib/aarch64-linux-gnu/tegra/nvidia_icd.json', '', d)}"
