package org.hank.utils.spdh

import java.lang.StringBuilder

data class SubFieldP(
    var scheme: String = "",
    var pan: String = "",
    var terminalType: String = "",
    var CVMRet: String = "",
    var versionCode: String = "",
    var terCapabilities: String = "",
    var dedicatedFileName: String = ""
) {
    override fun toString(): String {
        var sb = StringBuilder()
        when (scheme) {
            "00" -> {
                sb.apply {
                    append(scheme)
                    append(pan)
                    append(terminalType)
                }
            }
            "01" -> {
                sb.apply {
                    append(scheme)
                    append(pan)
                    append(terminalType)
                    append(CVMRet)
                    append(versionCode)
                    append(dedicatedFileName)
                }
            }
            "02" -> {
                sb.apply {
                    append(scheme)
                    append(pan)
                    append(terminalType)
                    append(CVMRet)
                    append(versionCode)
                    append(terCapabilities)
                    append(dedicatedFileName)
                }
            }
        }
        return sb.toString()
    }
}
