import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    // 1. A única instância da classe
    private static FuncionarioDAO instance = null;
    
    // Lista em memória para simplificar, em vez de usar arquivos
    private List<Funcionario> funcionarios;

    // 2. Construtor privado
    private FuncionarioDAO() {
        funcionarios = new ArrayList<>();
        // Adiciona um gerente padrão para que o login 'admin' possa ser associado a um objeto
        funcionarios.add(new Gerente("Admin", "000.000.000-00", "admin@email.com", "0000-0000", 1, "Gerente", 10000, "admin", "admin"));
    }

    // 3. Método público para obter a instância
    public static FuncionarioDAO getInstance() {
        if (instance == null) {
            instance = new FuncionarioDAO();
        }
        return instance;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        // Verifica se já existe um funcionário com o mesmo CPF
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(funcionario.getCpf())) {
                System.out.println("Erro: Já existe um funcionário com este CPF.");
                return; // Impede a adição
            }
        }
        funcionarios.add(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return new ArrayList<>(funcionarios); // Retorna uma cópia para proteger a lista original
    }

    public Funcionario buscarPorCpf(String cpf) {
        for (Funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }
    
    public Funcionario buscarPorLogin(String login) {
        for (Funcionario f : funcionarios) {
            if (f.getLogin().equals(login)) {
                return f;
            }
        }
        return null;
    }

    public void removerFuncionarioPorCpf(String cpf) {
        funcionarios.removeIf(f -> f.getCpf().equals(cpf));
    }
}