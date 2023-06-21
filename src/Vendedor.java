import java.util.*;

public class Vendedor extends Funcionario{
    /*
    Subclasse de Funcionário, não tem permissão para criar novos funcionários,
    mas pode realizar Compras
     */

    private List<Compra> listaCompras;

    Funcionario() {

    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }
}
