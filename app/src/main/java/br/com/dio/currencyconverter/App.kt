package br.com.dio.currencyconverter

import android.app.Application
import br.com.dio.currencyconverter.data.di.DataModule
import br.com.dio.currencyconverter.domain.di.DomainModule
import br.com.dio.currencyconverter.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()

    }

}