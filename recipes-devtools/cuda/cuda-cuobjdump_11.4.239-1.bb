CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "441041da2f84f0c34bed5222dafc7150daf50e363fddcf5e36166f3c5320bbde"
MAINSUM:x86-64 = "4a8342e19f766602873251c9c925d5413de1afe4c861a8976fb9d80b707d22c6"
BBCLASSEXTEND = "native nativesdk"
