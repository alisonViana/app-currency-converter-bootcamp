package br.com.dio.currencyconverter.data.repositories

import br.com.dio.currencyconverter.data.model.ExchangeResponseValue
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getExchangeValues(coins: String): Flow<ExchangeResponseValue>
    suspend fun getAll(): Flow<List<ExchangeResponseValue>>
    suspend fun insert(exchange: ExchangeResponseValue)
}