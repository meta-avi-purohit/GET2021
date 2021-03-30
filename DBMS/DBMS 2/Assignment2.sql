use storefront;

show tables;

INSERT INTO categories ( category_title )
VALUES 
('Home'),
('Faishon'),
('Electronics'),
('Sport')
;

INSERT INTO categories ( category_title, parent_ID )
VALUES
('Kitchen', 1),
('Home Decor', 1),
('Lighting & More', 1),
('Cleaning Stuff', 1)
;

INSERT INTO categories ( category_title, parent_ID )
VALUES
( 'Men Wear', 2),
( 'Women Wear', 2);

INSERT INTO categories ( category_title, parent_ID )
VALUES
('Shirt', 9),
('T-Shirt', 9),
( 'Jeans', 9);

INSERT INTO categories ( category_title, parent_ID )
VALUES
('Tops', 10),
('Skirt', 10),
( 'Jeans', 10);

INSERT INTO categories ( category_title, parent_ID )
VALUES
('Mobile', 3),
('Laptop', 3),
( 'Headphone', 3),
('Camera', 3);

INSERT INTO categories ( category_title, parent_ID )
VALUES
('Footwear', 4),
('Accessories', 4);

INSERT INTO categories ( category_title, parent_ID )
VALUES
('Bat', 22),
('Ball', 22);

INSERT INTO categories ( category_title )
VALUES ( 'Stationery ');

select * from categories;

INSERT INTO product ( product_title, category_ID, product_price, product_quantity )
VALUES 
( 'Toster', 5, 300, 60),
( 'Pan', 5, 250, 40);

INSERT INTO product ( product_title, category_ID, product_price, product_quantity )
VALUES 
( 'Wallpaper', 6, 100, 15),
( 'Clock', 6, 550, 30);

INSERT INTO product ( product_title, category_ID, product_price, product_quantity )
VALUES 
( 'Bulb', 7, 90, 100),
( 'Tourch', 7, 250, 25),
( 'Bulb', 8, 100, 40),
( 'Tourch', 8, 150, 20),
( 'Casual Shirt', 11, 400, 40),
( 'Formal', 11, 700, 55),
( 'Round Neck', 12, 300, 60),
( 'V-Neck', 12, 450, 25),
( 'Denim', 13, 700, 40),
( 'Formal', 13, 550, 50),
( 'Long Top', 14, 600, 70),
( 'Short Top', 14, 750, 40),
( 'Pencil', 15, 200, 10),
( 'Fly', 15, 300, 15),
( 'Skinny', 16, 700, 60),
( 'HighWaist', 16, 1000, 25),
( 'Android', 17, 14000, 20),
( 'IOS', 17, 25000, 55),
( 'Business', 18, 60000, 55),
( 'Gaming', 18, 70000, 20),
( 'Wireless', 19, 1200, 70),
( 'Wired', 19, 450, 60),
( 'Compact', 20, 20000, 60),
( 'Wide', 20, 50000, 40),
( 'Nike', 21, 1000, 100),
( 'Puma', 21, 2500, 90),
( 'SG', 23, 7000, 60),
( 'MRF', 23, 5000, 70),
( 'Tennies', 24, 50, 100),
( 'Cosco', 24, 70, 70);

INSERT INTO product ( product_title, category_ID, product_price, product_quantity )
VALUES 
( 'Pen', 25, 30, 60),
( 'Pencile', 25, 25, 40);

ALTER TABLE product
ADD status VARCHAR(10) NOT NULL;

UPDATE product SET status = 'Active' where product_ID = 1; 

UPDATE product SET status = 'Active' where product_ID = 2;
UPDATE product SET status = 'Active' where product_ID = 3;
UPDATE product SET status = 'Active' where product_ID = 4;
UPDATE product SET status = 'Active' where product_ID = 5;
UPDATE product SET status = 'Active' where product_ID = 6;
UPDATE product SET status = 'Active' where product_ID = 7;
UPDATE product SET status = 'Active' where product_ID = 8;
UPDATE product SET status = 'Active' where product_ID = 9;
UPDATE product SET status = 'Active' where product_ID = 10;
UPDATE product SET status = 'Active' where product_ID = 11;
UPDATE product SET status = 'Active' where product_ID = 12;
UPDATE product SET status = 'Active' where product_ID = 13;
UPDATE product SET status = 'Active' where product_ID = 14;
UPDATE product SET status = 'Active' where product_ID = 15;
UPDATE product SET status = 'Active' where product_ID = 16;
UPDATE product SET status = 'Active' where product_ID = 17;
UPDATE product SET status = 'Active' where product_ID = 18;
UPDATE product SET status = 'Active' where product_ID = 19;
UPDATE product SET status = 'Active' where product_ID = 20;
UPDATE product SET status = 'Active' where product_ID = 21;
UPDATE product SET status = 'Active' where product_ID = 22;
UPDATE product SET status = 'Active' where product_ID = 23;
UPDATE product SET status = 'Active' where product_ID = 24;
UPDATE product SET status = 'Active' where product_ID = 25;
UPDATE product SET status = 'Active' where product_ID = 26;
UPDATE product SET status = 'Active' where product_ID = 27;
UPDATE product SET status = 'Active' where product_ID = 28;
UPDATE product SET status = 'Active' where product_ID = 29;
UPDATE product SET status = 'Active' where product_ID = 30;
UPDATE product SET status = 'Active' where product_ID = 31;
UPDATE product SET status = 'Active' where product_ID = 32;
UPDATE product SET status = 'Active' where product_ID = 33;
UPDATE product SET status = 'Active' where product_ID = 34;
UPDATE product SET status = 'Active' where product_ID = 35;
UPDATE product SET status = 'Active' where product_ID = 36;

INSERT INTO product ( product_title, category_ID, product_price, product_quantity ,status)
VALUES 
( 'Scale', 25, 10, 100,'Not Active'),
( 'Erasar', 25, 5, 300,'Not Active'),
( 'Sharpher', 25, 10, 20, 'Not Active');

SELECT * FROM product;

INSERT INTO images(image,product_ID) 
VALUES(LOAD_FILE('D:/UIUX/UIUX-2/Parking.jpg'),1);

SELECT * FROM images;

/* Display Id, Title, Category Title, Price of the products which are
Active and recently added products should be at top.*/
SELECT P.product_ID,P.product_title,C.category_title,P.product_price 
FROM product P, categories C
WHERE P.category_ID = C.category_ID && P.status = 'Active'
ORDER BY P.product_ID DESC;

/* Display the list of products which don't have any images. */
SELECT product_ID , product_title FROM product
WHERE product_ID NOT IN ( SELECT product_ID FROM images );

/* Display all Id, Title and Parent Category Title for all the Categories listed,
sorted by Parent Category Title and then Category Title.*/
SELECT category_ID , category_title AS 'Category Title', 
CASE WHEN parent_ID IS NULL THEN 'Top Category'
     ELSE category_title
     END 'Parent Category Title'
FROM categories
ORDER BY 'Parent Category Title' ASC,category_title;
     
/* Display Id, Title, Parent Category Title of all the leaf Categories */
SELECT P.product_ID, P.product_title, C.category_title FROM product P, categories C
WHERE P.category_ID = C.category_ID AND C.parent_ID IS NOT NULL;

/* Display Product Title, Price & Description which falls into particular category Title */
SELECT P.product_title, P.product_price FROM product P, categories C
WHERE P.category_ID = C.category_ID AND C.category_title like 'Mobile';

/* Display the list of Products whose Quantity on hand (Inventory) is under 50 */
SELECT * FROM product
WHERE product_quantity < 50;