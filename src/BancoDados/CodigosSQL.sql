create database escola3;
use escola3;

create table login
(
    id int primary key auto_increment,
    login varchar(100),
    senha varchar(50),
    setor varchar(20),
    estado_login boolean default true,
    dt_cadastro timestamp default current_timestamp
)
