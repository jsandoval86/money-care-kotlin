package com.moneycare.tracking.incomes.valueobjects

data class Money(
    val amount : Double,
    val currency: String = "COP"
) {

    private val currenciesAllowed = listOf("COP", "USD")

    init {

        if( !currenciesAllowed.contains(currency) ) {
            throw RuntimeException("currency $currency is not allowed")
        }

    }

}
