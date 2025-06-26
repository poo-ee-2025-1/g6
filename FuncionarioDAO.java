import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private final String arquivo = "funcionarios.ser";

    public void salvarFuncionario(Funcionario funcionario) {
        List<Funcionario> funcionarios = listarFuncionarios();
        funcionarios.add(funcionario);
        salvarLista(funcionarios);
    }

    public List<Funcionario> listarFuncionarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (List<Funcionario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    public Funcionario buscarPorCpf(String cpf) {
        for (Funcionario f : listarFuncionarios()) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }

    public void removerFuncionarioPorCpf(String cpf) {
        List<Funcionario> funcionarios = listarFuncionarios();
        funcionarios.removeIf(f -> f.getCpf().equals(cpf));
        salvarLista(funcionarios);
    }

    private void salvarLista(List<Funcionario> funcionarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(funcionarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
