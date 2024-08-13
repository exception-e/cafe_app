DELETE FROM user_role;
DELETE FROM users;
DELETE FROM lunch;
DELETE FROM restaurant;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('Guest', 'guest@gmail.com', '{noop}guest');

INSERT INTO user_role (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100002);

INSERT INTO restaurant (name, id)
VALUES ('Joe', 100003),
       ('Tuna', 100004),
       ('Mario', 100005),
       ('Miso', 100006),
       ('Coffee-Cafe', 100007);

INSERT INTO lunch (name, price, restaurant_id, date, id)
VALUES ('Фри', 150, 100003, '2024-08-01', 100008),
       ('Бургер', 400, 100003, '2024-08-01', 100009),
       ('Кола', 100, 100003, '2024-08-01', 100010),
       ('Рыба', 500, 100004, '2024-08-01',100011),
       ('Овощи', 300, 100004, '2024-08-01', 100012),
       ('Сок', 200, 100004, '2024-08-01', 100013),
       ('Пицца', 650, 100005, '2024-08-01', 100014),
       ('Паста', 350, 100005, '2024-08-01', 100015),
       ('Вино', 250, 100005, '2024-08-01', 100016),
       ('Суши', 470, 100006, '2024-08-01', 100017),
       ('Сашими', 490, 100006, '2024-08-01', 100018),
       ('Лимонад', 180, 100006, '2024-08-01', 100019),
       ('Салат', 380, 100007, '2024-08-01', 100020),
       ('Сандвич', 410, 100007, '2024-08-01', 100021),
       ('Кофе', 230, 100007, '2024-08-01', 100022);