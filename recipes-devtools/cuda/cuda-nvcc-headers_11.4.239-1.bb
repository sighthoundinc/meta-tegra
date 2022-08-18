CUDA_PKG = "cuda-nvcc"

require cuda-shared-binaries.inc

L4T_DEB_GROUP = "cuda-nvcc"
MAINSUM = "d30ff7c5fe0ef8c2394f433147cf447b12f3f8cf86f1e888a76429a56e88478a"
MAINSUM:x86-64 = "4f104b48fe1e00a8a3fea52ee4640f2accd8c60b1513a79e8b21bd39eefaad18"

do_install:append() {
    for d in bin lib nvvm nvvmx; do
        rm -rf ${D}${prefix}/local/cuda-${CUDA_VERSION}/$d
    done
}

CONTAINER_CSV_FILES = ""
CONTAINER_CSV_PKGNAME = ""
FILES:${PN} = "${prefix}/local/cuda-${CUDA_VERSION}/include"
FILES:${PN}-dev = ""

BBCLASSEXTEND = "native nativesdk"
