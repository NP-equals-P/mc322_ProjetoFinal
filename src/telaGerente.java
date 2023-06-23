import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class telaGerente {
    private JTabbedPane painelVendedor;
    private JPanel painelConsumiveis;
    private JPanel painelSessoes;
    private JPanel painelGerente;
    private JLabel labelBemVindo;
    private JButton buttonSair;

    public telaGerente(Janela janela, Gerente gerente) {
        labelBemVindo.setText("Bem-vindo(a), " + gerente.getNome());
        buttonSair.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                janela.trocarCard(Janela.LOGIN);
                janela.getCards().remove(painelGerente);
            }
        });
    }

    public JPanel getPainelGerente() {
        return painelGerente;
    }
}
