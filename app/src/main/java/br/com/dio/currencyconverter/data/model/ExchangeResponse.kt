package br.com.dio.currencyconverter.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

typealias ExchangeResponse = HashMap<String, ExchangeResponseValue>

@Entity(tableName = "tb_exchange")
data class ExchangeResponseValue (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val code: String,
    val codein: String,
    val name: String,
    val high: Double,
    val low: Double,
    val varBid: Double,
    val pctChange: Double,
    val bid: Double,
    val ask: Double,
    val timestamp: String,
    @SerializedName("create_date") val createDate: String
)

