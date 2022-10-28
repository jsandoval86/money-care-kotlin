package com.moneycare.tracking.incomes

import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.tags.Tag
import com.moneycare.tracking.tags.TagRepository
import com.moneycare.tracking.shared.valueobjects.Concept
import com.moneycare.tracking.shared.valueobjects.Money
import org.springframework.transaction.annotation.Transactional
import javax.inject.Named

@Named
open class CreateIncomeUseCase (
    private val incomeRepository: IncomeRepository,
    private val tagRepository: TagRepository,
    private val outboxRepository: OutboxRepository
) {

    @Transactional
    open fun create(createIncomeCommand: CreateIncomeCommand) : Income {
        val concept = Concept(createIncomeCommand.getConcept())
        val amount  = Money(createIncomeCommand.getAmount())
        val tag : Tag = getTag(createIncomeCommand)

        val income = Income.create(concept, amount, tag.id)
        this.incomeRepository.save(income)
        this.outboxRepository.save(income.messages)

        return income
    }

    private fun getTag(createIncomeCommand: CreateIncomeCommand) =
        createIncomeCommand.getTagId()?.let {
            tagRepository.findById(it).orElse(Tag.undefined())
        } ?: Tag.undefined()
}