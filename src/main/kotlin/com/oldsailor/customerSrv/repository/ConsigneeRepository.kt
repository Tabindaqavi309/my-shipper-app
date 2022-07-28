package com.oldsailor.customerSrv.repository

import com.oldsailor.customerSrv.model.CongModel
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ConsigneeRepository : CrudRepository<CongModel, Long> {
    @Query(value = "SELECT * FROM consignees LIMIT ?2 OFFSET ?1", nativeQuery = true)
    fun findConsignee(offset: Int, limit: Int): List<CongModel>

    @Query(value = "SELECT * FROM consignees WHERE full_name LIKE ?1%", nativeQuery = true)
    fun fullTextSearch(value: String): List<FullTextSearchConsigneeResponse>

    @Query(value = "SELECT * FROM consignees WHERE customer_id = ?1", nativeQuery = true)
    fun findConsigneeByCustomerId(value: Long): List<CongModel>

    @Query(
        value = "SELECT COUNT(*) FROM consignees",
        nativeQuery = true
    )
    fun countData(): Int

    @Query(
        value = "SELECT COUNT(*) FROM consignees WHERE full_name LIKE ?1%",
        nativeQuery = true
    )
    fun countDataSingle(value: String): Int

}