package com.moneycare.tracking.incomes.mappers

import com.moneycare.tracking.incomes.commands.CreateIncomeCommand
import com.moneycare.tracking.incomes.request.CreateIncomeRequest
import org.springframework.stereotype.Component

@Component
class CreateIncomeRequestMapper {

    fun mapToCommand(createIncomeRequest: CreateIncomeRequest) : CreateIncomeCommand {
        return CreateIncomeCommand().apply {
            this.concept = createIncomeRequest.concept
            this.amount = createIncomeRequest.amount
            this.tagId = createIncomeRequest.tagId
        }
    }

}