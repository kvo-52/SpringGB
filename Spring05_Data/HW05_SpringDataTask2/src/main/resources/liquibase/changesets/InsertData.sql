-- Заполняем созданную таблицу начальными значениями
insert into users (username, password, email, role)
values ('Сергей', '123', 'serg@mail.ru', 'manager'),
       ('Слава', '345', 'slava@mail.ru', 'tester'),
       ('Кирилл', '567', 'kir@mail.ru', 'devops');

insert into projects (name, description, created_date)
values ('ПД', 'Проектная документация', '2023-12-25 18:00:00'),
       ('Магазин', 'Торговая площадка', '2024-02-03 20:35:22');

insert into entity_with_relation (related_entity_id, project_id, user_id)
values (null, 1, 1),
       (null, 1, 2),
       (null, 1, 3),
       (null, 2, 1),
       (null, 2, 3);