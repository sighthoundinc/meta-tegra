DEPENDS = "cuda-driver cuda-nvcc-headers cuda-cccl"

require cuda-shared-binaries.inc

MAINSUM = "5b1124506d3ebf10b92e80da25529402f61ac63fa5903082571ce52e7114272a"
MAINSUM:x86-64 = "cfe5427d16422197474f602127adb2d2ad0e6024609b7faf29a0a9678b581963"
DEVSUM = "80d56fc569c73163fdbc94068a2941ca1622bc7b06da872f33408567b06d5cec"
DEVSUM:x86-64 = "817a147c5f9a84d1db930be7a82746c5493e02a38c6b76b1660130392e21f58e"

inherit container-runtime-csv siteinfo
CONTAINER_CSV_FILES += " \
    ${sysconfdir}/ld.so.conf.d/cuda-${CUDA_VERSION_DASHED}.conf \
"

do_compile:append() {
    echo "${prefix}/local/cuda-${CUDA_VERSION}/${baselib}" > ${B}/cuda-${CUDA_VERSION_DASHED}.conf
    if [ "${baselib}" != "lib64" -a "${SITEINFO_BITS}" = "64" ]; then
	if [ -e ${B}/usr/local/cuda-${CUDA_VERSION}/${baselib} ]; then
            ln -s ${baselib} ${B}/usr/local/cuda-${CUDA_VERSION}/lib64
	fi
    fi
}

do_install:append:class-target() {
    install -d ${D}${sysconfdir}/ld.so.conf.d
    install -m 0644 ${B}/cuda-${CUDA_VERSION_DASHED}.conf ${D}${sysconfdir}/ld.so.conf.d/
}

FILES:${PN}-dev += "${prefix}/local/cuda-${CUDA_VERSION}/${baselib}/*.a \
                    ${@' ${prefix}/local/cuda-${CUDA_VERSION}/lib64' if d.getVar('baselib') != 'lib64' and d.getVar('SITEINFO_BITS') == '64' else ''}"
FILES:${PN}-staticdev = ""
INSANE_SKIP:${PN}-dev += "staticdev"
RDEPENDS:${PN}-dev:append:class-target = " cuda-nvcc-headers cuda-cccl cuda-target-environment"
BBCLASSEXTEND = "native nativesdk"
