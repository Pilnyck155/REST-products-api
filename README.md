docker run --name postgres-3 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=shop -d -p 3000:5432 postgres:alpine

CREATE TABLE Products ( product_id SERIAL NOT NULL PRIMARY KEY, name VARCHAR (50) NOT NULL, price DECIMAL (10,2) NOT NULL, date DATE NOT NULL);