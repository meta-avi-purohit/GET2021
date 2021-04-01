/*Identify the columns require indexing in order, product, category tables and create indexes.*/
ALTER TABLE product ADD INDEX productID (product_ID);

ALTER TABLE categories ADD INDEX categoryID (category_ID);

ALTER TABLE orders ADD INDEX orderID (order_ID);

ALTER TABLE orderdetails ADD INDEX productIDindetail (product_ID);

ALTER TABLE orderdetails ADD INDEX orderIDindetail (order_ID);

SHOW INDEX FROM orderdetails;

SHOW INDEX FROM orders;

SHOW INDEX FROM product;

SHOW INDEX FROM categories;