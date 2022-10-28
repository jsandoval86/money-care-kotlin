package com.moneycare.tracking.shared.valueobjects

import com.moneycare.shared.model.Currency

data class Money(
    val amount : Double = 0.0,
    val currency: String = Currency.COP.name
) {

    private val currenciesAllowed = listOf("COP", "USD")

    init {

        if( !currenciesAllowed.contains(currency) ) {
            throw RuntimeException("currency $currency is not allowed")
        }

    }

}
