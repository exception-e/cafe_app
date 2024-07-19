DELETE FROM user_roles;
DELETE from PUBLIC.PUBLIC.VOTING_PROCESS;
delete from PUBLIC.PUBLIC.LUNCHES;
delete from PUBLIC.PUBLIC.VOTINGS;
delete from PUBLIC.PUBLIC.USERS;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (NAME, email, PASSWORD) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

insert into PUBLIC.PUBLIC.VOTINGS (id, voting_date) values
  (100002, '2018-11-23' ),
  (100003, '2018-11-24' );

insert into PUBLIC.PUBLIC.LUNCHES(ID, NAME, MENU, VOTING_ID) values

  (100004, 'cafe1', 'menu1', 100002),
  (100005, 'cafe2', 'menu2', 100002),
  (100006, 'cafe3', 'menu3', 100002),
  (100007, 'cafe4', 'menu4', 100003),
  (100008, 'cafe5', 'menu5', 100003),
  (100009, 'cafe6', 'menu6', 100003);

insert into PUBLIC.PUBLIC.VOTING_PROCESS (id, VOTING_ID, USER_ID, LUNCH_ID) values
  (100010, 100002, 100000,100004),
  (100011, 100003, 100000,100008);
