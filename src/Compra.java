import java.io.*;
import java.util.*;

public class Compra implements Imprimivel{
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

//    /*
//    Recalcula o valor total da compra
//     */
//    public boolean atualizarTotal() {
//
//    }
//
//    /*
//    Cria um ingresso
//     */
//    public boolean criarIngresso() {
//
//    }
//
//    /*
//    Adiciona um ingresso, já criado, na lista de ingressos da compra
//     */
//    public boolean adicionarIngresso() {
//
//    }
//
//    /*
//    Adiciona um ingresso na lista de consumiveis da compra
//     */
//    public boolean adicionarConsumivel() {
//
//    }

    public void imprimir() {
        String registroCompra = Integer.toString(this.registroCompra);
        String nomeArquivo = "Compra"+registroCompra+".txt";

        try {
            BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(nomeArquivo));
            // Escrevendo o recibo da compra
            bufferEscrita.write("Código da compra: "+Integer.toString(getRegistroCompra())+"\n");
            bufferEscrita.write("#############################\n");
            bufferEscrita.write("Quantidade de ingressos comprados: "+this.listaIngressos.size()+"\n");
            for (Ingresso i : listaIngressos) {
                bufferEscrita.write("Horário: \n");
                bufferEscrita.write("Assento: \n");
                bufferEscrita.write("Filme: \n");
                bufferEscrita.write("Preço: \n");
                bufferEscrita.write("----------------------------------\n");
            }
            bufferEscrita.write("#############################\n");
            bufferEscrita.write("Consumíveis comprados:\n");
            for (Consumo i : listaConsumo) {
                bufferEscrita.write("Horário: \n");
                bufferEscrita.write("Assento: \n");
                bufferEscrita.write("Filme: \n");
            }

            bufferEscrita.close();
            System.out.println("Arquivo gravado com sucesso!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao gravar o arquivo: " + e.getMessage());
        }
    }
}
