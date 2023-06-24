import java.util.List;

public class Main {
    public static void main(String[] args) {
        Entidade entity = new Entidade("Fachada's Cinema", "Rua Santa Menefreda", "(11) 91102-0413",
                "fachada@gmail.com");
        Unidade u1 = new Unidade("07.305.383/0001-55", "Avenida Hill Valley", "fachadinha@gmail.com",entity);
        System.out.println("AAAAAAAAAAAAA");
        Compra compra = new Compra();
        compra.imprimir();
        u1.imprimir();
        entity.imprimir();
//        new Janela(entity,"Teste");

        List<String> arquivo = Sessao.lerFilmes();
        for (int i=0; i < arquivo.size(); i++) {
            System.out.println(arquivo.get(i)+"\n");
        }
    }
}