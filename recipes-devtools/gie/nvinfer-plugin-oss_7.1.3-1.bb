SUMMARY = "TensorRT Open source libnvinfer_plugin"
HOMEPAGE = "http://developer.nvidia.com/tensorrt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b43e4a60a0643023327e7caf2dbf8663"

DEPENDS = "zlib libcublas cudnn tensorrt cuda-cudart"

inherit cmake cuda

SRC_REPO = "github.com/NVIDIA/TensorRT.git;protocol=https"
SRCBRANCH = "master"
SRC_URI = "gitsm://${SRC_REPO};branch=${SRCBRANCH} \
           file://0001-Use-CUDA_TOOLKIT_TARGET_DIR.patch \
           "

SRCREV = "9a9cae75e7155b2114454f37ccc49eca9d3352dc"

S = "${WORKDIR}/git"

EXTRA_OECMAKE = "-DGPU_ARCHS=${@extract_sm(d)} -DBUILD_PARSERS=OFF -DBUILD_SAMPLES=OFF"
OECMAKE_TARGET_COMPILE = "nvinfer_plugin"

CXXFLAGS += "${CUDA_CXXFLAGS}"

do_install() {
    install -d ${D}${libdir}
    cp --preserve=mode,timestamps  ${B}/libnvinfer_plugin.so* ${D}${libdir}
    for f in ${D}${libdir}/libnvinfer_plugin.so*;do mv $f $f.${PN};done
}

pkg_postinst_${PN} () {
    update-alternatives --install ${libdir}/libnvinfer_plugin.so libnvinferplugin.so libnvinfer_plugin.so.${PN} 100
    update-alternatives --install ${libdir}/libnvinfer_plugin.so.7 libnvinferplugin.so.7 libnvinfer_plugin.so.7.${PN} 100
    update-alternatives --install ${libdir}/libnvinfer_plugin.so.7.1.3 libnvinferplugin.so.7.1.3 libnvinfer_plugin.so.7.1.3.${PN} 100
}

pkg_prerm_${PN} () {
    update-alternatives --remove libnvinferplugin.so libnvinfer_plugin.so.${PN}
    update-alternatives --remove libnvinferplugin.so.7 libnvinfer_plugin.so.7.${PN}
    update-alternatives --remove libnvinferplugin.so.7.1.3 libnvinfer_plugin.so.7.1.3.${PN}
}

# Without this I get:
# "%package -n libnvinfer-plugin7: package libnvinfer-plugin7 already exists"
# at the rpm creation step.
FILES_${PN}-dev = ""
FILES_${PN} = "${libdir}/*"
