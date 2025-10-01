# 📌 EventFlow API

API que dará suporte ao aplicativo **EventFlow**, responsável pela autenticação de usuários, gerenciamento de eventos, categorias, locais e perfis.

Este documento lista os requisitos e funcionalidades necessárias para o backend do projeto.

---

## 🎯 Objetivo
O **EventFlow** é um aplicativo móvel que deve permitir:
- Autenticação de usuários.
- Listagem, cadastro e gerenciamento de eventos.
- Integração com mapa para exibição de eventos.
- Criação e edição de categorias e locais.
- Exibição do perfil do usuário logado.

A API deve fornecer todos os recursos necessários para que o aplicativo possa consumir os dados.

---

## 📝 Requisitos da API

### 🔑 Autenticação
- **Login/Logout**
    - Rota de login (`POST /auth/login`): receber `email` e `senha`.
    - Rota de logout (`POST /auth/logout`).
    - Manter sessão ativa do usuário (token JWT ou similar).
- **Usuário Logado**
    - Rota para obter informações do usuário autenticado (`GET /auth/me`).

---

### 📅 Eventos
- **Listagem de eventos**
    - `GET /events`: listar nome, data, preço, categoria e miniatura.
    - Suporte a **busca simples** por nome ou categoria.
- **Mapa de eventos**
    - `GET /events/map`: retornar eventos com coordenadas (latitude/longitude).
- **Detalhes do evento**
    - `GET /events/{id}`: retornar todas as informações completas do evento.
- **Cadastro/Edição de evento**
    - `POST /events`: criar evento.
    - `PUT /events/{id}`: editar evento.
    - Campos obrigatórios:
        - `nome`
        - `descricao`
        - `data`
        - `hora`
        - `preco`
        - `categoria_id`
        - `local_id`
        - `imagem` (upload via câmera/galeria)

---

### 🗂️ Categorias
- **Listar categorias**
    - `GET /categories`
- **Criar/Editar categoria**
    - `POST /categories`
    - `PUT /categories/{id}`

---

### 📍 Locais
- **Listar locais**
    - `GET /locations`
- **Criar/Editar local**
    - `POST /locations`
    - `PUT /locations/{id}`
- **Campos obrigatórios:**
    - `nome`
    - `latitude`
    - `longitude`
    - `endereco` (opcional)

---

### 👤 Perfil
- **Exibir dados do usuário logado**
    - `GET /profile`
- **Logout**
    - `POST /auth/logout`

---

## ⚙️ Regras de Funcionamento
- Todo **evento deve estar vinculado a um local** com `latitude` e `longitude` para ser exibido no mapa.
- O aplicativo deve se comunicar **exclusivamente via API** (login, eventos, categorias, locais, perfil).
- O design das telas do app deve ser seguido rigorosamente (responsabilidade do front-end).

---

## 📱 Observações Importantes
- O aplicativo **deve gerar a APK final** para funcionamento.
- A API pode ser desenvolvida em qualquer linguagem/tecnologia (a critério do grupo ou conforme ensinado em aula).

---

## ✅ Checklist da API
- [ ] Autenticação com login/logout e sessão ativa.
- [ ] CRUD de eventos.
- [ ] CRUD de categorias.
- [ ] CRUD de locais.
- [ ] Retorno de eventos com coordenadas para mapa.
- [ ] Upload de imagens (eventos).
- [ ] Endpoint de perfil do usuário autenticado.

---
