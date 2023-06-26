import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class PainelEscolherAssentos extends JPanel implements ActionListener, atualizar{
    JanelaMatheus janela;
    JButton botaoVoltar;
    JButton botaoConfirmarAssentos;
    JPanel secaoCentral;
    ArrayList<JCheckBox> botoesAssentos;
    ArrayList<Integer> assentosSelecionados = new ArrayList<Integer>();

    PainelEscolherAssentos(JanelaMatheus janela) {
        this.janela = janela;

        this.setBackground(Color.black);
        this.setBounds(0, 0, 800, 450);
        this.setLayout(new BorderLayout());
        this.setVisible(false);

        JPanel secaoSuperior = new JPanel();
        secaoSuperior.setBackground(Color.orange);
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

        JPanel secaoInferior = new JPanel();
        secaoInferior.setBackground(Color.lightGray);
        secaoInferior.setLayout(null);
        secaoInferior.setVisible(true);
        secaoInferior.setPreferredSize(new Dimension(1600, 70));
        this.add(secaoInferior, BorderLayout.SOUTH);

        botaoConfirmarAssentos = new JButton();
        botaoConfirmarAssentos.setBounds(630, 15, 150, 40);
        botaoConfirmarAssentos.addActionListener(this);
        botaoConfirmarAssentos.setVisible(true);
        botaoConfirmarAssentos.setText("Confirmar");
        botaoConfirmarAssentos.setFocusable(false);
        secaoInferior.add(botaoConfirmarAssentos);

        secaoCentral = new JPanel();
        secaoCentral.setBackground(Color.white);
        secaoCentral.setVisible(true);
        secaoCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        secaoCentral.setPreferredSize(new Dimension(800, 330));
        this.atualizarPainel(0);
        this.add(secaoCentral, BorderLayout.CENTER);

        JPanel secaoLateralDireita = new JPanel();
        secaoLateralDireita.setBackground(Color.black);
        secaoLateralDireita.setVisible(true);
        secaoLateralDireita.setLayout(new FlowLayout());
        secaoLateralDireita.setPreferredSize(new Dimension(100, 400));
        this.add(secaoLateralDireita, BorderLayout.EAST);

        JPanel secaoLateralEsquerda = new JPanel();
        secaoLateralEsquerda.setBackground(Color.darkGray);
        secaoLateralEsquerda.setVisible(true);
        secaoLateralEsquerda.setLayout(new FlowLayout());
        secaoLateralEsquerda.setPreferredSize(new Dimension(100, 400));
        this.add(secaoLateralEsquerda, BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoVoltar) {
            this.atualizarPainel(0);
            this.setVisible(false);
            janela.getPainelEscolherSessao().setVisible(true);
        }
        else if (e.getSource() == botaoConfirmarAssentos) {
            this.setVisible(false);
            janela.getPainelCompra().setVisible(true);
            for (int i = 0; i < 100; i += 1) {
                if (botoesAssentos.get(i).isSelected()) {
                    assentosSelecionados.add(i + 1);
                }
            }
            
            for (Integer a : assentosSelecionados) {
                System.out.print(a);
            }
            janela.getPainelCompra().atualizarPainel(2);
            janela.getPainelCompra().atualizarPainel(4);
        }
    }

    @Override
    public void atualizarPainel(int codigo) {
        secaoCentral.removeAll();

        botoesAssentos = new ArrayList<JCheckBox>();

        for (int i = 0; i < 100; i += 1) {
            JCheckBox assento = new JCheckBox();
            assento.setPreferredSize(new Dimension(20, 20));
            botoesAssentos.add(assento);
        }

        for (int i = 0; i < 100; i += 1) {
            secaoCentral.add(botoesAssentos.get(i));
        }

        JPanel tela = new JPanel();
        tela.setVisible(true);
        tela.setPreferredSize(new Dimension(500, 7));
        tela.setBackground(Color.lightGray);
        secaoCentral.add(tela);
    }
    

    
}
