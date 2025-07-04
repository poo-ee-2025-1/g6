# Relatório Individual de Atividades - Arthur do Nascimento Albuquerque
**Matrícula**: 202403107

Este relatório apresenta as atividades desenvolvidas por mim ao longo da realização do projeto de sistema de gerenciamento de energia solar, com ênfase na parte de **Banco de Dados**. O documento está dividido nos seguintes eixos: ferramentas utilizadas, linguagem de programação, modelagem e documentação.

## 1. Ambiente de Desenvolvimento e Ferramentas Utilizadas

Durante o projeto, foram empregadas diversas ferramentas que facilitaram tanto a escrita do código quanto a organização do trabalho em equipe.

**Controle de Versão (Git e GitHub):**  
O uso do Git foi constante desde o início do projeto. Cada modificação no código era acompanhada de um commit descritivo, e o repositório no GitHub foi mantido bem estruturado, com a utilização de `.gitignore` para evitar arquivos desnecessários. Os scripts de banco de dados, assim como os arquivos de documentação, foram devidamente organizados em diretórios apropriados.

**Editores e IDEs (VS Code e BlueJ):**  
A maior parte da construção dos scripts SQL e da escrita de documentação foi realizada no Visual Studio Code, com o auxílio de extensões para visualização em tempo real de arquivos Markdown e suporte à sintaxe SQL. Em alguns momentos, o BlueJ foi utilizado para testes de integração entre Java e banco de dados.

## 2. Uso da Linguagem Java

Mesmo sendo responsável pelo banco de dados, foi essencial lidar com trechos do código Java para realizar a integração entre a aplicação e a base de dados.

**Criação e Estruturação de Classes DAO:**  
Implementei as classes responsáveis pela comunicação com o banco de dados utilizando JDBC. Essas classes seguem o padrão DAO (Data Access Object) e incluem métodos como `adicionarCliente()`, `buscarClientePorID()` e `listarFuncionarios()`. Foi aplicada a prática de utilizar `PreparedStatement` para evitar vulnerabilidades, como injeção de SQL.

**Tratamento de Conexões e Exceções:**  
Os métodos de acesso ao banco foram estruturados com blocos `try-catch` e fechamento adequado de conexões no `finally`, assegurando que os recursos fossem liberados corretamente após cada operação.

**Integração com a Interface JavaFX:**  
As classes DAO foram integradas aos controllers da aplicação. A troca de dados entre a interface e o banco foi feita com cuidado, respeitando a estrutura das entidades Java e os campos existentes nas tabelas.

## 3. Modelagem de Dados

A criação da estrutura do banco de dados teve como base uma modelagem prévia, com atenção às necessidades do sistema.

**Projeto do Modelo Relacional:**  
Com base nos requisitos e nos casos de uso levantados pela equipe, elaborei o modelo relacional do banco. As tabelas foram normalizadas e construídas com integridade referencial, usando chaves primárias e estrangeiras para garantir relacionamentos corretos entre entidades como `Clientes`, `Funcionários`, `Orçamentos` e `Manutenções`.

**Compreensão da Estrutura Orientada a Objetos:**  
Para garantir a compatibilidade entre a estrutura do banco e o código Java, foi necessário analisar os relacionamentos definidos no diagrama de classes do sistema. Isso permitiu criar tabelas com colunas coerentes com os atributos das classes e implementar métodos de conversão apropriados.

**Fluxo de Execução (Sequência de Ações):**  
A depuração do sistema e a análise do caminho percorrido pelos dados — desde a ação do usuário até a execução da consulta SQL — exigiu uma leitura e compreensão dos fluxos que, na prática, se assemelham a um diagrama de sequência.

**Casos de Uso Aplicados:**  
A modelagem foi guiada por casos práticos como “cadastro de clientes”, “emissão de orçamentos” e “gerenciamento de usuários”. As tabelas e consultas SQL foram planejadas para atender esses fluxos de forma eficiente.

## 4. Organização e Documentação do Projeto

A documentação foi tratada como parte essencial do desenvolvimento, e não como uma etapa separada.

**Documentação com Markdown:**  
Todos os scripts, diagramas e instruções relacionadas ao banco de dados foram organizados em arquivos Markdown, mantidos no repositório do projeto. Além disso, foi criado um dicionário de dados para detalhar a estrutura de cada tabela, seus campos, tipos e relacionamentos.

**Estrutura do Repositório:**  
O diretório do projeto foi mantido claro e segmentado. A pasta dedicada ao banco de dados continha os scripts de criação e população (`create.sql`, `insert.sql`), bem como o script de remoção (`drop.sql`) para facilitar testes repetidos durante o desenvolvimento.

**Gestão de Tarefas (Informal):**  
Apesar de não termos utilizado formalmente ferramentas como GitHub Projects ou Issues, o fluxo de trabalho seguiu a mesma lógica. A cada problema detectado, documentávamos a situação com prints ou logs, discutíamos a solução em grupo e atualizávamos os arquivos relevantes assim que o problema fosse resolvido.

## Considerações Finais

Minha contribuição no projeto esteve centrada na modelagem e implementação do banco de dados, uma etapa essencial para garantir a persistência e a consistência das informações do sistema. O trabalho possibilitou aplicar conhecimentos de modelagem, programação em Java com JDBC, e uso de ferramentas de controle de versão e documentação em ambiente colaborativo.
