public class Sala {
    private final int id;
    private double preco;
    private int numAssentos;
    private boolean ehVIP;
    private boolean eh3D;


    public Sala(int id, int numAssentos, boolean eh3D, boolean ehVIP) {
        this.id = id;
        this.preco = 30;
        this.numAssentos = numAssentos;
        this.eh3D = eh3D;
        this.ehVIP = ehVIP;
    }

    public int getId() {
        return id;
    }

    public double getPreco() {
        return preco;
    }

    public int getNumAssentos() {
        return numAssentos;
    }

    public boolean getEhVIP() {
        return ehVIP;
    }

    public boolean getEh3D() {
        return eh3D;
    }

    /*
    Atualiza o preço da sala com base nas características
    */
    public void calcularPreco() {
        if (eh3D == true) {
            preco = (preco * 1.5);
        }
        if (ehVIP == true) {
            preco = (preco * 2);
        }
    }
}
