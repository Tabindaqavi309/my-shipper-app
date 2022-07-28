package com.oldsailor.customerSrv.controller

import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.CarModel
import com.oldsailor.customerSrv.service.CarService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.lang.Exception

@RestController
@RequestMapping("/api/container-srv")
class CarController {

    @Autowired
    lateinit var carService: CarService

    @GetMapping("/cars/{containerId}")
    @ResponseStatus(HttpStatus.OK)
    fun index( @PathVariable containerId: Long): List<CarModel> {
        return carService.find(containerId.toLong())
    }

    @PostMapping("/car/create")
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@RequestBody car: List<CarModel>): Unit {
        try {
            carService.insert(car)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }


    @DeleteMapping("/car/{carId}/delete")
    @ResponseStatus(HttpStatus.OK)
    fun delete(@PathVariable carId: Long) {
        try {
            carService.delete(carId)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }
}