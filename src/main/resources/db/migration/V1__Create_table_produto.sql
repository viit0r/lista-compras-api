create table produto (
        id_produto bigint not null auto_increment,
        nome_produto varchar(255) not null,
        valor_unitario float(53) not null,
        primary key (id_produto)
    ) engine=InnoDB