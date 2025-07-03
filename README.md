# Sistema de Gestão de Vendas e Acompanhamento de Usinas Fotovoltaicas  
### Grupo 6 – Aplicativo Web Integrado

---

## 👥 Equipe de Desenvolvimento

| Área de Atuação         | Integrantes                                                                 |
|-------------------------|------------------------------------------------------------------------------|
| *Back-End*            | Mateus Gasparini Arraes (202403147)  <br> Arthur do Nascimento Albuquerque (202403107) <br> Vinicius Silva Machado (202405456) |
| *Front-End*           | João Augusto Alves Pereira (202403132) <br> Lucas Virgulino Pires (202403140) |
| *Modelagem e Documentação* | Vinicius Silva Machado (202405456)                                   |

---

## 1. Introdução

### 1.1 Contextualização do Problema

O setor de energia solar fotovoltaica, embora em plena expansão, enfrenta dificuldades operacionais relacionadas à gestão do relacionamento com o cliente. A utilização de canais não integrados como e-mail e aplicativos de mensagens resulta em:

- Perda de histórico de comunicação;
- Dificuldade no monitoramento de múltiplos projetos;
- Atrasos na elaboração e envio de orçamentos e propostas.

Esses fatores comprometem tanto a experiência do cliente quanto a eficiência da equipe técnica e comercial.

### 1.2 Objetivo da Solução

Desenvolver uma plataforma digital centralizada para profissionalizar o atendimento, reduzir retrabalho e proporcionar uma experiência fluida e transparente aos usuários.

- *Para o cliente:* acesso unificado a informações, acompanhamento de etapas do projeto e canal direto para suporte.
- *Para a empresa:* gestão estruturada de leads, automação de orçamentos e organização dos processos técnicos e administrativos.

### 1.3 Público-Alvo

- *Clientes finais:* interessados em adquirir sistemas fotovoltaicos.
- *Equipe comercial:* responsável por orçamentos e propostas.
- *Equipe técnica:* responsável por visitas, projetos e instalações.

---

## 2. Plano Estratégico

### 2.1 Objetivo Geral

Desenvolver uma aplicação web robusta para gerenciar o ciclo completo de implantação de um sistema fotovoltaico — desde o cadastro do cliente até o suporte pós-instalação.

### 2.2 Objetivos Específicos

#### Módulo 1: Gestão de Usuários
- Cadastro e autenticação com perfis diferenciados (cliente e funcionário).
- CRUD completo para usuários.

#### Módulo 2: Vendas
- Solicitação de orçamentos por clientes.
- Geração de propostas comerciais.
- Aprovação digital por parte do cliente.

#### Módulo 3: Gerenciamento de Projetos
- Conversão de propostas em projetos ativos.
- Definição e atualização das etapas de execução.
- Visualização do progresso por meio de um dashboard.

#### Módulo 4: Suporte e Manutenção
- Agendamento de visitas técnicas.
- Registro de equipamentos e documentos fiscais vinculados ao projeto.

---

## 3. Organização das Tarefas

| Tarefa                          | Responsável                | Observações                                                         |
|--------------------------------|----------------------------|----------------------------------------------------------------------|
| Modelagem do sistema           | Vinicius Silva Machado     | Estrutura de dados e diagrama de classes.                           |
| CRUD de usuários               | Mateus Gasparini Arraes    | Implementação central da lógica de autenticação e persistência.     |
| Interface do usuário (telas)   | João Augusto Alves Pereira | Estrutura e estilização das páginas do sistema.                     |
| Integração front-end           | Lucas Virgulino Pires      | Lógica e controladores de navegação entre as telas.                 |
| Banco de dados (em desenvolvimento) | Arthur Albuquerque         | Estruturação inicial da persistência de dados.                      |

---

## 4. Modelagem do Sistema

### 4.1 Diagrama de Classes

O sistema foi modelado com base em princípios de orientação a objetos, utilizando herança, composição e encapsulamento.

*Destaques:*
- Abstração da entidade Pessoa, com especializações para Cliente e Funcionário.
- Fluxo completo: Orçamento → Proposta → Projeto.
- Centralização de etapas, equipamentos, notas fiscais e suporte em torno da entidade Projeto.
- Padrão Singleton nos DAOs para consistência na manipulação de dados.

📎 *Diagrama de Classes disponível em:* [diagrama_classes.pdf](.[/diagrama_classes.pdf](https://github.com/poo-ee-2025-1/g6/blob/main/dLVDRXen4BuZyGuMFNIJbgYveYZg2cY457u4IQzes3NKbTUErbukRL-cZz5hNgpsUd_6PadQv1AO-JmpttZysNnM6d9TPBpVw_VUlxD_PCn1AQf8AibSffIJQ2eqIo6bweAKa7uFTahda6YIM31PKQKaa1_z7Y538cH6HsIZSoOEpf8yxNq3pO1ntwGfftifl9KVo87gXGaNNVXcLPbnAWC.pdf))

---

## 5. Banco de Dados

Foi iniciada a implementação de um sistema de persistência de dados para manter as informações registradas mesmo após o encerramento do aplicativo. Apesar dos esforços, a integração completa não foi concluída dentro do prazo, e o módulo ainda apresenta erros. A última tentativa encontra-se disponível no repositório.

---

## 6. Status Atual do Projeto

| Funcionalidade                          | Status        |
|----------------------------------------|---------------|
| Modelagem do sistema                   | ✅ Concluído  |
| Cadastro e autenticação de usuários    | ✅ Concluído  |
| Interface e navegação básica           | ✅ Concluído  |
| Integração com banco de dados          | ⚠ Em andamento |

---

## 7. Estrutura do Repositório
