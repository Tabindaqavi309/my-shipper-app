package com.oldsailor.customerSrv.repository

import java.math.BigInteger
import javax.persistence.Column

interface FullTextSearchResponse {
    var id: Long;
    var full_name: String;
    var phone_number: String;
    var email: String;
    var address: String;
    var city: String;
    var state: String;
    var zipcode: String;
    var irs_tax_id: String;
    var passport_number: String;
    var ssn: String;
}


interface FullTextSearchConsigneeResponse {
    var id: Long;
    var full_name: String;
    var phone_number: String;
    var email: String;
    var address: String;
    var city: String;
    var state: String;
    var zipcode: String;
    var care_of: String;
    var country: String;
    var customer_id: Long;
}
//
//interface FullTextSearchResponse {
//    val id: Long;
//    val full_name: String;
//}