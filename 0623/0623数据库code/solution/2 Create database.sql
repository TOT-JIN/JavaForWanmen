
/*************************************** 
 *        DDL: Create Database         * 
 ***************************************/

-- drop existing database if exists;
DROP DATABASE IF EXISTS fitbit_new;

-- create database;
CREATE DATABASE fitbit_new;

-- use database;
USE fitbit_new;


/*************************************** 
 *           DDL: Create Table         * 
 ***************************************/

/*        product          */
-- create table product;
DROP TABLE IF EXISTS product, client, sales;

CREATE TABLE IF NOT EXISTS product (
  product_id  INT            NOT NULL,
  code        CHAR(5)        NOT NULL,
  name        VARCHAR(20)    NOT NULL,
  class       VARCHAR(45)    NOT NULL,
  color       VARCHAR(45)    NOT NULL,
  has_clock   ENUM('Y','N')  NOT NULL,
  msrp        DECIMAL(9,2)       NULL,
  PRIMARY KEY (product_id),
  UNIQUE KEY  (code)
);


DESCRIBE product;

-- alter table;
ALTER TABLE product ADD COLUMN description VARCHAR(100) NOT NULL AFTER name;
ALTER TABLE product CHANGE COLUMN description `desc` VARCHAR(200) NOT NULL;   -- Note the backtick;
DESCRIBE product;
ALTER TABLE product DROP COLUMN `desc`;
 

/*       client      */
-- create table client;
CREATE TABLE IF NOT EXISTS client (
  client_id     INT          NOT NULL,
  name          VARCHAR(100) NOT NULL,
  type          VARCHAR(45)  NULL,
  PRIMARY KEY   (client_id),
  UNIQUE  KEY   (name)
);

DESCRIBE client;


/*        sales         */
-- create table sales;
CREATE TABLE IF NOT EXISTS sales (
  tran_id      INT            NOT NULL AUTO_INCREMENT, -- 自增
  date         DATE           NOT NULL,
  product_id   INT            NOT NULL,
  client_id    INT            NOT NULL,
  price        DECIMAL(7,2)          NOT NULL,
  quantity     INT            NULL DEFAULT 1,
  PRIMARY KEY  (tran_id),
  INDEX        fk_client_id_idx (client_id ASC),
  
-- constraint 加约束 FOREIGN KEY  CHECK
  CONSTRAINT   fk_product_id
    FOREIGN KEY (product_id)
    REFERENCES  product (product_id)
    ON DELETE CASCADE,
  CONSTRAINT fk_client_id
    FOREIGN KEY (client_id)
    REFERENCES client (client_id)
    ON DELETE CASCADE,
  CONSTRAINT chk_price CHECK (price > 0)
);
DESCRIBE sales;
SHOW TABLES;

-- create foreign key seperately;
ALTER TABLE sales ADD CONSTRAINT fk_client_id2 
  FOREIGN KEY (client_id)
  REFERENCES client (client_id)
  ON DELETE CASCADE
;

-- drop foreign key;
ALTER TABLE sales DROP FOREIGN KEY fk_client_id2;


-- add update cascade;
ALTER TABLE sales DROP FOREIGN KEY fk_product_id;
ALTER TABLE sales DROP FOREIGN KEY fk_client_id;

ALTER TABLE sales ADD CONSTRAINT fk_product_id
  FOREIGN KEY (product_id)
  REFERENCES product (product_id)
  ON UPDATE CASCADE
  ON DELETE CASCADE
;

ALTER TABLE sales ADD CONSTRAINT fk_client_id
  FOREIGN KEY (client_id)
  REFERENCES client (client_id)
  ON UPDATE CASCADE
  ON DELETE CASCADE
;


  
/********************************************** 
 *        DML: Insert, Update, Delete         * 
 **********************************************/

DESCRIBE product;

INSERT INTO product 
VALUES
(1,'E-ZIP','Zip','EVERYDAY','GREEN','Y',59.95),
(2,'E-FLX','Flex','EVERYDAY','BLACK','N',99.95),
(3,'A-BLZ','Blaze','ACTIVE','PURPLE','Y',199.95),
(4,'P-SUG','Surge','PERFORMANCE','BLACK','Y',249.95);

SELECT * FROM product;

-- update product;
UPDATE product
SET product_id=10
WHERE product_id=1;

-- cascade delete
DELETE FROM product
WHERE product_id = '10';

INSERT INTO product 
VALUES
(1,'E-ZIP','Zip','EVERYDAY','GREEN','Y',59.95);


DESCRIBE client;

INSERT INTO client 
VALUES
(1,'FITBIT','ONLINE'),
(2,'AMAZON','ONLINE'),
(3,'BESTBUY','OFFLINE'),
(4,'WALMART','OFFLINE')
;

DESCRIBE sales;

INSERT INTO sales 
(tran_id, date, product_id, client_id, price, quantity)
VALUES
(1,'2016-6-1', 1, 1, 40, 10),
(2,'2016-6-5', 1, 2, 30, 5),
(3,'2016-6-8', 2, 1, 80, 8),
(4,'2016-6-8', 2, 2, 70, 7),
(5,'2016-6-13', 3, 2, 150, 5),
(6,'2016-6-18', 3, 4, 150, 10),
(7,'2016-6-20', 2, 4, 40, 15); 

SELECT * FROM sales;

-- update sales;
UPDATE sales
SET date = '2016-06-21', price=200
WHERE date='2016-06-20' AND tran_id=7;

-- create table SHIPPING;
DROP TABLE IF EXISTS shipping;

CREATE TABLE IF NOT EXISTS shipping(
 shipping_id INT NOT NULL AUTO_INCREMENT,
 tran_id INT NOT NULL,
 tracking_no INT,
 status ENUM('PREPARING', 'SHIPPED', 'ARRIVED'),
 arrive_date DATE,
 eta DATE,
 PRIMARY KEY (shipping_id),
 
 CONSTRAINT fk_tran_id FOREIGN KEY(tran_id)
    REFERENCES sales(tran_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
 );
 
INSERT INTO shipping
(tran_id,tracking_no,status,arrive_date,eta)
VALUES
 (3, 103, 'ARRIVED', '2016-06-02', '2016-06-02'),
 (4, 104, 'ARRIVED', '2016-06-30', '2016-06-25'),
 (5, 105, 'SHIPPED', NULL,         '2016-03-04'),
 (6, 200, 'PREPARING', NULL, NULL)
;

SELECT * FROM shipping;
 