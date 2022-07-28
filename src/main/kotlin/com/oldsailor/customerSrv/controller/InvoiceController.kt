
package com.oldsailor.customerSrv.controller

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.InvoiceModel
import com.oldsailor.customerSrv.service.InvoiceService



import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/receipt-srv")
class InvoiceController {
    @Autowired
    lateinit var invoiceService: InvoiceService

    @GetMapping("/invoices")
    @ResponseStatus(HttpStatus.OK)
    fun index(@RequestParam offset: String, @RequestParam limit: String): JSONObject {
        return invoiceService.find(offset.toInt(), limit.toInt())
    }

    @PostMapping("/invoice/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody body: InvoiceModel): InvoiceModel {
        try {
            return invoiceService.insert(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @PutMapping("/invoice/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @RequestBody body: InvoiceModel,
    ) {
        invoiceService.update(body)
    }

    @DeleteMapping("/invoice/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) {
        try {
            invoiceService.delete(id)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @PostMapping("/invoice/full-text-search")
    fun fullTextSearch(@RequestBody req: SearchObj2): JSONObject {
        try {
            return  invoiceService.fullTextSearch(req.value)
        } catch (e: java.lang.Exception) {
            throw CustomException(e.message)
        }
    }
}

class SearchObj2(val value: String)