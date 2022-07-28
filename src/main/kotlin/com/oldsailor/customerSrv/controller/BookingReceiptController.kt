package com.oldsailor.customerSrv.controller

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.BookingReceiptModel
import com.oldsailor.customerSrv.service.BookingReceiptService


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/receipt-srv")
class BookingReceiptController {
    @Autowired
    lateinit var bookingReceiptService: BookingReceiptService

    @GetMapping("/booking_receipts")
    @ResponseStatus(HttpStatus.OK)
    fun index(@RequestParam offset: String, @RequestParam limit: String): JSONObject {
        return bookingReceiptService.find(offset.toInt(), limit.toInt())
    }

    @GetMapping("/booking_receipt/find-by-customerId/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findByCustomerId(@PathVariable id: String): List<BookingReceiptModel> {
        return bookingReceiptService.findByCustomerId(id.toLong())
    }

    @PostMapping("/booking_receipt/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody body: BookingReceiptModel): BookingReceiptModel {
        try {
            return bookingReceiptService.insert(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @PutMapping("/booking_receipt/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @RequestBody body: BookingReceiptModel,
    ) {
        bookingReceiptService.update(body)
    }

    @DeleteMapping("/booking_receipt/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable id: Long) {
        try {
            bookingReceiptService.delete(id)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @GetMapping("/booking_receipt/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findDataById(@PathVariable id: Long) = bookingReceiptService.findDataById(id)

    @PostMapping("/booking_receipt/full-text-search")
    fun fullTextSearch(@RequestBody req: SearchObj): JSONObject {
        try {
            return  bookingReceiptService.fullTextSearch(req.value)
        } catch (e: java.lang.Exception) {
            throw CustomException(e.message)
        }
    }
}