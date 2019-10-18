DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brand_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `detail` text DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `brand_url` varchar(255) DEFAULT NULL,
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`brand`
(`brand_id`,
`name`,
`detail`,
`image_url`,
`brand_url`,
`create_date`,
`modified_date`)
VALUES
(null,"小米","小米",null,null,now(),now()),
(null,"夏普","夏普",null,null,now(),now()),
(null,"苹果","苹果",null,null,now(),now()),
(null,"华为","华为",null,null,now(),now());

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `detail` text DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `status` enum('NEW','ON_SHELF','OUT_OF_STOCK','DEPRECATED') DEFAULT 'NEW',
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`product_id`),
  CONSTRAINT FK_PRODUCTS_CATEGORY FOREIGN KEY (`category_id`) REFERENCES `category_closure` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `product` (product_id,name,detail,image_url,category_id,status,create_date,modified_date) VALUES 
 (1,'小米电视4','','',3,null,'2018-07-05','2018-07-05'),
 (2,'夏普LCD','','',3,null,'2018-07-05','2018-07-05'),
 (3,'iPad2','','',7,null,'2018-07-05','2018-07-05'),
 (4,'联想4','','',6,null,'2018-07-05','2018-07-05');

DROP TABLE IF EXISTS `variant`;
CREATE TABLE `variant` (
  `variant_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`variant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`variant`
(`variant_id`,`name`,`create_date`,`modified_date`)
VALUES
(null,"屏幕尺寸",now(),now()),
(null,"分辨率",now(),now()),
(null,"屏幕类型",now(),now()),
(null,"匹数",now(),now()),
(null,"制冷类型",now(),now()),
(null,"处理器",now(),now()),
(null,"操作系统",now(),now()),
(null,"内存",now(),now()),
(null,"硬盘",now(),now()),
(null,"颜色",now(),now());



DROP TABLE IF EXISTS `product_variant`;  -- many to manay, 
CREATE TABLE `product_variant` (
  `product_variant_id` int(11) NOT NULL AUTO_INCREMENT,
  `variant_id` int(11) NOT NULL, -- product may have different varients
  `product_id` int(11) NOT NULL, -- varaint may share to many products
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`product_variant_id`,`variant_id`,`product_id`),
  
  CONSTRAINT FK_VARIANT FOREIGN KEY (`variant_id`) 
  REFERENCES `variant` (`variant_id`) ON DELETE CASCADE,
  
  CONSTRAINT FK_PRODUCT FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`product_id`) ON DELETE CASCADE
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`product_variant`
(`product_variant_id`,
`variant_id`,
`product_id`,
`create_date`,
`modified_date`)
VALUES
(null,1,1,now(),now()),
(null,2,1,now(),now()),
(null,3,1,now(),now()),
(null,10,1,now(),now()),
(null,1,2,now(),now()),
(null,2,2,now(),now()),
(null,3,2,now(),now()),
(null,10,2,now(),now()),
(null,1,3,now(),now()),
(null,2,3,now(),now()),
(null,7,3,now(),now()),
(null,1,4,now(),now()),
(null,6,4,now(),now()),
(null,8,4,now(),now()),
(null,9,4,now(),now()),
(null,10,4,now(),now());

SELECT @@GLOBAL.sql_mode;

SET @@GLOBAL.sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
set SESSION sql_mode ='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';

select * from `product_variant` left join `product` 
on product_variant.product_id = product.product_id;

select * from `product_variant` left join `variant` 
on variant.variant_id = variant.variant_id group by product_variant.product_id;


select product.product_id, product.name, variant.variant_id,variant.name from 
`product_variant` 
left join `product` on product_variant.product_id = product.product_id
left join `variant` on product_variant.variant_id = variant.variant_id;

DROP TABLE IF EXISTS `variant_options`;
CREATE TABLE `variant_options` (
  `variant_options_id` int(11) NOT NULL AUTO_INCREMENT,
  `variant_id` int(11) DEFAULT NULL,
  `value` varchar(100) DEFAULT NULL,
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`variant_options_id`),
  CONSTRAINT FK_VARIANT_OPTION_VARIANT FOREIGN KEY (`variant_id`) REFERENCES `variant` (`variant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`variant_options`
(
`variant_id`,
`value`,
`create_date`,
`modified_date`)
VALUES
(1,"65英寸",now(),now()),
(1,"58英寸",now(),now()),
(1,"11.6英寸",now(),now()),
(1,"13.3英寸",now(),now()),
(1,"7英寸",now(),now()),
(1,"9英寸",now(),now()),
(2,"4K",now(),now()),
(2,"2K",now(),now()),
(3,"LED",now(),now()),
(3,"OLED",now(),now()),
(4,"1匹",now(),now()),
(4,"3匹",now(),now()),
(5,"冷暖",now(),now()),
(5,"制冷",now(),now()),
(6,"麒麟",now(),now()),
(6,"i3",now(),now()),
(6,"i7",now(),now()),
(7,"iOS",now(),now()),
(7,"Android",now(),now()),
(7,"Windows",now(),now()),
(7,"Linux",now(),now()),
(8,"4G",now(),now()),
(8,"16G",now(),now()),
(9,"125G SSD",now(),now()),
(9,"500G SSD",now(),now()),
(10,"红色",now(),now()),
(10,"土豪金",now(),now());

select * from 
`variant` 
left join `variant_options` on variant_options.variant_id = variant.variant_id;

select product.product_id, product.name, 
variant.variant_id,variant.name, variant_options.variant_options_id,variant_options.value 
from `product_variant` 
left join `product` on product_variant.product_id = product.product_id
left join `variant` on product_variant.variant_id = variant.variant_id
left join `variant_options` on variant_options.variant_id = variant.variant_id;

DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku` (
  `sku_id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_no` varchar(100) DEFAULT NULL,
  `sku_name` varchar(100) DEFAULT NULL,  
  `product_id` int(11) DEFAULT NULL,
  `base_price` decimal(20,2) NOT NULL DEFAULT 0.0,
  `status` enum('NEW','ON_SHELF','OUT_OF_STOCK','DEPRECATED') DEFAULT 'NEW',
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`sku_id`),
  CONSTRAINT FK_SKU_PRODUCT FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`sku`
(`sku_no`,
`sku_name`,
`product_id`,
`base_price`,
`create_date`,
`modified_date`)
VALUES
("M010401","小米电视4超薄版",1,2000.0,now(),now()),
("M010402","小米电视4S蓝牙",1,4000.0,now(),now()),
("M010409","小米电视4X",1,6000.0,now(),now()),
("4SF470A","夏普LCD45寸豪华版",2,7000.0,now(),now()),
("4K60SU860A","夏普60寸豪华版",2,12000.0,now(),now());

DROP TABLE IF EXISTS `sku_value`;
CREATE TABLE `sku_value` (
  `sku_value_id` int(11) NOT NULL AUTO_INCREMENT,
  `variant_id` int(11) NOT NULL,
  `variant_options_id` int(11) NOT NULL,
  `sku_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`sku_value_id`, `sku_id`,`variant_id`,`product_id`),
  
  CONSTRAINT FK_SKU_VALUE_VARIANT FOREIGN KEY (`variant_id`) 
  REFERENCES `variant` (`variant_id`) ON DELETE CASCADE,
  
  CONSTRAINT FK_SKU_VALUE_VARIANT_OPTION FOREIGN KEY (`variant_options_id`) 
  REFERENCES `variant_options` (`variant_options_id`) ON DELETE CASCADE,
  
  CONSTRAINT FK_SKU_VALUE_SKU FOREIGN KEY (`sku_id`) 
  REFERENCES `sku` (`sku_id`) ON DELETE CASCADE,
  
  CONSTRAINT FK_SKU_VALUE_PRODUCT FOREIGN KEY (`product_id`) 
  REFERENCES `product` (`product_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

select product.product_id, product.name, 
variant.variant_id,variant.name, variant_options.variant_options_id,variant_options.value 
from `product_variant` 
left join `product` on product_variant.product_id = product.product_id
left join `variant` on product_variant.variant_id = variant.variant_id
left join `variant_options` on variant_options.variant_id = variant.variant_id;

INSERT INTO `dal_ecommerce`.`sku_value`
(`variant_id`,
`variant_options_id`,
`sku_id`,
`product_id`,
`create_date`,
`modified_date`)
VALUES
(1,1,1,1,now(),now()),
(1,2,2,1,now(),now()),
(1,1,3,1,now(),now()),
(2,7,1,1,now(),now()),
(2,8,2,1,now(),now()),
(2,8,3,1,now(),now());

-- 可以出售的SKU及其属性
select sku.sku_id,sku.sku_no,sku.skuName,product.product_id, product.name, 
variant.variant_id,variant.name, variant_options.variant_options_id,variant_options.value 
from `sku_value` 
left join `sku` on sku_value.sku_id = sku.sku_id
left join `variant` on sku_value.variant_id = variant.variant_id
left join `variant_options` on sku_value.variant_options_id = variant_options.variant_options_id
left join `product` on sku_value.product_id = product.product_id;

select 
p.product_id, p.name as product_name, p.detail, p.image_url, 
c.category_id , c.name as category_name, 
sku.sku_id, sku.sku_name, sku.sku_no, sku.base_price, sku.status as sku_status,
sku_value.sku_value_id,
variant.variant_id, variant.name as variant_name,
variant_options.variant_options_id, variant_options.value
from 
(select * from `product` where `product`.product_id = 1) p 
left join `category_closure` c on p.category_id = c.category_id
left join `sku_value` on sku_value.product_id = p.product_id
left join `sku` on sku_value.sku_id = sku.sku_id
left join `variant` on sku_value.variant_id = variant.variant_id
left join `variant_options` on sku_value.variant_options_id = variant_options.variant_options_id;

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(100) DEFAULT NULL,
  `user_id`  int(11) NOT NULL,
  `billing_address_id` int(11) DEFAULT NULL,
  `shpping_address_id` int(11) DEFAULT NULL,
  `order_status` enum('CART','DRAFT','NEW','IN_PROCESS','COMPLETED','FAILED') DEFAULT 'CART', 
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`order_id`,`user_id`),
  CONSTRAINT FK_ORDER_USER FOREIGN KEY (`user_id`) 
  REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`order`
(`order_no`,
`user_id`,
`order_status`,
`create_date`,
`modified_date`)
VALUES
(null,1,'CART',now(),now()),
(null,2,'CART',now(),now()),
(null,3,'CART',now(),now());

DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `order_item_id` int(11) NOT NULL AUTO_INCREMENT,
  `sku_id` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `unit_price` decimal(20,2) NOT NULL DEFAULT 0.0,
  `quantity` int(11) NOT NULL DEFAULT 0,  
  `create_date` DATE,
  `modified_date` DATE,  
  PRIMARY KEY (`order_item_id`),
  CONSTRAINT FK_ORDER_ITEM_SKU FOREIGN KEY (`sku_id`) REFERENCES `sku` (`sku_id`) ON DELETE SET NULL,
  CONSTRAINT FK_ORDER_ITEM_ORDER FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `dal_ecommerce`.`order_item`
(`sku_id`,
`order_id`,
`unit_price`,
`quantity`,
`create_date`,
`modified_date`)
VALUES
(1,1,1500,2,now(),now()),
(2,1,3000,2,now(),now());

select 
u.user_id, u.user_name, o.order_id, o.order_status, 
its.*, sk.*, (its.unit_price * its.quantity) as sub_total
from (select user_id, user_name from `user` where user_id=1) u
left join `order` o on o.user_id = u.user_id
left join `order_item` its on its.order_id = o.order_id
left join `sku` sk on sk.sku_id = its.sku_id;


