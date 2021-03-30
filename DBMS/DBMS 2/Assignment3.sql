use storefront;

show tables;

INSERT INTO shopper ( user_name )
VALUES
('Rishabh'),
('Avi'),
('Bob'),
('John'),
('Ayush'),
('Brijesh'),
('Rahul'),
('Rohit'),
('Ronak'),
('Devesh'),
('Virat'),
('Dhoni'),
('Devansh'),
('Hitarth'),
('Gaurav');

SELECT * FROM shopper;

ALTER TABLE orders
ADD address_ID int;

ALTER TABLE orders
ADD FOREIGN KEY (address_ID) REFERENCES address(address_ID);

INSERT iNTO address(area,city,state,country,shopper_ID)
VALUES
('Sector 12','Udaipur','Raj.','India',1),
('Sector 14','Udaipur','Raj.','India',2),
('Sector 15A','New York','London','UK',3),
('Sector 7','Okla','Alaska','USA',4),
('Sector 9','Jaipur','Raj.','India',5),
('Sector 13A','Rajsamand','Raj.','India',6),
('17B','Ajmer','Raj.','India',7),
('24C','Chittor','Raj.','India',8),
('11','Rajkot','Guj.','India',9),
('13C','Rachi','Jarkhand','India',10),
('Sector 1','Noida','Delhi','India',11),
('Sector 8','Nagor','Raj.','India',12),
('Sector 20','Bara','Raj.','India',13),
('Sector 15A','Pali','Raj.','India',14),
('Sector 14C','Jaipur','Raj.','India',15);

SELECT * FROM address;

SELECT * FROM product;

INSERT INTO orders (order_date,order_total,order_status,address_id)
VALUES('2021-01-23', 600,'Shipped',1);

INSERT INTO orders (order_date,order_total,order_status,address_id)
VALUES
('2021-02-21', 1000,'Cancle',2),
('2020-12-12', 1250,'Complete',3),
('2020-03-18', 14000,'Shipped',4),
('2021-02-18', 60000,'Shipped',5),
('2021-01-15', 70000,'Complete',6),
('2021-03-18', 1200,'Cancle',7),
('2020-09-09', 550,'Shipped',8),
('2021-02-03', 1100,'Complete',9),
('2020-05-01', 1400,'Complete',10),
('2021-02-17', 25000,'Shipped',11),
('2021-01-11', 250,'Cancle',12),
('2020-11-09', 20000,'Complete',15),
('2020-10-10', 1000,'Shipped',14),
('2021-01-16', 1300,'Complete',13);

INSERT INTO orders (order_date,order_total,order_status,address_id)
VALUES
('2021-04-02',	30, 'Complete',	4),
('2021-03-30',	25,	'Shipped',	7);

SELECT * FROM orders;

INSERT INTO orderdetails(product_ID,order_ID,quantity,total)
VALUES
(1,1,2,600),
(10,2,1,700),
(11,2,1,300),
(20,3,1,1000),
(8,3,1,150),
(7,3,1,100),
(21,4,1,14000),
(23,5,1,60000),
(24,6,1,70000),
(25,7,1,1200),
(4,8,1,550),
(9,9,1,400),
(10,9,1,700),
(13,10,2,1400),
(22,11,1,25000),
(3,12,1,100),
(8,12,1,150),
(27,13,1,20000),
(10,14,1,700),
(11,14,1,300),
(15,15,1,600),
(19,15,1,700);

SELECT * FROM orderdetails;

ALTER TABLE orderdetails ADD product_status VARCHAR(20) NOT NULL;

UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 1;

UPDATE orderdetails SET product_status = 'Not Ship' WHERE ID = 2;
UPDATE orderdetails SET product_status = 'Not Ship' WHERE ID = 3;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 4;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 5;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 6;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 7;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 8;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 9;
UPDATE orderdetails SET product_status = 'Not Ship' WHERE ID = 10;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 11;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 12;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 13;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 14;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 15;
UPDATE orderdetails SET product_status = 'Not Ship' WHERE ID = 16;
UPDATE orderdetails SET product_status = 'Not Ship' WHERE ID = 17;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 18;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 19;
UPDATE orderdetails SET product_status = 'Not Ship' WHERE ID = 20;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 21;
UPDATE orderdetails SET product_status = 'Shipped' WHERE ID = 22;

INSERT INTO orderdetails(product_ID,order_ID,quantity,total,product_status)
VALUES
(35, 16, 1,	30,	'Shipped'),	
(36, 17, 1,	25,	'Shipped');

/* Display Recent 50 Orders placed (Id, Order Date, Order Total) */
SELECT * FROM orders ORDER BY order_date DESC LIMIT 10;

/* Display 10 most expensive Orders. */
SELECT * FROM orders ORDER BY order_total DESC LIMIT 5;

/* Display all the Orders which are placed more than 10 days old 
and one or more items from those orders are still not shipped. */
SELECT * FROM orderdetails WHERE order_ID IN(
            SELECT order_ID FROM orders WHERE order_date <= DATE(CURDATE()- INTERVAL 10 DAY)
            AND order_status LIKE 'Shipped') AND product_status LIKE 'Not Ship';

/* Display list of shoppers which haven't ordered anything since last month. */
SELECT * FROM shopper WHERE shopper_ID IN (
                                            SELECT U.shopper_ID FROM address U
                                            WHERE U.address_ID IN (
                                                    SELECT O.address_ID FROM orders O
                                                    WHERE order_date <= DATE( CURDATE() - INTERVAL 1 MONTH)
                                                                   )
                                        );
                                        
/* Display list of shopper along with orders placed by them in last 15 days. */
SELECT S.shopper_ID, S.user_name,O.order_ID FROM orders O INNER JOIN address A INNER JOIN  shopper S
WHERE O.address_ID = A.address_ID AND A.shopper_ID = S.shopper_ID AND
      O.order_date >= DATE( CURDATE() - INTERVAL 15 DAY);


/* Display list of order items which are in “shipped” state for particular Order Id */
SELECT * FROM orderdetails WHERE product_status LIKE 'Shipped' AND order_id = 3;

/* Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price. */
SELECT OD.ID,OD.product_ID,OD.order_ID,OD.quantity,OD.total,OD.product_status,O.order_date
FROM orderdetails OD, orders O
WHERE OD.order_ID = O.order_ID AND OD.total BETWEEN 20 AND 30; 