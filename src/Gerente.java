import java.util.*;


public class Gerente extends Funcionario{
    /*
    Subclasse de Funcionário, tem permissão para criar novos funcionários
    e gerenciar os já existentes, além de realizar Compras
     */

    public Gerente(Unidade unidade, String nome, String CPF, double salario, String login, String senha) {
        super(unidade, nome, CPF, salario, login, senha);
    }

    /*
    Recebe qual o tipo de funcionario sera contratado, cria um objeto de sua classe e 
    chama uma função para colocar esse funcionario na lista de funcionarios da unidade.
     */
    public void contratarFuncionario(String tipo, String nome, String cpf, String login, String senha) {
        if (tipo.equals("Gerente")) {
            Gerente gerente = new Gerente(getUnidade(), nome, cpf, 4500.0, login, senha);
            adicionarFuncionarioLista(gerente);
        }
        else {
            Vendedor vendedor = new Vendedor(getUnidade(), nome, cpf, 1500.0, login, senha);
            adicionarFuncionarioLista(vendedor);
        }
    }

    /*
    Recebe um funcionario e coloca ele na lista de funcionarios da unidade
     */
    public void adicionarFuncionarioLista(Funcionario funcionario) {
        Unidade unidade = getUnidade();
        unidade.getListaFuncionarios().add(funcionario);
    }

    /*
    Recebe um cpf e retira esse funcionario da lista de funcionarios da unidade com base nesse cpf,
    ou seja, demite ele
     */
    public boolean demitirFuncionario(String cpf) {
        Unidade unidade = getUnidade();
            Iterator<Funcionario> i = unidade.getListaFuncionarios().iterator();
            while(i.hasNext()) {
                Funcionario f = i.next();
                if (f.getCpf().equals(cpf)) {
                    i.remove();
                    return true;
                }
            }
            return false; // nao encontrou alguem com o cpf dado para ser retirado

    }

    /*
    Modifica o filme que esta passando em uma sessao.
     */
    public void modificarFilme(String filme, String imagemCartaz, Sessao sessao) {
        sessao.setFilme(filme);
        sessao.setCartaz(imagemCartaz);
    }

    /*
    Recebe um cpf e um salario, e modifica o salario do funcionario com esse cpf para 
    o novo salario fornecido.
     */
    public void modificarSalario(String cpf, double novoSalario) {
        Unidade unidade = getUnidade();
        for (Funcionario f : unidade.getListaFuncionarios()) {
            if (f.getCpf().equals(cpf)) {
                f.setSalario(novoSalario);
            }
        }
    }

}
