# Projeto Spring Boot - Consumo de API ViaCEP

Este projeto é uma aplicação Spring Boot que consome a API do ViaCEP para obter informações de endereços brasileiros. O projeto inclui duas entidades principais: `Cliente` e `Endereco`.

## Funcionalidades

- **Consulta de Endereço**: A aplicação permite consultar informações de endereço usando o CEP, fornecido pela API do ViaCEP.
- **Gerenciamento de Clientes**: A aplicação gerencia dados de clientes, associando-os a endereços.

## Estrutura do Projeto

### Entidades

- **Cliente**: Representa um cliente com informações básicas como nome e e-mail.
- **Endereco**: Representa um endereço com detalhes como rua, bairro, cidade e estado.

### Endpoints

1. **Listar Cliente Pelo Id**
   - **Endpoint**: `/clientes/id`
   - **Método**: `GET`
   - **Descrição**: Lista um cliente pelo id.

2. **Cadastrar Cliente**
   - **Endpoint**: `/clientes`
   - **Método**: `POST`
   - **Descrição**: Cadastra um novo cliente. O endereço é automaticamente preenchido com base no CEP fornecido.
   - **Corpo da Requisição**:
     ```json
     {
       "nome": "João da Silva",
       "cep": "01001000"
     }
     ```
   - **Resposta**:
     ```json
     {
       "id": 1,
       "nome": "João da Silva",
       "email": "joao.silva@example.com",
       "endereco": {
         "cep": "01001000",
         "logradouro": "Praça da Sé",
         "bairro": "Sé",
         "localidade": "São Paulo",
         "uf": "SP"
       }
     }
     ```

3. **Listar Clientes**
   - **Endpoint**: `/clientes`
   - **Método**: `GET`
   - **Descrição**: Lista todos os clientes cadastrados.

   2. **Deletar Cliente**
    - **Endpoint**: `/clientes/id`
     - **Método**: `DELETE`
      - **Descrição**: Deleta um cliente pelo id.



## Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **Swagger**: Interface para documentação e teste da API. A documentação Swagger está disponível em `http://localhost:8080/swagger-ui.html`.
- **OpenFeign**: Cliente HTTP declarativo para consumir a API do ViaCEP de forma simplificada.


## Como Executar

1. **Clone o Repositório**
   ```bash
   git clone https://github.com/EricCarv4lhoProjeto-Consumo-Api-Cep.git
