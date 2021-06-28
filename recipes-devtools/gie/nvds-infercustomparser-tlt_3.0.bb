LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = " deepstream-5.0"

SRC_URI = "git://github.com/NVIDIA-AI-IOT/deepstream_tlt_apps.git;nobranch=1"
SRCREV = "94b7a596b86ebdf5a4f294d442c96c123fb2d6ff"

S = "${WORKDIR}/git/post_processor"

TARGET_CFLAGS += " -I${RECIPE_SYSROOT}${includedir} -I${RECIPE_SYSROOT}/usr/local/cuda-${CUDA_VERSION}/include -L${RECIPE_SYSROOT}/usr/local/cuda-${CUDA_VERSION}/lib"
EXTRA_OEMAKE += " CC='${CXX}'"

TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} += "${libdir}/libnvds_infercustomparser_tlt.so.${PV}"

do_compile () {
    export CUDA_VER=${CUDA_VERSION}
    oe_runmake
}

do_install () {
    install -d ${D}${libdir}
    install -m 0755 ${S}/libnvds_infercustomparser_tlt.so ${D}${libdir}/libnvds_infercustomparser_tlt.so.${PV}
}