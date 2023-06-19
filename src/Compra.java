import java.util.*;

public class Compra {
    /*
    Registra os itens que serão comprados por um cliente
     */
    private final int registroCompra;
    private List<Ingresso> listaIngressos;
    private List<Consumo> listaConsumo;
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
}
