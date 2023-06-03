create table lista (
        id_lista bigint not null auto_increment,
        dt_criacao datetime(6) not null,
        limite_gasto float(53),
        nome_lista varchar(255),
        valor_total float(53),
        primary key (id_lista)
    ) engine=InnoDB