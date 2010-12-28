CREATE TABLE inventory ( id INTEGER PRIMARY KEY,  product VARCHAR(50),  quantity INTEGER,  price DECIMAL(18,2) );
CREATE TABLE whatever ( id INTEGER PRIMARY KEY,  costam VARCHAR(50),  something INTEGER, inventory_id INTEGER);

ALTER TABLE PUBLIC.whatever ADD FOREIGN KEY (inventory_id) REFERENCES PUBLIC.inventory(id)

