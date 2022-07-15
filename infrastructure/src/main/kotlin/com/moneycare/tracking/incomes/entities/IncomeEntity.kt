package com.moneycare.tracking.incomes.entities

import com.moneycare.tracking.tags.entities.TagEntity
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.ManyToOne

@Entity
@Table(name = "incomes")
data class IncomeEntity (
    @Id
    @Column(columnDefinition = "BINARY(16)")
    var id : UUID,
    @Column
    var concept : String,
    @Column
    var amount : Double,
    @Column
    var date : LocalDateTime,

) {
    @Column
    @CreatedDate
    lateinit var createdAt : LocalDateTime

    @ManyToOne
    lateinit var tag : TagEntity
}