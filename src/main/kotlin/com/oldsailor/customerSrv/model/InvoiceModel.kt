package com.oldsailor.customerSrv.model

import java.util.*
import javax.persistence.*

@Table(name = "invoices")
@Entity
data class InvoiceModel
    (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id")
    var id: Long?,
    @Column(unique = true, name = "date_added")
    var date_added: Date?,
    var ocean_freight: String?,
    var truck: String?,
    var ectn_besc: String?,
    var label_1: String?,
    var label_1_value: String?,
    var label_2: String?,
    var label_2_value: String?,
    var label_3: String?,
    var label_3_value: String?,
    var label_4: String?,
    var label_4_value: String?,
    var label_5: String?,
    var label_5_value: String?,
    var label_6: String?,
    var label_6_value: String?,
    var invoice_total: Int?,
    var balance_due: Int?,
    var dock_receipt_id: Long?,
    var customer_id: Long?,

    )