package com.moneycare.tracking.incomes.usecase

import com.moneycare.shared.helper.MockitoHelper
import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.incomes.commands.CreateIncomeData
import com.moneycare.tracking.incomes.models.Tag
import com.moneycare.tracking.incomes.repository.IncomeRepository
import com.moneycare.tracking.incomes.repository.TagRepository
import com.moneycare.tracking.incomes.valueobjects.Concept
import com.moneycare.tracking.incomes.valueobjects.Money
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.times
import org.mockito.MockitoAnnotations
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreateIncomeUseCaseTest {

    @Mock
    private lateinit var incomeRepository: IncomeRepository

    @Mock
    private lateinit var outboxRepository: OutboxRepository

    @Mock
    private lateinit var tagRepository: TagRepository

    @InjectMocks
    private lateinit var createIncomeUseCase: CreateIncomeUseCase

    @BeforeAll
    fun init() {

        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun createIncome() {
        val conceptIncome = "Salary"
        val amount = 15_000_000.0
        val tag = Tag.byDefault().id

        // TODO(create builder CreateIncomeDataBuilder)
        val incomeCreateData = CreateIncomeData().apply {
            this.concept = conceptIncome; this.amount = amount; this.tagId = tag
        }
        Mockito.`when`(tagRepository.findById(MockitoHelper.anyObject()))
            .thenReturn(Optional.of(Tag.byDefault()))

        val income = this.createIncomeUseCase.create(incomeCreateData)

        assertEquals(conceptIncome, income.concept.description)
        assertEquals(amount, income.amount.amount)
        assertEquals(tag, income.tagId)

        // TODO(assert find income)

    }

}