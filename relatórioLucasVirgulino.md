# Relatório Individual de Atividades – Lucas Virgulino Pires  
**Matrícula:** 202403140  

---

## Introdução e Responsabilidades  
No contexto do projeto do **Sistema de Gerenciamento de Energia Solar**, fiquei encarregado do desenvolvimento completo do **front-end**. Minha principal tarefa foi transformar as regras de negócio e os modelos de dados, já definidos pela equipe de back-end, em uma **interface gráfica funcional, intuitiva e responsiva** para os três tipos de usuários do sistema: **Cliente, Funcionário e Gerente**.  

Essa tarefa envolveu desde a **configuração do ambiente de desenvolvimento** até a implementação de uma **arquitetura de interface sólida**, enfrentando desafios de navegação, gerenciamento de estado e integração com a camada de dados.  

---

## Ambiente de Desenvolvimento e Tecnologias Empregadas  
A criação da interface exigiu a combinação de diversas ferramentas para assegurar produtividade e um resultado de alta qualidade.  

### IDE e Biblioteca Gráfica  
- A base do desenvolvimento foi a **IDE BlueJ**, em sintonia com as ferramentas utilizadas em sala de aula.  
- Para a construção da interface, optei pela biblioteca **JavaFX**, devido à sua modernidade e flexibilidade em comparação com outras bibliotecas mais antigas.  

### Da Programação Manual ao Design Visual  
- A abordagem inicial consistiu em criar as primeiras telas por meio de **código**.  
- No entanto, para alcançar uma maior separação de responsabilidades e acelerar o design, o projeto migrou para o uso de **FXML**.  
- Essa decisão foi fundamental, pois permitiu que a estrutura visual da interface fosse definida em arquivos **XML**, separando-a completamente da lógica de controle em **Java**.  
- Para a edição desses arquivos, a ferramenta **Scene Builder** foi essencial, possibilitando a criação de layouts complexos através de uma interface de "arrastar e soltar".  

### Controle de Versão e Colaboração  
- O acesso ao código-fonte do projeto foi feito via **GitHub**, o que me permitiu clonar o repositório e trabalhar em paralelo com a equipe de back-end, assegurando que as minhas implementações de interface estivessem sempre sincronizadas com o modelo de dados mais recente.  

---

## Arquitetura do Front-End e Soluções Adotadas  
Para assegurar que a aplicação fosse organizada e escalável, adotei padrões de arquitetura e criei soluções específicas para os desafios que surgiram.  

### Modelo MVC  
- A estrutura central de toda a interface foi o padrão **MVC**.  
- Os arquivos **FXML** representavam as **Views**, as classes de negócio (**Cliente, Orçamento**, etc.) os **Models**, e a lógica residia nas classes **Controller** (**LoginController, DashboardClienteController**, etc.).  
- A conexão **View-Controller** ocorria via anotação `@FXML` e propriedade `onAction` nos componentes, proporcionando respostas claras às ações do usuário.  

### Resolvendo a Incoerência de Dados com Singleton  
- O gerenciamento de estado representou o maior obstáculo.  
- No início, novos clientes não conseguiam logar porque cada tela criava listas de dados próprias (`new ClienteDAO()`).  
- Refatoramos as **DAOs** (**ClienteDAO, OrcamentoDAO, InstalacaoDAO, ManutencaoDAO**) para o padrão **Singleton**.  
- Garantindo uma única instância de cada DAO para a aplicação (via `DAO.getInstance()`), todas as telas compartilhavam dados, eliminando a inconsistência.  

### Centralizando a Lógica de Navegação  
- Para evitar a repetição de código nas transições de tela, criamos a classe auxiliar **Navigation.java**.  
- Este utilitário centralizou o carregamento de **FXML** e a troca de cenas, permitindo que qualquer controller navegasse para outra tela com um único método (`Navigation.navigateTo(...)`), simplificando o código.  

### Gerenciamento do Estado de Login  
- "Lembrar" qual usuário estava logado ao navegar entre telas foi um desafio.  
- Resolvemos isso passando o objeto do usuário (**Cliente ou Funcionário**) como parâmetro para o método `initData()` do controller da tela de destino.  
- Assim, cada tela personalizava-se e obtinha os dados corretos do usuário ativo.  

---

## Desafios Técnicos e Aprendizados  
O desenvolvimento foi um aprendizado contínuo, marcado pela superação de desafios técnicos específicos.  

### Depuração de Conexão com Banco de Dados  
- A migração para um back-end persistente trouxe desafios de ambiente.  
- Erros como `java.sql.SQLException: No suitable driver found` ensinaram a importância de configurar as bibliotecas, adicionando o driver **JDBC do PostgreSQL** ao classpath.  
- Depois, `java.net.ConnectException: Connection refused` mostrou a necessidade de o banco de dados estar ativo.  

### Análise de Falhas no JavaFX  
- Inúmeras vezes, me vi diante de interfaces incompletas ou com erros de `LoadException`.  
- A solução desses problemas me mostrou a importância de examinar o **rastreamento da pilha** para achar a linha problemática no FXML.  
- Descobri, assim, que a tag `<font>` variava conforme a versão do JavaFX, e a adoção de **estilos CSS inline** (`-fx-font-weight: bold;`) deixou tudo mais estável.  

---

## Conclusão  
Após essa etapa, a aplicação final possui uma **interface gráfica harmoniosa, responsiva e completa** para as três categorias de usuários.  

O desenvolvimento do front-end foi além da criação de interfaces, abrangendo a **criação de uma base consistente** que lidou com questões complexas de estado e fluxo.  

As dificuldades encontradas, desde a configuração inicial até a correção de erros de lógica e interface, foram essenciais para expandir minha expertise em **Java, no framework JavaFX e em modelos de projeto chave no desenvolvimento de software**.  