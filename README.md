# Api-Hemocentro
Projeto final para a disciplina de Containers and Virtualizations.
Essa API Rest tem como objetivo um CRUD para doadores e hemocentros.

##  Pré-requisitos para execução do projeto
  Tecnologias necessárias.

  1- Para executar os projetos é necessário ter instalado Java SE Development Kit versão 11.
  
  2- Utilizar uma IDE para execução dos projetos de API desenvolvida em Java. Ex. IntelliJ ou Eclipse.
  
  3- Docker 
  
---
 
## Download do projeto

Baixar o projeto: `$ git clone https://github.com/igor-fga/Api-Hemocentro.git`

---

## Instruções execução do projeto

  1- Acessar a pasta aonde foi feito o clone do projeto do github e entrar na pasta **Api**.
  
  2- Digitar o comando `docker-compose up -d`.

  3- Aguardar o termino do build e o iniciar dos containers.
  
  4- Importar a collection **Api Hemocentro.postman_collection.json** do postman disponível na pasta **Api**.
  
  5- Executar a requisições do Postman para o CRUD de doadores e bancos de sangue.

## Endereços dos serviços em execução
  
  - http://localhost:8000/v1/doadores

  - http://localhost:8000/v1/bancos-de-sangue

---

## Endereço da imagem da API no Docker Hub

  - https://hub.docker.com/r/teixeira308/apihemocentro
  
---

## Video com a demonstração do projeto

  - https://www.loom.com/share/72bda83388ad4360b40079cbce7ebea5

