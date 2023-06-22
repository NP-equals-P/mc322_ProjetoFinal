import java.util.*;

public class Vendedor extends Funcionario{
    /*
    Subclasse de Funcionário, não tem permissão para criar novos funcionários,
    mas pode realizar Compras
     */
    private List<Compra> listaCompras;

    /*
    Construtor
     */
    public Vendedor(Unidade unidade, String nome, String cpf, double salario) {
        super(unidade, nome, cpf, salario);
        this.listaCompras = new ArrayList<Compra>();
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    /*
    Registra os itens que serão comprados por um cliente
     */
    public Compra realizarCompra() {
        Compra compra = new Compra();
        return compra;
    }

    /*
    Adiciona uma compra completa na lista de compras e muda o salario do vendedor com base nessa compra.
     */
    public void confirmarCompra(Compra compra) {
        listaCompras.add(compra);
        atualizarSalario();
    }

    /*
    Atualiza o salario do vendedor com base no calculo estipulado pela unidade.
     */
    public void atualizarSalario() {
        Unidade unidade = getUnidade();
        unidade.calcSalario(this);
    }

}
