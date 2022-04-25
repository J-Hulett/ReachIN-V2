BEGIN TRANSACTION;

DROP TABLE IF EXISTS unit, item CASCADE;

CREATE TABLE unit
(
    unit_id   serial,
    unit_type varchar(50) NOT NULL,
    CONSTRAINT PK_unit_id PRIMARY KEY (unit_id),
    CONSTRAINT UQ_unit_type UNIQUE (unit_type)
);

CREATE TABLE item
(
    item_id    serial,
    item_name  varchar(50) NOT NULL,
    time_added timestamp,
    quantity   numeric(6, 2),
    unit_id    int         NOT NULL,
    CONSTRAINT PK_item_id PRIMARY KEY (item_id),
    CONSTRAINT UQ_name UNIQUE (item_name),
    CONSTRAINT FK_unit_unit_id FOREIGN KEY (unit_id) REFERENCES unit (unit_id)
);

INSERT INTO unit (unit_type)
VALUES ('Pound');
INSERT INTO unit (unit_type)
VALUES ('Quart');
INSERT INTO unit (unit_type)
VALUES ('Pint');
INSERT INTO unit (unit_type)
VALUES ('Cup');

INSERT INTO item (item_name, time_added, quantity, unit_id)
VALUES ('Kosher Salt', CURRENT_TIMESTAMP, 12.00, 1);
INSERT INTO item (item_name, time_added, quantity, unit_id)
VALUES ('Ammoiglio', CURRENT_TIMESTAMP, 6.00, 2);
INSERT INTO item (item_name, time_added, quantity, unit_id)
VALUES ('Gremolata', CURRENT_TIMESTAMP, 3.00, 3);
INSERT INTO item (item_name, time_added, quantity, unit_id)
VALUES ('Basil Pesto', CURRENT_TIMESTAMP, 4.50, 4);

COMMIT;