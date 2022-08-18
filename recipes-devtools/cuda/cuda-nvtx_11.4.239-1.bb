CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "b8669c8e819053d7c78c13c374b86871b131cc233d7c240d1b4c4d21c0369f6f"
MAINSUM:x86-64 = "68b271917df3349f1f73f1424c0cabc90c5c317a14590fc494287ffca1ae0f8f"

BBCLASSEXTEND = "native nativesdk"
