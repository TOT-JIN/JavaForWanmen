
/***************
 * Aggregation * 
 ***************/

-- Find minimum msrp of all products
select min(msrp) as min_msrp
from product;

-- Find maximum msrp of all products
select max(msrp) as max_msrp
from product;

-- Top 2 MSRP of all products;
-- DESC
-- limit
select msrp 
from product 
order by msrp desc
limit 2;

select msrp 
from product 
order by msrp
limit 2;

-- Find average msrp of all products
select avg(msrp) as avg_msrp
from product;

-- Find how many kind of products we have
select count(product_id) as num_products
from product;

-- Find total of msrp of all kind of products
select sum(msrp) as tot_msrp
from product;

-- Find total sales revenue(amount);
select product_id, sum(price*quantity) as sales_amount
from sales;

/***************
 *  Group by   * 
 ***************/
-- Find total sales revenue by product. Order by sales_amount desendingly;
select product_id, sum(price*quantity) as sales_amount
from sales
group by product_id
order by sales_amount desc;

-- total # of transactions by product
select name, count(1) as trn_count
from sales s, product p
where s.product_id = p.product_id
group by s.product_id
;


-- count distinct product and client that have sales;
select count(distinct product_id) as distinct_product, 
	   count(distinct client_id) as distinct_client, 
       count(*) as total_rows
from sales
;

-- how many different/unique products each client purchased;
select c.name, count(distinct product_id) as dist_prd
from sales a, client c
where a.client_id = c.client_id
group by a.client_id
;

-- find clients that purchase more than 1 unique products;
select c.name, count(distinct product_id) as dist_prd
from sales a, client c
where a.client_id = c.client_id 
group by a.client_id
having dist_prd >=2;

-- practice: find products that are sold less than 20 units;
select p.name, sum(quantity) as tot_quantity
from sales s, product p
where s.product_id = p.product_id
group by s.product_id
having tot_quantity < 20
;






