CREATE TABLE IF NOT EXISTS booking_receipts
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date_added DATE NOT NULL DEFAULT (CURRENT_DATE),
    vessel_name VARCHAR(200)  NULL,
    voyage_number VARCHAR(200) NULL,
    booking_number VARCHAR(200) NULL,
    equipment_size VARCHAR(100) NULL,
    total_no_of_containers VARCHAR(100) NULL,
    loading_terminal VARCHAR(200) NULL,
    carrier VARCHAR(100) NULL,
    commodity VARCHAR(400) NULL,
    cut_off_date DATE NULL,
    sail_date DATE NULL,
    arrival_date DATE NULL,
    type_of_move VARCHAR(200) NULL,
    pickup_terminal VARCHAR(200) NULL,
    place_of_receipt VARCHAR(255) NULL,
    port_of_loading VARCHAR(200) NULL,
    port_of_discharge VARCHAR(200) NULL,
    place_of_delivery VARCHAR(400) NULL,
    rate VARCHAR(200) NULL,
    notes VARCHAR(500) NULL,
    customer_id BIGINT NOT NULL,
    consignee_id BIGINT NOT NULL,
    CONSTRAINT FK_customer_booking
                FOREIGN KEY (customer_id) REFERENCES customers (id),
     CONSTRAINT FK_consignee_booking
                  FOREIGN KEY (consignee_id) REFERENCES consignees (id)
);
