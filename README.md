O fluxo principal de uma requisição segue:

```text
Cliente
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL
```

## 📌 Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/frases` | Lista todas as frases |
| GET | `/frases/{id}` | Busca uma frase pelo ID |
| GET | `/frases/buscar` | Busca uma frase pelo texto exato |
| GET | `/frases/buscar-contendo` | Busca frases contendo uma palavra ou trecho |
| GET | `/frases/paginadas` | Lista frases com paginação |
| POST | `/frases` | Cadastra uma nova frase |
| PUT | `/frases/{id}` | Atualiza uma frase pelo ID |
| DELETE | `/frases/{id}` | Remove uma frase pelo ID |

### Exemplo de requisição

```json
{
  "frase": "A persistência transforma conhecimento em resultado."
}
```

### Exemplo de resposta

```json
{
  "id": 1,
  "frase": "A persistência transforma conhecimento em resultado."
}
```

## ✅ Validação e tratamento de erros

Os dados recebidos pela API são validados antes de serem processados.

Por exemplo, uma frase deve respeitar as regras de preenchimento e tamanho definidas pela aplicação.

Em caso de dados inválidos, a API retorna `400 Bad Request` com informações sobre o campo responsável pelo erro:

```json
{
  "campo": "frase",
  "mensagem": "A frase deve ter entre 3 e 255 caracteres"
}
```

Quando uma operação é realizada com um ID inexistente, a API retorna `404 Not Found` com a mensagem:

```text
Frase não encontrada
```

## 📖 Documentação da API

A API possui documentação interativa utilizando Swagger/OpenAPI.

Com a aplicação em execução, a documentação pode ser acessada em:

```text
http://localhost:8080/swagger-ui.html
```

A especificação OpenAPI também está disponível em:

```text
http://localhost:8080/v3/api-docs
```

Pelo Swagger UI é possível visualizar e testar os endpoints diretamente pelo navegador.

## ▶️ Como executar

### Pré-requisitos

Para executar o projeto localmente é necessário ter instalado:

- Java 25
- Maven
- MySQL

### 1. Clone o repositório

```bash
git clone URL_DO_SEU_REPOSITORIO
```

### 2. Configure o banco de dados

Crie um banco MySQL para a aplicação:

```sql
CREATE DATABASE devquotes;
```

Configure a conexão com o banco no arquivo `application.properties`.

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/devquotes
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

> Não publique suas credenciais reais no repositório.

### 3. Execute a aplicação

No terminal:

```bash
mvn spring-boot:run
```

Ou execute a aplicação diretamente pela sua IDE.

A API estará disponível em:

```text
http://localhost:8080
```

## 🎯 Objetivo do projeto

O projeto foi desenvolvido com foco na aplicação prática de conceitos de desenvolvimento backend com Java e Spring Boot, incluindo criação de APIs REST, persistência de dados, arquitetura em camadas, validação, tratamento de exceções e documentação de endpoints.
