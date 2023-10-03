INSERT INTO items (name)
VALUES ('sword_1'),
       ('sword_2'),
       ('sword_3'),
       ('sword_4'),
       ('helmet_1'),
       ('helmet_2'),
       ('helmet_3'),
       ('helmet_4');

INSERT INTO inventories (cash, coins)
VALUES (50, 100);

INSERT INTO clans (name)
VALUES ('random_clan');

INSERT INTO players (player_id, credential, created, modified, last_session, total_spent, total_refund, total_transactions, last_purchase, level, xp, total_playtime, country, language, birthdate, gender, clan_id, inventory_id, custom_field)
VALUES ('dc09fa42-2578-4c02-8dec-9bd231da907b', 'apple_credential', '2023-10-01 21:13:53.930706', null, '2023-10-01 21:13:53.929959', 0, 0, 0, null, 2, 0, 0, 'RO', 'en', '1997-09-28', 'male', 1, 1, null);

INSERT INTO devices (model, carrier, firmware, player_id) VALUES ('iphone 12 pro', 'vodafone', 'firmware', 1);

INSERT INTO inventory_items (inventory_id, item_id, count) VALUES (1, 1, 5), (1, 4, 2)
