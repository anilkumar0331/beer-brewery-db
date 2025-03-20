DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.schemata WHERE schema_name = 'beer_brewery_schema') THEN
        CREATE SCHEMA beer_brewery_schema;
    END IF;
END $$;

CREATE TABLE beer_brewery_schema.beer_brewery_inventory (
    id SERIAL PRIMARY KEY,
    beer_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create function to update timestamps
CREATE OR REPLACE FUNCTION beer_brewery_schema.update_timestamps()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = CURRENT_TIMESTAMP;
    IF TG_OP = 'INSERT' THEN
        NEW.created_at = CURRENT_TIMESTAMP;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Create trigger to call the function on insert or update
CREATE TRIGGER set_timestamps
BEFORE INSERT OR UPDATE ON beer_brewery_schema.beer_brewery_inventory
FOR EACH ROW
EXECUTE FUNCTION beer_brewery_schema.update_timestamps();