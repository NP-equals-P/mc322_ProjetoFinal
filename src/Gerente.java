import java.time.LocalDate;
import java.util.*;

public class Gerente extends Funcionario{
    /*
    Subclasse de Funcionário, tem permissão para criar novos funcionários
    e gerenciar os já existentes, além de realizar Compras
     */

    public Gerente(String unidade, String nome, String CPF, double salario) {
        super(unidade, nome, CPF, salario);
    }
//    public boolean adicionarFuncionario();
}
