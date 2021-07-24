package org.hank.utils.spdh

import com.google.gson.Gson
import java.lang.StringBuilder

class SpdhMsg {
    var header: HeaderBean? = null
    var fields: MutableList<FieldsBean>? = null

    fun putFields(putField: FieldsBean) {
        if (fields == null)
            fields = ArrayList()
        fields!!.add(putField)
    }

    override fun toString(): String {
        //数字先提出来
        var numfields: MutableList<FieldsBean> = ArrayList()
        for (item in fields!!) {
            if (item.name.matches(Regex("^[0-9]*\$"))) {
                numfields.add(Gson().fromJson(Gson().toJson(item), FieldsBean::class.java))
            }
        }
        fields!!.sortBy { it.name }
        //移除数字field
        var fieldscharacter = StringBuilder()
        var fieldsnum = StringBuilder()
        if (numfields.size > 0) {
            for (i in numfields) {
                fields!!.removeAt(numfields.indexOf(i))
                fieldsnum.append(i.toString())
            }
        }
        for (i in fields!!) {
            fieldscharacter.append(i.toString())
        }
        return header.toString() + fieldscharacter.toString() + fieldsnum.toString()
    }
}