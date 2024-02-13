CREATE TABLE IF NOT EXISTS "user"
(id INT AUTO_INCREMENT PRIMARY KEY,
name varchar(50) NOT NULL,
age int NOT NULL,
email varchar(50) NOT NULL
);

INSERT INTO "user" (name, age, email) values ('Kat', 25, 'kat@maail.ru');
INSERT INTO "user" (name, age, email) values ('Den', 35, 'dennn@gmail.com');
INSERT INTO "user" (name, age, email) values ('Pitter', 40, 'pit@gmail.com');
INSERT INTO "user" (name, age, email) values ('Alex', 21, 'alextred@mail.ru');
INSERT INTO "user" (name, age, email) values ('Elena',37, 'elena@yandex.ru' );