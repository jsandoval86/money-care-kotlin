package com.moneycare.tracking.expenses

import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.tags.Tag
import com.moneycare.tracking.tags.TagRepository
import com.moneycare.tracking.shared.valueobjects.Concept
import com.moneycare.tracking.shared.valueobjects.Money
import javax.inject.Named

@Named
class ExpenseCreator(
    private val tagRepository: TagRepository,
    private val expenseRepository: ExpenseRepository,
    private val outboxRepository: OutboxRepository
) {

    fun create(createExpenseData : CreateExpenseData) : Expense {
        val concept = Concept(createExpenseData.concept)
        val amount = Money(createExpenseData.amount)
        val tag : Tag = getTag(createExpenseData)

        val expense = Expense.create(concept, amount, tag.id)
        this.expenseRepository.save(expense)
        this.outboxRepository.save(expense.messages)

        return expense
    }

    private fun getTag(createExpenseData: CreateExpenseData) =
        createExpenseData.tagId?.let {
            tagRepository.findById(it).orElse(Tag.byDefault())
        } ?: Tag.byDefault()

}