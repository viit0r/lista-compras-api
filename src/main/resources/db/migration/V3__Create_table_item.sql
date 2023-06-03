create table item (
        id_item bigint not null auto_increment,
        coletado bit,
        qtde_item integer,
        valor_total_itens float(53),
        id_lista bigint not null,
        id_produto bigint not null,
        primary key (id_item)
    ) engine=InnoDB