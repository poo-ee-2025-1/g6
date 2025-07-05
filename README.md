# Relatório Geral do Projeto: Sistema de Gerenciamento de Energia Solar

### **Seção 1 - Introdução: Justificativa, Descrição e Motivação**

O projeto consiste no desenvolvimento de um **Sistema de Gerenciamento de Energia Solar**, uma aplicação de desktop robusta criada para administrar todo o ciclo de vida da instalação de painéis solares. A principal justificativa para o sistema é a necessidade de centralizar e organizar as interações entre os diferentes envolvidos no processo: **Clientes, Funcionários e Gerentes**.

O problema abordado é a ausência de uma ferramenta integrada que gerencie desde a solicitação de orçamentos e o cadastro de clientes até a atribuição de funcionários, o acompanhamento das instalações e as solicitações de manutenção. Sem um sistema como este, os processos podem ser descentralizados, propensos a erros e ineficientes.

A motivação por trás do projeto foi multifacetada. Para a equipe, representou uma oportunidade crucial de aplicar na prática os conceitos de **Programação Orientada a Objetos (POO)** em um contexto de sistema complexo e escalável. Houve uma transição de conhecimento, saindo de scripts sequenciais para a construção de uma arquitetura de software estruturada, com separação de responsabilidades (Model-View-Controller). A meta era entregar uma aplicação com uma **interface gráfica funcional, intuitiva e responsiva**, que atendesse às necessidades específicas de cada perfil de usuário, consolidando o aprendizado técnico em uma solução de software completa.

### **Seção 2 - Plano: Objetivo Geral e Específicos**

**Objetivo Geral:**
Desenvolver um sistema de desktop completo e funcional, utilizando Java e JavaFX, para gerenciar os processos de uma empresa de instalação de painéis solares. O sistema deve permitir o gerenciamento de clientes, funcionários, orçamentos, instalações e manutenções, garantindo a integridade e a consistência dos dados através de uma arquitetura bem definida.

**Objetivos Específicos:**
Com base nos relatórios e nos artefatos do projeto, os seguintes objetivos específicos foram traçados e alcançados:
* **Implementar uma Arquitetura em Camadas (MVC):** Separar claramente o modelo de dados (Model), a interface com o usuário (View) e a lógica de controle (Controller) para garantir a organização e a manutenabilidade do código.
* **Desenvolver uma Interface Gráfica Multi-usuário:** Criar telas específicas e funcionais para três perfis de usuário (Cliente, Funcionário, Gerente), utilizando JavaFX e a ferramenta Scene Builder para produzir layouts modernos e responsivos.
* **Definir um Modelo de Dados Coerente:** Estruturar as classes principais do sistema (`Cliente`, `Funcionario`, `Orcamento`, `Instalacao`, etc.), definindo seus atributos, métodos e relacionamentos.
* **Garantir a Consistência do Estado da Aplicação:** Resolver o problema de inconsistência de dados entre diferentes telas através da aplicação do padrão de projeto **Singleton** nas classes de Acesso a Dados (DAOs), garantindo uma única fonte de verdade para toda a aplicação.
* **Modelar e Implementar a Persistência de Dados:** Projetar um banco de dados relacional para armazenar as informações do sistema, definindo tabelas, colunas, tipos de dados e restrições. Em paralelo, implementar as classes DAO com JDBC para conectar a aplicação Java ao banco de dados PostgreSQL.
* **Utilizar Boas Práticas de Desenvolvimento:** Adotar o uso de controle de versão com Git e GitHub para colaboração em equipe e versionamento do código-fonte, incluindo práticas como o uso de `.gitignore` para manter o repositório limpo.

### **Seção 3 - Divisão de Tarefas e Responsabilidades**

A equipe foi organizada com base em especialidades, permitindo que cada membro se aprofundasse em uma camada do sistema, com um líder garantindo a integração e a depuração do todo.

**Mateus Gasparini Arraes (Líder, Gerente de Projeto e Depurador)**
Conforme a solicitação, Mateus Gasparini Arraes, embora sem um relatório individual, teve um papel central e transversal. Ele foi o responsável por **gerenciar a equipe e fazer a depuração do código**. Sua atuação foi fundamental para a coesão do projeto, pois **auxiliou todas as partes**, desde o back-end e a lógica dos controladores até o front-end e a integração com o banco de dados. Foi descrito como possuidor de um "exímio domínio sobre o código", indicando que sua função era garantir que todas as peças desenvolvidas individualmente se conectassem e funcionassem corretamente, resolvendo bugs e facilitando a colaboração entre os membros.

**Lucas Virgulino Pires (Desenvolvimento Front-end)**
* **Responsabilidade Principal:** Desenvolvimento completo do front-end.
* **Atividades Executadas:**
    * Transformou os modelos de dados em uma interface gráfica funcional para os três tipos de usuários (Cliente, Funcionário, Gerente).
    * Utilizou **JavaFX**, **FXML** e **Scene Builder** para construir as telas, evoluindo de uma abordagem inicial via código para um design visual mais robusto e desacoplado.
    * Implementou o padrão **MVC** para estruturar a interface, conectando as Views (FXML) aos Controllers (Java).
    * Resolvel o desafio de gerenciamento de estado entre telas ao refatorar as classes DAO para o padrão **Singleton**.
    * Centralizou a lógica de navegação criando a classe utilitária `Navigation.java` para evitar a repetição de código.
    * Superou desafios técnicos como `LoadException` no JavaFX e erros de conexão com o banco de dados, como `No suitable driver found`.

**Arthur do Nascimento Albuquerque (Banco de Dados)**
* **Responsabilidade Principal:** Modelagem e implementação do banco de dados.
* **Atividades Executadas:**
    * Elaborou o modelo relacional do banco de dados, criando tabelas normalizadas com chaves primárias e estrangeiras.
    * Implementou as classes no padrão **DAO (Data Access Object)** usando **JDBC** para comunicação com a base.
    * Utilizou `PreparedStatement` para prevenir vulnerabilidades de injeção de SQL.
    * Garantiu o tratamento adequado de conexões e exceções com blocos `try-catch-finally`.
    * Criou um **dicionário de dados** para documentar a estrutura das tabelas e organizou os scripts SQL (`create.sql`, `insert.sql`, `drop.sql`) no repositório.

**Vinicius Silva Machado (Modelagem e Back-end)**
* **Responsabilidade Principal:** Desenvolvimento da camada **Model** do projeto.
* **Atividades Executadas:**
    * Criou as classes de entidade do sistema, como `Cliente`, `Funcionario`, `Gerente`, `Orcamento`, `Instalacao` e `Manutencao`.
    * Definiu os atributos, construtores e métodos (getters/setters) para garantir o encapsulamento correto.
    * Além de sua tarefa principal, colaborou diretamente com Mateus e Arthur na **lógica dos controladores de backend** (sem interface gráfica).
    * Auxiliou o grupo na compreensão de conceitos de POO, como herança e encapsulamento.

**João Augusto Alves Pereira (Refatoração e Integração)**
* **Responsabilidade Principal:** Refatoração de interfaces, correção de bugs e integração.
* **Atividades Executadas:**
    * Refatorou as interfaces FXML com o **Scene Builder**, transformando layouts básicos em designs mais complexos e modernos.
    * Corrigiu a lógica dos controllers, padronizando os métodos de `handle` para usar `MouseEvent` em vez de `ActionEvent`, alinhando o código Java com os eventos gerados pelo FXML.
    * Diagnosticou e corrigiu um `IllegalAccessError` ao aplicar corretamente o padrão **Singleton**, substituindo `new ClienteDAO()` por `ClienteDAO.getInstance()`.
    * Depurou e resolveu um `NullPointerException` no fluxo de navegação, causado por um nome de arquivo FXML incorreto.
    * Demonstrou um domínio prático dos princípios de gerenciamento de projetos ao seguir um fluxo de trabalho informal de **abertura, documentação e resolução de "issues"** com a equipe.

### **Seção 4 - Modelagem Completa**

A modelagem do sistema foi um pilar central do projeto, abrangendo o diagrama de classes para a estrutura orientada a objetos, o dicionário de dados para a persistência e a compreensão implícita dos fluxos de execução (diagramas de sequência) e casos de uso.

#### **Diagrama de Classes**

O diagrama de classes define a estrutura estática do software, mostrando as entidades, seus atributos, métodos e relacionamentos.
* **Herança:** A classe abstrata `Pessoa` serve como base para `Cliente` e `Funcionario`, compartilhando atributos comuns como `nome`, `cpf`, `email` e `telefone`. A classe `Gerente`, por sua vez, herda de `Funcionario`, especializando-se com métodos para `aprovarOrcamento` e `recusarOrcamento`.
* **Associações:**
    * Um `Cliente` pode ter múltiplas associações com `Orcamento` e `Instalacao`.
    * Um `Orcamento` está associado a um único `Cliente` e a um `Funcionario` responsável.
    * Uma `Instalacao` também se relaciona a um `Cliente` e a um `Funcionario` responsável, além de estar ligada a um `Orcamento`.
    * Um `Cliente` pode solicitar múltiplas `Manutencao`.
* **Padrão de Projeto DAO e Singleton:** Para cada entidade principal, foi criada uma classe de acesso a dados (ex: `ClienteDAO`, `OrcamentoDAO`, `InstalacaoDAO`, `FuncionarioDAO`, `ManutencaoDAO`). [cite_start]Todas implementam o padrão **Singleton**, garantindo uma única instância global através do método estático `getInstance()`[cite: 6].
* [cite_start]**Enumerações:** O sistema utiliza enumerações para representar estados fixos, como `StatusInstalacao` (`AGUARDANDO_APROVACAO`, `INSTALACAO_EM_ANDAMENTO`, etc.) e os status de um `Orcamento` ("Pendente", "Aprovado", "Recusado")[cite: 35].

#### **Dicionário de Dados (Modelo Relacional)**

O dicionário de dados detalha a implementação do modelo no banco de dados relacional, servindo como uma ponte entre a orientação a objetos e a persistência.
* **Tabela CLIENTE:** Armazena dados do cliente. [cite_start]A coluna `CPF` é a chave primária (`varchar(14)`)[cite: 1]. [cite_start]Outros campos incluem `NOME`, `E-MAIL`, `LOGIN` e `SENHA`[cite: 1].
* **Tabela FUNCIONARIO:** Guarda informações dos funcionários. [cite_start]`CPF` também é a chave primária[cite: 2]. [cite_start]Possui um `ID FUNCIONÁRIO` único e campos como `CARGO` e `SALÁRIO`[cite: 2].
* **Tabela ORÇAMENTO:** Centraliza os orçamentos. [cite_start]Possui um `ID` serial como chave primária[cite: 3]. [cite_start]Utiliza chaves estrangeiras para se relacionar com as tabelas `CLIENTE` (via `CPF CLIENTE`) e `FUNCIONARIO` (via `CPF FUNCIONARIO`), garantindo a integridade referencial[cite: 3].
* **Tabela INSTALAÇÃO:** Registra as instalações. [cite_start]Usa um `ID` serial como chave primária[cite: 4]. [cite_start]Relaciona-se com `CLIENTE`, `ORÇAMENTO` e `FUNCIONARIO` através de chaves estrangeiras[cite: 4].
* **Tabela MANUTENÇÃO:** Gerencia os pedidos de manutenção. [cite_start]Possui um `ID` serial como chave primária e se relaciona com `CLIENTE` e `FUNCIONARIO` (responsável)[cite: 5].

#### **Diagramas de Sequência (Lógica de Execução Implícita)**

Embora não tenham sido fornecidos diagramas formais, os relatórios descrevem a compreensão e depuração de fluxos de execução que são, na prática, diagramas de sequência.
* **Fluxo de Navegação:** João Augusto descreveu a depuração do fluxo de clique no link "Cadastre-se", que seguia a sequência: `Hyperlink (View)` -> `LoginController (Controller)` -> `Navigation (Helper)` -> `FXMLLoader (Framework)`. A compreensão dessa sequência foi vital para corrigir um `NullPointerException`.
* **Fluxo de Login:** Um usuário insere credenciais na tela de login (View). O `LoginController` recebe esses dados, chama o método `buscarPorLogin` do `FuncionarioDAO` ou `ClienteDAO` (Singleton), que por sua vez executa uma consulta SQL no banco. O DAO retorna um objeto (Model), e o controller usa a classe `Navigation` para carregar o dashboard correspondente, passando o objeto do usuário logado via `initData`.

#### **Casos de Uso**

Os relatórios revelam que o desenvolvimento foi guiado por casos de uso práticos para cada perfil de usuário.
* **Usuário (Geral):**
    * Fazer login no sistema.
    * Cadastrar-se como um novo cliente.
* **Cliente:**
    * Solicitar um orçamento para instalação de painéis solares.
    * Visualizar o status de seus orçamentos e instalações.
    * Solicitar manutenção para uma instalação concluída.
* **Funcionário/Gerente:**
    * Gerenciar clientes e outros funcionários (caso de uso de Gerente).
    * Criar e enviar orçamentos para clientes.
    * Aprovar ou recusar orçamentos (caso de uso de Gerente).
    * Acompanhar e atualizar o status de instalações em andamento.

[Diagrama de Classes](https://drive.google.com/file/d/1KEP00rJFiRNyeluT70uO3k11zlQk7xmI/view?usp=sharing)
[Dicionario de dados BD](https://drive.google.com/file/d/1GJAdpJPa68oC6HEvX7_Px6oUo8rIAJil/view?usp=sharing)
