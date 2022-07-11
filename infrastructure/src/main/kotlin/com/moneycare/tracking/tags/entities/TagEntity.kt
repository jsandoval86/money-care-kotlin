package com.moneycare.tracking.tags.entities

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "tags")
class TagEntity {

    @Id
    lateinit var id : UUID

    lateinit var name : String
}