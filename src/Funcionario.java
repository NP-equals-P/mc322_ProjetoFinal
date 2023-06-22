

public abstract class Funcionario {
    /*
    Superclasse dos tipos Vendedor e Gerente
     */
    private String unidade;
    private String nome;
    private final String cpf;
    private double salario;

    public Funcionario(String unidade, String nome, String cpf, double salario) {
        this.unidade = unidade;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }




}
