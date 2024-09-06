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

INSERT INTO restaurant (name)
VALUES ('Joe'),
       ('Tuna'),
       ('Mario'),
       ('Miso'),
       ('Coffee-Cafe');

INSERT INTO lunch (name, price, restaurant_id, date)
VALUES ('Фри', 150, 100003, '2024-08-01'),
       ('Бургер', 400, 100003, '2024-08-01'),
       ('Кола', 100, 100003, '2024-08-01'),
       ('Рыба', 500, 100004, '2024-08-01'),
       ('Овощи', 300, 100004, '2024-08-01'),
       ('Сок', 200, 100004, '2024-08-01'),
       ('Пицца', 650, 100005, '2024-08-01'),
       ('Паста', 350, 100005, '2024-08-01'),
       ('Вино', 250, 100005, '2024-08-01'),
       ('Суши', 470, 100006, '2024-08-01'),
       ('Сашими', 490, 100006, '2024-08-01'),
       ('Лимонад', 180, 100006, '2024-08-01'),
       ('Салат', 380, 100007, '2024-08-01'),
       ('Сандвич', 410, 100007, '2024-08-01'),
       ('Кофе', 230, 100007, '2024-08-01');