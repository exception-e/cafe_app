DROP TABLE user_roles IF EXISTS;
DROP TABLE users IF EXISTS;
drop table lunches if exists;
drop table voting if exists ;
drop table voting_variants if exists ;
drop table voting_data if exists;

DROP SEQUENCE global_seq IF EXISTS;

CREATE SEQUENCE GLOBAL_SEQ
  AS INTEGER
  START WITH 100000;

CREATE TABLE users
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name             VARCHAR(255)            NOT NULL,
  email            VARCHAR(255)            NOT NULL,
  password         VARCHAR(255)            NOT NULL,
  enabled          BOOLEAN DEFAULT TRUE    NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx
  ON USERS (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR(255),

  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);

CREATE TABLE lunches
(
  id               INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  name             VARCHAR(255)            NOT NULL,
  menu             VARCHAR(255)            NOT NULL
);

create table voting
(
  id              INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  result          VARCHAR(255),

  foreign key (result) references lunches (id)
);

create table voting_variants
(
  voting_id       INTEGER                 not null,
  variant         INTEGER                 not null,

  constraint voting_variant unique (voting_id, variant),
  foreign key (voting_id) references voting (id) on DELETE cascade,
  foreign key (variant) references lunches (id)
);

create table voting_data
(
  voting_id integer not null ,
  user_id integer not null ,
  lunch_id integer not null ,

  constraint users_variant unique (voting_id, user_id),
  foreign key (voting_id) references voting (id),
  foreign key (user_id) references users (id),
  foreign key (lunch_id) references lunches (id)
)

/*CREATE TABLE meals
(
  id          INTEGER GENERATED BY DEFAULT AS SEQUENCE GLOBAL_SEQ PRIMARY KEY,
  date_time   TIMESTAMP    NOT NULL,
  description VARCHAR(255) NOT NULL,
  calories    INT          NOT NULL,
  user_id     INTEGER      NOT NULL,
  FOREIGN KEY (user_id) REFERENCES USERS (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX meals_unique_user_datetime_idx
  ON meals (user_id, date_time)*/