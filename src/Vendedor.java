import java.util.*;

public class Vendedor extends Funcionario{
    /*
    Subclasse de Funcionário, não tem permissão para criar novos funcionários,
    mas pode realizar Compras
     */

    private List<Compra> listaCompras;

    public Vendedor(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
        this.listaCompras = new ArrayList<Compra>();
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    /*
    Registra os itens que serão comprados por um cliente
     */
    public void realizarCompra() {
        Compra compra = new Compra();
        listaCompras.add(compra);
    }

}
