package com.oldsailor.customerSrv.model

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*


@Table(name = "customers")
@Entity
data class CustomerModel(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique=true, name="id")
    var id: Long?,
    @Column(unique=true, name="full_name")
    var full_name: String,
    @Column(unique=true)
    var phone_number: String?,
    var email: String?,
    var address: String?,
    var city: String?,
    var state: String?,
    var zipcode: String?,
    var irs_tax_id: String?,
    var passport_number: String?,
    var ssn: String?
)