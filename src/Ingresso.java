import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Ingresso {
    private final int id;
    private int assento;
    private Sessao sessao;
    private double preco;
    private boolean ehInteiro;
    private static int contador = 0;

    public Ingresso(int assento, Sessao sessao, boolean ehInteiro) {
            this.assento = assento;
            this.sessao = sessao;
            this.ehInteiro = ehInteiro;
            this.preco = calcPreco(sessao, ehInteiro);
            this.id = contador;
            contador++;
    }

    public double calcPreco(Sessao sessao, boolean ehInteiro) {
        double valor = 0;
        Sala sala = sessao.getSala();
        valor = sala.getPreco();
        if (ehInteiro == false) {
            valor = (valor / 2.);
        }
        return valor;
    }

    public int getId() {
        return id;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public boolean isEhInteiro() {
        return ehInteiro;
    }

    public void setEhInteiro(boolean ehInteiro) {
        this.ehInteiro = ehInteiro;
    }

    public void imprimir() {
        String id = Integer.toString(getId());
        String nomeArquivo = "fileOut/Ingresso" + id + ".txt";
        Sessao sessao = getSessao();

        try {
            BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(nomeArquivo));
            // Escrevendo as informações do ingresso
            bufferEscrita.write("Filme: " + sessao.getFilme() + "\n");
            bufferEscrita.write("Preço: " + getPreco() + "\n");
            bufferEscrita.write("Horário da sessão: " + sessao.getHorario() + "\n");
            bufferEscrita.write("Sala: " + sessao.getSala().getId() + "\n");
            bufferEscrita.write("#############################\n\n");
            bufferEscrita.write("Bom filme!!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
