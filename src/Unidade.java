import java.util.*;

public class Unidade {
    /*
    Filial da Entidade, será responsável por conter os Funcionários e as Compras
     */
    private String cnpj;
    private List<Funcionario> listaFuncionarios;
    private String endereco;
    private String email;
    private List<Compra> listaCompras;
    private List<Sessao> listaSessoes;
    private double saldo;

    public Unidade(String cnpj, String endereco, String email) {
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.listaFuncionarios = new ArrayList<Funcionario>();
        this.listaCompras = new ArrayList<Compra>();
        this.listaSessoes = new ArrayList<Sessao>();
        this.saldo = 0;
    }

    public String getCnpj() {
        return cnpj;
    }
    
    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public List<Sessao> getListaSessoes() {
        return listaSessoes;
    }

    public double getSaldo() {
        return saldo;
    }

    /*
    Calcula o salario de um funcionario (fornecido), com base na sua lista de compras.
     */
    public void calcSalario(Vendedor vendedor) {
        double soma = 0;
        for (Compra c : vendedor.getListaCompras()) {
            soma += (c.getTotal() * (0.5 / 100));
        }
        soma += vendedor.getSalario();
        vendedor.setSalario(soma);
    }

    /*
    Calcula quanto uma unidade ganha, sendo as vendas dela (lista de compras) um saldo positivo
    e os salarios dos funcionarios um saldo negativo.
     */
    public void calcSaldo() {
        for (Compra c : listaCompras) {
            saldo += c.getTotal();
        }
        for (Funcionario f : listaFuncionarios) {
            saldo -= f.getSalario();
        }
    }


}
