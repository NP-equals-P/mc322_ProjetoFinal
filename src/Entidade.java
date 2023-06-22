import java.util.ArrayList;
import java.util.List;

public class Entidade {
    /*
    Classe principal da corporação, representa a rede do cinema
     */
    private String nomeRede;
    private String enderecoRede;
    private String telefoneRede;
    private String emailRede;
    private List<Unidade> listaUnidades;
    private double valorArrecadado;

    public Entidade(String nomeRede, String enderecoRede, String telefoneRede, String emailRede) {
        this.nomeRede = nomeRede;
        this.enderecoRede = enderecoRede;
        this.telefoneRede = telefoneRede;
        this.emailRede = emailRede;
        this.listaUnidades = new ArrayList<Unidade>();
        this.valorArrecadado = 0;
    }

    public String getNomeRede() {
        return nomeRede;
    }

    public void setNomeRede(String nomeRede) {
        this.nomeRede = nomeRede;
    }

    public String getEnderecoRede() {
        return enderecoRede;
    }

    public void setEnderecoRede(String enderecoRede) {
        this.enderecoRede = enderecoRede;
    }

    public String getTelefoneRede() {
        return telefoneRede;
    }

    public void setTelefoneRede(String telefoneRede) {
        this.telefoneRede = telefoneRede;
    }

    public String getEmailRede() {
        return emailRede;
    }

    public void setEmailRede(String emailRede) {
        this.emailRede = emailRede;
    }

    public List<Unidade> getListaUnidades() {
        return listaUnidades;
    }

    public double getValorArrecadado() {
        return valorArrecadado;
    }

    /*
    Calcula o valor arrecadado total da entidade, sendo a soma dos valores arrecadados
    por todas as unidades.
     */
    public void calcValorArrecadado() {
        for (Unidade u : listaUnidades) {
            valorArrecadado += u.getSaldo();
        }
    }
}
