package com.moneycare.tracking.incomes.usecase

import com.moneycare.shared.messages.outbox.repository.Message
import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.incomes.models.Income
import com.moneycare.tracking.incomes.repository.IncomeRepository
import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import javax.inject.Named

@Named
class CreateIncomeUseCase(
    private val incomeRepository: IncomeRepository,
    private val outboxRepository: OutboxRepository
) {

    fun create(concept : Concept, amount: Money) {
        val income = Income.create(concept, amount)
        this.incomeRepository.save(income)
        this.outboxRepository.save(Message())
    }

}