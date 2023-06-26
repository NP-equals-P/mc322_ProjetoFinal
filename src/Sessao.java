import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class Sessao {
    // ideia: talvez colocar pra apenas o Gerente poder criar uma sessão

    /*
    Contém as informações de um horário de sessão específico
     */
    private String horario;
    private Sala sala;
    private String filme;
    private List<Boolean> listaAssentos; // lista de true ou false que representa se o assento ja foi ocupado ou
                                        // nao, sendo true um assento livre.
    private String cartaz;

    public Sessao(String horario, Sala sala, String filme, String cartaz) {
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
        int numAssentos = sala.getNumAssentos();
        this.listaAssentos = new ArrayList<Boolean>(numAssentos); // cria uma lista de booleano do tamanho dos assentos da sala.
        listaAssentos.addAll(Collections.nCopies(numAssentos, Boolean.TRUE));   // coloca todos os elementos da lista como true.
        this.cartaz = cartaz;
    }

    public String getHorario() {
        return horario;
    }

    public Sala getSala() {
        return sala;
    }

    public String getFilme() {
        return filme;
    }

    public void setFilme(String filme) {
        this.filme = filme;
    }

    public List<Boolean> getListaAssentos() {
        return listaAssentos;
    }

    public static List<String> lerFilmes() {
        /*
        Lê um arquivo CSV e retorna um ArrayList com o nome de filmes nas
        posições pares (posicao mod2 == 0) e um caminho para imagem nas posições
        ímpares (posicao mod2 == 1), sendo que na posição seguinte a um filme, tem
        a imagem desse filme
         */
        List<String> listaArquivo = new ArrayList<String>();
        try {
            String diretorioAtual = System.getProperty("user.dir");
            String caminho = diretorioAtual + "/fileIn/Filmes_em_Cartaz.csv";
            BufferedReader arquivo = new BufferedReader(new FileReader(caminho));
            String linha;
            String[] buffer;
            while ((linha = arquivo.readLine()) != null) {
                buffer = linha.split(",");
                for (String Str : buffer) {
                    listaArquivo.add(Str);
                }
            }
            arquivo.close();
        } catch (FileNotFoundException notFound) {
            System.err.println(notFound.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        if (!listaArquivo.isEmpty()) {
            return listaArquivo;
        } else {
            return null;
        }
    }
    public String getCartaz() {
        return cartaz;
    }

    public void setCartaz(String cartaz) {
        this.cartaz = cartaz;
    }

    @Override
    public String toString() {
        return "Horário: " + getHorario() + "\n" +
                "Sala: " + getSala().getId() +
                (getSala().getEh3D() ? " 3D" : "") +
                (getSala().getEhVIP() ? " VIP" : "") + "\n" +
                "Filme: " + getFilme();
    }

    public int getAssentosOcupados() {
        int contador = 0;
        for(Boolean assento : listaAssentos) {
            if (assento == false) {
                contador += 1;
            }
        }

        return contador;
    }
}
