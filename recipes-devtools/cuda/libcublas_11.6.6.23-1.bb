CUDA_PKGNAMES = "libcublas-${CUDA_VERSION_DASHED}_${PV}_${CUDA_DEB_PKGARCH}.deb libcublas-dev-${CUDA_VERSION_DASHED}_${PV}_${CUDA_DEB_PKGARCH}.deb"

require cuda-shared-binaries.inc

SRC_COMMON_DEBS = "libcublas-${CUDA_VERSION_DASHED}_${PV}_${CUDA_DEB_PKGARCH}.deb;name=main;subdir=${BP} \
                   libcublas-dev-${CUDA_VERSION_DASHED}_${PV}_${CUDA_DEB_PKGARCH}.deb;name=dev;subdir=${BP} \
                   ${CUDA_LICENSE_PKG}"

MAINSUM = "4e9499122c3921073869970580f78c31beaa65b58f8345600ad2db99297f27e5"
MAINSUM:x86-64 = "e3d88ea853ec7f72886f9c0f955421caafc1f20f4f7383f94ba37d22ab7782b1"
DEVSUM = "268491c19854a47d1fc8e7530301da318c159b50ed94b3d1579792d8a4bbbd90"
DEVSUM:x86-64 = "c4676a21931a524d55c65a78de13fe78ee85fbb4abf61416e6c17375af75f960"

BBCLASSEXTEND = "native nativesdk"
