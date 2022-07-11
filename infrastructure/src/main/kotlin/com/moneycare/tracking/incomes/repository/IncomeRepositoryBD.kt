package com.moneycare.tracking.incomes.repository

import com.moneycare.tracking.incomes.Income
import com.moneycare.tracking.incomes.IncomeRepository
import org.springframework.stereotype.Repository

@Repository
open class IncomeRepositoryBD: IncomeRepository {

    override fun save(income: Income) {
        println(income)
    }

}