import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    // public int getLugaresLivres() {
    //     return lugaresLivres;
    // }

    // public void setLugaresLivres(int lugaresLivres) {
    //     this.lugaresLivres = lugaresLivres;
    // }
}
