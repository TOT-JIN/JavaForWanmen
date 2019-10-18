
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




describe product;
-- alter table;



/*       client      */
-- create table client;



describe client;


/*        sales         */
-- create table sales;


-- create foreign key seperately;

-- drop foreign key;


-- add update cascade;


-- create view;


  
/********************************************** 
 *        DML: Insert, Update, Delete         * 
 **********************************************/

INSERT INTO product 
VALUES
(1,'E-ZIP','Zip','EVERYDAY','GREEN','Y',59.95),
(2,'E-FLX','Flex','EVERYDAY','BLACK','N',99.95),
(3,'A-BLZ','Blaze','ACTIVE','PURPLE','Y',199.95),
(4,'P-SUG','Surge','PERFORMANCE','BLACK','Y',249.95);

-- update product;

-- cascade delete


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

-- update sales;




INSERT INTO client 
VALUES
(1,'FITBIT','ONLINE'),
(2,'AMAZON','ONLINE'),
(3,'BESTBUY','OFFLINE'),
(4,'WALMART','OFFLINE')
;

-- create table SHIPPING;
DROP TABLE IF EXISTS shipping;



 