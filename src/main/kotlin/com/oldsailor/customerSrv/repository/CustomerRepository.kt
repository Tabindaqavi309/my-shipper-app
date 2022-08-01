package com.oldsailor.customerSrv.repository

import com.oldsailor.customerSrv.model.CustomerModel
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<CustomerModel, Long> {
    @Query(value = "SELECT * FROM customers ORDER BY id DESC LIMIT ?2 OFFSET ?1", nativeQuery = true)
    fun findCustomers(offset: Int, limit: Int): List<CustomerModel>

    // @Query(value = "SELECT id, full_name FROM CUSTOMERS WHERE full_name LIKE ?1%", nativeQuery = true)
    @Query(value = "SELECT * FROM customers WHERE full_name LIKE ?1%", nativeQuery = true)
    fun fullTextSearch(value: String): List<FullTextSearchResponse>

    @Query(
        value = "SELECT COUNT(*) FROM customers",
        nativeQuery = true
    )
    fun countData(): Int

    @Query(
        value = "SELECT COUNT(*) FROM customers WHERE full_name LIKE ?1%",
        nativeQuery = true
    )
    fun countDataSingle(value: String): Int

}

