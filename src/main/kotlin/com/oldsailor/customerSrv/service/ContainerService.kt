package com.oldsailor.customerSrv.service

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.ContainerModel
import com.oldsailor.customerSrv.model.ContainerResponseSingle
import com.oldsailor.customerSrv.repository.ContainerRepository
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*


@Service
class ContainerService(private val db: ContainerRepository) {
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



    fun findByCustomerId(id: Long, offset: Int, limit: Int): JSONObject {
        val count: Int = db.countCustomerContainerData(id)
        val data = db.findByCustomerId(id, offset, limit)
        val rootObject = JSONObject()
        rootObject["data"] = data
        rootObject["count"] = count
        return rootObject
    }


    fun findDataById(id: Long): ContainerResponseSingle = db.findDataById(id)



    @ExceptionHandler(CustomException::class)
    fun insert(container: ContainerModel): ContainerModel {
        try {
            return db.save(container)
        } catch (e: Exception) {
            throw CustomException("Container already initiated")
        }
    }

    fun update(containerId: Long, container: ContainerModel) {
        var data: Optional<ContainerModel> = db.findById(containerId)
        container.id = data.get().id
        db.save(container)
    }

    @ExceptionHandler(CustomException::class)
    fun delete(containerId: Long) {
        try {
            db.deleteById(containerId)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }
}
