# (c) Copyright 2012  Hewlett-Packard Development Company, L.P.

SUMMARY = "Open webOS default virtual keyboard"
SECTION = "webos/libs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

DEPENDS = "qt4-webos qmake-webos-native glib-2.0 luna-prefs luna-service2 luna-webkit-api libpbnjson"

PR = "r2"

inherit webos_public_repo
inherit webos_qmake
inherit webos_enhanced_submissions
inherit webos_library
inherit webos_machine_dep

WEBOS_GIT_TAG = "submissions/${WEBOS_SUBMISSION}"
SRC_URI = "${OPENWEBOS_GIT_REPO}/${PN};tag=${WEBOS_GIT_TAG};protocol=git"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += "MACHINE=${MACHINE}"

do_configure() {
    MACHINE=${MACHINE} ${QMAKE}
}

do_install() {
    oe_runmake INSTALL_ROOT=${D} install
}

FILES_${PN} += "${webos_sysmgr_datadir}"
