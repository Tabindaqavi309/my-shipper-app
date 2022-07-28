CREATE TABLE IF NOT EXISTS invoices (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date_added DATE NOT NULL DEFAULT (CURRENT_DATE),
    ocean_freight VARCHAR(255) NULL,
    truck VARCHAR(255) NULL,
    ectn_besc VARCHAR(255) NULL,
    label_1 VARCHAR(255) NULL,
    label_1_value VARCHAR(255) NULL,
        label_2 VARCHAR(255) NULL,
        label_2_value VARCHAR(255) NULL,
            label_3 VARCHAR(255) NULL,
            label_3_value VARCHAR(255) NULL,
                label_4 VARCHAR(255) NULL,
                label_4_value VARCHAR(255) NULL,
                    label_5 VARCHAR(255) NULL,
                    label_5_value VARCHAR(255) NULL,
                        label_6 VARCHAR(255) NULL,
        label_6_value VARCHAR(255) NULL,
      invoice_total INT NULL,
     balance_due INT,
    dock_receipt_id BIGINT NULL,
    poa_nra_id BIGINT NULL,
    customer_id BIGINT NULL,
    CONSTRAINT FK_dock_receipt_invoice
                FOREIGN KEY (dock_receipt_id) REFERENCES dock_receipts (id),
    CONSTRAINT FK_customer_invoice
                   FOREIGN KEY (customer_id) REFERENCES customers (id),
    CONSTRAINT FK_poa_nra1
            FOREIGN KEY (poa_nra_id) REFERENCES poa_nras (id)

);