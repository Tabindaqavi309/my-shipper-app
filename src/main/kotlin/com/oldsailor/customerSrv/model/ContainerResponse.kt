package com.oldsailor.customerSrv.model


import java.util.*

interface ContainerResponse {
    var id: Long;
    var date_added: Date;
    var container_content: String;
    var personal_effect: String;
    var container_type: String;
    var freight: String?;
    var unit: String?;
    var in_transit: String?;
    var full_name: String;
    var weight: Int?;
    var measurement: Int?;
    var total_weight: Int?;
    var customerId: Long;

}


interface ContainerResponseSingle {
    var id: Long;
    var date_added: Date;
    var container_content: String;
    var personal_effect: String;
    var container_type: String;
    var freight: String?;
    var unit: String?;
    var in_transit: String?;
    var full_name: String;
    var weight: Int?;
    var measurement: Int?;
    var total_weight: Int?;
    var customer_id: Long;

}


class ContainerUpdateBody(
    var container: ContainerModel,
    var car: List<CarModel>
)




