package com.oldsailor.customerSrv.model

import java.util.*
import javax.persistence.*


@Table(name = "dock_receipts")
@Entity
data class DockReceiptModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id")
    var id: Long?,
    @Column(unique = true, name = "date_added")
    var date_added: Date?,
    var customer_id: Long,
    var consignee_id: Long,
    var container_id: Long,
    var booking_id: Long,
    var notify_party_name: String?,
    var notify_party_address: String?,
    var notify_party_country: String?,
    var notify_party_phone_number: String?,
    var seal_number: String?,
    var demurrage: String?,
    var container_number: String?,
    var aes_number: String?,
    var originals_to_be_released: String?,
    var client_as_agent: Boolean?,
    var forwarding_agent_references: String?,
    var for_transhipment_to: String?,
    var point_and_country_of_origin: String?,

    )