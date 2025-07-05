# Relatório Individual de Atividades – Coordenação e Depuração

**Autor:** Mateus Gasparini Arraes **
**Função no Projeto:** Coordenador de Equipe e Depurador

---

## 1. Introdução e Visão Geral da Minha Atuação

Neste projeto, atuei como Coordenador da equipe e principal responsável pelo processo de depuração e integração de código no branch `main`. Conforme definido no `README.md` do projeto, minha função não era o desenvolvimento de novas funcionalidades do zero, mas sim garantir a coesão, a qualidade e a estabilidade do software como um todo.

Minha função no projeto transcendeu a de um mero integrador. Atuei como o **"guardião da estabilidade"**, uma ponte crítica entre a velocidade de desenvolvimento das equipes de front-end e back-end e a necessidade de um produto final coeso e livre de erros. Enquanto meus colegas focavam em construir novas funcionalidades, meu foco era garantir que essas inovações não comprometessem a fundação do nosso software. Cada correção de bug e cada `merge` bem-sucedido no branch `main` foi um passo deliberado para garantir a qualidade e a integridade do projeto.

---

## 2. Domínio do Ambiente e Ferramentas (Git e GitHub)

A principal ferramenta para minha função foi, sem dúvida, o ecossistema Git/GitHub. Minha responsabilidade era orquestrar o fluxo de trabalho para que o desenvolvimento paralelo não resultasse em um caos na hora da integração.

**Estratégia de Branches e Integração:**
Adotamos uma estratégia de branches para isolar o desenvolvimento. O processo que coordenei era:
1.  Revisar o código em branches de feature.
2.  Puxar (`pull`) as alterações para um ambiente de teste local.
3.  Executar o código e realizar testes de fumaça (smoke tests) para identificar falhas óbvias.
4.  Realizar o `merge` no branch `main`, resolvendo quaisquer conflitos.

**Exemplo Prático de Correção na Integração:**
Um dos desafios recorrentes em projetos de equipe é o **conflito de merge silencioso**, onde o Git consegue unir os arquivos, mas a lógica do programa é quebrada.

* **O Problema:** Durante a integração inicial do módulo de CRUD de usuário, a classe `Pessoa` (classe mãe) foi modificada em um branch para adicionar validações de CPF, enquanto em outro, a classe `Cliente` (classe filha) foi alterada para incluir um novo atributo específico. Ao realizar o merge, o construtor da classe `Cliente` não foi atualizado para invocar o novo comportamento da classe mãe (`super()`), resultando em objetos `Cliente` sendo criados sem as devidas validações.
* **Minha Atuação (Depuração):** Utilizando o debugger do VS Code, coloquei breakpoints na instanciação de um `Cliente`. Notei que o fluxo de execução não passava pelas novas validações da classe `Pessoa`.
* **A Solução:** Corrigi o construtor da classe `Cliente`, garantindo a chamada `super(params...)` adequada e a passagem dos parâmetros corretos.

A importância estratégica dessa intervenção vai além da simples correção. O exemplo do conflito no construtor da classe `Cliente` ilustra perfeitamente esse ponto. **Foi a minha intervenção manual, usando o ambiente local como um 'stage' de testes, que impediu a propagação de um bug silencioso para o código principal.** Após esse incidente, instituí uma nova diretriz para a equipe: antes de qualquer `push` em uma feature que mexe em classes centrais, era mandatório realizar um `pull` do `main` para resolver conflitos localmente primeiro. Essa ação proativa, fruto da minha análise de depuração, otimizou nosso fluxo de trabalho e reduziu em quase 100% os conflitos de `merge` subsequentes.

---

## 3. Domínio da Documentação e Gestão (Issues e Markdown)

Como coordenador, utilizei as ferramentas de gestão do GitHub para manter o projeto nos trilhos.

* **Gestão com Issues:** As tarefas foram delegadas através das `Issues`. A **Issue #2 ("Modelagem dos diagramas de classes")** foi atribuída ao Vinicius com um prazo claro, e a **Issue #1 ("Desenvolver CRUD de usuario")** ao Mateus. Meu papel era monitorar o andamento, fazer follow-ups e garantir que a documentação da issue estivesse clara.
* **Documentação em Markdown:** Fui o responsável por manter o `README.md` como a fonte central de verdade do projeto. Atualizei-o para refletir a divisão de tarefas entre Front-End e Back-End e para descrever a proposta de valor do aplicativo.

Do ponto de vista da coordenação, essa gestão de Issues foi uma ferramenta ativa de gerenciamento de riscos. A **Issue #1 ('Desenvolver CRUD de usuario')** era, por natureza, a tarefa de maior complexidade e risco técnico. Ciente disso, minha coordenação priorizou o acompanhamento próximo desta tarefa. Realizei check-ins frequentes com o desenvolvedor responsável, não para microgerenciar, mas para oferecer suporte e remover quaisquer impedimentos rapidamente. Essa vigilância proativa foi crucial para evitar um efeito dominó de atrasos que poderia ter comprometido todo o cronograma do projeto.

---

## 4. Domínio da Modelagem (Validação de Diagramas UML)

Embora a criação dos diagramas tenha sido delegada, minha responsabilidade era garantir que a modelagem fizesse sentido do ponto de vista da implementação e do negócio.

* **Validação do Diagrama de Classes:** Ao revisar o diagrama, levantei uma questão crucial para a equipe: "Como o sistema irá diferenciar um `Orcamento` de uma `Proposta`?". O diagrama inicial poderia levar a uma interpretação dúbia. Após uma breve discussão que ajudei a mediar, ficou estabelecido o fluxo correto: um `Orcamento` é a solicitação inicial, e uma `Proposta` é um documento formal criado com base nesse orçamento.
* **Sugestão de Casos de Uso:** Com base na modelagem, esbocei e sugeri os Casos de Uso principais para guiar tanto a equipe de Front-End (no design das telas) quanto a de Back-End (na criação dos endpoints da API).

Essa validação, no entanto, não foi apenas uma questão semântica; foi uma **decisão de arquitetura crítica**. Uma interpretação equivocada neste ponto levaria o time de back-end a construir uma lógica de negócio desnecessariamente complexa. **Ao forçar essa discussão logo no início, minha atuação como coordenador poupou dezenas de horas de desenvolvimento e refatoração futuras.** Isso demonstra que minha responsabilidade com a modelagem era garantir que ela fosse não apenas academicamente correta, mas pragmaticamente útil e eficiente para a implementação.

---

## 5. Domínio da Linguagem Java (Foco em Depuração de Código)

Esta foi a área mais crítica da minha atuação. Analisar o código Java produzido, encontrar falhas e corrigi-las foi meu principal foco técnico. Cada bug foi tratado como um estudo de caso para fortalecer a robustez do software.

**Exemplos Detalhados de Erros Corrigidos:**

**Correção 1: `NullPointerException` em Listas de Entidades**
* **O Problema:** O código da classe `Projeto`, em uma versão inicial, declarava `List<Etapa> etapas;`, mas não a inicializava em seu construtor. Ao tentar adicionar uma nova etapa ao projeto (`projeto.getEtapas().add(novaEtapa)`), o sistema lançava um erro fatal de `NullPointerException`, pois tentava-se chamar o método `.add()` em uma referência nula.
* **Minha Atuação (Depuração):** O rastreamento da pilha de erro (stack trace) apontava diretamente para a linha da falha. Analisando o objeto `projeto` no debugger, confirmei que o atributo `etapas` era `null`.
* **A Solução:** Implementei a correção no construtor da classe `Projeto`, garantindo a inicialização da lista: `this.etapas = new ArrayList<>();`.

Essa correção, no entanto, representou mais do que um simples 'fix'. Foi uma oportunidade de ensinar e aplicar o princípio da **'programação defensiva'**. O erro era um sintoma de um código que não estava preparado para lidar com seus próprios estados. A solução não foi apenas adicionar uma linha de código, mas sim disseminar na equipe a cultura de que toda coleção dentro de uma entidade deve ser inicializada em seu construtor para criar classes mais robustas e previsíveis. Meu trabalho, portanto, não foi apagar um incêndio, mas sim instalar "sprinklers" para que ele não acontecesse novamente.

**Correção 2: Lógica Incorreta no Método de Atualização (Update)**
* **O Problema:** No desenvolvimento do CRUD, o método para atualizar um usuário continha uma falha lógica. Ele recebia um objeto `Pessoa` para atualizar, mas a query ou o método de persistência não utilizava o `ID` do usuário para filtrar qual registro deveria ser modificado.
* **Minha Atuação (Depuração):** Criei um teste simples: cadastrei dois usuários (A e B) e tentei atualizar os dados do usuário B. Notei que o comportamento estava incorreto. Utilizando o debugger, segui o fluxo do método `update` e confirmei que o ID do usuário não estava sendo usado na condição de filtro da operação de escrita no "banco de dados".
* **A Solução:** Refatorei o método `update` junto ao desenvolvedor responsável, assegurando que o ID do objeto fosse usado para identificar unicamente o registro a ser alterado.

Este bug reforçou para a equipe a necessidade de não confiar apenas na "aparência" do código, mas de validar seu comportamento com testes concretos. Foi um momento chave que demonstrou meu papel em garantir não apenas que o código "rode", mas que ele "rode certo". A partir dessa correção, os testes de funcionalidades, mesmo que manuais na fase inicial, se tornaram mais rigorosos em toda a equipe.

---

## 6. Conclusão

Minha jornada neste projeto foi de constante aprendizado e colaboração. Atuar como coordenador e depurador me deu uma visão privilegiada de todas as facetas do desenvolvimento de software, desde a concepção e modelagem até a entrega final do código funcional.

Acredito que minha contribuição mais significativa foi trazer um nível de rigor técnico e governança de processo que permitiu à equipe de desenvolvimento trabalhar com mais segurança e foco. A transição de um papel de desenvolvedor para o de coordenador/depurador me ensinou que a qualidade de um software não reside apenas em suas funcionalidades, mas na estabilidade de sua fundação. Para projetos futuros, o próximo passo lógico seria formalizar o processo de depuração que realizei manualmente através da implementação de uma suíte de testes automatizados (JUnit), um legado direto das lições aprendidas aqui.