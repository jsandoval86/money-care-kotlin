package com.moneycare.tracking.incomes.handlers.commands

import com.moneycare.tracking.incomes.commands.CreateIncomeCommand
import com.moneycare.tracking.incomes.usecase.CreateIncomeUseCase
import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import javax.inject.Named

@Named
class CreateIncomeCommandHandler(
    private val createIncomeUseCase: CreateIncomeUseCase
) {

    fun handle(createIncomeCommand: CreateIncomeCommand) {
        val concept = Concept(createIncomeCommand.concept)
        val money = Money(createIncomeCommand.amount)

        this.createIncomeUseCase.create(concept, money)
    }

}