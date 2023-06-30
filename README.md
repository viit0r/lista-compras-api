# API - Lista de compras

API desenvolvida para gerenciar a criação de listas de compras e armazenar as informações das listas e produtos em banco de dados MySQL

## Sumário
- [Informações importantes](#informações-importantes)
- [Lista de compras](#lista-de-compras)
  - [Criar uma lista](#criar-uma-lista)
  - [Buscar todas as listas](#buscar-todas-as-listas)
- [Item](#item)
  - [Criar um item](#criar-um-item)
  - [Buscar todos os itens](#buscar-todos-os-itens)
  - [Buscar os itens de uma lista](#buscar-os-itens-de-uma-lista)
- [Produto](#produto)
  - [Criar um produto](#criar-um-produto)
  - [Buscar todos os produtos](#buscar-todos-os-produtos)

## Informações importantes
Para se comunicar com a API, você deverá:
- Ter o serviço do MySQL instalado e rodando na sua máquina.
- Efetuar um clone do projeto.
- Configurar as credenciais do banco de dados (username e password) no arquivo [application.yml](src/main/resources/application.yml).
- Criar um banco com o nome *lista_compras_db*.
- Executar o projeto.

Após isso, poderá utilizar alguma ferramenta ou o próprio navegador para testar as requisições. 😉

A URL base para todas as requisições será *http://localhost:8080*.

## Lista de compras
### Criar uma lista
Faz a criação de uma lista de compras.

POST - [ _/lista_ ]

**Request body**
```
{
    "nome": "string",
    "limiteGasto": double
}
```

**Response status** - 201 Created

**Response body**
```
{
    "id": long,
    "nome": "string",
    "dataCriacao": "date",
    "limiteGasto": double,
    "valorTotal": double
}
```

### Buscar todas as listas
Efetua a busca e retorna todas as listas de compras já criadas.

GET - [ _/lista_ ]

**Response status** - 200 OK

**Response body**
```
[
    {
        "id": long,
        "nome": "string",
        "dataCriacao": "date",
        "limiteGasto": double,
        "valorTotal": double
    },
    ...
]
```

## Item
### Criar um item
Faz a criação de um item dentro de uma determinada lista de compras.

POST - [ _/item_ ]

**Request body**
```
{
    "coletado": boolean,
    "qtde": int,
    "produto": {
        "id": long,
        "nome": "string",
        "valorUnitario": double
    },
    "lista": {
        "id": long
    }
}
```

**Response status** - 201 Created

**Response body**
```
{
    "id": long,
    "coletado": boolean,
    "qtde": int,
    "valorTotal": double,
    "produto": {
        "id": long,
        "nome": "string",
        "valorUnitario": double
    },
    "lista": {
        "id": long,
        "nome": "string",
        "dataCriacao": "date",
        "limiteGasto": double,
        "valorTotal": double
    }
}
```

### Buscar todos os itens
Efetua a busca e retorna todos itens já criados.

GET - [ _/item_ ]

**Response status** - 200 OK

**Response body**
```
[
    {
        "id": long,
        "coletado": boolean,
        "qtde": int,
        "valorTotal": double,
        "produto": {
            "id": long,
            "nome": "string",
            "valorUnitario": double
        },
        "lista": {
            "id": long,
            "nome": "string",
            "dataCriacao": "date",
            "limiteGasto": double,
            "valorTotal": double
        }
    },
    ...
]
```

### Buscar os itens de uma lista

Efetua a busca de todos os itens de uma determinada lista, baseando-se no ID da lista.

GET - [ _/item/{idLista}_ ]

**Response status** - 200 OK

**Response body**
```
{
        "id": long,
        "coletado": boolean,
        "qtde": int,
        "valorTotal": double,
        "produto": {
            "id": long,
            "nome": "string",
            "valorUnitario": double
        },
        "lista": {
            "id": long,
            "nome": "string",
            "dataCriacao": "date",
            "limiteGasto": double,
            "valorTotal": double
        }
    },
    ...
```

## Produto
### Criar um produto

Efetua a criação de um novo produto na base de dados.

POST - [ _/produto_ ]

**Response body**
```
{
    "nome": "string",
    "valorUnitario": double
}
```

**Response status** - 201 Created

**Response body**
```
{
    "id": long,
    "nome": "string",
    "valorUnitario": double
}
```

### Buscar todos os produtos
Efetua a busca de todos os produtos já cadastrados na base de dados.

GET - [ _/produto_ ]

**Response status** - 200 OK

**Response body**
```
[
    {
        "id": long,
        "nome": "string",
        "valorUnitario": double
    },
    ...
]
```