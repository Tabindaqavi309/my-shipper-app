package com.oldsailor.customerSrv.model

import java.util.*

interface POANRAResponse {
    var id: Long?;
    var date_added: Date;
    var customer_id: Long;
    var consignee_id: Long;
    var bill_of_lading_destination: String
    var bill_of_lading_origin: String;
    var cargo_qty: String;
    var customer_name: String;
    var carrier: String;
    var carrier_rep: String;
    var commodity: String;
    var destination_service: String;
    var effective_date: String;
    var expiration_date: String;
    var insurance: String;
    var maximum: String;
    var minimum: String;
    var origin_service: String;
    var port_of_destination: String;
    var rate: String;
    var rate_basis: String;
    var special_conditions: String;
    var type_of_payment: String;
    var type_of_shipment: String;
    var email: String?;
    var state: String?;
    var phone_number: String?;
}


interface POANRASingleResponse {
    var id: Long?;
    var date_added: Date;
    var customer_id: Long;
    var consignee_id: Long;
    var bill_of_lading_destination: String
    var bill_of_lading_origin: String;
    var cargo_qty: String;
    var customer_name: String;
    var carrier: String;
    var carrier_rep: String;
    var commodity: String;
    var destination_service: String;
    var effective_date: String;
    var expiration_date: String;
    var insurance: String;
    var maximum: String;
    var minimum: String;
    var origin_service: String;
    var port_of_destination: String;
    var rate: String;
    var rate_basis: String;
    var special_conditions: String;
    var type_of_payment: String;
    var type_of_shipment: String;
    var email: String?;
    var cus_state: String?;
    var cus_city: String?;
    var cus_zipcode: String?;
    var phone_number: String?;
    var passport_number: String?;
    var cus_address: String?


    var con_name: String?
    var con_address: String?;
    var con_city: String?
    var con_state: String?
    var con_zip: String?;
    var con_tel: String?;
    var con_country: String;
    var con_email: String





}