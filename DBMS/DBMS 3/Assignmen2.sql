SELECT * FROM shopper;

/* Display Shopper’s information along with number of orders he/she placed during last 30 days. */
SELECT S.shopper_ID, S.user_name, COUNT(O.order_ID) AS 'Number Of Orders' FROM shopper S
INNER JOIN address A ON S.shopper_ID = A.shopper_ID
INNER JOIN orders O ON O.address_ID = A.address_ID
WHERE DATEDIFF(NOW(), O.order_date) <= 30
GROUP BY O.address_ID;

/* Display the top 10 Shoppers who generated maximum number of revenue in last 30 days. */
SELECT S.shopper_ID, S.user_name, SUM(O.order_total) 'MAX Revenue' FROM shopper S
INNER JOIN address A ON S.shopper_ID = A.shopper_ID
INNER JOIN orders O ON O.address_ID = A.address_ID
WHERE O.order_date >= DATE(CURDATE() - INTERVAL 30 DAY)
GROUP BY O.address_ID
ORDER BY order_total DESC LIMIT 10;

/* Display top 20 Products which are ordered most in last 60 days along with numbers. */
SELECT P.product_ID,P.product_title FROM product P
INNER JOIN orderdetails D ON D.product_ID = P.product_ID
INNER JOIN orders O ON O.order_ID = D.order_ID
WHERE O.order_date >= DATE(CURDATE() - INTERVAL 60 day)
GROUP BY D.product_ID ORDER BY D.product_ID DESC LIMIT 20;

/* Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale. */
SELECT MONTH(order_date) Month, SUM(order_total) Revenue FROM orders
WHERE order_date > DATE(CURDATE() - INTERVAL 5 MONTH) 
GROUP BY Month;

SET SQL_SAFE_UPDATES = 0;
/* Mark the products as Inactive which are not ordered in last 90 days. */
UPDATE product P SET P.status = 'Inactive' 
WHERE P.status = 'Active' AND P.product_ID NOT IN ( SELECT D.product_ID FROM orderdetails D 
INNER JOIN orders O ON O.order_ID = D.order_ID
AND O.order_date >= DATE(CURDATE() - INTERVAL 90 DAY));
SET SQL_SAFE_UPDATES = 1;

/* Given a category search keyword, display all the Products present in this category/categories. */
SELECT P.product_ID, P.product_title FROM product P
INNER JOIN categories C ON P.category_ID = C.category_ID
WHERE C.category_title LIKE 'Shirt';

/* Display top 10 Items which were cancelled most. */
SELECT P.product_ID,P.product_title FROM product P
WHERE P.product_ID IN ( SELECT D.product_ID FROM orderdetails D
INNER JOIN orders O ON O.order_ID = D.order_ID
WHERE O.order_status LIKE 'Cancle' AND D.product_status LIKE 'Not Ship');