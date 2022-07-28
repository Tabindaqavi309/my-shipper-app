package com.oldsailor.customerSrv.service

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.AutoCompleteModel
import com.oldsailor.customerSrv.model.POANRAModel
import com.oldsailor.customerSrv.model.POANRASingleResponse
import com.oldsailor.customerSrv.repository.AutoCompleteRepository
import com.oldsailor.customerSrv.repository.POANRARepository

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@Service
class POANRAService(private val db: POANRARepository, private val autoCompleteDB: AutoCompleteRepository) {
    fun find(offset: Int, limit: Int): JSONObject {
        val count: Int = db.countData()
        val data = db.find(offset, limit)
        val rootObject = JSONObject()
        rootObject["data"] = data
        rootObject["count"] = count

        return rootObject
    }


    fun findAutoComplete(): List<AutoCompleteModel> = autoCompleteDB.findAutoComplete()


    fun findDataById(id: Long): POANRASingleResponse = db.findDataById(id)

    fun fullTextSearch(value: String): JSONObject {
        val count: Int = db.countDataSingle(value)
        val data = db.fullTextSearch(value)
        val rootObject = JSONObject()
        rootObject["data"] = data
        rootObject["count"] = count

        return rootObject
    }



    @ExceptionHandler(CustomException::class)
    fun insertAutoComplete(body: AutoCompleteModel): AutoCompleteModel {
        try {
            return autoCompleteDB.save(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @ExceptionHandler(CustomException::class)
    fun insert(body: POANRAModel): POANRAModel {
        try {
            return db.save(body)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    fun update(body: POANRAModel) = db.save(body)


    @ExceptionHandler(CustomException::class)
    fun delete(id: Long) {
        try {
            db.deleteById(id)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }
}