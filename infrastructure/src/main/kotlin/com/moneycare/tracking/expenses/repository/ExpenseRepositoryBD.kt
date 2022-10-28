package com.moneycare.tracking.expenses.repository

import com.moneycare.tracking.expenses.Expense
import com.moneycare.tracking.expenses.ExpenseRepository
import org.springframework.stereotype.Repository

@Repository
open class ExpenseRepositoryBD : ExpenseRepository {

    override fun save(expense: Expense) {
        // TODO: save expense
        println(expense)
    }

}