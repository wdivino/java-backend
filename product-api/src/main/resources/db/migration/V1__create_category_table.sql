create schema if not exists products;

create table category (
    id bigserial primary key,
    nome varchar(100) not null
);