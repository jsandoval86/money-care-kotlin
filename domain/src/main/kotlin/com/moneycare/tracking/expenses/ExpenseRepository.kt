package com.moneycare.tracking.expenses

interface ExpenseRepository {

    fun save(expense : Expense)

}