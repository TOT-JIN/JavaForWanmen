
DROP TABLE IF EXISTS `category_set`;
CREATE TABLE `category_set` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `lft` int(11) NOT NULL,
  `rgt` int(11) NOT NULL,
  `create_date` DATE,
  `modified_date` DATE,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO `dal_ecommerce`.`category_set`
(`category_id`,
`name`,
`lft`,
`rgt`,
`create_date`,
`modified_date`)
VALUES
(null,'ROOT',1,20,'2016-06-02', '2016-06-02'),
(null,'TELEVISIONS',2,9,'2016-06-02', '2016-06-02'),
(null,'TUBE',3,4,'2016-06-02', '2016-06-02'),
(null,'LCD',5,6,'2016-06-02', '2016-06-02'),
(null,'PLASMA',7,8,'2016-06-02', '2016-06-02'),
(null,'PORTABLE ELECTRONICS',10,19,'2016-06-02', '2016-06-02'),
(null,'MP3 PLAYERS',11,14,'2016-06-02', '2016-06-02'),
(null,'FLASH',12,13,'2016-06-02', '2016-06-02'),
(null,'CD PLAYERS',15,16,'2016-06-02', '2016-06-02'),
(null,'2 WAY RADIOS',17,18,'2016-06-02', '2016-06-02');

SELECT * FROM dal_ecommerce.category_set;

SELECT *
FROM category_set
WHERE lft = 1;

SELECT *
FROM category_set
WHERE lft =(rgt - 1);

SELECT parents.name AS category, subs.name AS sub
FROM category_set AS parents, category_set AS subs
WHERE (subs.lft BETWEEN parents.lft AND parents.rgt ) AND (subs.name <> parents.name)
group by category ;

SELECT O2.name, COUNT(O1.category_id)-1 AS level
FROM category_set AS O1, category_set AS O2
WHERE O2.lft BETWEEN O1.lft AND O1.rgt
GROUP BY O2.name order by level;

SELECT CONCAT( REPEAT( '--', (COUNT(parent.name) - 1) ), node.name) AS name,node.lft
FROM category_set AS node, category_set AS parent
WHERE node.lft BETWEEN parent.lft AND parent.rgt
group by node.name,node.lft order by node.lft;


-- add new node to parent  


-- insert new node to neighbor




