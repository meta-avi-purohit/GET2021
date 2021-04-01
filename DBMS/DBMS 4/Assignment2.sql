/* Create a Stored procedure to retrieve average sales of each product in a month. 
Month and year will be input parameter to function. */
DROP PROCEDURE IF EXISTS avgSales;

DELIMITER //
CREATE PROCEDURE avgSales(month INT, year INT )
BEGIN
    SELECT P.product_ID,AVG(D.total) FROM product P
    INNER JOIN orderdetails D ON P.product_ID = D.product_ID
    INNER JOIN orders O ON O.order_ID = D.order_ID
    WHERE (O.order_status = 'Shipped' OR O.order_status = 'Complete' ) AND MONTH(O.order_date) = month AND YEAR(O.order_date) = year
    GROUP BY P.product_ID;
END //

DELIMITER ;

CALL avgSales(1,2021);

/* Create a stored procedure to retrieve table having order detail with status
for a given period. Start date and end date will be input parameter. 
Put validation on input dates like start date is less than end date. 
If start date is greater than end date take first date of month as start date. */
DELIMITER //
CREATE PROCEDURE retrieve(start DATE, ends DATE)
BEGIN
    IF start > ends THEN SET start = DATE_FORMAT(ends, '%Y-%M-01');
    END IF;
    SELECT * FROM orders
    WHERE order_date >= start AND order_date <= ends;
END //
DELIMITER ;

CALL retrieve('2020-11-01' , '2021-01-30');