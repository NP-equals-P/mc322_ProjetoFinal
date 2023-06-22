import java.io.*;
import java.util.*;

public class Compra implements Imprimivel{
    /*
    Registra os itens que serão comprados por um cliente
     */
    private final int registroCompra;
    private List<Ingresso> listaIngressos;
    private List<Consumivel> listaConsumo;
    private double total;
    private static int cont = 1;

    public Compra() {
        this.registroCompra = cont;
        cont++;
        this.listaConsumo = new ArrayList<Consumivel>();
        this.listaIngressos = new ArrayList<Ingresso>();
        this.total = 0;
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

    public List<Consumivel> getListaConsumo() {
        return listaConsumo;
    }

    public void setListaConsumo(List<Consumivel> listaConsumo) {
        this.listaConsumo = listaConsumo;
    }

    public double getTotal() {
        return total;
    }

    // public void setTotal(double total) {
    //     this.total = total;
    // }

    public void imprimir() {
        String registroCompra = Integer.toString(this.registroCompra);
        String nomeArquivo = "Compra" + registroCompra + ".txt";

        try {
            BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(nomeArquivo));
            // Escrevendo o recibo da compra
            bufferEscrita.write("Código da compra: " + Integer.toString(getRegistroCompra()) + "\n");
            bufferEscrita.write("#############################\n");
            bufferEscrita.write("Quantidade de ingressos comprados: " + this.listaIngressos.size() + "\n");
            for (Ingresso i : listaIngressos) {
                bufferEscrita.write("Horário: \n");
                bufferEscrita.write("Assento: \n");
                bufferEscrita.write("Filme: \n");
                bufferEscrita.write("Preço: \n");
                bufferEscrita.write("----------------------------------\n");
            }
            bufferEscrita.write("#############################\n");
            bufferEscrita.write("Consumíveis comprados:\n");
            for (Consumivel i : listaConsumo) {
                bufferEscrita.write("Horário: \n");
                bufferEscrita.write("Assento: \n");
                bufferEscrita.write("Filme: \n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    Recalcula o valor total da compra
     */
    public void atualizarTotal() {
        for (Ingresso i : listaIngressos) {
            total += i.getPreco();
        }
        for (Consumivel c : listaConsumo) {
            total += c.getPreco();
        }
    }

    /*
    Cria um ingresso
     */
    public void criarIngresso(int assento, Sessao sessao, boolean ehInteiro) {
        boolean condicao = true;
        condicao = verificarAssento(assento, sessao);
        if (condicao == false) {
            System.out.println("Esse assento já está ocupado.");
        }
        else {
            Ingresso ing = new Ingresso(assento, sessao, ehInteiro);
            adicionarIngresso(ing);
        }
    }

    /*
    Adiciona um ingresso, já criado, na lista de ingressos da compra
     */
    public void adicionarIngresso(Ingresso ingresso) {
        listaIngressos.add(ingresso);
    }

    /*
    Cria um consumivel
     */
    public void criarConsumivel(String nome, double preco) {
        Consumivel c = new Consumivel(nome, preco);
        adicionarConsumivel(c);
    }

    /*
    Adiciona um consumivel na lista de consumiveis da compra
     */
    public void adicionarConsumivel(Consumivel consumivel) {
        listaConsumo.add(consumivel);
    }

    /*
    Remove um ingresso da lista de ingressos com base no seu id
     */
    public boolean removerIngresso(int id) {
        Iterator<Ingresso> i = listaIngressos.iterator();
        while(i.hasNext()) {
            Ingresso ing = i.next();
            if (ing.getId() == id) {
                i.remove();
                return true;
            }
        }
        return false; // nao encontrou alguem com o nome dado para ser retirado
    }

    /*
    Remove um consumivel da lista de consumiveis com base no seu nome(como nao importa qual
    consumivel voce quer tirar dede que ele seja do mesmo tipo, nao precisa de um id, apenas do nome)
     */
    public boolean removerConsumivel(String nome) {
        Iterator<Consumivel> i = listaConsumo.iterator();
        while(i.hasNext()) {
            Consumivel consumivel = i.next();
            if (consumivel.getNome().equals(nome)) {
                i.remove();
                return true;
            }
        }
        return false; // nao encontrou alguem com o nome dado para ser retirado
    }

    public boolean verificarAssento(int assento, Sessao sessao) {
        boolean condicao = true;
        List<Boolean> lista = sessao.getListaAssentos();
        if (lista.get(assento) == false) {
            condicao = false;
        }
        return condicao;
    }

}
