-- Создаем таблицу с задачами
create table if not exists users
(
    id       bigserial primary key,
    username varchar(255) not null,
    password varchar(255) not null,
    email    varchar(100) not null,
    role     varchar(100) not null
);

create table if not exists projects
(
    id           bigserial primary key,
    name         varchar(255) not null,
    description  varchar(255) not null,
    created_date timestamp    not null
);

create table if not exists entity_with_relation
(
    id                bigserial primary key,
    related_entity_id integer,
    project_id        integer not null,
    user_id           integer not null,
    unique (project_id, user_id)
);