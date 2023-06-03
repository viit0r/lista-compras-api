alter table item 
       add constraint fk_id_lista 
       foreign key (id_lista) 
       references lista (id_lista), 
       add constraint fk_id_produto 
       foreign key (id_produto) 
       references produto (id_produto);