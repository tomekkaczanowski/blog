CREATE TABLE whatever ( id INTEGER PRIMARY KEY,  product VARCHAR(50),  quantity INTEGER,  price DECIMAL(18,2) );
CREATE TABLE costam ( id INTEGER PRIMARY KEY,  costam VARCHAR(50),  something INTEGER, whatever_id INTEGER);

ALTER TABLE PUBLIC.costam ADD FOREIGN KEY (whatever_id) REFERENCES PUBLIC.whatever(id)

