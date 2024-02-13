# Define the number of records you want to generate
num_records = 10000

# Open a file to write the SQL statements to
with open('insert_products.sql', 'w') as file:
    for i in range(num_records):
        # Example data generation logic
        name = f"product_{i}"
        price_per_piece = round(5.99 + i * 0.01, 2)  # Example variation in price
        stock_level = 10000 - i  # Example stock level
        
        # Create the SQL insert statement
        insert_statement = f"INSERT INTO products (name, price_per_piece, stock_level) VALUES ('{name}', {price_per_piece}, {stock_level});\n"
        
        # Write to file
        file.write(insert_statement)

print(f"Generated {num_records} INSERT statements.")