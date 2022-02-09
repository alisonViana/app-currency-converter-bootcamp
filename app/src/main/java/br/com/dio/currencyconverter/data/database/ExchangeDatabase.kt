package br.com.dio.currencyconverter.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.dio.currencyconverter.data.model.ExchangeResponseValue
import br.com.dio.currencyconverter.data.services.ExchangeDao

@Database(entities = [ExchangeResponseValue::class], version = 1)
abstract class ExchangeDatabase: RoomDatabase() {

    abstract val exchangeDao: ExchangeDao

    companion object {

        @Volatile
        private var INSTANCE: ExchangeDatabase? = null

        fun getInstance(context: Context): ExchangeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExchangeDatabase::class.java,
                    "db_exchange"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}