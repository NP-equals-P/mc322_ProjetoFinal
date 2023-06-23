import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class telaInserirVendedor {
    private JTextField campoNome;
    private JTextField campoCPF;
    private JTextField campoLogin;
    private JPasswordField campoSenha;
    private JButton voltarButton;
    private JButton confirmarButton;
    private JComboBox<String> seletorTipo;
    private JLabel labelErro;
    private JPanel painelInserir;

    public telaInserirVendedor(Janela janela, Gerente gerente) {
        labelErro.setVisible(false);
        labelErro.setForeground(Color.RED);
        voltarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                janela.adicionarCard(Janela.GERENTE, new telaGerente(janela, gerente).getPainelGerente());
                janela.trocarCard(Janela.GERENTE);
                janela.getCards().remove(painelInserir);
            }
        });
        confirmarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String nome = campoNome.getText();
                    String cpf = campoCPF.getText();
                    String login = campoLogin.getText();
                    String senha = String.valueOf(campoSenha.getPassword());
                    String tipo = (String)seletorTipo.getSelectedItem();
                    gerente.contratarFuncionario(tipo, nome, cpf, login, senha);

                    janela.adicionarCard(Janela.GERENTE, new telaGerente(janela, gerente).getPainelGerente());
                    janela.trocarCard(Janela.GERENTE);
                    janela.getCards().remove(painelInserir);
                } catch (NullPointerException exception) {
                    labelErro.setVisible(true);
                }
            }
        });
    }

    public JPanel getPainelInserir() {
        return painelInserir;
    }
}
