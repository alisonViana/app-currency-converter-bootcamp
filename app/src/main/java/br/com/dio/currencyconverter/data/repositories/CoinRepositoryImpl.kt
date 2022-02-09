package br.com.dio.currencyconverter.data.repositories

import br.com.dio.currencyconverter.core.exceptions.RemoteException
import br.com.dio.currencyconverter.data.model.ErrorResponse
import br.com.dio.currencyconverter.data.model.ExchangeResponseValue
import br.com.dio.currencyconverter.data.services.AwesomeService
import br.com.dio.currencyconverter.data.services.ExchangeDao
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CoinRepositoryImpl(
    private val service: AwesomeService,
    private val dao: ExchangeDao
): CoinRepository {

    override suspend fun getExchangeValues(coins: String) = flow {
        try {
            val exchangeValue = service.exchangeValue(coins)
            val exchange = exchangeValue.values.first()
            emit(exchange)
        } catch (e: HttpException) {
            val json = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(json, ErrorResponse::class.java)
            throw RemoteException(errorResponse.message)
        }
    }

    override suspend fun getAll(): Flow<List<ExchangeResponseValue>> {
        return dao.getAll()
    }

    override suspend fun insert(exchange: ExchangeResponseValue) {
        dao.insert(exchange)
    }
}