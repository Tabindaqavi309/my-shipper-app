package com.oldsailor.customerSrv.controller

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.CustomerModel
import com.oldsailor.customerSrv.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/api/customer-srv/customer")
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService


    @GetMapping("/")
    fun index(@RequestParam offset: String, @RequestParam limit: String) =
        customerService.find(offset.toInt(), limit.toInt())


    @PostMapping("/full-text-search")
    fun searchByCustomer(@RequestBody req: SearchObj1): JSONObject {
        try {
         return   customerService.fullTextSearch(req.value)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun addCustomer(@RequestBody customer: CustomerModel): CustomerModel {
        try {
            return customerService.addCustomer(customer)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCustomer(@RequestBody customer: CustomerModel, @PathVariable customerId: Long) =
        customerService.update(customerId, customer)


    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteCustomer(@PathVariable customerId: Long) {
        try {
            customerService.delete(customerId)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

}

class SearchObj1(val value: String)