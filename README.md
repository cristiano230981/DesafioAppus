# DesafioAppus

Sistema de Score de Vendas

A empresa XPTO contratatou você para fazer a nova versão do sistema de vendas dele.

Para os crud’s é necessário a criação de UI (os aspectos de UI/UX não serão considerados)

## Requisitos funcionais

Nesse sistema, é possível:
- Cadastrar, alterar, deletar e buscar vendedores
- Um vendedor é composto por um nome e matrícula
- Apenas a busca por matrícula é necessária
- Cadastrar, alterar, deletar produto
- Um produto é composto por nome e preço
- Não é necessária busca por produto
- Cadastrar de venda
- Uma venda é definida por um vendedor, 1 ou mais itens e o valor total
- Lista dos vendedores por maior número de vendas (API)
- Lista dos vendedores por valor ($$) vendido (API)
- Lista de itens mais vendidos (API)

## Requisitos não funcionais
- O sistema é feito em java
- Deve conter scripts para criação do banco caso a aplicação não crie as tabelas
automaticamente. Assim como as instruções docker para subir um container com o(s)
banco(s) escolhido(s).

## Entregáveis
O que o cliente precisa de receber:
- O código fonte com instruções de como executar o sistema através de um repositório no
github, incluindo exemplos de chamadas para a API.

## Implementação Opcional
Para as implementações opcionais não é necessário codificar nada, apenas contar como faria
através de diagramas, texto, ou qualquer outro artifício para representar a ideia de resolução do
problema.

## A lista a seguir é opcional:
- Um dockerfile para criar uma imagem docker e executar a aplicação
- Pensando que os endpoints de estatística serão muito acessados, desenhe um
diagrama com uma arquitetura que suporte uma carga alta de acessos nesses
endpoints
- Autenticação e Autorização tanto para o frontend quanto para as API’s.
- Qualquer outro entregável que você julgue que adicione valor ao sistema.
Observações
O challenge será avaliado em diversos quesitos:
● Forma da entrega
● Corretude do código
● Itens entregues
● Qualidade de código
● Testes
● etc


## Clonar o repositório
```bash
git clone https://github.com/cristiano230981/DesafioAppus.git
```

## Build da api
```bash
mvn clean
mvn install
```

## Build da imagem com a aplicação
```bash
docker build -t desafioappus:0.1 .
```

## Subir o docker
```bash
docker-compose up
```

## Swagger Documentação
```bash
http://localhost:8081/swagger-ui.html
```