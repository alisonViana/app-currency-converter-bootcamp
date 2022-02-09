package br.com.dio.currencyconverter.data.services

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.dio.currencyconverter.data.model.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow
import okhttp3.internal.connection.Exchange

@Dao
interface ExchangeDao {

    @Query("SELECT * FROM tb_exchange")
    fun getAll(): Flow<List<ExchangeResponseValue>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(exchange: ExchangeResponseValue)
}