import java.time.LocalDate;
import java.util.*;

public abstract class Funcionario {
    /*
    Superclasse dos tipos Vendedor e Gerente
     */
    private String unidade;
    private String nome;
    private final String CPF;
    private LocalDate dataNascimento;
    private double salario;

    public Funcionario(String nome, String CPF, LocalDate dataNascimento, double salario) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
    }




}
