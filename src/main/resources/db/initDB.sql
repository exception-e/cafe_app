DROP TABLE IF EXISTS USER_ROLE;
DROP TABLE IF EXISTS VOTE;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS LUNCH;
DROP TABLE IF EXISTS RESTAURANT;


DROP SEQUENCE IF EXISTS GLOBAL_SEQ;

CREATE SEQUENCE GLOBAL_SEQ
    AS INTEGER
    START WITH 100000;

CREATE TABLE USERS
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name     VARCHAR(255)                     NOT NULL,
    email    VARCHAR(255)                     NOT NULL,
    password VARCHAR(255)                     NOT NULL,
    enabled  BOOLEAN             DEFAULT TRUE NOT NULL,

    constraint USERS_UNIQUE_EMAIL unique (email)
);

CREATE TABLE USER_ROLE
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255),

    CONSTRAINT USERS_ROLE UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE RESTAURANT
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR(255) NOT NULL
);

CREATE TABLE LUNCH
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name          VARCHAR(255) NOT NULL,
    price         INTEGER      NOT NULL,
    restaurant_id INTEGER      NOT NULL,
    date          DATE         NOT NULL,

    CONSTRAINT NAME_DATE unique (name, date),
    FOREIGN KEY (restaurant_id) REFERENCES RESTAURANT (id) ON DELETE CASCADE
);

create table VOTE
(
    id            INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    date          DATE                DEFAULT current_date not null,
    time          TIME                DEFAULT current_time not null,
    user_id       integer                                  NOT NULL,
    restaurant_id integer                                  NOT NULL,


    foreign key (user_id) references USERS (id) on delete cascade,
    foreign key (restaurant_id) references RESTAURANT (id)
);