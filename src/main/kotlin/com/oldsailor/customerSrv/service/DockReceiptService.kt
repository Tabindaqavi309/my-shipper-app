package com.oldsailor.customerSrv.service


import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.DockReceiptModel
import com.oldsailor.customerSrv.repository.DockReceiptRepository

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler


@Service
class DockReceiptService(private val db: DockReceiptRepository) {

    fun find(offset: Int, limit: Int): JSONObject {
        val count: Int = db.countData()
        val data = db.find(offset, limit)
        val rootObject = JSONObject()
        rootObject["data"] = data
        rootObject["count"] = count
        return rootObject
    }


    fun findDataByCustomerId(customerId: Long) = db.findDataByCustomerId(customerId)

    fun findDataById(id: Long) = db.findDataById(id)

    fun fullTextSearch(value: String): JSONObject {
        val count: Int = db.countDataSingle(value)
        val data = db.fullTextSearch(value)
        val rootObject = JSONObject()
        rootObject["data"] = data
        rootObject["count"] = count

        return rootObject
    }


    @ExceptionHandler(CustomException::class)
    fun insert(body: DockReceiptModel): DockReceiptModel {
        try {
            return db.save(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    fun update(body: DockReceiptModel) = db.save(body)


    @ExceptionHandler(CustomException::class)
    fun delete(id: Long) {
        try {
            db.deleteById(id)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }
}