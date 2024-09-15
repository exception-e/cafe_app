DELETE FROM user_role;
DELETE FROM users;
DELETE FROM lunch;
DELETE FROM restaurant;
DELETE FROM vote;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('Guest', 'guest@gmail.com', '{noop}guest'),
       ('Guest1', 'guest1@gmail.com', '{noop}guest1'),
       ('Guest2', 'guest2@gmail.com', '{noop}guest2'),
       ('Guest3', 'guest3@gmail.com', '{noop}guest3'),
       ('Guest4', 'guest4@gmail.com', '{noop}guest4'),
       ('Guest5', 'guest5@gmail.com', '{noop}guest5');


INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
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

INSERT INTO lunch (name, price, restaurant_id, date)
VALUES ('Фри', 150, 100008, '2024-08-01'),
       ('Бургер', 400, 100008, '2024-08-01'),
       ('Кола', 100, 100008, '2024-08-01'),
       ('Рыба', 500, 100009, '2024-08-01'),
       ('Овощи', 300, 100009, '2024-08-01'),
       ('Сок', 200, 100009, '2024-08-01'),
       ('Пицца', 650, 100010, '2024-08-01'),
       ('Паста', 350, 100010, '2024-08-01'),
       ('Вино', 250, 100010, '2024-08-01'),
       ('Суши', 470, 100011, '2024-08-01'),
       ('Сашими', 490, 100011, '2024-08-01'),
       ('Лимонад', 180, 100011, '2024-08-01'),
       ('Салат', 380, 100012, '2024-08-01'),
       ('Сандвич', 410, 100012, '2024-08-01'),
       ('Кофе', 230, 100012, '2024-08-01');

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

