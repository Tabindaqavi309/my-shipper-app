

package com.oldsailor.customerSrv.service

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.InvoiceModel
import com.oldsailor.customerSrv.repository.InvoiceRepository

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler


@Service
class InvoiceService(private val db: InvoiceRepository) {

    fun find(offset: Int, limit: Int): JSONObject {
        val count: Int = db.countData()
        val data = db.find(offset, limit)
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
    fun insert(body: InvoiceModel): InvoiceModel {
        try {
            return db.save(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    fun update(body: InvoiceModel) = db.save(body)


    @ExceptionHandler(CustomException::class)
    fun delete(id: Long) {
        try {
            db.deleteById(id)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }
}