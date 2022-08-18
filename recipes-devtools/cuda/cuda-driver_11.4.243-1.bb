CUDA_PKG = "${BPN}-dev"

require cuda-shared-binaries.inc

DEPENDS:tegra = "tegra-libraries-cuda"

L4T_DEB_GROUP = "cuda-cudart"
DEVSUM = "8f5e40761a28e24ec337be2f8bbe9abe11986a9c2f46781f875af8a7f5105675"
DEVSUM:x86-64 = "4b3af8e70358c64cfea4db944264fae589a4997f26b551e27521d7eca5626c3b"

ALLOW_EMPTY:${PN} = "1"
EXCLUDE_PACKAGES_FROM_SHLIBS = ""
PRIVATE_LIBS = "libcuda.so.1"

BBCLASSEXTEND = "native nativesdk"
