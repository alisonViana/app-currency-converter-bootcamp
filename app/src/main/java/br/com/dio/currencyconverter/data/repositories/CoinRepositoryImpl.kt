package br.com.dio.currencyconverter.data.repositories

import br.com.dio.currencyconverter.data.services.AwesomeService
import kotlinx.coroutines.flow.flow

class CoinRepositoryImpl(private val service: AwesomeService): CoinRepository {

    override suspend fun getExchangeValues(coins: String) = flow {
        val exchangeValue = service.exchangeValue(coins)
        val exchange = exchangeValue.values.first()
        emit(exchange)
    }
}