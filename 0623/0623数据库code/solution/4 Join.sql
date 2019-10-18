
/***************
 * join tables *
 ***************/
 
-- list all sales for FLEX and BLAZE;
select date,
       s.product_id,
       p.name,
       client_id, 
       price*quantity as amount
from  sales s, product p
where name in ('Flex','Blaze') and p.product_id = s.product_id
;

-- what happens without a.product_id=b.product_id;
-- use table alias;
select date,
       s.product_id,
       p.name,
       client_id, 
       price*quantity as amount
from  sales s, product p
where name in ('Flex','Blaze')
;

select * from product;
select * from sales;


-- practice: list all transactions with Amazon;
SELECT lower(c.name) as name, tran_id 
FROM sales s, client c 
where s.client_id = c.client_id
and lower(c.name) = 'amazon';



-- list all sales with msrp > 100 and quantity >= 10, or quality >= 100; ignore non-existing product_id in PRODUCT;
-- ignore non-existing product_id in PRODUCT;
select * 
from sales s, product p
where s.product_id = p.product_id and (p.msrp > 100 and quantity>=10 or quantity >=100)
;




/***************
*     Join     * 
***************/

-- list all transactions; show shipping status if there is any;
select s.tran_id as tran_id_left, sh.tran_id as tran_id_righ
from sales s
left join shipping sh
on s.tran_id = sh.tran_id;


-- show all transactions with shipping status;
-- 两者等价
select *
from sales s, shipping sh
where s.tran_id = sh.tran_id;

/* inner join */
select *
from sales s
inner join shipping sh
on s.tran_id = sh.tran_id;

-- compare with left join
/* left join */
select *
from sales s
left join shipping sh
on s.tran_id = sh.tran_id;


-- list all shipments with shipping status; show client_id and product_id if exists;
/* right join */
select coalesce(sh.tran_id,"(empty)", s.tran_id) as trn_id, s.client_id, s.product_id, sh.status
from sales s
right join shipping sh
on s.tran_id = sh.tran_id
;
-- list all shipping status with client_id and product_id;
/* right join */
select coalesce(sh.tran_id,"(empty)", s.tran_id) as trn_id, s.client_id, s.product_id, sh.status
from shipping sh
right join sales s
on s.tran_id = sh.tran_id
;


-- list all sales and shipping status in one table;
select *
from sales s
     join shipping sh
on s.tran_id = sh.tran_id;


-- list all transactions and shipping status in one table;
/* full join */
select s.tran_id as trn_id, s.client_id, s.product_id, sh.status
from shipping sh
full join sales s
on s.tran_id = sh.tran_id
;

; -- MySQL doesn't support full join!


/*********************
 *    set operators  *
 *********************/
-- union;

-- example
select * from sales where tran_id > 3
union
select * from sales where tran_id > 2;

select s.tran_id as trn_id, s.client_id, s.product_id, sh.status
from sales s
left join shipping sh
on s.tran_id = sh.tran_id
union
select s.tran_id as trn_id, s.client_id, s.product_id, sh.status
from sales s
right join shipping sh
on s.tran_id = sh.tran_id;

-- union all
-- example
select * from sales where tran_id > 3
union all
select * from sales where tran_id > 2;

select s.tran_id as trn_id, s.client_id, s.product_id, sh.status
from sales s
left join shipping sh
on s.tran_id = sh.tran_id
union all
select s.tran_id as trn_id, s.client_id, s.product_id, sh.status
from sales s
right join shipping sh
on s.tran_id = sh.tran_id;

-- union: cols需要一致
select * from product where product_id > 3
union
select * from sales where tran_id > 2;

select name as tran_id from product where product_id > 3
union
select tran_id from sales where tran_id > 2;


