package com.oldsailor.customerSrv.repository

import com.oldsailor.customerSrv.model.POANRAModel
import com.oldsailor.customerSrv.model.POANRAResponse
import com.oldsailor.customerSrv.model.POANRASingleResponse

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface POANRARepository: CrudRepository<POANRAModel, Long> {
    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, poa_nras.* FROM poa_nras LEFT JOIN customers ON poa_nras.customer_id = customers.id ORDER BY poa_nras.id DESC LIMIT ?2 OFFSET ?1",
        nativeQuery = true
    )
    fun find(offset: Int, limit: Int): List<POANRAResponse>


    @Query(
        value = "SELECT COUNT(*) FROM poa_nras",
        nativeQuery = true
    )
    fun countData(): Int

    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.email, customers.passport_number, customers.address AS cus_address, customers.city AS cus_city, customers.zipcode AS cus_zipcode, customers.state AS cus_state, customers.phone_number, customers.irs_tax_id, customers.id AS customerId," +
                " poa_nras.*, " +
                "consignees.full_name AS con_name, consignees.address AS con_address, consignees.city AS con_city, consignees.state AS con_state, consignees.zipcode AS con_zip, consignees.phone_number AS con_tel, consignees.country AS con_country, consignees.email AS con_email " +
                "FROM poa_nras " +
                "LEFT JOIN customers ON poa_nras.customer_id = customers.id " +
                "LEFT JOIN consignees ON consignees.customer_id = customers.id " +
                "WHERE poa_nras.id = ?1",
        nativeQuery = true
    )
    fun findDataById(id: Long): POANRASingleResponse



    @Query(value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, poa_nras.* FROM poa_nras LEFT JOIN customers ON poa_nras.customer_id = customers.id WHERE customers.full_name LIKE ?1%", nativeQuery = true)
    fun fullTextSearch(value: String): List<POANRAResponse>


    @Query(
        value = "SELECT COUNT(*) FROM poa_nras LEFT JOIN customers ON poa_nras.customer_id = customers.id WHERE customers.full_name LIKE ?1%",
        nativeQuery = true
    )
    fun countDataSingle(value: String): Int


}
