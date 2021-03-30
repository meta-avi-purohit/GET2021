USE storefront;

SELECT * FROM product;

SELECT * FROM categories;

/*Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.*/
SELECT product_ID, product_title , COUNT(category_ID) AS COUNT
FROM product
GROUP BY product_title HAVING COUNT(category_ID) > 2;

/*Display Count of products as per below price range:/*
/* 0 - 100 */
SELECT COUNT(product_ID) AS Count FROM product WHERE product_price >= 0 AND product_price <= 100;
/* 101 - 500 */
SELECT COUNT(product_ID) AS Count FROM product WHERE product_price >= 101 AND product_price <= 500;
/* above 500 */
SELECT COUNT(product_ID) AS Count FROM product WHERE product_price >500;

/* Display the Categories along with number of products under each category. */
SELECT C.category_title , COUNT(P.category_ID) AS 'Number Of Products' FROM categories C
INNER JOIN  product P ON P.category_ID = C.category_ID
GROUP BY P.category_ID;