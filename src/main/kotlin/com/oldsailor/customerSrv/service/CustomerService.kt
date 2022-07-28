package com.oldsailor.customerSrv.service

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.CustomerModel
import com.oldsailor.customerSrv.repository.CustomerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@Service
class CustomerService(val db: CustomerRepository) {

    fun find(offset: Int, limit: Int): JSONObject {
        val count: Int = db.countData()
        val data = db.findCustomers(offset, limit)
        val rootObject = JSONObject()
        rootObject["data"] = data
        rootObject["count"] = count

        return rootObject
    }

    fun fullTextSearch(value: String): JSONObject {
        val count: Int = db.countDataSingle(value)
        val data = db.fullTextSearch(value)
        val rootObject = JSONObject()
        rootObject["data"] = data
        rootObject["count"] = count

        return rootObject
    }


    @ExceptionHandler(CustomException::class)
    fun addCustomer(customer: CustomerModel): CustomerModel {
        try {
            return db.save(customer)
        } catch (e: Exception) {
            throw CustomException("Customer exist, duplicate error attempt")
        }
    }

    fun update(customerId: Long, customer: CustomerModel) {
        var data: Optional<CustomerModel> = db.findById(customerId)
        customer.id = data.get().id
        db.save(customer)
    }

    @ExceptionHandler(CustomException::class)
    fun delete(customerId: Long) {
        db.deleteById(customerId)
    }
}