-- Insert sample data
DO $$
BEGIN
    FOR i IN 1..1000 LOOP
        INSERT INTO beer_brewery_schema.beer_brewery_inventory (beer_name, quantity, price)
        VALUES ('Beer_' || i, (RANDOM() * 100)::INT, (RANDOM() * 10)::DECIMAL(10, 2));
    END LOOP;
END $$;