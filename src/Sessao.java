import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class Sessao {
    // ideia: talvez colocar pra apenas o Gerente poder criar uma sessão

    /*
    Contém as informações de um horário de sessão específico
     */
    private String horario; //talvez mude pra string ou algo assim dps
    private Sala sala;
    private String filme;
    private List<Boolean> listaAssentos; // lista de true ou false que representa se o assento ja foi ocupado ou
    // nao, sendo true um assento livre.

    public Sessao(String horario, Sala sala, String filme) {
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
        int numAssentos = sala.getNumAssentos();
        this.listaAssentos = new ArrayList<Boolean>(numAssentos); // cria uma lista de booleano do tamanho dos assentos da sala.
        listaAssentos.addAll(Collections.nCopies(numAssentos, Boolean.TRUE));   // coloca todos os elementos da lista como true.
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
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
            Scanner scanner = new Scanner(System.in);
            Path caminho = Paths.get("fileIn/Test1.csv"); // só pra testes esta com string fixa, mas o nome do arquivo vem pela interface
            // Paths.get encontra o caminho absoluto com base no caminho relativo
            BufferedReader arquivo = new BufferedReader(new FileReader("fileIn/Test1.csv"));
            String linha;
            String[] buffer;
            while ((linha = arquivo.readLine()) != null) {
                buffer = linha.split(",");
                for (String Str : buffer) {
                    listaArquivo.add(Str);
                }
            }
            arquivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!listaArquivo.isEmpty()) {
            return listaArquivo;
        } else {
            return null;
        }
    }
}
