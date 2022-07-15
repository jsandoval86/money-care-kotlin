package com.moneycare.tracking.expenses.controllers.mappers

import com.moneycare.tracking.expenses.CreateExpenseData
import com.moneycare.tracking.expenses.requests.CreateExpenseRequest
import org.springframework.stereotype.Component

@Component
class CreateExpenseRequestMapper {

    fun mapToData(createExpenseRequest : CreateExpenseRequest) : CreateExpenseData {
        return CreateExpenseData().apply {
            this.concept = createExpenseRequest.concept
            this.amount = createExpenseRequest.amount
            this.tagId = createExpenseRequest.tagId
        }
    }

}