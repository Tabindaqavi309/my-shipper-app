package com.oldsailor.customerSrv.controller

import com.nimbusds.jose.shaded.json.JSONObject
import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.CarModel
import com.oldsailor.customerSrv.model.ContainerModel
import com.oldsailor.customerSrv.model.ContainerUpdateBody
import com.oldsailor.customerSrv.service.CarService
import com.oldsailor.customerSrv.service.ContainerService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/container-srv")
class ContainerController {

    @Autowired
    lateinit var containerService: ContainerService

    @Autowired
    lateinit var carService: CarService

    @PostMapping("/container/full-text-search")
    fun fullTextSearch(@RequestBody req: SearchObj): JSONObject {
        try {
            return  containerService.fullTextSearch(req.value)
        } catch (e: java.lang.Exception) {
            throw CustomException(e.message)
        }
    }

    @GetMapping("/containers")
    @ResponseStatus(HttpStatus.OK)
    fun index(@RequestParam offset: String, @RequestParam limit: String): JSONObject {
        return containerService.find(offset.toInt(), limit.toInt())
    }

    @GetMapping("/containers/find-by-customer-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findByCustomerId(@PathVariable id: Long, @RequestParam offset: Int, @RequestParam limit: Int ): JSONObject {
        return containerService.findByCustomerId(id, offset, limit)
    }


    @PostMapping("/container/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody container: ContainerModel): ContainerModel {
        try {
            return containerService.insert(container)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @PutMapping("/container/{containerId}/update")
    @ResponseStatus(HttpStatus.OK)
    fun update(
        @RequestBody data: ContainerUpdateBody,
        @PathVariable containerId: Long
    ) {
        var container: ContainerModel = data.container
        var car: List<CarModel> = data.car
        containerService.update(containerId, container)
        carService.updateAll(car)
    }

    @DeleteMapping("/container/{containerId}/delete")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable containerId: Long) {
        try {
            containerService.delete(containerId)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    @GetMapping("/container/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findDataById(@PathVariable id: Long) = containerService.findDataById(id)

}


class SearchObj(val value: String)