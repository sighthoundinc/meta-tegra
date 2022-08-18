CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM:x86-64 = "94452ace6b542bb9ca32f4322a815a96b5e818576ca870678676ea2a530adc4e"

DEPENDS = "cuda-cupti"
DEPENDS:append:tegra = " tegra-libraries-cuda"
ALLOW_EMPTY:${PN} = "1"
BBCLASSEXTEND = "native nativesdk"
