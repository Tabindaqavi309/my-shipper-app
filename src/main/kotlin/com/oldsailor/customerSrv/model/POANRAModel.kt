package com.oldsailor.customerSrv.model

import java.util.*
import javax.persistence.*


@Table(name = "poa_nras")
@Entity
data class POANRAModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id")
    var id: Long?,
    @Column(unique = true, name = "date_added")
    var date_added: Date?,
    var customer_id: Long,
    var consignee_id: Long,
    var bill_of_lading_destination: String?,
    var bill_of_lading_origin: String?,
    var cargo_qty: String?,
    var carrier: String?,
    var carrier_rep: String?,
    var commodity: String?,
    var destination_service: String?,
    var effective_date: Date?,
    var expiration_date: Date?,
    var insurance: Boolean,
    var maximum: String?,
    var minimum: String?,
    var origin_service: String?,
    var port_of_destination: String?,
    var rate: String?,
    var rate_basis: String?,
    var special_conditions: String?,
    var type_of_payment: String?,
    var type_of_shipment: String?,
)