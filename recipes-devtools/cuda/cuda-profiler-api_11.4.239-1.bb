CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "9bb846ce5fee0fe6617e9329aee8a47d813cbd397f66edb972069101ac3365ce"
MAINSUM:x86-64 = "8100c07955a7bb24986f6dc0bee82d3c91aa45fb864c8e901c61b9341403c844"

DEPENDS = "cuda-cupti"
DEPENDS:append:tegra = " tegra-libraries-cuda"
ALLOW_EMPTY:${PN} = "1"
BBCLASSEXTEND = "native nativesdk"
