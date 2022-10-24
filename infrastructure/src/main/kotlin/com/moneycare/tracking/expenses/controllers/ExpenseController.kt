package com.moneycare.tracking.expenses.controllers

import com.moneycare.tracking.expenses.CreateExpenseData
import com.moneycare.tracking.expenses.Expense
import com.moneycare.tracking.expenses.ExpenseCreator
import com.moneycare.tracking.expenses.controllers.mappers.CreateExpenseRequestMapper
import com.moneycare.tracking.expenses.requests.CreateExpenseRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class ExpenseController(
    private val expenseCreator : ExpenseCreator,
    private val createExpenseRequestMapper: CreateExpenseRequestMapper
) {

    @PostMapping
    fun create(@RequestBody request : CreateExpenseRequest) : Expense {
        val createExpenseData = this.createExpenseRequestMapper.mapToData(request)
        return this.expenseCreator.create(createExpenseData)
    }

}