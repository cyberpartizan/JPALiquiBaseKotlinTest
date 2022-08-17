package com.example.test.models

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "dictionary_values")
data class DictionaryValue(

    @Id
    @Column(name = "dictionary_value_id", nullable = false, columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    val id: UUID? = null,
    @Column(name = "name")
    var name: String? = null
) {

}