-- Создаем таблицу с задачами
create table if not exists tasks
(
    id            bigserial primary key,
    description   varchar(255) not null,
    status        varchar(255) not null,
    date_creation timestamp    not null
);