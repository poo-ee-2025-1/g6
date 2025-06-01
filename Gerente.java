import java.util.List;

public class Gerente extends Funcionario {

    public Gerente(String nome, String cpf, String email, String telefone,
                   int idFuncionario, String cargo, double salario,
                   String login, String senha) {
        super(nome, cpf, email, telefone, idFuncionario, cargo, salario, login, senha);
    }

    // Métodos de gerenciamento (só a estrutura, a lógica será em controladores ou serviços)

    public void cadastrarFuncionario(List<Funcionario> funcionarios, Funcionario novo) {
        funcionarios.add(novo);
    }

    public void removerFuncionario(List<Funcionario> funcionarios, Funcionario f) {
        funcionarios.remove(f);
    }

    public void aprovarOrcamento(Orcamento orcamento) {
        orcamento.setAprovado(true);
    }

    public void recusarOrcamento(Orcamento orcamento) {
        orcamento.setAprovado(false);
    }

    @Override
    public String toString() {
        return super.toString() + "\n[Gerente]";
    }
}
