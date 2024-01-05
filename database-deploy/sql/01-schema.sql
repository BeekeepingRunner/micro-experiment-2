CREATE TABLE products (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    price_per_piece DECIMAL(19,2),
    stock_level BIGINT
);

CREATE TABLE orders (
    id BIGINT PRIMARY KEY,
    customer_id BIGINT,
    status VARCHAR(100)
);