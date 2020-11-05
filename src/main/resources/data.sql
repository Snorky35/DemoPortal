DROP TABLE IF EXISTS PRODUCTS;
	 
	CREATE TABLE PRODUCTS (
	  id INT AUTO_INCREMENT  PRIMARY KEY,
	  name VARCHAR(250) NOT NULL,
	  price INT
	);
	 
	INSERT INTO PRODUCTS (name, price) VALUES
			('SquareOne', 499),
			('Chromacy', 29),
			('Crystal Bay', 49),
			('Dice Track', 69);

