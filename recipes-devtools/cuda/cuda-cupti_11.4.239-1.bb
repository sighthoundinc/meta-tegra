require cuda-shared-binaries.inc

MAINSUM = "b9d65746b57a14c32d88a3a0c290c41c27adc93f6b29293c91d1236b35da2196"
MAINSUM:x86-64 = "b2ffe50a4ea148c3156c6b260212d459e99fc6ae345826c53f879d4126c012ec"
DEVSUM = "8c7ecd4fa8d5a709a8bb2cfdb21ea57068a97f38ac22b0f5c13bb1a1de601886"
DEVSUM:x86-64 = "6b192b8a24611b591201b329f251a5c00136796d379aa887bbfdc02825d9bf39"

FILES:${PN}-dev += "${prefix}/local/cuda-${CUDA_VERSION}/extras/CUPTI/Readme.txt \
                    ${prefix}/local/cuda-${CUDA_VERSION}/extras/CUPTI/include ${prefix}/local/cuda-${CUDA_VERSION}/extras/CUPTI/sample"

BBCLASSEXTEND = "native nativesdk"
