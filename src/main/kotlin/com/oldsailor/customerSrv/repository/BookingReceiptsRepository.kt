package com.oldsailor.customerSrv.repository

import com.oldsailor.customerSrv.model.BookingReceiptModel
import com.oldsailor.customerSrv.model.BookingResponse
import com.oldsailor.customerSrv.model.BookingResponseSingle

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface BookingReceiptsRepository : CrudRepository<BookingReceiptModel, Long> {
    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, booking_receipts.* " +
                "FROM booking_receipts LEFT JOIN customers ON booking_receipts.customer_id = customers.id " +
                "ORDER BY booking_receipts.id DESC LIMIT ?2 OFFSET ?1",
        nativeQuery = true
    )
    fun find(offset: Int, limit: Int): List<BookingResponse>


    @Query(
        value = "SELECT COUNT(*) FROM booking_receipts",
        nativeQuery = true
    )
    fun countData(): Int

    @Query(
        value = "SELECT * FROM booking_receipts WHERE customer_id = ?1",
        nativeQuery = true
    )
    fun findByCustomerId(id: Long): List<BookingReceiptModel>


    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.email, customers.passport_number, customers.address AS cus_address, customers.city AS cus_city, customers.zipcode AS cus_zipcode, customers.state AS cus_state, customers.phone_number, customers.irs_tax_id, customers.id AS customerId," +
                " booking_receipts.* " +
                "FROM booking_receipts" +
                " LEFT JOIN customers ON booking_receipts.customer_id = customers.id " +
                "WHERE booking_receipts.id = ?1",
        nativeQuery = true
    )
    fun findDataById(id: Long): BookingResponseSingle


    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, booking_receipts.* " +
                "FROM booking_receipts LEFT JOIN customers ON booking_receipts.customer_id = customers.id " +
                "               WHERE full_name LIKE ?1% ",
        nativeQuery = true
    )
    fun fullTextSearch(value: String): List<BookingResponse>


    @Query(
        value = "SELECT COUNT(*) " +
                "FROM booking_receipts LEFT JOIN customers ON booking_receipts.customer_id = customers.id " +
                "  WHERE full_name LIKE ?1% ",
        nativeQuery = true
    )
    fun countDataSingle(value: String): Int

}



