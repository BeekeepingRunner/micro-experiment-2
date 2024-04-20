import random;

num_records = 10000

statuses = ['NEW', 'CONFIRMED', 'FAILED']

current_customer_id = 1

with open('insert_orders.sql', 'w') as file:
    for i in range(num_records):
        status = statuses[i % len(statuses)]
        
        # Example logic to increment customer_id after each cycle of statuses
        if i % len(statuses) == 0 and i != 0:
            current_customer_id += 1

        product_id = random.randint(1, 10000)
        req_quantity = random.randint(1, 1000)

        insert_statement = f"INSERT INTO orders (customer_id, status, product_id, requested_product_quantity) VALUES ({current_customer_id}, '{status}', {product_id}, {req_quantity});\n"
        
        file.write(insert_statement)

print(f"Generated {num_records} INSERT statements to 'insert_orders.sql'.")