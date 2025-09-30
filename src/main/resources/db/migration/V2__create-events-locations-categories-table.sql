CREATE TABLE event_locations (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    latitude DOUBLE PRECISION NOT NULL,
    longitude DOUBLE PRECISION NOT NULL,
    has_address BOOLEAN DEFAULT FALSE,
    address VARCHAR(255),
    city VARCHAR(100),
    state VARCHAR(100),
    country VARCHAR(100),
    zip_code VARCHAR(20)
);

CREATE TABLE event_categories (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE events (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    banner VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    event_date TIMESTAMP NOT NULL,
    price DECIMAL(10,2),
    event_category_id INTEGER,
    FOREIGN KEY (event_category_id) REFERENCES event_categories(id) ON DELETE RESTRICT
);