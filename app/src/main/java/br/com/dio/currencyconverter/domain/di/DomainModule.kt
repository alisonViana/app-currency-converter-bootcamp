package br.com.dio.currencyconverter.domain.di

import br.com.dio.currencyconverter.domain.GetExchangeValueUseCase
import br.com.dio.currencyconverter.domain.ListExchangeUseCase
import br.com.dio.currencyconverter.domain.SaveExchangeUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModules())
    }

    private fun useCaseModules(): Module {
        return module {
            factory { GetExchangeValueUseCase(get()) }
            factory { ListExchangeUseCase(get()) }
            factory { SaveExchangeUseCase(get()) }
        }
    }
}