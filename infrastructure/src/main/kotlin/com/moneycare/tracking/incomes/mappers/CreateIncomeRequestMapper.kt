package com.moneycare.tracking.incomes.mappers

import com.moneycare.tracking.incomes.commands.CreateIncomeData
import com.moneycare.tracking.incomes.request.CreateIncomeRequest
import org.springframework.stereotype.Component

@Component
class CreateIncomeRequestMapper {

    fun mapToData(createIncomeRequest: CreateIncomeRequest) : CreateIncomeData {
        return CreateIncomeData().apply {
            this.concept = createIncomeRequest.concept
            this.amount = createIncomeRequest.amount
            this.tagId = createIncomeRequest.tagId
        }
    }

}