package com.moneycare.tracking.incomes.usecase

import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.incomes.commands.CreateIncomeData
import com.moneycare.tracking.incomes.models.Income
import com.moneycare.tracking.incomes.models.Tag
import com.moneycare.tracking.incomes.repository.IncomeRepository
import com.moneycare.tracking.incomes.repository.TagRepository
import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import javax.inject.Named

@Named
class CreateIncomeUseCase(
    private val incomeRepository: IncomeRepository,
    private val tagRepository: TagRepository,
    private val outboxRepository: OutboxRepository
) {

    fun create(createIncomeData: CreateIncomeData) : Income{
        val concept = Concept(createIncomeData.concept)
        val amount  = Money(createIncomeData.amount)
        val tag : Tag = getTag(createIncomeData)

        val income = Income.create(concept, amount, tag.id)

        this.incomeRepository.save(income)
        this.outboxRepository.save(income.messages)

        return income
    }

    private fun getTag(createIncomeData: CreateIncomeData) =
        createIncomeData.tagId?.let {
            tagRepository.findById(it).orElse(Tag.byDefault())
        } ?: Tag.byDefault()
}