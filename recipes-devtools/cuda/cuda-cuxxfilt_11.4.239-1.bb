CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "55ddbcf3392287dbb3d68476ad19c620d0aa18b67af00cc74a03601545341425"
MAINSUM:x86-64 = "5a1dfb1cda03e45827579f8da1e85c0459ec0c8f3f66a8abd76c6671a24f27c2"

BBCLASSEXTEND = "native nativesdk"
