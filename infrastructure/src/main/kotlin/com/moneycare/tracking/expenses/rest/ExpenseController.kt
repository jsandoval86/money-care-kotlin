package com.moneycare.tracking.expenses.rest

import com.moneycare.tracking.expenses.Expense
import com.moneycare.tracking.expenses.CreateExpenseUseCase
import com.moneycare.tracking.expenses.rest.mappers.CreateExpenseRequestMapper
import com.moneycare.tracking.expenses.rest.requests.CreateExpenseRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class ExpenseController(
    private val createExpenseUseCase : CreateExpenseUseCase,
    private val createExpenseRequestMapper: CreateExpenseRequestMapper
) {

    @PostMapping
    fun create(@RequestBody request : CreateExpenseRequest) : Expense {
        val createExpenseData = this.createExpenseRequestMapper.mapToData(request)
        return this.createExpenseUseCase.create(createExpenseData)
    }

}