package org.hank.utils.spdh

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.StringBuilder

data class FieldsBean(
    var name: String = "",
    var data: Any? = null,
    var isSubFields: Boolean = false
) {
    override fun toString(): String {
        //对子域的顺序排位
        if (data is MutableList<*>) {
            var item: MutableList<FieldsBean> = Gson().fromJson(
                Gson().toJson(data),
                object : TypeToken<MutableList<FieldsBean>>() {}.type
            )
            //先把所有是数字的提出来
            var numList: MutableList<FieldsBean> = ArrayList()
            for (numitem in item) {
                if (numitem.name.matches(Regex("^[0-9]*\$"))) {
                    numList.add(Gson().fromJson(Gson().toJson(numitem), FieldsBean::class.java))
                }
            }
            item.sortBy { it.name }
            //移除数字field
            var fieldscharacter = StringBuilder()
            var fieldsnum = StringBuilder()
            if (numList.size > 0) {
                for (i in numList) {
                    item.removeAt(numList.indexOf(i))
                    fieldsnum.append(0x1E.toChar().toString()+"${i.name}${i.data!!}")
                }
            }
            for (i in item) {
                fieldscharacter.append(0x1E.toChar().toString()+"${i.name}${i.data!!}")
            }
            //如果data是集合 必定不是subfield 直接1C打头
            return 0x1C.toChar().toString() +"${name}${fieldscharacter}${fieldsnum}"
        }
        //根据是否是subfied返回 1C 还是 1E
        return if (isSubFields) 0x1E.toChar().toString()+"${name}${data}" else 0x1C.toChar().toString()+"${name}${data}"
    }
}
