package com.moneycare.tracking.tags.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tags")
data class TagEntity (
    @Id
    var id : String,
    @Column
    var name : String
)
