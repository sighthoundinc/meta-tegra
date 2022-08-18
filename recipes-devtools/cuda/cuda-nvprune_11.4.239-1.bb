CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "5a001e6af583fea15af01654bab8fecae14c5fa5fb3039a92a8df2253f565af4"
MAINSUM:x86-64 = "892db8c22b533ca29a8f4807006dc95e8125445189a56355895ea02f5fc35d40"

BBCLASSEXTEND = "native nativesdk"
