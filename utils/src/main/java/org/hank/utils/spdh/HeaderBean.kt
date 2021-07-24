package org.hank.utils.spdh


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder

data class HeaderBean(
    @Expose @SerializedName("currentDate")
    var currentDate: String = "",
    @Expose @SerializedName("currentTime")
    var currentTime: String = "",
    @Expose @SerializedName("deviceType")
    var deviceType: String = "",
    @Expose @SerializedName("employeeId")
    var employeeId: String = "",
    @Expose @SerializedName("messagSubType")
    var messagSubType: String = "",
    @Expose @SerializedName("messageType")
    var messageType: String = "",
    @Expose @SerializedName("processingFlag1")
    var processingFlag1: String = "",
    @Expose @SerializedName("processingFlag2")
    var processingFlag2: String = "",
    @Expose @SerializedName("processingFlag3")
    var processingFlag3: String = "",
    @Expose @SerializedName("responseCode")
    var responseCode: String = "",
    @Expose @SerializedName("terminalId")
    var terminalId: String = "",//terminalid 长度为16 不足右补零
    @Expose @SerializedName("transactionCode")
    var transactionCode: String = "",
    @Expose @SerializedName("transmissionNumber")
    var transmissionNumber: String = ""
) {
    override fun toString(): String {
        var strBuilder = StringBuilder()
        strBuilder.apply {
            append(deviceType)
            append(transmissionNumber)
            append(terminalId)
            append(employeeId)
            append(currentDate)
            append(currentTime)
            append(messageType)
            append(messagSubType)
            append(transactionCode)
            append(processingFlag1)
            append(processingFlag2)
            append(processingFlag3)
            append(responseCode)
        }
        return strBuilder.toString()
    }
}