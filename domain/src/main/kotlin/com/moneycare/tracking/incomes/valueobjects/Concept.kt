package com.moneycare.tracking.incomes.valueobjects

data class Concept(
    var description : String
) {

    init {

        if( description.trim().isEmpty() ){
            description = "No description income"
        }

    }

}