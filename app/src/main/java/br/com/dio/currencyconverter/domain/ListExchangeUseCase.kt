package br.com.dio.currencyconverter.domain

import br.com.dio.currencyconverter.core.UseCase
import br.com.dio.currencyconverter.data.model.ExchangeResponseValue
import br.com.dio.currencyconverter.data.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ListExchangeUseCase(
    private val repository: CoinRepository
): UseCase.NoParam<List<ExchangeResponseValue>>() {

    override suspend fun execute(): Flow<List<ExchangeResponseValue>> {
        return flow {
            repository.getAll()
        }
    }
}