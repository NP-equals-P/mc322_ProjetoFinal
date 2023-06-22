// import java.util.*;

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

    public boolean getEhInteiro() {
        return ehInteiro;
    }

    /*
    Calcula o preço do ingresso, levando em conta o preço de uma sala e se é ou nao um ingresso inteiro.
     */
    public double calcPreco(Sessao sessao, boolean ehInteiro) {
        double valor = 0;
        Sala sala = sessao.getSala();
        valor = sala.getPreco();
        if (ehInteiro == false) {
            valor = (valor / 2.);
        }
        return valor;
    } 
}
