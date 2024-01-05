INSERT INTO products (id, name, price_per_piece, stock_level) VALUES (1, 'soap', 5.99, 1000);

INSERT INTO orders (id, customer_id, status) VALUES (1, 1, 'NEW');
INSERT INTO orders (id, customer_id, status) VALUES (2, 1, 'CONFIRMED');
INSERT INTO orders (id, customer_id, status) VALUES (3, 2, 'FAILED');