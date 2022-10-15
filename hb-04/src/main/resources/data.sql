DELIMITER $$
CREATE PROCEDURE GetCustomerDataByName(IN custName VARCHAR(100))
BEGIN
SELECT * FROM customer WHERE first_name = custName;
END$$
DELIMITER ;