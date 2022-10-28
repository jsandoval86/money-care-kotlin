package com.moneycare.tracking.incomes.rest.mappers

import com.moneycare.tracking.incomes.Income
import com.moneycare.tracking.incomes.rest.response.IncomeResponse
import org.springframework.stereotype.Component

@Component
class IncomeResponseMapper {

    fun mapToIncomeResponse(income: Income) : IncomeResponse {
        return IncomeResponse(
            income.id, income.concept.description, income.amount.amount,
            income.amount.currency, income.date, income.tagId
        )
    }
}