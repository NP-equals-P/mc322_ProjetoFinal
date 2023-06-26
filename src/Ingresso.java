// import java.io.BufferedWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ingresso {
    private final int id;
    private final int assento;
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
    
    public int getId() {
        return id;
    }
    
    public int getAssento() {
        return assento;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public double getPreco() {
        return preco;
    }

    /*
    Calcula o preço do ingresso, levando em conta o preço de uma sala e se é ou nao um ingresso inteiro.
     */
    public double calcPreco(Sessao sessao, boolean ehInteiro) {
        double valor = 0;
        Sala sala = sessao.getSala();
        valor = sala.getPreco();
        if (!ehInteiro) {
            valor = (valor / 2.);
        }
        return valor;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public void setEhInteiro(boolean ehInteiro) {
        this.ehInteiro = ehInteiro;
    }

    /*
    Cria um arquivo .txt no diretório fileOut com as principais informações sobre o
    ingresso em questão
     */
    public void imprimir() {
        String id = Integer.toString(getId());
        String diretorioAtual = System.getProperty("user.dir");
        String caminho = diretorioAtual + "/fileOut/Ingresso" + id + ".txt";
        Sessao sessao = getSessao();

        try {
            BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(caminho));
            // Escrevendo as informações do ingresso
            bufferEscrita.write("Filme: " + sessao.getFilme() + "\n");
            bufferEscrita.write("Preço: " + getPreco() + "\n");
            bufferEscrita.write("Horário da sessão: " + sessao.getHorario() + "\n");
            bufferEscrita.write("Sala: " + sessao.getSala().getId() + "\n");
            bufferEscrita.write("#############################\n\n");
            bufferEscrita.write("Bom filme!!");
            bufferEscrita.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
