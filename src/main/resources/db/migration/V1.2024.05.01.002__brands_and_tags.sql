CREATE TABLE IF NOT EXISTS brands (
                                        id BIGINT PRIMARY KEY GENERATED  BY DEFAULT AS IDENTITY,
                                        title TEXT
);
ALTER TABLE palettes ADD CONSTRAINT brand_fk FOREIGN KEY (brand_id) REFERENCES brands (id);

CREATE TABLE IF NOT EXISTS tags (
                                        id BIGINT PRIMARY KEY GENERATED  BY DEFAULT AS IDENTITY,
                                        title TEXT
);
ALTER TABLE palettes ADD CONSTRAINT tag_fk FOREIGN KEY (tag_id) REFERENCES tags (id);