/* Create a view displaying the order information (Id, Title, Price, Shopper’s name, 
Email, Orderdate, Status) with latest ordered items should be displayed first for last 60 days. */
CREATE VIEW information AS 
SELECT P.product_ID,P.product_title,S.user_name,O.order_date,O.order_status
FROM product P 
INNER JOIN orderdetails D ON D.product_ID = P.product_ID
INNER JOIN orders O ON O.order_ID = D.order_ID
INNER JOIN address A ON A.address_ID = O.address_ID
INNER JOIN shopper S ON S.shopper_ID = A.shopper_ID
WHERE O.order_date >= DATE(CURDATE() - INTERVAL 60 DAY)
ORDER BY O.order_date;

/* Use the above view to display the Products(Items) which are in ‘shipped’ state. */
SELECT * FROM information 
WHERE order_status LIKE 'Shipped';

/* Use the above view to display the top 5 most selling products. */
SELECT product_title, COUNT(product_title) FROM information
GROUP BY product_title 
ORDER BY product_title DESC LIMIT 5;