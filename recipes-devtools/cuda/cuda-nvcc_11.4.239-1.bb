CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "d30ff7c5fe0ef8c2394f433147cf447b12f3f8cf86f1e888a76429a56e88478a"
MAINSUM:x86-64 = "4f104b48fe1e00a8a3fea52ee4640f2accd8c60b1513a79e8b21bd39eefaad18"

# header files are populated by cuda-nvcc-headers recipes
do_install:append() {
    rm -rf ${D}${prefix}/local/cuda-${CUDA_VERSION}/include
}

FILES:${PN} = "${prefix}/local/cuda-${CUDA_VERSION}"
FILES:${PN}-dev = ""
INSANE_SKIP:${PN} += "dev-so"
RDEPENDS:${PN} = "${BPN}-headers"
RDEPENDS:${PN}:append:class-nativesdk = " nativesdk-cuda-environment"

BBCLASSEXTEND = "native nativesdk"
