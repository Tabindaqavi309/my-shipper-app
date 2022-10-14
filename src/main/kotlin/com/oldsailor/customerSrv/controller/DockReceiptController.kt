
package com.oldsailor.customerSrv.controller

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.DockReceiptModel
import com.oldsailor.customerSrv.service.DockReceiptService


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/receipt-srv")
class DockReceiptController {
    @Autowired
    lateinit var dockReceiptService: DockReceiptService

    @GetMapping("/dock_receipts")
    @ResponseStatus(HttpStatus.OK)
    fun index(@RequestParam offset: String, @RequestParam limit: String): JSONObject {
        return dockReceiptService.find(offset.toInt(), limit.toInt())
    }

    @GetMapping("/dock_receipts/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    fun findDataByCustomerId(@PathVariable customerId: Long) =  dockReceiptService.findDataByCustomerId(customerId)

    @PostMapping("/dock_receipt/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody body: DockReceiptModel): DockReceiptModel {
        try {
            return dockReceiptService.insert(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @PutMapping("/dock_receipt/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @RequestBody body: DockReceiptModel,
    ) {
        dockReceiptService.update(body)
    }

    @DeleteMapping("/dock_receipt/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) {
        try {
            dockReceiptService.delete(id)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @GetMapping("/dock_receipt/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findDataById(@PathVariable id: Long) = dockReceiptService.findDataById(id).first();

    @PostMapping("/dock_receipt/full-text-search")
    fun fullTextSearch(@RequestBody req: SearchObj): JSONObject {
        try {
            return  dockReceiptService.fullTextSearch(req.value)
        } catch (e: java.lang.Exception) {
            throw CustomException(e.message)
        }
    }
}