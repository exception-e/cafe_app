DELETE FROM user_role;
DELETE FROM users;
DELETE FROM lunch;
DELETE FROM restaurant;
DELETE FROM vote;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('User0', 'user0@gmail.com', '{noop}user0'),
       ('User1', 'user1@gmail.com', '{noop}user1'),
       ('User2', 'user2@gmail.com', '{noop}user2'),
       ('User3', 'user3@gmail.com', '{noop}user3'),
       ('User4', 'user4@gmail.com', '{noop}user4'),
       ('User5', 'user5@gmail.com', '{noop}user5');


INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001),
       ('USER', 100002),
       ('USER', 100003),
       ('USER', 100004),
       ('USER', 100005),
       ('USER', 100006),
       ('USER', 100007);

INSERT INTO restaurant (name)
VALUES ('Joe'),
       ('Tuna'),
       ('Mario'),
       ('Miso'),
       ('Coffee-Cafe');

INSERT INTO lunch (name, price_cents, restaurant_id, date)
VALUES ('Фри', 15000, 100008, '2024-08-01'),
       ('Бургер', 40000, 100008, '2024-08-01'),
       ('Кола', 10000, 100008, '2024-08-01'),
       ('Рыба', 50000, 100009, '2024-08-01'),
       ('Овощи', 30000, 100009, '2024-08-01'),
       ('Сок', 20000, 100009, '2024-08-01'),
       ('Пицца', 65000, 100010, '2024-08-01'),
       ('Паста', 35000, 100010, '2024-08-01'),
       ('Вино', 25000, 100010, '2024-08-01'),
       ('Суши', 47000, 100011, '2024-08-01'),
       ('Сашими', 49000, 100011, '2024-08-01'),
       ('Лимонад', 18000, 100011, '2024-08-01'),
       ('Салат', 38000, 100012, '2024-08-01'),
       ('Сандвич', 41000, 100012, '2024-08-01'),
       ('Кофе', 23000, 100012, '2024-08-01');

INSERT INTO vote (user_id, restaurant_id)
VALUES (100000, 100008),
       (100001, 100008),
       (100002, 100008),
       (100003, 100008),
       (100004, 100008),
       (100005, 100009),
       (100006, 100009),
       (100007, 100009);

INSERT INTO vote (time, user_id, restaurant_id)
VALUES ('10:27:58', 100000, 100008),
       ('10:27:58', 100001, 100008),
       ('10:27:58', 100002, 100008),
       ('10:27:58', 100003, 100008);

INSERT INTO vote (time, date, user_id, restaurant_id)
VALUES ('10:27:58', '2024-09-13', 100000, 100008),
       ('10:27:58', '2024-09-13', 100001, 100008),
       ('10:27:58', '2024-09-13', 100002, 100008),
       ('10:27:58', '2024-09-13', 100003, 100008);

