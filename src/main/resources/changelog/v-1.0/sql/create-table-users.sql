create table users
(
    id       bigserial    not null,
    password varchar(255),
    username varchar(255) unique not null,
    fio varchar(255),
    primary key (id)
);