package br.com.dio.currencyconverter.data.di

import android.util.Log
import androidx.annotation.RestrictTo
import br.com.dio.currencyconverter.data.services.AwesomeService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {

    private const val HTTP_TAG = "OKHttp"

    fun load() {
        loadKoinModules(networkModules())
    }

    // single - o koin devolve sempre a mesma instância
    // factory - o koin devolve uma instância nova a cada chamada

    private fun networkModules(): Module {
        return module {
            //Interceptor é o responsável por captar todas as mensagens do retroFit
            single {
                val interceptor= HttpLoggingInterceptor {
                    Log.i(HTTP_TAG, ": $it")
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }

            //Usado para converter as strings em objetos
            single {
                GsonConverterFactory.create(GsonBuilder().create())
            }

            //Cria os services
            single {
                createService<AwesomeService>(get(), get())
            }
        }
    }

    private inline fun <reified T> createService(client: OkHttpClient, factory: GsonConverterFactory): T {
        return Retrofit.Builder()
            .baseUrl("https://economia.awesomeapi.com.br")
            .client(client)
            .addConverterFactory(factory)
            .build()
            .create(T::class.java)
    }

}