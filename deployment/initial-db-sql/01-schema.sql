CREATE TABLE products (
    id bigserial PRIMARY KEY,
    name VARCHAR(255),
    price_per_piece DECIMAL(19,2),
    stock_level BIGINT
);

CREATE TABLE orders (
    id bigserial PRIMARY KEY,
    customer_id BIGINT,
    status VARCHAR(100),
    product_id bigserial,
    requested_product_quantity INTEGER,
    FOREIGN KEY (product_id) REFERENCES products(id)
);