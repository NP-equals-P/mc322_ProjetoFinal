import java.time.LocalDate;
import java.util.*;

public class Gerente extends Funcionario{
    /*
    Subclasse de Funcionário, tem permissão para criar novos funcionários
    e gerenciar os já existentes, além de realizar Compras
     */

    public Gerente(String nome, String CPF, LocalDate dataNascimento, double salario) {
        super(nome, CPF, dataNascimento, salario);
    }
//    public boolean adicionarFuncionario();
}
