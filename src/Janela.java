import javax.swing.*;
import java.awt.*;

public class Janela {
    private final JPanel cards;
    /* Criar nome dos cards */
    private static final String LOGIN = "Login";
    private final Entidade entidade;

    public Janela(Entidade entidade, String titulo) {
        this.entidade = entidade;
        JFrame frame = new JFrame();
        frame.setTitle(titulo);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cards = new JPanel(new CardLayout());
        frame.add(cards);

        /* Adiciona cards (paineis) */
        cards.add(new telaLogin(this).getPainelLogin(), LOGIN);
        frame.setContentPane(cards);
    }

    public void trocarCard(String card) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, card);
    }

    public Entidade getEntidade() {
        return entidade;
    }
}
