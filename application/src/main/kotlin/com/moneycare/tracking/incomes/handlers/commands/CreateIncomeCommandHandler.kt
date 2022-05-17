package com.moneycare.tracking.incomes.handlers.commands

import com.moneycare.tracking.incomes.commands.CreateIncomeCommand
import com.moneycare.tracking.incomes.models.Tag
import com.moneycare.tracking.incomes.repository.TagRepository
import com.moneycare.tracking.incomes.usecase.CreateIncomeUseCase
import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import java.util.*
import javax.inject.Named

@Named
class CreateIncomeCommandHandler(
    private val createIncomeUseCase: CreateIncomeUseCase,
    private val tagRepository: TagRepository
) {

    fun handle(createIncomeCommand: CreateIncomeCommand) {
        val concept = Concept(createIncomeCommand.concept)
        val money = Money(createIncomeCommand.amount)
        val tag : Tag? = createIncomeCommand.tagId?.let {
            this.tagRepository.findById(it).orElse(Tag.withotTag())
        }

        this.createIncomeUseCase.create( concept, money,  tag ?: Tag.withotTag())
    }

}