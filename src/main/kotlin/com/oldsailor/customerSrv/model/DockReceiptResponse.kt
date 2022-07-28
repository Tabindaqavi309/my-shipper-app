package com.oldsailor.customerSrv.model

import java.util.*

interface DockReceiptResponse {
    var id: Long?;
    var date_added: Date?;
    var customer_id: Long;
    var consignee_id: Long;
    var container_id: Long;
    var customer_name: String;
    var booking_id: Long;
    var total_weight: Int?;
    var notify_party_name: String?;
    var notify_party_address: String?;
    var notify_party_country: String?;
    var notify_party_phone_number: String?;
    var seal_number: String?;
    var demurrage: String?;
    var container_number: String?;
    var aes_number: String?;
    var originals_to_be_released: String?;
    var client_as_agent: Boolean?;
    var forwarding_agent_references: String?;
    var for_transhipment_to: String?;
    var point_and_country_of_origin: String?;
    var personal_effect: String?
    var weight: Int?
    var measurement: Int?







}


interface DockReceiptResponseSingle {
    var id: Long?;
    var date_added: Date?;

    //container
    var personal_effect: String?
    var weight: Int?
    var measurement: Int?
    var container_content: String;
    var container_type: String;
    var total_weight: Int?;
    var container_number: String?;
    var freight: String?;
    var unit: String?;
    var in_transit: String?;


    //booking repo
    var vessel_name: String?;
    var voyage_number: String?;
    var booking_number: String?
    var port_of_loading: String?;
    var port_of_discharge: String?;
    var loading_terminal: String?;
    var carrier: String?;
    var pickup_terminal: String?;
    var place_of_receipt: String?;
    var type_of_move: String?;
    var cut_off_date: Date?;
    var sail_date: Date?;
    var arrival_date: Date?;
    var equipment_size: String?;



    //dock
    var originals_to_be_released: String?;
    var point_and_country_of_origin: String?;
    var for_transhipment_to: String?;
    var aes_number: String?;
    var forwarding_agent_references: String?;
    var seal_number: String?;
    var client_as_agent: String?;
    var demurrage: String?;

    var notify_party_name: String?;
    var notify_party_address: String?;
    var notify_party_country: String?;
    var notify_party_phone_number: String?;



    //cus
    var email: String?;
    var cus_state: String?;
    var cus_city: String?;
    var cus_zipcode: String?;
    var phone_number: String?;
    var passport_number: String?;
    var cus_address: String?
    var customer_name: String;

    //con
    var con_name: String?
    var con_address: String?;
    var con_city: String?
    var con_state: String?
    var con_zip: String?;
    var con_tel: String?;
    var con_country: String;
    var con_email: String



}