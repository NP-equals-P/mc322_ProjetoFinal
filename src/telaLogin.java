import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class telaLogin {
    private JLabel labelTitulo;
    private JLabel labelLogin;
    private JTextField campoLogin;
    private JButton buttonEntrar;
    private JPanel painelLogin;

    private JLabel labelErroLogin;
    private JLabel labelSenha;
    private JTextField campoSenha;

    public telaLogin(Janela janela) {
        labelErroLogin.setVisible(false);
        labelErroLogin.setForeground(Color.RED);

        buttonEntrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String login = campoLogin.getText();
                String senha = campoSenha.getText();
                Entidade entidade = janela.getEntidade();

                Funcionario funcionario = entidade.getListaFuncionarios()
                        .stream()
                        .filter(f -> f.getLogin().equals(login))
                        .findAny()
                        .orElse(null);

                if (funcionario == null) {
                    labelErroLogin.setVisible(true);
                } else if (!funcionario.getSenha().equals(senha)) {
                    labelErroLogin.setVisible(true);
                    labelErroLogin.setText("Senha incorreta!");
                } else {
                    if (funcionario.getClass() == Gerente.class) {
                        janela.adicionarCard(Janela.GERENTE, new telaGerente(janela, (Gerente) funcionario).getPainelGerente());
                        janela.trocarCard(Janela.GERENTE);
                    }
                }
            }
        });
    }

    public JLabel getLabelLogin() {
        return labelTitulo;
    }

    public JLabel getLabelUsuario() {
        return labelLogin;
    }

    public JTextField getCampoUsuario() {
        return campoLogin;
    }

    public JButton getButtonEntrar() {
        return buttonEntrar;
    }

    public JPanel getPainelLogin() {
        return painelLogin;
    }

    public JLabel getLabelErroLogin() {
        return labelErroLogin;
    }
}
