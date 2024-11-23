# Como executar o docker compose

## Pré-requisitos
- Docker
- Docker Compose

## Arquivos

### 1. **`compose.yml`**
- Desenvolvimento local
- API personalizada (`javags:1.0`)

### 2. **`compose-image-docker.yml`**
- Produção
- API pré-construída (`viniciosromano/gs2-sem2:latest`)

## Como Rodar

### Usando `compose.yml`

1. **Iniciar contêineres**:

   ```bash
   docker-compose -f compose.yml up --build
   ```
   
**Em caso de erro tente novamente o mesmo comando, caso o erro persista faça:**:

1. **Build da imagem**:

   ```bash
   docker-compose -f compose.yml build
   ```
   
2. **Iniciar contêiner do banco**:

   ```bash
   docker-compose -f compose.yml up database
   ```
   
3. **Iniciar contêiner da api**:

   ```bash
   docker-compose -f compose.yml up api
   ```

### Usando `compose-image-docker.yml`

1. **Iniciar contêineres**:

   ```bash
   docker compose -f compose-image-docker.yml up
   ```
   
**Em caso de erro tente novamente o mesmo comando, caso o erro persista faça:**:

1. **Iniciar contêiner do banco**:

   ```bash
   docker-compose -f compose-image-docker.yml up database
   ```

2**Iniciar contêiner da api**:

   ```bash
   docker-compose -f compose-image-docker.yml up api
   ```
