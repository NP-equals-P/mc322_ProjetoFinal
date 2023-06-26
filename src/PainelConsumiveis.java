import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelConsumiveis extends JPanel implements ActionListener{
    JanelaMatheus janela;
    JButton botaoVoltar;
    JButton botaoAdicionar;
    JPanel secaoPipoca;
    JPanel secaoBebida;
    JPanel secaoOutro;
    JButton botaoPipocaPequena;
    JButton botaoPipocaMedia;
    JButton botaoPipocaGrande;
    JButton botaoPipocaBalde;
    JButton botaoRefrigerante;
    JButton botaoAgua;
    JButton botaoSuco;
    JButton botaoChocolate; 
    JButton botaoBala;   
    JButton botaoAmendoim;

    PainelConsumiveis(JanelaMatheus janela) {
        this.janela = janela;

        this.setBackground(Color.pink);
        this.setBounds(0, 0, 800, 450);
        this.setLayout(null);
        this.setVisible(false);

        JPanel secaoSuperior = new JPanel();
        secaoSuperior.setLayout(null);
        secaoSuperior.setBackground(Color.black);
        secaoSuperior.setVisible(true);
        secaoSuperior.setBounds(0, 0, 800, 50);
        this.add(secaoSuperior);

        botaoVoltar = new JButton();
        botaoVoltar.setBounds(10, 10, 100, 30);
        botaoVoltar.addActionListener(this);
        botaoVoltar.setVisible(true);
        botaoVoltar.setText("Voltar");
        botaoVoltar.setFocusable(false);
        secaoSuperior.add(botaoVoltar);

        secaoPipoca = new JPanel();
        secaoPipoca.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 110));
        secaoPipoca.setBounds(0, 50, 800, 400);
        secaoPipoca.setVisible(false);
        secaoPipoca.setBackground(Color.orange);
        this.add(secaoPipoca);

        botaoPipocaPequena = new JButton();
        botaoPipocaPequena.setText("Pipoca pequena");
        botaoPipocaPequena.setFocusable(false);
        botaoPipocaPequena.setPreferredSize(new Dimension(150, 150));
        botaoPipocaPequena.setVisible(true);
        botaoPipocaPequena.addActionListener(this);
        secaoPipoca.add(botaoPipocaPequena);

        botaoPipocaMedia = new JButton();
        botaoPipocaMedia.setText("Pipoca média");
        botaoPipocaMedia.setFocusable(false);
        botaoPipocaMedia.setPreferredSize(new Dimension(150, 150));
        botaoPipocaMedia.setVisible(true);
        botaoPipocaMedia.addActionListener(this);
        secaoPipoca.add(botaoPipocaMedia);

        botaoPipocaGrande = new JButton();
        botaoPipocaGrande.setText("Pipoca grande");
        botaoPipocaGrande.setFocusable(false);
        botaoPipocaGrande.setPreferredSize(new Dimension(150, 150));
        botaoPipocaGrande.setVisible(true);
        botaoPipocaGrande.addActionListener(this);
        secaoPipoca.add(botaoPipocaGrande);

        botaoPipocaBalde = new JButton();
        botaoPipocaBalde.setText("Pipoca balde");
        botaoPipocaBalde.setFocusable(false);
        botaoPipocaBalde.setPreferredSize(new Dimension(150, 150));
        botaoPipocaBalde.setVisible(true);
        botaoPipocaBalde.addActionListener(this);
        secaoPipoca.add(botaoPipocaBalde);

        secaoBebida = new JPanel();
        secaoBebida.setLayout(new FlowLayout(FlowLayout.CENTER, 55, 110));
        secaoBebida.setBounds(0, 50, 800, 400);
        secaoBebida.setVisible(false);
        secaoBebida.setBackground(Color.blue);
        this.add(secaoBebida);

        botaoRefrigerante = new JButton();
        botaoRefrigerante.setText("Refrigerante");
        botaoRefrigerante.setFocusable(false);
        botaoRefrigerante.setPreferredSize(new Dimension(150, 150));
        botaoRefrigerante.setVisible(true);
        botaoRefrigerante.addActionListener(this);
        secaoBebida.add(botaoRefrigerante);

        botaoAgua = new JButton();
        botaoAgua.setText("Água");
        botaoAgua.setFocusable(false);
        botaoAgua.setPreferredSize(new Dimension(150, 150));
        botaoAgua.setVisible(true);
        botaoAgua.addActionListener(this);
        secaoBebida.add(botaoAgua);

        botaoSuco = new JButton();
        botaoSuco.setText("Suco");
        botaoSuco.setFocusable(false);
        botaoSuco.setPreferredSize(new Dimension(150, 150));
        botaoSuco.setVisible(true);
        botaoSuco.addActionListener(this);
        secaoBebida.add(botaoSuco);

        secaoOutro = new JPanel();
        secaoOutro.setLayout(new FlowLayout(FlowLayout.CENTER, 55, 110));
        secaoOutro.setBounds(0, 50, 800, 400);
        secaoOutro.setVisible(false);
        secaoOutro.setBackground(Color.magenta);
        this.add(secaoOutro);

        botaoChocolate = new JButton();
        botaoChocolate.setText("Chocolate");
        botaoChocolate.setFocusable(false);
        botaoChocolate.setPreferredSize(new Dimension(150, 150));
        botaoChocolate.setVisible(true);
        botaoChocolate.addActionListener(this);
        secaoOutro.add(botaoChocolate);

        botaoBala = new JButton();
        botaoBala.setText("Bala");
        botaoBala.setFocusable(false);
        botaoBala.setPreferredSize(new Dimension(150, 150));
        botaoBala.setVisible(true);
        botaoBala.addActionListener(this);
        secaoOutro.add(botaoBala);

        botaoAmendoim = new JButton();
        botaoAmendoim.setText("Amendoim");
        botaoAmendoim.setFocusable(false);
        botaoAmendoim.setPreferredSize(new Dimension(150, 150));
        botaoAmendoim.setVisible(true);
        botaoAmendoim.addActionListener(this);
        secaoOutro.add(botaoAmendoim);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoVoltar) {
            this.setVisible(false);
            secaoPipoca.setVisible(false);
            secaoBebida.setVisible(false);
            secaoOutro.setVisible(false);
            janela.getPainelCategorias().setVisible(true);
        }
        else {
            adicionarConsumivel(((JButton)e.getSource()).getText(), janela);
            //janela.getPainelCategorias().atualizarPainel(0);
            this.setVisible(false);
            secaoPipoca.setVisible(false);
            secaoBebida.setVisible(false);
            secaoOutro.setVisible(false);
            janela.getPainelCategorias().setVisible(true);

        }
    }

    public void estadoPipoca() {
        secaoPipoca.setVisible(true);
    }

    public void estadoBebida() {
        secaoBebida.setVisible(true);
    }

    public void estadoOutro() {
        secaoOutro.setVisible(true);
    }
    
    static void adicionarConsumivel(String nome, JanelaMatheus janela) {
        if (nome.equals("Pipoca pequena")) {
            PainelComplexo aux = new PainelComplexo(0, janela, "Pipoca pequena");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[0] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[0] += 1;
                aux.atualizarNome();
            }
        }
        else if (nome.equals("Pipoca média")) {
            PainelComplexo aux = new PainelComplexo(1, janela, "Pipoca média");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[1] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[1] += 1;
                aux.atualizarNome();
            }
        }
        else if (nome.equals("Pipoca grande")) {
            PainelComplexo aux = new PainelComplexo(2, janela, "Pipoca grande");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[2] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[2] += 1;
                aux.atualizarNome(); 
            }
        }
        else if (nome.equals("Pipoca balde")) {
            PainelComplexo aux = new PainelComplexo(3, janela, "Pipoca balde");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[3] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[3] += 1;
                aux.atualizarNome();
            }
        }
        else if (nome.equals("Refrigerante")) {
            PainelComplexo aux = new PainelComplexo(4, janela, "Refrigerante");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[4] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[4] += 1;
                aux.atualizarNome();
            } 
        }
        else if (nome.equals("Água")) {
            PainelComplexo aux = new PainelComplexo(5, janela, "Água");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[5] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[5] += 1;
                aux.atualizarNome();
            } 
        }
        else if (nome.equals("Suco")) {
            PainelComplexo aux = new PainelComplexo(6, janela, "Suco");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[6] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[6] += 1;
                aux.atualizarNome();
            } 
        }
        else if (nome.equals("Chocolate")) {
            PainelComplexo aux = new PainelComplexo(7, janela, "Chocolate");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[7] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[7] += 1;
                aux.atualizarNome();
            } 
        }
        else if (nome.equals("Bala")) {
            PainelComplexo aux = new PainelComplexo(8, janela, "Bala");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[8] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[8] += 1;
                aux.atualizarNome();
            } 
        }
        else if (nome.equals("Amendoim")) {
            PainelComplexo aux = new PainelComplexo(9, janela, "Amendoim");
            if (janela.getPainelVendedor().getQuantidadeConsumiveis()[9] == 0) {
                janela.getPainelCategorias().secaoListarMovel.add(aux);
                janela.getPainelVendedor().getQuantidadeConsumiveis()[9] += 1;
                aux.atualizarNome();
            } 
        }
    }
}
