import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelLogin extends JPanel implements ActionListener{
    JanelaMatheus janela;
    JButton botaoLogin;
    JTextField campoTextoNome;
    JTextField campoTextoSenha;

    PainelLogin(JanelaMatheus janela) {
        this.janela = janela;

        this.setBackground(Color.red);
        this.setBounds(0, 0, 800, 450);
        this.setLayout(null);
        
        botaoLogin = new JButton();
        botaoLogin.setBounds(0, 0, 50, 50);
        botaoLogin.addActionListener(this);
        this.add(botaoLogin);

        campoTextoNome = new JTextField();
        campoTextoNome.setBounds(100, 100, 200, 20);
        this.add(campoTextoNome);

        campoTextoSenha = new JTextField();
        campoTextoSenha.setBounds(100, 200, 200, 20);
        this.add(campoTextoSenha);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource() == botaoLogin)) {

            //if (unidade.checarLogin(campoTextoNome.getText(), campoTextoSenha.getText())) {
            //
            //      if (unidade.acharFuncionario(campoTextoNome.getText()) instanceof Vendedor) {
            //          this.setVisible(false);
            //          janela.getPainelVendedor().setFuncionarioLogado(unidade.acharFuncionario(campoTextoNome.getText()));
            //          janela.getPainelVendedor().setVisible(true);
            //      }
            //      else {
            //          ... ?
            //      }
            //}
            //else {
            //      JOptionPane.showMessageDialog(null, "Nome ou senha incorretos!", "Erro no login", JOptionPane.ERROR_MESSAGE);
            //}

            //MÉTODO DUMMY//
            if (campoTextoNome.getText().equals("vendedor")) {
                campoTextoNome.setText("");
                this.setVisible(false);
                janela.getPainelVendedor().setVisible(true);
            }
        }
    }
} 
