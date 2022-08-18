CUDA_PKG = "${BPN}"

require cuda-shared-binaries.inc

MAINSUM = "80cc72d29a6b0901544833f3623b50703b6dca43833034ab5ea7043649a1b023"
MAINSUM:x86-64 = "4ef4079265d44e8af0e149b2549d11064aa25c7f5ce00520e6d18abdd89b31aa"

DEPENDS = "ncurses expat"

do_compile:append() {
    sed -i -r -e 's,^(\s*)print (.*)$,\1print(\2),' ${B}/usr/local/cuda-${CUDA_VERSION}/share/gdb/system-gdbinit/*.py
}

FILES:${PN}-dev += "${prefix}/local/cuda-${CUDA_VERSION}/share/gdb"
RDEPENDS:${PN}-dev += "python3"
INSANE_SKIP:${PN}-dev += "staticdev"
BBCLASSEXTEND = "native nativesdk"
