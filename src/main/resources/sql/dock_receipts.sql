CREATE TABLE IF NOT EXISTS dock_receipts
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date_added DATE NOT NULL DEFAULT (CURRENT_DATE),
    point_and_country_of_origin VARCHAR(200) NULL,
    for_transhipment_to VARCHAR(100) NULL,
    forwarding_agent_references VARCHAR(400) NULL,
    client_as_agent BOOLEAN NULL,
    originals_to_be_released VARCHAR(200) NULL,
    aes_number VARCHAR(200) NULL,
    container_number VARCHAR(200) NULL,
    demurrage VARCHAR(200) NULL,
    seal_number VARCHAR(255) NULL,
    notify_party_phone_number VARCHAR(200) NULL,
    notify_party_country VARCHAR(200) NULL,
    notify_party_address VARCHAR(200) NULL,
    notify_party_name VARCHAR(200) NULL,
    booking_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    container_id BIGINT NOT NULL,
    consignee_id BIGINT NOT NULL,
    CONSTRAINT FK_customer_dock
                FOREIGN KEY (customer_id) REFERENCES customers (id),
     CONSTRAINT FK_consignee_dock
                  FOREIGN KEY (consignee_id) REFERENCES consignees (id),
     CONSTRAINT FK_container_dock
                  FOREIGN KEY (container_id) REFERENCES containers (id),
     CONSTRAINT FK_booking_dock
                       FOREIGN KEY (booking_id) REFERENCES booking_receipts (id)
);
