package com.example.test.models

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "documents")
data class Document(

    @Id
    @Column(name = "document_id", nullable = false, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID? = null,

    @Column(name = "date")
    var date: LocalDate? = null
) {

}