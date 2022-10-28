package com.moneycare.tracking.expenses.rest.mappers

import com.moneycare.tracking.expenses.CreateExpenseData
import com.moneycare.tracking.expenses.rest.requests.CreateExpenseRequest
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