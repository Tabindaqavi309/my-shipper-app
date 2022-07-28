package com.oldsailor.customerSrv.model

import com.fasterxml.jackson.annotation.JsonUnwrapped
import java.util.*
import javax.persistence.*

@Table(name = "containers")
@Entity
data class ContainerModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name="id")
    var id: Long?,
    @Column(unique=true, name="date_added")
    var date_added: Date?,
    var container_content: String?,
    var personal_effect: String?,
    var container_type: String?,
    var freight: String?,
    var unit: String?,
    var in_transit: String?,
    var weight: Int? = null,
    var measurement: Int? = null,
    var total_weight: Int? = null,
    var customer_id: Long,
)