/* Create a function to calculate number of orders in a month.
Month and year will be input parameter to function. */
DELIMITER //
CREATE FUNCTION numberOfOrder(monthI DATE, yearI DATE) RETURNS INT DETERMINISTIC
BEGIN
    RETURN ( SELECT COUNT(order_ID) FROM orders
    WHERE MONTH(order_date) = MONTH(monthI) AND YEAR(order_date) = YEAR(yearI));
END //

DELIMITER ;

SELECT numberOfOrder('2021-02-21','2021-03-21') AS numberOfOrder;


DROP FUNCTION IF EXISTS maxMonth;
/* Create a function to return month in a year having maximum orders. Year will be input parameter. */
DELIMITER //
CREATE FUNCTION maxMonth ( yearIP DATE ) RETURNS VARCHAR(10) DETERMINISTIC
BEGIN
     RETURN(
     SELECT MONTHNAME(order_date) FROM orders
     WHERE YEAR(order_date) = YEAR(yearIP)
     GROUP BY MONTHNAME(order_date)
     ORDER BY COUNT(order_ID) DESC limit 1);
END //

DELIMITER ;

SELECT maxMonth('2021-02-02') as MONTH;