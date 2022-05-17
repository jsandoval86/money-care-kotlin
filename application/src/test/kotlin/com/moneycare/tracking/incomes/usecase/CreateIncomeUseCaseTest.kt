package com.moneycare.tracking.incomes.usecase

import com.moneycare.shared.helper.MockitoHelper
import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.incomes.models.Tag
import com.moneycare.tracking.incomes.repository.IncomeRepository
import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreateIncomeUseCaseTest {

    @Mock
    private lateinit var incomeRepository: IncomeRepository

    @Mock
    private lateinit var outboxRepository: OutboxRepository

    @InjectMocks
    private lateinit var createIncomeUseCase: CreateIncomeUseCase

    @BeforeAll
    fun init() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun createIncome() {
        val concept = Concept("Salary")
        val money = Money(15_000_000.0, "COP")
        val tag = Tag.withotTag()

        this.createIncomeUseCase.create(concept, money, tag)

        verify(incomeRepository, times(1)).save(MockitoHelper.anyObject())
        verify(outboxRepository, times(1)).save(MockitoHelper.anyList())

    }

}