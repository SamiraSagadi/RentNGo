# RentNGo
# Project Description
This application allows a customer to rent items they need for a certain number of days. An owner can list products that they have available for rent and display a price per day for the item. 

# Creating the database with Postico
Creating RentNGo Database: 
```
CREATE DATABASE RentNGo;
```
Creating Customer Database:
```
CREATE TABLE CUSTOMERS(
CUSTOMER_ID SERIAL NOT NULL,
FIRST_NAME VARCHAR(255) NOT NULL,
LAST_NAME VARCHAR(255) NOT NULL,
EMAIL VARCHAR(255) UNIQUE NOT NULL,
PASSWORD VARCHAR(255) NOT NULL,
PRIMARY KEY(CUSTOMER_ID)
);
```

Creating Products Database:
```
CREATE TABLE PRODUCTS(
PRODUCT_ID SERIAL NOT NULL,
NAME VARCHAR(255) NOT NULL,
CATEGORY VARCHAR(255) NOT NULL,
DAILY_PRICE DOUBLE  NOT NULL,
AVAILABILITY VARCHAR(255) NOT NULL,
PRIMARY KEY(PRODUCT_ID)
);
```

Creating Order Database:
```
CREATE TABLE ORDERS(
ORDER_ID SERIAL NOT NULL,
CUSTOMER_ID SERIAL NOT NULL,
ORDER_DATE DATE,
CUSTOMER_ADDRESS VARCHAR(255) NOT NULL,
PRIMARY KEY(ORDER_ID),
FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID)
);
```

Creating OrderDetail Database:
```
CREATE TABLE ORDERDETAIL(
ORDER_DETAIL_ID SERIAL NOT NULL,
ORDER_ID SERIAL NOT NULL,
PRODUCT_ID SERIAL NOT NULL,
TOTAL_PRICE DECIMAL,
PRIMARY KEY(ORDER_DETAIL_ID),
FOREIGN KEY (ORDER_ID) REFERENCES ORDERS(ORDER_ID),
FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCTS(PRODUCT_ID)
);
```

Creating Owner Database:
```
CREATE TABLE OWNERS(
OWNER_ID SERIAL NOT NULL,
FULL_NAME VARCHAR(255) NOT NULL,
EMAIL VARCHAR(255) UNIQUE NOT NULL,
PRIMARY KEY(OWNER_ID)
);
```

# Example of customer APIs available 
Note: use localhost:8080 before using the APIs!

|URL              |REQUEST TYPE|DESCRIPTION|
|-----------------|------------|-----------|
|/get-all-customers|    GET    |get all customers in database|
|/add-new-customer |    POST   |add a customer to the databse|
|/edit/{customerId}|    PUT    |edit a customer using their ID|
|/delete/{customerId}| DELETE  |delete a customer|

