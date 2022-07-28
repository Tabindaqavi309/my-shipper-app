package com.oldsailor.customerSrv.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*


@Table(name = "consignees")
@Entity
data class CongModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?,
    @Column(unique = true)
    var full_name: String,
    @Column(unique = true)
    var phone_number: String?,
    var email: String?,
    var address: String?,
    var city: String?,
    var state: String?,
    var zipcode: String?,
    var care_of: String?,
    var country: String?,
    var customer_id: Long
)



