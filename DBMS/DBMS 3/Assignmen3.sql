CREATE TABLE city(
Name VARCHAR(20) NOT NULL,
ZipCode VARCHAR(20) PRIMARY KEY);

CREATE TABLE state(
Name VARCHAR(20) NOT NULL,
ZipCode VARCHAR(20),
FOREIGN KEY (ZipCode) REFERENCES city (ZipCode)
);

INSERT INTO city(Name , ZipCode)
VALUES ( 'Udaipur' , '313001'),
       ( 'Jaipur' , '313028' ),
       ( 'Ranchi' , '834001' ),
       ( 'Surat' , '403100' ),
       ( 'Indore' , '513001' );

INSERT INTO state(Name , ZipCode)
VALUES ( 'Rajasthan' , '313001'),
       ( 'Rajasthan' , '313028' ),
       ( 'JharKhand' , '834001' ),
       ( 'Gujarat' , '403100' ),
       ( 'Madhya Pradesh' , '513001' );
       
SELECT C.ZipCode PIN, C.Name CITY , S.Name STATE FROM city C
INNER JOIN state S ON C.ZipCode = S.ZipCode
ORDER BY STATE,CITY;