package com.moneycare.tracking.incomes

import com.moneycare.shared.helper.MockitoHelper
import com.moneycare.shared.messages.outbox.repository.OutboxRepository
import com.moneycare.tracking.incomes.commands.CreateIncomeData
import com.moneycare.tracking.incomes.models.Tag
import com.moneycare.tracking.incomes.repository.IncomeRepository
import com.moneycare.tracking.incomes.repository.TagRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreateIncomeCreatorTest {

    @Mock
    private lateinit var incomeRepository: IncomeRepository

    @Mock
    private lateinit var outboxRepository: OutboxRepository

    @Mock
    private lateinit var tagRepository: TagRepository

    @InjectMocks
    private lateinit var createIncomeCreator: CreateIncomeCreator

    @BeforeAll
    fun init() {

        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun createIncome() {
        val conceptIncome = "Salary"
        val amount = 15_000_000.0
        val tag = Tag.byDefault().id

        val incomeCreateData = CreateIncomeData().apply {
            this.concept = conceptIncome; this.amount = amount; this.tagId = tag
        }
        Mockito.`when`(tagRepository.findById(MockitoHelper.anyObject()))
            .thenReturn(Optional.of(Tag.byDefault()))

        val income = this.createIncomeCreator.create(incomeCreateData)

        assertEquals(conceptIncome, income.concept.description)
        assertEquals(amount, income.amount.amount)
        assertEquals(tag, income.tagId)
        assertEquals(1, income.messages.size)

    }

}