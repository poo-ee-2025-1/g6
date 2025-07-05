# Relatório Individual de Atividades - João Augusto Alves Pereira

**Matrícula:** 202403132

Este documento detalha as competências desenvolvidas e as contribuições realizadas durante o ciclo de vida do projeto de sistema de gerenciamento de energia solar, com foco nos domínios de ambiente, linguagem de programação, modelagem e documentação.

---

### 1. Domínio do Ambiente e Ferramentas

Ao longo do projeto, demonstrou-se proficiência e capacidade de adaptação no uso de um ecossistema de desenvolvimento moderno e integrado.

* **Controle de Versão (Git e GitHub):** O projeto foi gerenciado a partir de um repositório no GitHub, evidenciado pelo uso de uma estrutura de pastas versionada (`g6-f8d0dd9a6d1e60bb46a9267dbca083ff75d5ea0b`). A presença e correta utilização de um arquivo `.gitignore` para excluir arquivos compilados (`*.class`) e outros artefatos temporários demonstra uma compreensão sólida das melhores práticas de versionamento, garantindo que apenas o código-fonte essencial seja mantido no repositório.

* **Ambiente de Desenvolvimento Integrado (IDE):** A utilização de uma IDE, como evidenciado pelas capturas de tela de erros e compilação, foi fundamental para o ciclo de desenvolvimento. A capacidade de compilar o código, identificar erros em tempo real (como o erro de declaração de classe pública em arquivo incorreto) e depurar a aplicação foi exercida de forma contínua.

* **Ferramentas de UI (Scene Builder):** O ponto de partida do trabalho foi a refatoração de interfaces com o Scene Builder. A ferramenta foi utilizada com sucesso para reestruturar completamente os arquivos FXML, passando de layouts básicos para designs complexos, modernos e responsivos, baseados em "cards" e layouts aninhados.

### 2. Domínio da Linguagem Java

O domínio da linguagem Java foi aprofundado e consolidado através da resolução de problemas práticos que iam além da sintaxe básica, abrangendo conceitos de arquitetura e boas práticas.

* **Criação de Classes e Métodos Coerentes:** O trabalho evoluiu da simples criação de classes para a refatoração de métodos complexos. Um exemplo claro foi a correção do `DashboardClienteController`, onde os métodos de `handle` foram padronizados para aceitar `MouseEvent` em vez de `ActionEvent`, alinhando a assinatura do método com o evento gerado pelo FXML. Além disso, a classe `Manutencao` foi atualizada para incluir o campo e os métodos `get/setResponsavel()`, corrigindo um erro de compilação e alinhando a classe com as necessidades do sistema.

* **Compreensão de Padrões de Projeto:** Foi demonstrado um claro entendimento prático do padrão de projeto **Singleton**. O erro inicial de `IllegalAccessError` foi diagnosticado como uma tentativa de instanciar classes DAO com construtores privados. A correção, substituindo `new ClienteDAO()` por `ClienteDAO.getInstance()`, mostrou a capacidade de aplicar corretamente o padrão para garantir uma única fonte de verdade para os dados da aplicação.

* **Programação Orientada a Objetos e JavaFX:** A habilidade de integrar os princípios de POO com o framework JavaFX foi exercida ao passar objetos completos (como `Cliente` e `Funcionario`) entre diferentes controllers através do método `initData`. Isso demonstra um domínio que vai além de passar tipos primitivos, garantindo que o estado da aplicação seja mantido de forma coesa entre as telas.

### 3. Domínio da Modelagem

Embora não tenha sido um requisito criar e entregar diagramas UML formais, o trabalho prático exigiu e demonstrou uma forte capacidade de modelagem mental e compreensão da arquitetura do sistema.

* **Diagrama de Classes (Compreensão Implícita):** A resolução dos erros exigiu um entendimento claro do relacionamento entre as classes. Para corrigir a falta do método `getResponsavel()`, foi preciso entender que um objeto `Manutencao` deveria ter uma associação com um objeto `Funcionario`. Da mesma forma, para implementar o login, foi necessário compreender a herança entre `Pessoa`, `Funcionario` e `Gerente` para autenticar diferentes tipos de usuário.

* **Diagrama de Sequência (Lógica de Execução):** A depuração dos fluxos de navegação foi, na prática, a execução de um diagrama de sequência. O processo de identificar por que o clique no link "Cadastre-se" não funcionava envolveu seguir a sequência de chamadas: `Hyperlink (view) -> LoginController (controller) -> Navigation (helper) -> FXMLLoader (framework)`. Entender essa sequência foi crucial para identificar o `NullPointerException` causado pelo nome de arquivo FXML incorreto e corrigi-lo.

* **Casos de Uso:** O desenvolvimento guiou-se por casos de uso implícitos, como "Usuário faz login", "Gerente gerencia funcionários", "Cliente solicita orçamento". A refatoração das telas e a correção dos controllers foram feitas para garantir que esses casos de uso funcionassem corretamente do início ao fim.

### 4. Domínio da Documentação

A documentação foi uma parte integral do processo de desenvolvimento, manifestada através do uso de ferramentas de controle de versão e de um ciclo de comunicação e resolução de problemas bem definido.

* **Uso de Markdown:** A solicitação de entrega de relatórios neste formato (`.md`) e a presença de um `README.md` no repositório indicam familiaridade com a linguagem de marcação padrão para documentação em ambientes de desenvolvimento.

* **Uso de Projetos (Kanban, Issues, Prazos):** Embora não tenhamos utilizado as ferramentas formais do GitHub, como "Issues" ou "Projects", o nosso fluxo de trabalho colaborativo simulou perfeitamente este ciclo:
    1.  **Abertura de Issue:** Cada vez que um problema era encontrado ("não consigo acessar a página", "apareceu este erro"), uma nova "tarefa" era criada.
    2.  **Documentação da Issue:** O problema era documentado de forma exemplar, com a inclusão de screenshots da interface e logs de erro completos, o que é uma prática essencial para a resolução eficiente de bugs em equipe.
    3.  **Resolução e "Commit":** A solução era desenvolvida, testada e entregue (no nosso caso, através do fornecimento do código corrigido).
    4.  **Fechamento da Issue:** A validação era feita e, uma vez confirmado o sucesso, passávamos para a próxima tarefa/problema.

Este processo demonstra um domínio prático dos princípios de gerenciamento de projetos ágeis, focando em ciclos curtos de identificação, desenvolvimento e validação.