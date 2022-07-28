CREATE TABLE IF NOT EXISTS customers
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(200) UNIQUE NOT NULL,
    phone_number VARCHAR(200) UNIQUE NOT NULL DEFAULT '',
    email VARCHAR(200) NOT NULL   DEFAULT '',
    address VARCHAR(200)   NOT NULL   DEFAULT '',
    city VARCHAR(200)   NOT NULL   DEFAULT '',
    state VARCHAR(200)   NOT NULL   DEFAULT '',
    zipcode VARCHAR(200)   NOT NULL   DEFAULT '',
    irs_tax_id VARCHAR(200)   NOT NULL   DEFAULT '',
    passport_number VARCHAR(200)   NOT NULL   DEFAULT '',
    ssn VARCHAR(200)  NOT NULL  DEFAULT ''
);


CREATE TABLE IF NOT EXISTS consignees
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(200) UNIQUE NOT NULL,
    phone_number VARCHAR(200) UNIQUE NOT NULL DEFAULT '',
    email VARCHAR(200) NOT NULL   DEFAULT '',
    address VARCHAR(200)   NOT NULL   DEFAULT '',
    city VARCHAR(200)   NOT NULL   DEFAULT '',
    state VARCHAR(200)   NOT NULL   DEFAULT '',
    zipcode VARCHAR(200)   NOT NULL   DEFAULT '',
    care_of VARCHAR(200)   NOT NULL   DEFAULT '',
    country VARCHAR(200)   NOT NULL   DEFAULT '',
    customer_id BIGINT NOT NULL,
    CONSTRAINT FK_customer
                FOREIGN KEY (customer_id) REFERENCES customers (id)
);


-- CREATE TABLE IF NOT EXISTS states
-- (
--     id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(200)  NOT NULL DEFAULT '',
-- );
--
-- CREATE TABLE IF NOT EXISTS cities
-- (
--     id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(200) NOT NULL DEFAULT '',
-- );
--
-- CREATE TABLE IF NOT EXISTS countries
-- (
--     id BIGINT PRIMARY KEY AUTO_INCREMENT,
--     name VARCHAR(200)  NOT NULL DEFAULT '',
-- );


CREATE TABLE IF NOT EXISTS containers
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date_added DATE NOT NULL DEFAULT (CURRENT_DATE),
    container_content VARCHAR(200) NULL,
    freight VARCHAR(200) NULL,
    unit VARCHAR(200) NULL,
    in_transit VARCHAR(200) NULL,
    total_weight INT NULL,
    weight INT NULL,
    measurement INT NULL,
    personal_effect LONGTEXT NULL,
    container_type VARCHAR(100) NULL,
    customer_id BIGINT NOT NULL,
    CONSTRAINT FK_customer_container
                FOREIGN KEY (customer_id) REFERENCES customers (id)
);



CREATE TABLE IF NOT EXISTS cars
(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    date_added DATE NOT NULL DEFAULT (CURRENT_DATE),
    vin VARCHAR(200) NOT NULL,
    details VARCHAR(200) NOT NULL,
    value_for_aes VARCHAR(200) NULL,
    measurement INT NULL,
    weight INT NULL,
    container_id BIGINT NOT NULL,
    CONSTRAINT FK_container
                FOREIGN KEY (container_id) REFERENCES containers (id)
);



