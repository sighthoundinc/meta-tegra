require cuda-shared-binaries.inc

MAINSUM = "9cfae20c24d580a28ab97cff977e8fe7a0248fd3335272f23391d0a16455e14f"
MAINSUM:x86-64 = "12e18a8389ad762b55097869ab6ff440406b7992b603e27064c22835d3e58138"
DEVSUM = "71240afeb550733de7292ac582a7ab8a16eef44225120de7cdd80ec3c8a8572f"
DEVSUM:x86-64 = "ea641cc6f1176b504bd178b4ba197a316b72aed14d06550c9d71ef53df3b96cb"

FILES:${PN}-dev:remove = "${prefix}/local/cuda-${CUDA_VERSION}/${baselib}/*${SOLIBSDEV}"
FILES:${PN} += "${prefix}/local/cuda-${CUDA_VERSION}/${baselib}/libnvrtc-builtins.so"
FILES:${PN}-dev += "${prefix}/local/cuda-${CUDA_VERSION}/${baselib}/libnvrtc.so"
INSANE_SKIP:${PN} += "dev-so"
BBCLASSEXTEND = "native nativesdk"
