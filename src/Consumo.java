public enum Consumo {
    /*
    Qualquer tipo de gasto que não seja o ingresso para uma sessão
    Ex: Balde de pipoca, refrigerante, etc
     */
    PIPOCA_GRANDE("Balde de pipoca, Grande"),
    PIPOCA_MEDIA("Balde de pipoca, Médio"),
    PIPOCA_PEQUENA("Balde de pipoca, Pequeno"),
    REFRI_GRANDE("Refrigerante, Grande"),
    REFRI_MEDIA("Refrigerante, Médio"),
    REFRI_PEQUENO("Refrigerante, Pequeno"),
    CHOCOLATE("Barra de chocolate"),
    OUTRO("Outro");
    /*
     Talvez nem precise desse outro
     Talvez precise de mais constantes
     Se for ter o outro, podemos colocar na interface pra pessoa escrever
     oq está sendo comprado
     */


    private final String consumivel;

    Consumo(String consumivel) {
        this.consumivel = consumivel;
    }

    public String getConsumivel() {
        return this.consumivel;
    }
}
