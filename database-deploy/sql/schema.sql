CREATE TABLE micropostgres.product (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    pricePerPiece DECIMAL(19,2),
    stockLevel BIGINT
);
