# Delivery Feedback Copilot

Uma aplicação web que utiliza Inteligência Artificial para analisar feedbacks de clientes sobre entregas, identificar sentimentos, reconhecer problemas e elogios e sugerir melhorias na experiência do consumidor.

## Sobre o projeto

O Delivery Feedback Copilot nasceu da ideia de transformar comentários de clientes em informações úteis para a tomada de decisão.

A aplicação recebe um feedback em texto, envia a informação para um backend em Java e utiliza a API da Groq para gerar uma análise em linguagem natural.

## Funcionalidades

- Recebimento de feedbacks escritos pelos usuários.
- Análise de sentimento do cliente.
- Identificação de problemas relatados.
- Identificação de elogios.
- Sugestões de melhorias.
- Exibição do resultado da análise na interface.

## Tecnologias utilizadas

**Frontend**
- React
- Vite
- JavaScript
- CSS

**Backend**
- Java
- Spring Boot
- Maven
- Spring RestClient

**Inteligência Artificial**
- API da Groq
- Modelo `openai/gpt-oss-20b`

## Arquitetura

O projeto está dividido em duas partes:

- `delivery-feedback-copilot/`: interface frontend desenvolvida em React.
- `delivery-feedback-backend/`: API backend desenvolvida em Java com Spring Boot, responsável por receber os feedbacks e se comunicar com a Groq.

Fluxo da aplicação:

1. O usuário digita um feedback na interface.
2. O frontend envia os dados para o backend.
3. O backend encaminha o feedback para a API da Groq.
4. A IA gera a análise.
5. O backend retorna o resultado ao frontend.
6. A interface apresenta a análise ao usuário.

## Como executar o projeto

### Pré-requisitos

- Java 17 ou superior.
- Node.js e npm.
- Uma chave de API da Groq.

### 1. Configurar a chave da Groq

No terminal do backend, configure a variável de ambiente:

```powershell
$env:GROQ_API_KEY="sua_chave_aqui"
```

A chave deve ser mantida em uma variável de ambiente e nunca deve ser publicada no repositório.

### 2. Executar o backend

Na pasta principal do projeto:

```powershell
cd delivery-feedback-backend
.\mvnw.cmd spring-boot:run
```

O backend será iniciado em:

`http://localhost:8080`

### 3. Executar o frontend

Em outro terminal:

```powershell
cd delivery-feedback-copilot
npm install
npm run dev
```

A aplicação ficará disponível em:

`http://localhost:5173`

## Endpoint

| Método | Rota | Descrição |
|---|---|---|
| GET | `/api/health` | Verifica o funcionamento do backend |
| POST | `/api/feedback` | Recebe e analisa um feedback |

## Status do projeto

🚧 Em desenvolvimento.

Esta é a primeira versão funcional do Delivery Feedback Copilot. Novas funcionalidades e melhorias estão sendo planejadas e implementadas.