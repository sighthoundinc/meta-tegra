CUDA_PKG = "${BPN}-dev"

require cuda-shared-binaries.inc

L4T_DEB_GROUP = "${BPN}-dev"
DEVSUM = "233c3bd5307e3ef39b7882b906ed53770f003ed903b95879226c8e6092a7fb34"
DEVSUM:x86-64 = "5845fd68d72285984757653139a527d26584b83a65a0a135065248aba78a7e32"

ALLOW_EMPTY:${PN} = "1"
FILES:${PN}-dev += "${prefix}/local/cuda-${CUDA_VERSION}/nvml/example"
EXCLUDE_PACKAGES_FROM_SHLIBS = ""
PRIVATE_LIBS = "libnvidia-ml.so.1"

BBCLASSEXTEND = "native nativesdk"
