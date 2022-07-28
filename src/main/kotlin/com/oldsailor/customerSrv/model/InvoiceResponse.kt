package com.oldsailor.customerSrv.model

import java.util.*

interface InvoiceResponse {
    var id: Long?;
    var date_added: Date?;
    var ocean_freight: String?;
    var truck: String?;
    var ectn_besc: String?;
    var label_1: String?;
    var label_1_value: String?;
    var label_2: String?;
    var label_2_value: String?;
    var label_3: String?;
    var label_3_value: String?;
    var label_4: String?;
    var label_4_value: String?;
    var label_5: String?;
    var label_5_value: String?;
    var label_6: String?;
    var label_6_value: String?;
    var invoice_total: String?;
    var balance_due: String?;
    var dock_receipt_id: Long?;
    var customer_id: Long?;
    var booking_number: String;
    var customer_name: String;
    var container_number: String;
}