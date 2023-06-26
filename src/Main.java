import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Instanciando a entidade primordial e a sua primeira unidade e respectivo gerente
        Entidade entidade1 = new Entidade("Kino", "Aqui", "9", "@");
        Unidade unidade1 = new Unidade("3", "Aqui", "@", entidade1);
        entidade1.getListaUnidades().add(unidade1);
        Gerente gerente1 = new Gerente(unidade1, "Marcos", "9", 4500, "admin", "admin");

        //Instanciando um vendedor (essa parte vai ser deletada pois sera feita pelo gerente)
        Vendedor vendedor = new Vendedor(unidade1, "Carlos", "3", 1500, "vend", "vend");
        unidade1.getListaFuncionarios().add(vendedor);

        //Instanciando e adicionando as salas da unidade
        Sala sala1 = new Sala(1, 100, false, false);
        Sala sala2 = new Sala(2, 100, true, false);
        Sala sala3 = new Sala(3, 100, false, true);
        Sala sala4 = new Sala(4, 100, true, true);
        Sala[] listaSalas = {sala1, sala2, sala3, sala4};
        for (Sala sala : listaSalas) {
            unidade1.getListaSalas().add(sala);
        }
 

        //Instanciando e adicionando as sessoes da unidade (4 filmes, 5 sessoes cada = 20 sessoes)
        Sessao sessao1 = new Sessao("10:00-12:00", sala1, "Titanic", "path");
        Sessao sessao2 = new Sessao("12:30-14:30", sala2, "Titanic", "path");
        Sessao sessao3 = new Sessao("15:00-17:00", sala3, "Titanic", "path");
        Sessao sessao4 = new Sessao("17:30-19:30", sala4, "Titanic", "path");
        Sessao sessao5 = new Sessao("20:00-22:00", sala1, "Titanic", "path");
        Sessao sessao6 = new Sessao("10:00-12:00", sala2, "Bacurau", "path");
        Sessao sessao7 = new Sessao("12:30-14:30", sala3, "Bacurau", "path");
        Sessao sessao8 = new Sessao("15:00-17:00", sala4, "Bacurau", "path");
        Sessao sessao9 = new Sessao("17:30-19:30", sala1, "Bacurau", "path");
        Sessao sessao10 = new Sessao("20:00-22:00", sala2, "Bacurau", "path");
        Sessao sessao11 = new Sessao("10:00-12:00", sala3, "Vingadores", "path");
        Sessao sessao12 = new Sessao("12:30-14:30", sala4, "Vingadores", "path");
        Sessao sessao13 = new Sessao("15:00-17:00", sala1, "Vingadores", "path");
        Sessao sessao14 = new Sessao("17:30-19:30", sala2, "Vingadores", "path");
        Sessao sessao15 = new Sessao("20:00-22:00", sala3, "Vingadores", "path");
        Sessao sessao16 = new Sessao("10:00-12:00", sala3, "2012", "path");
        Sessao sessao17 = new Sessao("12:30-14:30", sala4, "2012", "path");
        Sessao sessao18 = new Sessao("15:00-17:00", sala1, "2012", "path");
        Sessao sessao19 = new Sessao("17:30-19:30", sala2, "2012", "path");
        Sessao sessao20 = new Sessao("20:00-22:00", sala3, "2012", "path");
        Sessao[] listaSessoes = {sessao1, sessao2, sessao3, sessao4, sessao5, sessao6, sessao7, sessao8, sessao9, sessao10, sessao11, sessao12, sessao13, sessao14, sessao15, sessao16, sessao17, sessao18, sessao19, sessao20};
        for (Sessao sessao : listaSessoes) {
            unidade1.getListaSessoes().add(sessao);
        }

        //Instanciando os consumiveis (EU FIZ MERDA DESCULPA)
        Consumivel consumivel1 = new Consumivel("Pipoca pequena", 10.0);
        Consumivel consumivel2 = new Consumivel("Pipoca média", 10.0);
        Consumivel consumivel3 = new Consumivel("Pipoca grande", 10.0);
        Consumivel consumivel4 = new Consumivel("Pipoca balde", 10.0);
        Consumivel consumivel5 = new Consumivel("Refrigerante", 10.0);
        Consumivel consumivel6 = new Consumivel("Água", 10.0);
        Consumivel consumivel7 = new Consumivel("Suco", 10.0);
        Consumivel consumivel8 = new Consumivel("Chocolate", 10.0);
        Consumivel consumivel9 = new Consumivel("Bala", 10.0);
        Consumivel consumivel10 = new Consumivel("Amendoim", 10.0);
        Consumivel[] listaConsumiveis = {consumivel1, consumivel2, consumivel3, consumivel4, consumivel5, consumivel6, consumivel7, consumivel8, consumivel9, consumivel10};
        for (Consumivel consumivel : listaConsumiveis) {
            unidade1.getListaConsumivel().add(consumivel);
        }

        //new Janela(entidade1, null);

        new JanelaMatheus(unidade1);
    }
}
