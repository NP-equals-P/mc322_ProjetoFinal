import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
    private List<Consumivel> listaConsumivel;
    private Entidade entidade;
    private double saldo;

    public Unidade(String cnpj, String endereco, String email, Entidade entidade) {
        this.cnpj = cnpj.replaceAll("[^0-9]", ""); // para colocar apenas os números
        this.endereco = endereco;
        this.email = email;
        this.listaFuncionarios = new ArrayList<Funcionario>();
        this.listaCompras = new ArrayList<Compra>();
        this.listaSessoes = new ArrayList<Sessao>();
        this.listaConsumivel = new ArrayList<Consumivel>();
        this.entidade = entidade;
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

    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }

    public List<Consumivel> getListaConsumivel() {
        return listaConsumivel;
    }

    public void setListaConsumivel(List<Consumivel> listaConsumivel) {
        this.listaConsumivel = listaConsumivel;
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

    /*
    Cria um arquivo .txt no diretório fileOut com as principais informações sobre a
    unidade em questão
     */
    public void imprimir() {
        String diretorioAtual = System.getProperty("user.dir");
        String caminho = diretorioAtual + "/fileOut/Unidade" + getCnpj() + ".txt";
        try {
            BufferedWriter bufferEscrita = new BufferedWriter(new FileWriter(caminho));
            // Escrevendo as informações da Unidade
            bufferEscrita.write("Esta unidade é uma filial de " + this.entidade.getNomeRede() + "©\n\n");
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
        } catch (IOException problema) {
            System.err.println(problema.getMessage());
        }
    }


}
