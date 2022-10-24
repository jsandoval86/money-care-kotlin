package com.moneycare.tracking.incomes

import javax.inject.Named

@Named
open class IncomeDataMapper {

    fun mapToData(income: Income) : IncomeData {
        return IncomeData(
            income.id, income.concept, income.amount, income.date, income.tagId
        )
    }
}