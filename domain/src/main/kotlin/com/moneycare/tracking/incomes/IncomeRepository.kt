package com.moneycare.tracking.incomes

import java.util.UUID
import java.util.Optional

interface IncomeRepository {

    fun save(income: Income)
    fun findById(id : UUID) : Optional<Income>

}