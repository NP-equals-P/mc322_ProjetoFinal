import java.util.*;

public class Compra {
    /*
    Registra os itens que serão comprados por um cliente
     */
    private final int registroCompra;
    private List<Ingresso> listaIngressos;
    private List<Consumo> listaConsumo;
    private double total;
    private static int cont = 0;

    public Compra() {
        this.registroCompra = cont++;
        this.listaConsumo = new ArrayList<>();
        this.listaIngressos = new ArrayList<>();
    }

    public int getRegistroCompra() {
        return registroCompra;
    }

    public List<Ingresso> getListaIngressos() {
        return listaIngressos;
    }

    public void setListaIngressos(List<Ingresso> listaIngressos) {
        this.listaIngressos = listaIngressos;
    }

    public List<Consumo> getListaConsumo() {
        return listaConsumo;
    }

    public void setListaConsumo(List<Consumo> listaConsumo) {
        this.listaConsumo = listaConsumo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    /*
    Recalcula o valor total da compra
     */
    public boolean atualizarTotal() {

    }

    /*
    Cria um ingresso
     */
    public boolean criarIngresso() {

    }

    /*
    Adiciona um ingresso, já criado, na lista de ingressos da compra
     */
    public boolean adicionarIngresso() {

    }

    /*
    Adiciona um ingresso na lista de consumiveis da compra
     */
    public boolean adicionarConsumivel() {

    }
}

/home/math/IdeaProjects/Kinoplex2_ou_nome_melhor/src/Funcionario.java