package com.oldsailor.customerSrv.controller

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.CongModel
import com.oldsailor.customerSrv.service.ConsigneeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.lang.Exception


@RestController
@RequestMapping("/api/customer-srv/consignee")
class ConsigneeController {

    @Autowired
    lateinit var consigneeService: ConsigneeService

    @GetMapping("")
    fun index(@RequestParam offset: String, @RequestParam limit: String) =
        consigneeService.find(offset.toInt(), limit.toInt())

    @GetMapping("/find-by-customerId/{customerId}")
    fun findConsigneeByCustomerId(@PathVariable customerId: Long): List<CongModel> {
        return consigneeService.findConsigneeByCustomerId(customerId)
    }

    @PostMapping("/full-text-search")
    fun searchByConsignee(@RequestBody req: SearchObj): JSONObject {
        try {
            return   consigneeService.fullTextSearch(req.value)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    fun addConsignee(@RequestBody consignee: CongModel): CongModel {
        try {
            return consigneeService.addConsignee(consignee)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @PutMapping("/{consigneeId}")
    @ResponseStatus(HttpStatus.OK)
    fun updateCustomer(@RequestBody consignee: CongModel, @PathVariable consigneeId: Long) =
        consigneeService.update(consigneeId, consignee)


    @DeleteMapping("/{consigneeId}")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable consigneeId: Long) {
        try {
            consigneeService.delete(consigneeId)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }
}

