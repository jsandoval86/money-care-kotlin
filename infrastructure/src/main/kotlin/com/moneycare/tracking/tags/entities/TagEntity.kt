package com.moneycare.tracking.tags.entities

import com.moneycare.tracking.tags.TagType
import javax.persistence.*

@Entity
@Table(name = "tags")
data class TagEntity (
    @Id
    var id: String,
    @Column
    var name: String,
    @Column
    @Enumerated(EnumType.STRING)
    var type: TagType
)
