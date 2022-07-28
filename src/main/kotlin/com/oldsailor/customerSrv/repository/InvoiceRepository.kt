package com.oldsailor.customerSrv.repository

import com.oldsailor.customerSrv.model.InvoiceModel
import com.oldsailor.customerSrv.model.InvoiceResponse

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface InvoiceRepository : CrudRepository<InvoiceModel, Long> {
    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, dock_receipts.id as dockReceiptId, dock_receipts.container_number, invoices.*, booking_receipts.booking_number " +
                "               FROM invoices " +
                "                LEFT JOIN customers ON customers.id = invoices.customer_id " +
                "                LEFT JOIN dock_receipts ON dock_receipts.id = invoices.dock_receipt_id " +
                "                LEFT JOIN booking_receipts ON booking_receipts.id = dock_receipts.booking_id " +
                "               ORDER BY invoices.id " +
                "                DESC LIMIT ?2 OFFSET ?1",
        nativeQuery = true
    )
    fun find(offset: Int, limit: Int): List<InvoiceResponse>

    @Query(
        value = "SELECT COUNT(*) FROM dock_receipts",
        nativeQuery = true
    )
    fun countData(): Int

    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, dock_receipts.id as dockReceiptId, dock_receipts.container_number, invoices.*, booking_receipts.booking_number " +
                "               FROM invoices " +
                "                LEFT JOIN customers ON customers.id = invoices.customer_id " +
                "                LEFT JOIN dock_receipts ON dock_receipts.id = invoices.dock_receipt_id " +
                "                LEFT JOIN booking_receipts ON booking_receipts.id = dock_receipts.booking_id " +
                "               WHERE full_name LIKE ?1% ",
        nativeQuery = true
    )
    fun fullTextSearch(value: String): List<InvoiceResponse>


    @Query(
        value = "SELECT COUNT(*)" +
                "               FROM invoices " +
                "                LEFT JOIN customers ON customers.id = invoices.customer_id " +
                "                LEFT JOIN dock_receipts ON dock_receipts.id = invoices.dock_receipt_id " +
                "                LEFT JOIN booking_receipts ON booking_receipts.id = dock_receipts.booking_id " +
                "               WHERE full_name LIKE ?1% ",
        nativeQuery = true
    )
    fun countDataSingle(value: String): Int
}