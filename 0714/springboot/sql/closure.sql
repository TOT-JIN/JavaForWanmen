DROP TABLE IF EXISTS `category_closure`;
CREATE TABLE `category_closure` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `display_order` int(11) NOT NULL,
  `create_date` datetime  DEFAULT NULL,
  `modified_date` datetime  DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `dal_ecommerce`.`category_closure`
(`category_id`,
`name`,
`create_date`,
`modified_date`)
VALUES
(null,'Root',NOW(),NOW()),
(null,'家用电器',NOW(),NOW()),
(null,'电视',NOW(),NOW()),
(null,'空调',NOW(),NOW()),
(null,'电脑整机',NOW(),NOW()),
(null,'笔记本',NOW(),NOW()),
(null,'平板电脑',NOW(),NOW());

DROP TABLE IF EXISTS `category_hierarchy`;
CREATE TABLE `category_hierarchy` (
    `ancestor` int(10)  NOT NULL DEFAULT 0,
    `descendant` int(10)  NOT NULL DEFAULT 0,
    `length` int(10)  NOT NULL DEFAULT 0,
    PRIMARY KEY (`ancestor`,`descendant`),
    KEY `descendant` (`descendant`),
    CONSTRAINT FK_HIERARCHY_CATEGORY_ANCESTOR FOREIGN KEY (`ancestor`) REFERENCES `category_closure` (`category_id`),
    CONSTRAINT FK_HIERARCHY_CATEGORY_DESCENDANT FOREIGN KEY (`descendant`) REFERENCES `category_closure` (`category_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

truncate category_hierarchy;

INSERT INTO `dal_ecommerce`.`category_hierarchy`
(`ancestor`,`descendant`,`length`)
VALUES
(1,1,0),
(1,2,1),
(1,3,2),
(1,4,2),
(1,5,1),
(1,6,2),
(1,7,2),
(2,2,0),
(2,3,1),
(2,4,1),
(3,3,0),
(4,4,0),
(5,5,0),
(5,6,1),
(5,7,1),
(6,6,0),
(6,7,0);


 -- retrieve descendants of #4
SELECT 
    t.ancestor as category_id,  c.category_id as node_id, c.name, t.length
FROM
    category_closure AS c
        JOIN
    category_hierarchy AS t ON c.category_id = t.descendant
WHERE
    t.ancestor = 1
order by length;


    
-- get all the parents
SELECT 
	t.descendant, c.*, t.length
FROM
    category_closure AS c
        JOIN
    category_hierarchy AS t ON c.category_id = t.ancestor
WHERE
    t.descendant = 2;
    
SELECT * FROM dal_ecommerce.category_closure;    
-- insert new child
-- first
insert into category_closure(`name`,`create_date`,`modified_date`) values('窗式',NOW(),NOW());
-- second get all ancestors for the parent to be insert and add length, since we a child of the parent 
insert into category_hierarchy (ancestor, descendant, length) 
select cp.ancestor, 8, cp.length+1 from category_hierarchy as cp 
where cp.descendant=4 union all select 8, 8, 0;


insert into category_closure(`name`,`create_date`,`modified_date`) values('服装',NOW(),NOW());
insert into category_hierarchy (ancestor, descendant, length) 
select cp.ancestor, 9, cp.length+1 from category_hierarchy as cp 
where cp.descendant=1 union all select 9, 9, 0;

-- "delete from category_hierarchy where descendant in (select descendant from category_hierarchy where ancestor = 4);”,
select *
from category_hierarchy a join category_hierarchy b 
on (a.descendant = b.descendant)
where b.ancestor=4;

delete a 
from category_hierarchy a join category_hierarchy b 
on (a.descendant = b.descendant) 
where b.ancestor=4;


select *
from category_hierarchy 
where ancestor=4 or descendant=4;

-- explain cross join 笛卡尔积
SELECT *
FROM category_closure a, category_closure b
where a.category_id = b.category_id;

SELECT t.ancestor as category_id, c.category_id as node_id, c.name, t.length
FROM category_closure AS c JOIN category_hierarchy AS t ON c.category_id = t.descendant
WHERE t.ancestor = 1;

SELECT t.ancestor as category_id, c.category_id as node_id, 
c.name, t.length,p.product_id,p.name,p.detail,p.image_url
FROM category_closure AS c 
INNER JOIN category_hierarchy AS t ON c.category_id = t.descendant
LEFT JOIN product as p ON c.category_id = p.category_id
WHERE t.ancestor = 1 order by length;

    
 
 
 