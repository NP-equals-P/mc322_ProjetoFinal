import java.time.LocalDate;
import java.util.*;

public class Vendedor extends Funcionario{
    /*
    Subclasse de Funcionário, não tem permissão para criar novos funcionários,
    mas pode realizar Compras
     */

    private List<Compra> listaCompras;

    public Vendedor(String nome, String CPF, LocalDate dataNascimento, double salario) {
        super(nome, CPF, dataNascimento, salario);
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
}
