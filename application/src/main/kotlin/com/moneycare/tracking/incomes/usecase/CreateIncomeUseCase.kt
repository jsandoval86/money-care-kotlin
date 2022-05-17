package com.moneycare.tracking.incomes.usecase

import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.incomes.models.Income
import com.moneycare.tracking.incomes.models.Tag
import com.moneycare.tracking.incomes.repository.IncomeRepository
import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import javax.inject.Named

@Named
class CreateIncomeUseCase(
    private val incomeRepository: IncomeRepository,
    private val outboxRepository: OutboxRepository
) {

    fun create(concept : Concept, amount: Money, tag: Tag) {
        val income = Income.create(concept, amount, tag)
        this.incomeRepository.save(income)
        this.outboxRepository.save(income.messages)
    }

}