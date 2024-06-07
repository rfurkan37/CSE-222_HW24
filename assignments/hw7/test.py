def generate_test(filename):
    with open(filename, 'w') as f:
        # Add new stocks
        for i in range(1, 101):
            f.write(f"ADD STOCK{i} {150.0 + i} {1000000 + i} {100 + i}\n")
        # Update the stocks
        for i in range(1, 101):
            f.write(f"UPDATE STOCK{i} {155.0 + i} {1000001 + i} {101 + i}\n")
        # Search for the stocks
        for i in range(1, 101):
            f.write(f"SEARCH STOCK{i}\n")
        # Remove the stocks
        for i in range(1, 101):
            f.write(f"REMOVE STOCK{i}\n")
        # Search for the stocks again
        for i in range(1, 101):
            f.write(f"SEARCH STOCK{i}\n")

generate_test('input.txt')