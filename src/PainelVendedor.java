import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelVendedor extends JPanel implements ActionListener, atualizar{
    JanelaMatheus janela;
    //Vendedor vendedorLogado;
    int filmeSelecionado;
    int sessaoSelecionada;
    double totalCompra = 0.0;
    double totalIngressos = 0.0;
    double totalConsumiveis = 0.0;
    //ArrayList<Ingresso> listaIngressos = new ArrayList<Ingresso>();
    //ArrayList<Consumivel> listaConsumiveis = new ArrayList<Consumivel>();
    Integer[] quantidadesConsumiveis = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    Integer[] quantidadesIngressos = {0, 0, 0, 0, 0, 0};

    JButton botaoVoltar;
    JButton boatoCompra;
    JButton botaoFilme1;
    JButton botaoFilme2;
    JButton botaoFilme3;
    JButton botaoFilme4;
    JLabel comissao;
    JPanel secaoCentral;

    PainelVendedor(JanelaMatheus janela) {
        this.janela = janela;

        this.setBackground(Color.blue);
        this.setBounds(0, 0, 800, 450);
        this.setVisible(false);
        this.setLayout(new BorderLayout());
        
        JPanel secaoSuperior = new JPanel();
        secaoSuperior.setBackground(Color.black);
        secaoSuperior.setVisible(true);
        secaoSuperior.setLayout(null);
        secaoSuperior.setPreferredSize(new Dimension(100, 50));
        this.add(secaoSuperior, BorderLayout.NORTH);

        secaoCentral = new JPanel();
        secaoCentral.setBackground(Color.gray);
        secaoCentral.setVisible(true);
        secaoCentral.setLayout(new FlowLayout(FlowLayout.CENTER, 24, 30));
        secaoCentral.setPreferredSize(new Dimension(100, 283));
        this.add(secaoCentral, BorderLayout.CENTER);
        

        botaoFilme1 = new JButton();
        botaoFilme1.setPreferredSize(new Dimension(170, 240));
        botaoFilme1.addActionListener(this);
        botaoFilme1.setVisible(true);
        botaoFilme1.setText("1");
        botaoFilme1.setFocusable(false);
        secaoCentral.add(botaoFilme1);

        ImageIcon cartaz1 = new ImageIcon("avengers.png");
        botaoFilme1.setIcon(cartaz1);

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
        
        JPanel secaoInferior = new JPanel();
        secaoInferior.setBackground(Color.black);
        secaoInferior.setVisible(true);
        secaoInferior.setLayout(null);
        secaoInferior.setPreferredSize(new Dimension(800, 100));
        this.add(secaoInferior, BorderLayout.SOUTH);

        comissao = new JLabel("(R$" + 0 + ")");
        comissao.setVisible(true);
        comissao.setBounds(720, 25, 100, 20);
        secaoInferior.add(comissao);
        
        botaoVoltar = new JButton();
        botaoVoltar.setBounds(10, 10, 60, 30);
        botaoVoltar.addActionListener(this);
        botaoVoltar.setVisible(true);
        botaoVoltar.setText("Sair");
        botaoVoltar.setFocusable(false);
        secaoSuperior.add(botaoVoltar);

        boatoCompra = new JButton();
        boatoCompra.setBounds(300, 10, 200, 50);
        boatoCompra.addActionListener(this);
        boatoCompra.setVisible(true);
        boatoCompra.setText("Realizar compra");
        boatoCompra.setFocusable(false);
        secaoInferior.add(boatoCompra);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoVoltar) {
            //this.setVendedorLogado(null);
            this.setVisible(false);
            janela.getPainelLogin().setVisible(true);
        }
        else if (e.getSource() == boatoCompra) {
            //janela.getPainelCompra().atualizarPainel(0);
            filmeSelecionado = 0;
            sessaoSelecionada = 0;
            this.setVisible(false);
            janela.getPainelCompra().setVisible(true);
        }
        else {
            //janela.getPainelSessoesDisponiveis().atualizarPainel(0);
            //this.filmeSelecionado = Integer.parseInt(((JButton) e.getSource()).getText());
            this.setVisible(false);
            janela.getPainelSessoesDisponiveis().setVisible(true);
        }
    }
    
    public void atualizarPainel(int codigo) {
        // if (codigo == 0) {
        //      JButton[] listaBotoes = {botaoFilme1, botaoFilme2, botaoFilme3, botaoFilme4};
        //      for (JButton botaoFilme : listaBotoes) {
        //          ImageIcon cartaz = new ImageIcon(unidade.acharCartaz(Integer.parseInt(botaoFilme.getText())));
        //          botaoFilme.setIcon(cartaz);
        // }
        // else {
        //      comissao.setText("(R$" + vendedorLogado.getComissao() + ")"); 
        // }
        // 
        //
    }
    
    //public void setVendedorLogado(Vendedor vendedorLogado) {
    //    this.vendedorLogado = vendedorLogado;
    //}

    public Integer[] getQuantidadeConsumiveis() {
        return quantidadesConsumiveis;
    }

    public void zerarQuantidadeConsumiveis() {
        for (int i = 0; i < 10; i += 1) {  
            quantidadesConsumiveis[i] = 0;
        }
    }

    public void setFilmeSelecionado(int codigo) {
        this.filmeSelecionado = codigo;
    }

    public void setSessaoSelecionado(int codigo) {
        this.sessaoSelecionada = codigo;
    }

    public void setTotalCompra(Double valor) {
        this.totalCompra = valor;
    }

    public void setTotalConsumiveis(Double valor) {
        this.totalConsumiveis = valor;
    }

    public void setTotalIngressos(Double valor) {
        this.totalIngressos = valor;
    }

} 
