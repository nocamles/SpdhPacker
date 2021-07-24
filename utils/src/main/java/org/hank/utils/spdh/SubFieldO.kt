package org.hank.utils.spdh

import java.lang.StringBuilder

data class SubFieldO(
    var scheme: String = "",
    var cid: String = "",
    var tcc: String = "",
    var date: String = "",
    var arqc: String = "",
    var aip: String = "",
    var atc: String = "",
    var unumber: String = "",
    var tvr: String = "",
    var tran_type: String = "",
    //region  只有scheme == 01  才有
    var curr_code: String = "",
    var amount: String = "",
    //endregion
    var iad: String = "",
) {
    override fun toString(): String {
        var sb = StringBuilder()
        sb.apply {
            append(scheme)
            append(cid)
            append(tcc)
            append(date)
            append(arqc)
            append(aip)
            append(atc)
            append(tvr)
            append(tran_type)
            if (scheme == "01") {
                append(curr_code)
                append(amount)
            }
            append(iad)
        }
        return sb.toString()
    }
}
