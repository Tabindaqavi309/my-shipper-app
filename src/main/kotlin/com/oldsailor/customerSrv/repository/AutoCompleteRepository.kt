package com.oldsailor.customerSrv.repository

import com.oldsailor.customerSrv.model.AutoCompleteModel
 import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface AutoCompleteRepository: CrudRepository<AutoCompleteModel, Long> {

    @Query(
        value = "SELECT * FROM auto_completes",
        nativeQuery = true
    )
    fun findAutoComplete(): List<AutoCompleteModel>

}