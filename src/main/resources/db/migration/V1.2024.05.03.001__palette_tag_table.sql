CREATE TABLE IF NOT EXISTS palette_tag (
                                        id BIGINT PRIMARY KEY,
                                        p_id BIGINT,
                                        t_id BIGINT
);
ALTER TABLE palette_tag ADD CONSTRAINT p_p_fk FOREIGN KEY (p_id) REFERENCES palettes (id);
ALTER TABLE palette_tag ADD CONSTRAINT p_t_fk FOREIGN KEY (t_id) REFERENCES tags (id);