package com.oldsailor.customerSrv.repository

 import com.oldsailor.customerSrv.model.CarModel
 import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : CrudRepository<CarModel, Long> {
    @Query(value = "SELECT * FROM cars WHERE container_id = ?1", nativeQuery = true)
    fun find( containerId: Long): List<CarModel>


}