CUDA_PKG = "cuda-cccl"
L4T_DEB_GROUP = "cuda-thrust"

require cuda-shared-binaries.inc

MAINSUM = "7d1cd8f4526ecc031416a23293859bc3095170fe8c7f3c68d11cdc9ef4f90ddd"
MAINSUM:x86-64 = "97c3d84cdf7e07479357dddf0fab9fb98d2acdb5c51c79e57f95109e464da74f"

CONTAINER_CSV_FILES = ""
CONTAINER_CSV_PKGNAME = ""
FILES:${PN} = "${prefix}/local/cuda-${CUDA_VERSION}/include"
FILES:${PN}-dev = ""

BBCLASSEXTEND = "native nativesdk"
