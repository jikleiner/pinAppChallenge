CREATE SEQUENCE SEQ_CLIENTES AS INTEGER START WITH 1
  INCREMENT BY 1;

CREATE TABLE CLIENTES (CLIENTE_ID INTEGER AUTO_INCREMENT PRIMARY KEY,
CLIENTE_NOMBRE VARCHAR(50) NOT NULL,
CLIENTE_APELLIDO VARCHAR(50) NOT NULL,
CLIENTE_EDAD INTEGER NOT NULL,
CLIENTE_FECHA_NACIMIENTO DATE NOT NULL);

INSERT INTO CLIENTES (CLIENTE_NOMBRE, CLIENTE_APELLIDO, CLIENTE_EDAD, CLIENTE_FECHA_NACIMIENTO) 
VALUES ('Tom', 'Cruise', 60, '1962-7-3'), 
	('Brad', 'Pitt', 59, '1963-12-18'), 
	('Tom', 'Hanks', 66, '1956-7-9'), 
	('Johnny', 'Depp', 59, '1963-6-9'), 
	('Leonardo', 'DiCaprio', 48, '1974-11-11'), 
	('Will', 'Smith', 54, '1968-9-25'), 
	('Dwayne', 'Johnson', 50, '1972-5-2'), 
	('Hugh', 'Jackman', 54, '1968-10-12'), 
	('Robert', 'Downey', 57, '1965-4-4'), 
	('Chris', 'Evans', 41, '1981-6-13'), 
	('Vin', 'Diesel', 55, '1967-7-18'), 
	('Bradley', 'Cooper', 48, '1975-1-5'), 
	('Daniel', 'Craig', 55, '1968-3-2'), 
	('Nicolas', 'Cage', 59, '1964-1-7'), 
	('Jackie', 'Chan', 68, '1954-4-7'), 
	('Jerry', 'Seinfeld', 68, '1954-4-29'), 
	('Jason', 'Momoa', 43, '1979-8-1'), 
	('Mel', 'Gibson', 67, '1956-1-3'), 
	('Samuel', 'L.', 74, '1948-12-21'), 
	('Al', 'Pacino', 82, '1940-4-25'), 
	('Sylvester', 'Stallone', 76, '1946-7-6'), 
	('Keanu', 'Reeves', 58, '1964-9-2'), 
	('Morgan', 'Freeman', 85, '1937-6-1'), 
	('Jason', 'Statham', 55, '1967-7-26'), 
	('Matt', 'Damon', 52, '1970-10-8'), 
	('Robert', 'DeNiro', 79, '1943-8-17'), 
	('James', 'Franco', 44, '1978-4-19'), 
	('Mark', 'Wahlberg', 51, '1971-6-5'), 
	('Kevin', 'Spacey', 63, '1959-7-26'), 
	('Tom', 'Hiddleston', 42, '1981-2-9'), 
	('Arnold', 'Schwarzenegger', 75, '1947-7-30'), 
	('Tom', 'Hardy', 45, '1977-9-15'), 
	('George', 'Clooney', 61, '1961-5-6'), 
	('Adam', 'Sandler', 56, '1966-9-9'), 
	('Jack', 'Nicholson', 85, '1937-4-22'), 
	('Michael', 'Keaton', 71, '1951-9-5'), 
	('Christian', 'Bale', 49, '1974-1-30'), 
	('Ryan', 'Gosling', 42, '1980-11-12'), 
	('Jim', 'Carrey', 61, '1962-1-17'), 
	('Dave', 'Bautista', 54, '1969-1-18'), 
	('Chris', 'Pratt', 43, '1979-6-21'), 
	('Ryan', 'Reynolds', 46, '1976-10-23'), 
	('Mark', 'Ruffalo', 55, '1967-11-22'), 
	('Jeremy', 'Renner', 52, '1971-1-7'), 
	('Paul', 'Rudd', 53, '1969-4-6'), 
	('Tobey', 'Maguire', 47, '1975-6-27'), 
	('Ben', 'Affleck', 50, '1972-8-15'), 
	('Joe', 'Manganiello', 46, '1976-12-28'), 
	('Anthony', 'Mackie', 44, '1978-9-23'), 
	('Jared', 'Leto', 51, '1971-12-26'), 
	('Jake', 'Gyllenhaal', 42, '1980-12-19'), 
	('Ian', 'Somerhalder', 44, '1978-12-8'), 
	('Denzel', 'Washington', 68, '1954-12-28'), 
	('Idris', 'Elba', 50, '1972-9-6'), 
	('Matthew', 'McConaughey', 53, '1969-11-4'), 
	('Joaquin', 'Phoenix', 48, '1974-10-28'), 
	('Ben', 'Stiller', 57, '1965-11-30'), 
	('Daniel', 'Brühl', 44, '1978-6-16'), 
	('Matt', 'Bomer', 45, '1977-10-11'), 
	('Gerard', 'Butler', 53, '1969-11-13'), 
	('Benedict', 'Cumberbatch', 46, '1976-7-19'), 
	('Chris', 'Pine', 42, '1980-8-26'), 
	('Chris', 'Hemsworth', 39, '1983-8-11'), 
	('Robert', 'Pattinson', 36, '1986-5-13'), 
	('Tom', 'Holland', 26, '1996-6-1'), 
	('Daniel', 'Radcliffe', 33, '1989-7-23'), 
	('John', 'David', 38, '1984-7-28'), 
	('Aaron', 'Taylor-Johnson', 32, '1990-6-13'), 
	('Zac', 'Efron', 35, '1987-10-18'), 
	('Taylor', 'Lautner', 31, '1992-2-11'), 
	('Dylan', 'Minnette', 26, '1996-12-29'), 
	('Kit', 'Harington', 36, '1986-12-26'), 
	('Sebastian', 'Stan', 40, '1982-8-13'), 
	('Ezra', 'Miller', 30, '1992-9-30'), 
	('Logan', 'Lerman', 31, '1992-1-19'), 
	('Paul', 'Wesley', 40, '1982-7-23'), 
	('Dan', 'Stevens', 40, '1982-10-10'), 
	('Henry', 'Cavill', 39, '1983-5-5'), 
	('Paul', 'Dano', 38, '1984-6-19'), 
	('Nicholas', 'Hoult', 33, '1989-12-7');