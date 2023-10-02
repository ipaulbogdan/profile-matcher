CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE clans (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE items (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE inventories (
   id SERIAL PRIMARY KEY,
   cash INT,
   coins INT
);

CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    player_id UUID NOT NULL UNIQUE,
    credential VARCHAR(255) NOT NULL ,
    created TIMESTAMP NOT NULL,
    modified TIMESTAMP,
    last_session TIMESTAMP NOT NULL,
    total_spent NUMERIC,
    total_refund NUMERIC,
    total_transactions NUMERIC,
    last_purchase TIMESTAMP,
    level INT,
    xp INT,
    total_playtime INT,
    country VARCHAR(2) NOT NULL,
    language VARCHAR(2) NOT NULL,
    birthdate DATE,
    gender VARCHAR(6) NOT NULL,
    clan_id INT,
    inventory_id INT,
    custom_field VARCHAR(255),

    CONSTRAINT fk_clan FOREIGN KEY(clan_id) REFERENCES clans(id),
    CONSTRAINT fk_inventory FOREIGN KEY(inventory_id) REFERENCES inventories(id)
);

CREATE TABLE devices (
     id SERIAL PRIMARY KEY,
     model VARCHAR(255) NOT NULL,
     carrier VARCHAR(255) NOT NULL,
     firmware VARCHAR(255) NOT NULL,
     player_id INT NOT NULL,

     CONSTRAINT fk_player FOREIGN KEY (player_id) REFERENCES players(id)
);

CREATE TABLE inventory_items (
    id SERIAL PRIMARY KEY,
    inventory_id INT NOT NULL,
    item_id INT NOT NULL,
    count INT NOT NULL
)

