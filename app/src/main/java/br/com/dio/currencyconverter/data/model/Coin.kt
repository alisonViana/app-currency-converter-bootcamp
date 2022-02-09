package br.com.dio.currencyconverter.data.model

import java.util.*

enum class Coin(val description: String, val locale: Locale) {
    BTC("Bitcoin", Locale.ROOT),
    BOB("Boliviano",  Locale("es", "BO")),
    VEF("Bolívar Venezuelano", Locale("es", "VE")),
    USD("Dólar Americano", Locale.US),
    AUD("Dólar Australiano", Locale("en", "AU")),
    CAD("Dólar Canadense", Locale.CANADA),
    HKD("Dólar de Hong Kong", Locale("en", "HK")),
    ETH("Ethereum", Locale.US),
    EUR("Euro",  Locale.GERMAN),
    JPY("Iene Japonês", Locale.JAPAN),
    GBP("Libra Esterlina", Locale.UK),
    ARS("Peso Argentino", Locale("es", "AR")),
    CLP("Peso Chileno", Locale("es", "CL")),
    COP("Peso Colombiano", Locale("es", "CO")),
    MXN("Peso Mexicano", Locale("es", "MX")),
    UYU("Peso Uruguaio", Locale("es", "UY")),
    BRL("Real Brasileiro", Locale("pt", "BR")),
    RUB("Rublo Russo", Locale("ru", "RU")),
    INR("Rúpia Indiana", Locale("hi", "IN")),
    PEN("Sol do Peru", Locale("es", "PE")),
    XRP("XRP", Locale.US),
    KRW("Won Sul-Coreano", Locale.KOREA)
}