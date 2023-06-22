import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Unidade {
    /*
    Filial da Entidade, será responsável por conter os Funcionários e as Compras
     */
    private String nome;
    private String cnpj;
    private List<Funcionario> listaFuncionarios;
    private String endereco;
    private String email;
    private List<Compra> listaCompras;
    private List<Sessao> listaSessoes;
    private Entidade entidade;
    private double saldo;

    public Unidade(String nome, String cnpj, String endereco, String email, Entidade entidade) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.email = email;
        this.listaFuncionarios = new ArrayList<Funcionario>();
        this.listaCompras = new ArrayList<Compra>();
        this.listaSessoes = new ArrayList<Sessao>();
        this.entidade = entidade;
        this.saldo = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
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

    public void imprimir() {
        String nomeArquivo = "fileOut/" + getNome() + " - " + getCnpj() + ".txt";
        try {
            BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(nomeArquivo));
            // Escrevendo as informações da Unidade
            bufferEscrita.write("A empresa" + getNome() + "é uma filial de" + this.entidade.getNomeRede() + "\n");
            bufferEscrita.write("CNPJ: " + getCnpj() + "\n");
            bufferEscrita.write("Email: " + getEmail() + "\n");
            String qntdeFuncionarios = Integer.toString(getListaFuncionarios().size());
            String qntdeSessoes = Integer.toString(getListaSessoes().size());
            bufferEscrita.write("Quantidade de funcionários:" + qntdeFuncionarios + "\n");
            bufferEscrita.write("Quantidade de sessões oferecidas: " + qntdeSessoes + "\n");
            bufferEscrita.write("Patrimônio Líquido: " + getSaldo() + "\n");
            bufferEscrita.write("#############################\n\n");
            bufferEscrita.write("Venha conhecer!!");
            bufferEscrita.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
