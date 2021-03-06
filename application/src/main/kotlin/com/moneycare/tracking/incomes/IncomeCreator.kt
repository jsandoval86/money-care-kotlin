package com.moneycare.tracking.incomes

import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.shared.models.Tag
import com.moneycare.tracking.shared.repository.TagRepository
import com.moneycare.tracking.shared.valueobjects.Concept
import com.moneycare.tracking.shared.valueobjects.Money
import javax.inject.Named

@Named
class IncomeCreator(
    private val incomeRepository: IncomeRepository,
    private val tagRepository: TagRepository,
    private val outboxRepository: OutboxRepository,
    private val incomeDataMapper: IncomeDataMapper
) {

    fun create(createIncomeData: CreateIncomeData) : IncomeData {
        val concept = Concept(createIncomeData.concept)
        val amount  = Money(createIncomeData.amount)
        val tag : Tag = getTag(createIncomeData)

        val income = Income.create(concept, amount, tag.id)
        this.incomeRepository.save(income)
        this.outboxRepository.save(income.messages)

        return incomeDataMapper.mapToData(income)
    }

    private fun getTag(createIncomeData: CreateIncomeData) =
        createIncomeData.tagId?.let {
            tagRepository.findById(it).orElse(Tag.byDefault())
        } ?: Tag.byDefault()
}