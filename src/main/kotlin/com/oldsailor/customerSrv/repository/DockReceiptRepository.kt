package com.oldsailor.customerSrv.repository


import com.oldsailor.customerSrv.model.DockReceiptModel
import com.oldsailor.customerSrv.model.DockReceiptResponse
import com.oldsailor.customerSrv.model.DockReceiptResponseSingle

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface DockReceiptRepository : CrudRepository<DockReceiptModel, Long> {
    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, dock_receipts.*, containers.personal_effect, containers.total_weight, containers.weight, containers.measurement " +
                "FROM dock_receipts " +
                "LEFT JOIN customers ON customers.id = dock_receipts.customer_id  " +
                "LEFT JOIN containers ON containers.id = dock_receipts.container_id " +
                "ORDER BY dock_receipts.id " +
                "DESC LIMIT ?2 OFFSET ?1",
        nativeQuery = true
    )
    fun find(offset: Int, limit: Int): List<DockReceiptResponse>

    @Query(
        value = "SELECT COUNT(*) FROM dock_receipts",
        nativeQuery = true
    )
    fun countData(): Int


    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, dock_receipts.*, containers.personal_effect, containers.total_weight, containers.weight, containers.measurement " +
                "FROM dock_receipts " +
                "LEFT JOIN customers ON customers.id = dock_receipts.customer_id  " +
                "LEFT JOIN containers ON containers.id = dock_receipts.container_id " +
                "WHERE dock_receipts.customer_id = ?1 ORDER BY dock_receipts.id ",

        nativeQuery = true
    )
    fun findDataByCustomerId(customerId: Long): List<DockReceiptResponse>

    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.email, customers.passport_number, customers.address AS cus_address, customers.city AS cus_city, customers.zipcode AS cus_zipcode, customers.state AS cus_state, customers.phone_number, customers.irs_tax_id, customers.id AS customerId," +
                " consignees.full_name AS con_name, consignees.address AS con_address, consignees.city AS con_city, consignees.state AS con_state, consignees.zipcode AS con_zip, consignees.phone_number AS con_tel, consignees.country AS con_country, consignees.email AS con_email," +
                " dock_receipts.originals_to_be_released, dock_receipts.point_and_country_of_origin, dock_receipts.for_transhipment_to, dock_receipts.aes_number, dock_receipts.forwarding_agent_references, dock_receipts.seal_number, dock_receipts.client_as_agent, dock_receipts.demurrage, dock_receipts.notify_party_name, dock_receipts.notify_party_address, dock_receipts.notify_party_country, dock_receipts.notify_party_phone_number, dock_receipts.date_added, dock_receipts.id, " +
                "containers.personal_effect, containers.weight, containers.measurement, containers.container_content, containers.container_type, containers.total_weight, dock_receipts.container_number, containers.freight, containers.unit, containers.in_transit," +
                " booking_receipts.vessel_name, booking_receipts.voyage_number, booking_receipts.booking_number, booking_receipts.port_of_loading, booking_receipts.port_of_discharge, booking_receipts.loading_terminal, booking_receipts.carrier, booking_receipts.pickup_terminal, booking_receipts.place_of_receipt, booking_receipts.type_of_move, booking_receipts.cut_off_date, booking_receipts.sail_date, booking_receipts.arrival_date, booking_receipts.equipment_size " +
                "FROM dock_receipts " +
                "LEFT JOIN customers ON customers.id = dock_receipts.customer_id  " +
                "LEFT JOIN containers ON containers.id = dock_receipts.container_id " +
                "LEFT JOIN consignees ON consignees.customer_id = dock_receipts.customer_id " +
                "LEFT JOIN booking_receipts ON booking_receipts.id = dock_receipts.booking_id " +
                "WHERE dock_receipts.id = ?1",
        nativeQuery = true
    )
    fun findDataById(id: Long): DockReceiptResponseSingle


    @Query(
        value = "SELECT customers.full_name AS customer_name, customers.id AS customerId, dock_receipts.*, containers.personal_effect, containers.total_weight, containers.weight, containers.measurement " +
                "FROM dock_receipts " +
                "LEFT JOIN customers ON customers.id = dock_receipts.customer_id  " +
                "LEFT JOIN containers ON containers.id = dock_receipts.container_id " +
                "               WHERE full_name LIKE ?1% ",
        nativeQuery = true
    )
    fun fullTextSearch(value: String): List<DockReceiptResponse>


    @Query(
        value = "SELECT COUNT(*) " +
                "FROM dock_receipts " +
                "LEFT JOIN customers ON customers.id = dock_receipts.customer_id  " +
                "LEFT JOIN containers ON containers.id = dock_receipts.container_id " +
                "  WHERE full_name LIKE ?1% ",
        nativeQuery = true
    )
    fun countDataSingle(value: String): Int


}
