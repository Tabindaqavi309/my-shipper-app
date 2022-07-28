package com.oldsailor.customerSrv.model

import java.util.*
import javax.persistence.*


@Table(name = "booking_receipts")
@Entity
data class BookingReceiptModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id")
    var id: Long?,
    @Column(unique = true, name = "date_added")
    var date_added: Date?,
    var customer_id: Long,
    var consignee_id: Long,
    var vessel_name: String?,
    var voyage_number: String?,
    var booking_number: String?,
    var equipment_size: String?,
    var total_no_of_containers: String?,
    var loading_terminal: String?,
    var carrier: String?,
    var cut_off_date: Date?,
    var sail_date: Date?,
    var arrival_date: Date?,
    var commodity: String?,
    var type_of_move: String?,
    var pickup_terminal: String?,
    var place_of_receipt: String?,
    var port_of_loading: String?,
    var port_of_discharge: String?,
    var place_of_delivery: String?,
    var rate: String?,
    var notes: String?,
 )