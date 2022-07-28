package com.oldsailor.customerSrv.repository


import com.oldsailor.customerSrv.model.ContainerModel
import com.oldsailor.customerSrv.model.ContainerResponse
import com.oldsailor.customerSrv.model.ContainerResponseSingle
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ContainerRepository : CrudRepository<ContainerModel, Long> {

    @Query(
        value = "SELECT customers.full_name, customers.id AS customerId, containers.* FROM containers LEFT JOIN customers ON containers.customer_id = customers.id ORDER BY containers.id DESC LIMIT ?2 OFFSET ?1",
        nativeQuery = true
    )
    fun find(offset: Int, limit: Int): List<ContainerResponse>

    @Query(
        value = "SELECT COUNT(*) FROM containers",
        nativeQuery = true
    )
    fun countData(): Int


    @Query(
        value = "SELECT COUNT(*) FROM containers WHERE customer_id = ?1 ",
        nativeQuery = true
    )
    fun countCustomerContainerData(id: Long): Int

    @Query(
        value = "SELECT customers.full_name, customers.id AS customerId, containers.* FROM containers LEFT JOIN customers ON containers.customer_id = customers.id WHERE containers.customer_id = ?1 ORDER BY containers.id DESC LIMIT ?3 OFFSET ?2",
        nativeQuery = true
    )
    fun findByCustomerId(id: Long, offset: Int, limit: Int): List<ContainerResponse>



    @Query(
        value = "SELECT * FROM containers WHERE id = ?1 ",
        nativeQuery = true
    )
    fun findDataById(id: Long): ContainerResponseSingle


     @Query(value = "SELECT customers.full_name, customers.id AS customerId, containers.* FROM containers LEFT JOIN customers ON containers.customer_id = customers.id WHERE customers.full_name LIKE ?1%", nativeQuery = true)
    fun fullTextSearch(value: String): List<ContainerResponse>


    @Query(
        value = "SELECT COUNT(*) FROM containers LEFT JOIN customers ON containers.customer_id = customers.id WHERE customers.full_name LIKE ?1%",
        nativeQuery = true
    )
    fun countDataSingle(value: String): Int

}