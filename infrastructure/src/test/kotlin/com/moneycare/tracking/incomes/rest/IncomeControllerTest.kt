package com.moneycare.tracking.incomes.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.moneycare.shared.model.Currency
import com.moneycare.tracking.incomes.IncomeRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import com.moneycare.tracking.incomes.rest.request.CreateIncomeRequestBuilder
import com.moneycare.tracking.incomes.rest.response.IncomeResponse
import com.moneycare.tracking.tags.Tag
import com.moneycare.tracking.tags.TagRepository
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IncomeControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var incomeRepository: IncomeRepository

    @Autowired
    private lateinit var tagRepository: TagRepository

    @Test
    fun createIncome() {

        val tagUndefined = Tag.undefined()
        tagRepository.save(tagUndefined)
        val createIncomeRequest = CreateIncomeRequestBuilder()
            .withTagId(tagUndefined.id)
            .build()

        val response = mockMvc.perform(
            MockMvcRequestBuilders.post(URLIncomes.URL)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(createIncomeRequest))
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.notNullValue()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.concept", Matchers.equalTo("Salary")))
            .andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.equalTo(100.0)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.currency", Matchers.equalTo(Currency.COP.name)))
            .andExpect(MockMvcResultMatchers.jsonPath("$.date", Matchers.notNullValue()))
            .andExpect(MockMvcResultMatchers.jsonPath("$.tagId", Matchers.equalTo(tagUndefined.id)))


        val income : IncomeResponse = objectMapper.readValue(response.andReturn().response.contentAsString)

        val incomePersisted = incomeRepository.findById(income.id)

        assertTrue(incomePersisted.isPresent)
        assertEquals(income.id, incomePersisted.get().id)

    }
}