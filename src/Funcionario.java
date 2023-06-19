import java.time.LocalDate;
import java.util.*;

public abstract class Funcionario {
    /*
    Superclasse dos tipos Vendedor e Gerente
     */
    private String nome;
    private final String CPF;
    private LocalDate dataNascimento;
    private double salario;
    private List<Compra> listaCompras;

    public Funcionario(String nome, String CPF, LocalDate dataNascimento, double salario) {
        this.nome = nome;
        this.CPF = CPF;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
        this.listaCompras = new ArrayList<>();
    }
}
