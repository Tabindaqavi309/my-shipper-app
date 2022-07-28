package com.oldsailor.customerSrv.service


import com.oldsailor.customerSrv.exception.CustomException
import com.oldsailor.customerSrv.model.CarModel
import com.oldsailor.customerSrv.repository.CarRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@Service
class CarService(private val db: CarRepository) {
    fun find(containerId: Long): List<CarModel> = db.find(containerId)

    @ExceptionHandler(CustomException::class)
    @Transactional
    fun insert(car: List<CarModel>) {
        try {
            db.saveAll(car)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }

    fun updateAll(car: List<CarModel>): Iterable<CarModel> {
        println(car)
        return db.saveAll(car)
    }


    @ExceptionHandler(CustomException::class)
    fun delete(carId: Long) {
        try {
            db.deleteById(carId)
        } catch (e: Exception) {
            throw CustomException(e.message)
        }
    }
}