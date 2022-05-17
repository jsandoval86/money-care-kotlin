package com.moneycare.tracking.incomes.request

import java.util.UUID

class CreateIncomeRequestBuilder {

    private var concept : String  = "Salary"
    private var amount  : Double  = 100.0
    private var tagId   : String? = UUID.randomUUID().toString()

    fun build() : CreateIncomeRequest {
        return CreateIncomeRequest().apply {
            this.concept = this@CreateIncomeRequestBuilder.concept
            this.amount = this@CreateIncomeRequestBuilder.amount
            this.tagId = this@CreateIncomeRequestBuilder.tagId
        }
    }

}
