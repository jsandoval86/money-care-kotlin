package com.moneycare.tracking.incomes.rest.mappers

import com.moneycare.tracking.incomes.CreateIncomeCommand
import com.moneycare.tracking.incomes.rest.request.CreateIncomeRequest
import org.springframework.stereotype.Component

@Component
class CreateIncomeRequestMapper {

    fun mapToData(createIncomeRequest: CreateIncomeRequest) : CreateIncomeCommand {
        return CreateIncomeCommand(createIncomeRequest.concept, createIncomeRequest.amount, createIncomeRequest.tagId)
    }

}