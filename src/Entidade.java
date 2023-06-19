public class Entidade {
    /*
    Classe principal da corporação, representa a rede do cinema
     */
    private String nomeRede;
    private String enderecoRede;
    private String telefoneRede;
    private String emailRede;

    public Entidade(String nomeRede, String enderecoRede, String telefoneRede, String emailRede) {
        this.nomeRede = nomeRede;
        this.enderecoRede = enderecoRede;
        this.telefoneRede = telefoneRede;
        this.emailRede = emailRede;
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
}
