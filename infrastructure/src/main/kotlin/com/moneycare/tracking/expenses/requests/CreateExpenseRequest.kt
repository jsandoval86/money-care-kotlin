package com.moneycare.tracking.expenses.requests

class CreateExpenseRequest {
    lateinit var concept: String
    var amount : Double = 0.0
    var tagId : String? = null
}