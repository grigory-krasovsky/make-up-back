CREATE TABLE IF NOT EXISTS palettes (
                                        id BIGINT PRIMARY KEY GENERATED  BY DEFAULT AS IDENTITY,
                                        name TEXT,
                                        price DECIMAL(10,2),
                                        tag_id BIGINT,
                                        image TEXT,
                                        rating INT,
                                        brand_id BIGINT,
                                        description TEXT
);