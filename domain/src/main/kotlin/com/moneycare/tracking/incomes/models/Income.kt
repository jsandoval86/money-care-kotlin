package com.moneycare.tracking.incomes.models

import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import java.util.UUID

data class Income(
    val id : UUID = UUID.randomUUID(),
    var concept: Concept,
    val amount : Money
) {

    companion object {
        fun create(concept: Concept, amount: Money) : Income {
            return Income(concept = concept, amount = amount)
        }
    }

}
