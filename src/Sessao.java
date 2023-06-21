import java.time.LocalDate;

public class Sessao {
    // ideia: talvez colocar pra apenas o Gerente poder criar uma sessão

    /*
    Contém as informações de um horário de sessão específico
     */
    private LocalDate horario; //talvez mude pra string ou algo assim dps
    private Sala sala;
    private String filme;
    private int lugaresLivres;

    public Sessao(LocalDate horario, Sala sala, String filme) {
        this.horario = horario;
        this.sala = sala;
        this.filme = filme;
//        this.lugaresLivres = sala.getNumeroAssentos(); // inicializa com os assentos da sala
    }

    public LocalDate getHorario() {
        return horario;
    }

    public void setHorario(LocalDate horario) {
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

    public int getLugaresLivres() {
        return lugaresLivres;
    }

    public void setLugaresLivres(int lugaresLivres) {
        this.lugaresLivres = lugaresLivres;
    }
}
