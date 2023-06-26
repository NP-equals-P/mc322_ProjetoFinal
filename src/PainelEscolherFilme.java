import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelEscolherFilme extends JPanel implements ActionListener, atualizar{
    JanelaMatheus janela;
    JButton botaoVoltar;
    JPanel secaoCentral;
    JButton botaoFilme1;
    JButton botaoFilme2;
    JButton botaoFilme3;
    JButton botaoFilme4;

    PainelEscolherFilme(JanelaMatheus janela) {
        this.janela = janela;

        this.setBackground(Color.magenta);
        this.setBounds(0, 0, 800, 450);
        this.setLayout(new BorderLayout());
        this.setVisible(false);

        JPanel secaoSuperior = new JPanel();
        secaoSuperior.setBackground(Color.yellow);
        secaoSuperior.setVisible(true);
        secaoSuperior.setLayout(null);
        secaoSuperior.setPreferredSize(new Dimension(800, 50));
        this.add(secaoSuperior, BorderLayout.NORTH);

        botaoVoltar = new JButton();
        botaoVoltar.setBounds(10, 10, 100, 30);
        botaoVoltar.addActionListener(this);
        botaoVoltar.setVisible(true);
        botaoVoltar.setText("Voltar");
        botaoVoltar.setFocusable(false);
        secaoSuperior.add(botaoVoltar);

        secaoCentral = new JPanel();
        secaoCentral.setBackground(Color.red);
        secaoCentral.setVisible(true);
        secaoCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 24, 65));
        secaoCentral.setPreferredSize(new Dimension(100, 283));
        this.add(secaoCentral, BorderLayout.CENTER);
        this.atualizarPainel(0);

        botaoFilme1 = new JButton();
        botaoFilme1.setPreferredSize(new Dimension(170, 240));
        botaoFilme1.addActionListener(this);
        botaoFilme1.setVisible(true);
        botaoFilme1.setText("1");
        botaoFilme1.setFocusable(false);
        secaoCentral.add(botaoFilme1);

        botaoFilme2 = new JButton();
        botaoFilme2.setPreferredSize(new Dimension(170, 240));
        botaoFilme2.addActionListener(this);
        botaoFilme2.setVisible(true);
        botaoFilme2.setText("2");
        botaoFilme2.setFocusable(false);
        secaoCentral.add(botaoFilme2);

        botaoFilme3 = new JButton();
        botaoFilme3.setPreferredSize(new Dimension(170, 240));
        botaoFilme3.addActionListener(this);
        botaoFilme3.setVisible(true);
        botaoFilme3.setText("3");
        botaoFilme3.setFocusable(false);
        secaoCentral.add(botaoFilme3);

        botaoFilme4 = new JButton();
        botaoFilme4.setPreferredSize(new Dimension(170, 240));
        botaoFilme4.addActionListener(this);
        botaoFilme4.setVisible(true);
        botaoFilme4.setText("4");
        botaoFilme4.setFocusable(false);
        secaoCentral.add(botaoFilme4);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoVoltar) {
            this.setVisible(false);
            janela.getPainelCompra().setVisible(true);
        }
        else {
            this.setVisible(false);
            janela.getPainelEscolherSessao().setVisible(true);
            janela.getPainelVendedor().setFilmeSelecionado(Integer.parseInt(((JButton) e.getSource()).getText()));
        }
    }


    @Override
    public void atualizarPainel(int codigo) {
    }
}
