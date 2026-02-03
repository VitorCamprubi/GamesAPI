# GamesAPI 🎮

API REST simples para cadastro e gerenciamento de **Jogos** e **Categorias**.  
Inclui CRUD completo e endpoint para listar jogos por categoria.

## ✅ Funcionalidades
- CRUD de **Categorias**
- CRUD de **Jogos**
- Relacionamento **Jogo -> Categoria** (`@ManyToOne`)
- Listar jogos por **id da categoria**

## 🛠 Tecnologias
- Java
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate)
- Maven
- Banco de dados: configurável via `application.properties` (ex: MySQL)

## ▶️ Como rodar o projeto
1. Clone o repositório:
  ```bash
   git clone https://github.com/SEU_USUARIO/GamesAPI.git
   ```

2. Entre na pasta do projeto e rode:

   ```bash
   mvn spring-boot:run
   ```

   *(ou execute a classe `GamesApiApplication` pela IDE)*

3. Configure seu banco em `src/main/resources/application.properties` (se necessário).

## 📌 Endpoints

### Categorias

* `GET /categoria` → lista todas
* `GET /categoria/{id}` → busca por id
* `POST /categoria` → cria
* `PUT /categoria/{id}` → atualiza
* `DELETE /categoria/{id}` → remove

Exemplo de body (POST/PUT):

```json
{
  "nome": "RPG"
}
```

### Jogos

* `GET /game` → lista todos
* `GET /game/{id}` → busca por id
* `GET /game/categoria/{id}` → lista jogos por categoria
* `POST /game` → cria
* `PUT /game/{id}` → atualiza
* `DELETE /game/{id}` → remove

Exemplo de body (POST/PUT):

```json
{
  "nome": "Elden Ring",
  "descricao": "RPG de ação em mundo aberto",
  "ranking": 10,
  "categoria": {
    "id": 1
  }
}
```

## 🧪 Testando

Você pode testar com **Postman** ou **Insomnia** usando os endpoints acima.

