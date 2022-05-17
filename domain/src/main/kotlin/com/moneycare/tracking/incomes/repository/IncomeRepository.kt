package com.moneycare.tracking.incomes.repository

import com.moneycare.tracking.incomes.models.Income

interface IncomeRepository {

    fun save(income: Income)

}