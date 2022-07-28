CREATE TABLE IF NOT EXISTS poa_nras
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date_added DATE NOT NULL DEFAULT (CURRENT_DATE),
    bill_of_lading_destination VARCHAR(200)  NULL,
    bill_of_lading_origin VARCHAR(200) NULL,
    cargo_qty VARCHAR(100) NULL,
    carrier VARCHAR(100) NULL,
    carrier_rep VARCHAR(100) NULL,
    commodity VARCHAR(400) NULL,
    destination_service VARCHAR(100) NULL,
    effective_date DATE NULL,
    expiration_date DATE NULL,
    insurance BOOLEAN NULL,
    maximum VARCHAR(200) NULL,
    minimum VARCHAR(200) NULL,
    origin_service VARCHAR(200) NULL,
    port_of_destination VARCHAR(255) NULL,
    rate VARCHAR(100) NULL,
    rate_basis VARCHAR(100) NULL,
    special_conditions VARCHAR(400) NULL,
    type_of_payment VARCHAR(100) NULL,
    type_of_shipment VARCHAR(100) NULL,
    customer_id BIGINT NOT NULL,
    consignee_id BIGINT NOT NULL,
    CONSTRAINT FK_customer_poaNra
                FOREIGN KEY (customer_id) REFERENCES customers (id),
     CONSTRAINT FK_consignee_poaNra
                  FOREIGN KEY (consignee_id) REFERENCES consignees (id)
);
