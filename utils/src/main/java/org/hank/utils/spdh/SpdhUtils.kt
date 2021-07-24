package org.hank.utils.spdh


object SpdhUtils {
    fun str2Header(data: String): HeaderBean {
        var header = HeaderBean()
        header.apply {
            deviceType = data.substring(0, 2)
            transmissionNumber = data.substring(2, 4)
            terminalId = data.substring(4, 20)
            employeeId = data.substring(20, 26)
            currentDate = data.substring(26, 32)
            currentTime = data.substring(32, 38)
            messageType = data.substring(38, 39)
            messagSubType = data.substring(39, 40)
            transactionCode = data.substring(40, 42)
            processingFlag1 = data.substring(42, 43)
            processingFlag2 = data.substring(43, 44)
            processingFlag3 = data.substring(44, 45)
            responseCode = data.substring(45, 48)
        }
        return header
    }

    fun str2Fields(data: String): MutableList<FieldsBean> {
        var list: MutableList<FieldsBean> = ArrayList()
        for (item in data.split(0x1C.toChar().toString())) {
            if (item.isEmpty())
                continue
            var temp = FieldsBean()
            temp.name = item.substring(0, 1)
            temp.isSubFields = false
            if (item.contains(0x1E.toChar().toString())) {
                var subList: MutableList<FieldsBean> = ArrayList()
                for (item1 in item.substring(1, item.length).split(0x1E.toChar().toString())) {
                    if (item1.isEmpty())
                        continue
                    var temp1 = FieldsBean()
                    temp1.name = item1.substring(0, 1)
                    temp1.isSubFields = true
                    temp1.data = item1.substring(1, item1.length)
                    subList.add(temp1)
                }
                temp.data = subList
            } else {
                temp.data = item.substring(1, item.length)
            }
            list.add(temp)
        }
        return list
    }
}