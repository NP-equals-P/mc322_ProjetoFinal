import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class telaGerente {
    private JTabbedPane painelVendedor;
    private JPanel painelConsumiveis;
    private JPanel painelSessoes;
    private JPanel painelGerente;
    private JLabel labelBemVindo;
    private JButton buttonSair;
    private JList<Funcionario> listaFuncionarios;
    private JTextArea textoFuncionarioInfo;
    private JButton removerButton;
    private JButton alterarButton;
    private JButton cadastrarButton;

    public telaGerente(Janela janela, Gerente gerente) {
        alterarButton.setEnabled(false);
        DefaultListModel<Funcionario> listaFuncionariosModelo = new DefaultListModel<>();
        listaFuncionariosModelo.addAll(gerente.getUnidade().getListaFuncionarios());
        listaFuncionarios.setModel(listaFuncionariosModelo);
        labelBemVindo.setText("Bem-vindo(a), " + gerente.getNome());
        buttonSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                janela.trocarCard(Janela.LOGIN);
                janela.getCards().remove(painelGerente);
            }
        });
        listaFuncionarios.addListSelectionListener(e -> {
            Funcionario selecionado = listaFuncionarios.getSelectedValue();
            if (selecionado == null) {
                textoFuncionarioInfo.setText("");
                return;
            }
            atualizarTextoInfo(selecionado);

            if (selecionado == gerente) {
                removerButton.setEnabled(false);
            }
            alterarButton.setEnabled(true);
        });


        cadastrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                janela.adicionarCard(Janela.INSERIR_FUNCIONARIO, new telaInserirVendedor(janela, gerente).getPainelInserir());
                janela.getCards().remove(painelGerente);
            }
        });
        removerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Funcionario selecionado = listaFuncionarios.getSelectedValue();
                listaFuncionariosModelo.removeElement(selecionado);
                gerente.demitirFuncionario(selecionado.getCpf());
            }
        });
        listaFuncionarios.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        });
        alterarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Funcionario selecionado = listaFuncionarios.getSelectedValue();
                try {
                    String salario = JOptionPane.showInputDialog("Digite o novo salário:");
                    gerente.modificarSalario(selecionado.getCpf(), Double.parseDouble(salario));
                    atualizarTextoInfo(selecionado);
                } catch (NullPointerException exception) {
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Insira um número!");
                }
            }
        });
    }

    public JPanel getPainelGerente() {
        return painelGerente;
    }

    public void atualizarTextoInfo(Funcionario selecionado) {
        String info = "Nome: " + selecionado.getNome() + "\n" +
                "CPF: " + selecionado.getCpf() + "\n" +
                "Salário: R$ " + selecionado.getSalario() + "\n" +
                "Login: " + selecionado.getLogin() + "\n" +
                "Senha: " + selecionado.getSenha() + "\n";
        textoFuncionarioInfo.setText(info);
    }
}
