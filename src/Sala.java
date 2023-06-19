public class Sala {
    private int numeroSala;
    private boolean eh3D;
    private int numeroAssentos;

    public Sala(int numeroSala, boolean eh3D, int numeroAssentos) {
        this.numeroSala = numeroSala;
        this.eh3D = eh3D;
        this.numeroAssentos = numeroAssentos;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public boolean isEh3D() {
        return eh3D;
    }

    public void setEh3D(boolean eh3D) {
        this.eh3D = eh3D;
    }

    public int getNumeroAssentos() {
        return numeroAssentos;
    }

    public void setNumeroAssentos(int numeroAssentos) {
        this.numeroAssentos = numeroAssentos;
    }
}
