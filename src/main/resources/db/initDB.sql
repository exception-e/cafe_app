DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS vote;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS lunch;
DROP TABLE IF EXISTS restaurant;


DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq
    AS INTEGER
    START WITH 100000;

CREATE TABLE users
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name     VARCHAR(255)                     NOT NULL,
    email    VARCHAR(255)                     NOT NULL,
    password VARCHAR(255)                     NOT NULL,
    enabled  BOOLEAN             DEFAULT TRUE NOT NULL,

    constraint users_email unique (email)
);

CREATE TABLE user_role
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),

    CONSTRAINT users_role UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurant
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR(255) NOT NULL
);

CREATE TABLE lunch
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name          VARCHAR(255) NOT NULL,
    price_cents   INTEGER      NOT NULL,
    restaurant_id INTEGER      NOT NULL,
    date          DATE         NOT NULL,

    CONSTRAINT name_date unique (name, date),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id) ON DELETE CASCADE
);

create table vote
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    --- Comment
    date          DATE                DEFAULT current_date not null,
    time          TIME                DEFAULT current_time not null,
    user_id       integer                                  NOT NULL,
    restaurant_id integer                                  NOT NULL,


    foreign key (user_id) references users (id) on delete cascade,
    foreign key (restaurant_id) references restaurant (id) on delete cascade
);