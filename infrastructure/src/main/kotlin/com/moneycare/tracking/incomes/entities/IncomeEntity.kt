package com.moneycare.tracking.incomes.entities

import com.moneycare.tracking.tags.entities.TagEntity
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "incomes")
class IncomeEntity {

    @Id
    lateinit var id : UUID

    lateinit var concept : String

    var amount : Double = 0.0

    lateinit var date : LocalDateTime

    @CreatedDate
    lateinit var createdAt : LocalDateTime

    @ManyToOne
    lateinit var tag : TagEntity

}