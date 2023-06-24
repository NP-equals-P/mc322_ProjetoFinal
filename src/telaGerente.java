import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JList<Sessao> listaSessoes;
    private JButton modificarFilmeButton;
    private JLabel labelTituloFilme;
    private JLabel labelImagem;
    private JList listaConsumiveis;
    private JButton alterarPrecoButton;

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

            removerButton.setEnabled(selecionado != gerente);
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
        alterarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Funcionario selecionado = listaFuncionarios.getSelectedValue();
                try {
                    String salario = JOptionPane.showInputDialog("Digite o novo salário:");
                    gerente.modificarSalario(selecionado.getCpf(), Double.parseDouble(salario));
                    atualizarTextoInfo(selecionado);
                } catch (NullPointerException ignored) {
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(null, "Insira um número!");
                }
            }
        });

        DefaultListModel<Sessao> listaSessoesModelo = new DefaultListModel<>();
        listaSessoesModelo.addAll(gerente.getUnidade().getListaSessoes());
        listaSessoes.setModel(listaSessoesModelo);
        modificarFilmeButton.setEnabled(false);

        listaSessoes.addListSelectionListener(e -> {
            Sessao selecionada = listaSessoes.getSelectedValue();
            atualizarSessaoInfo(selecionada);
            modificarFilmeButton.setEnabled(true);
        });
        modificarFilmeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Sessao selecionada = listaSessoes.getSelectedValue();
                try {
                    String filme = JOptionPane.showInputDialog("Digite o nome do Filme:");
                    JFileChooser escolher = new JFileChooser("fileIn/");
                    escolher.setDialogTitle("Escolher cartaz");
                    escolher.addChoosableFileFilter(new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif"));
                    if (escolher.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                        gerente.modificarFilme(filme, escolher.getSelectedFile().getPath(), selecionada);
                        atualizarSessaoInfo(selecionada);
                    }
                } catch (NullPointerException ignored) {
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

    public void atualizarSessaoInfo(Sessao selecionada) {
        labelTituloFilme.setText(selecionada.getFilme());
        labelImagem.setText("<html><img width=250 height=250 src=\"file:"+ selecionada.getCartaz() + "\"><html>");
    }
}
