

public abstract class Funcionario {
    /*
    Superclasse dos tipos Vendedor e Gerente
     */
    private Unidade unidade;
    private String nome;
    private final String cpf;
    private double salario;

    public Funcionario(Unidade unidade, String nome, String cpf, double salario) {
        this.unidade = unidade;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }
    
    public Unidade getUnidade() {
        return unidade;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
