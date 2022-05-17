package com.moneycare.tracking.incomes.repository

import com.moneycare.tracking.incomes.models.Income
import org.springframework.stereotype.Repository

@Repository
open class IncomeRepositoryBD: IncomeRepository {

    override fun save(income: Income) {
        println(income)
    }

}