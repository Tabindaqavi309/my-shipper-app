package com.oldsailor.customerSrv.service

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.CongModel
import com.oldsailor.customerSrv.repository.ConsigneeRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@Service
class ConsigneeService(val db: ConsigneeRepository) {

    fun find(offset: Int, limit: Int): JSONObject {
        val count: Int = db.countData()
        val data = db.findConsignee(offset, limit)
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

    fun findConsigneeByCustomerId(value: Long): List<CongModel> = db.findConsigneeByCustomerId(value)

    @ExceptionHandler(CustomException::class)
    fun addConsignee(consignee: CongModel): CongModel {
        try {
            return db.save(consignee)
        } catch (e: Exception) {
            throw CustomException("Consignee exist, duplicate error attempt")
        }
    }

    fun update(consigneeId: Long,consignee: CongModel) {
        var data: Optional<CongModel> = db.findById(consigneeId)
        consignee.id = data.get().id
        db.save(consignee)
    }

    @ExceptionHandler(CustomException::class)
    fun delete(consigneeId: Long) {
        db.deleteById(consigneeId)
    }
}