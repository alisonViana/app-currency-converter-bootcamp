package br.com.dio.currencyconverter.domain

import br.com.dio.currencyconverter.core.UseCase
import br.com.dio.currencyconverter.data.model.ExchangeResponseValue
import br.com.dio.currencyconverter.data.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveExchangeUseCase(
    private val repository: CoinRepository
): UseCase.NoSource<ExchangeResponseValue>() {

    override suspend fun execute(param: ExchangeResponseValue): Flow<Unit> {
        return flow{
            repository.insert(param)
            emit(Unit)
        }
    }
}