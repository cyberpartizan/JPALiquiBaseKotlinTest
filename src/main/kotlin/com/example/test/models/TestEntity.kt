package com.example.test.models

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "tests")
data class TestEntity(

    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID? = null,

    @Column(name = "name")
    var name: String? = null,

    @OneToOne()
    @JoinColumn(name = "document_id")
    var document: Document? = null,

    @OneToOne
    @JoinColumn(name = "dictionary_value_id")
    var dictionaryValue: DictionaryValue? = null
) {



}