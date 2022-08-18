CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "5c74f610b67fb91b75d80ca04d1a8f08d41806da46c3014f5a97c534f37805d1"
MAINSUM:x86-64 = "c84249816bf72d4fe407c7513e3d933418b1abba8885bdd3a415f7e7c45afb07"

BBCLASSEXTEND = "native nativesdk"
