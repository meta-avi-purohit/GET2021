create database storefront;

show databases;

use storefront;

show tables;

create table categories(
                        category_ID int NOT NULL AUTO_INCREMENT,
                        category_title varchar(50) NOT NULL,
                        parent_ID int,
                        PRIMARY KEY(category_ID)
                        );
                        
create table product(
                     product_ID int NOT NULL AUTO_INCREMENT,
                     product_title varchar(50) NOT NULL,
                     category_ID int NOT NULL,
                     product_price int NOT NULL,
                     product_quantity int NOT NULL,
                     PRIMARY KEY(product_ID),
                     FOREIGN KEY ( category_ID ) REFERENCES categories ( category_ID )
                     );

create table images(
                    image_ID int NOT NULL AUTO_INCREMENT,
                    image longblob NOT NULL,
                    product_ID int NOT NULL,
                    PRIMARY KEY ( image_ID ),
                    FOREIGN KEY ( product_ID ) REFERENCES product ( product_ID )
                    );
                    
create table shopper(
                     shopper_ID INT NOT NULL AUTO_INCREMENT,
                     user_name VARCHAR(50) NOT NULL,
                     PRIMARY KEY ( shopper_ID )
                     );
                     
create table address(
                     address_ID INT NOT NULL AUTO_INCREMENT,
                     area VARCHAR(50) NOT NULL,
                     city VARCHAR(50) NOT NULL,
                     state VARCHAR(50) NOT NULL,
                     country VARCHAR(50) NOT NULL,
                     shopper_ID INT NOT NULL,
                     PRIMARY KEY ( address_ID ),
                     FOREIGN KEY ( shopper_ID ) REFERENCES shopper ( shopper_ID )
                     );
                     
create table orders(
                    order_ID INT NOT NULL AUTO_INCREMENT,
                    order_date DATE NOT NULL,
                    order_total INT NOT NULL,
                    order_status VARCHAR(30) NOT NULL,
                    PRIMARY KEY ( order_ID )
                    );
        
create table orderdetails(
                           ID INT NOT NULL AUTO_INCREMENT,
                           product_ID INT NOT NULL,
                           order_ID INT NOT NULL,
                           quantity INT NOT NULL,
                           total INT NOT NULL,
                           PRIMARY KEY ( ID ),
                           FOREIGN KEY ( product_ID ) REFERENCES product ( product_ID ),
                           FOREIGN KEY ( order_ID ) REFERENCES orders ( order_ID )
                           );
                           
show tables;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE product;

SET FOREIGN_KEY_CHECKS = 1;

create table product(
                     product_ID int NOT NULL AUTO_INCREMENT,
                     product_title varchar(50) NOT NULL,
                     category_ID int NOT NULL,
                     product_price int NOT NULL,
                     product_quantity int NOT NULL,
                     PRIMARY KEY(product_ID),
                     FOREIGN KEY ( category_ID ) REFERENCES categories ( category_ID )
                     );
                     
SHOW TABLES;