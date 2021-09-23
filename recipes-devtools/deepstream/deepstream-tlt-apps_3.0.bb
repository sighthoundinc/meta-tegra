DESCRIPTION = "NVIDIA Transfer Learning Toolkit custom parser"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = " deepstream-5.0"

SRC_URI = "git://github.com/NVIDIA-AI-IOT/deepstream_tao_apps.git;branch=release/tlt3.0"
SRCREV = "16405b1a725a888cf6473cdd4fd0cb7effbf393f"

S = "${WORKDIR}/git"

inherit pkgconfig

TARGET_CFLAGS += " -I${RECIPE_SYSROOT}${includedir} -I${RECIPE_SYSROOT}/usr/local/cuda-${CUDA_VERSION}/include -L${RECIPE_SYSROOT}/usr/local/cuda-${CUDA_VERSION}/lib"
TARGET_LDFLAGS += " -L${RECIPE_SYSROOT}/opt/nvidia/deepstream/deepstream-5.0/lib"
EXTRA_OEMAKE += " CC='${CXX}' CUDA_VER=${CUDA_VERSION}"

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} += "${libdir}/libnvds_infercustomparser_tlt.so.${PV}"

do_install () {
    install -d ${D}${libdir}
    install -m 0755 ${S}/post_processor/libnvds_infercustomparser_tlt.so ${D}${libdir}/libnvds_infercustomparser_tlt.so.${PV}
}