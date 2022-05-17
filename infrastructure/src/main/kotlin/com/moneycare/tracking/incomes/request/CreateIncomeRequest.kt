package com.moneycare.tracking.incomes.request


/*
 * Documentation API
 * Validation entry layer
 * Values can be expressed in http terms
 *      example : in a query /url?ids=1,2,3,4
 * Lets use validation annotations
 */
class CreateIncomeRequest {
    lateinit var concept : String
    var amount : Double = 0.0
    var tagId : String? = null
}

