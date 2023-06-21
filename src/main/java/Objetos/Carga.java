package Objetos;

public class Carga {
    private int identificador;
    private int cliente;
    private int origem;
    private int destino;
    private int peso;
    private double valorDeclarado;
    private int tempoMaximo;
    private int tipoCarga;
    private Prioridade prioridade;
    private Situacao situacao;

    public Carga(int identificador, int cliente, int origem, int destino, int peso, double valorDeclarado,
            int tempoMaximo, int tipoCarga, Prioridade prioridade, Situacao situacao) {
        this.identificador = identificador;
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximo = tempoMaximo;
        this.tipoCarga = tipoCarga;
        this.prioridade = prioridade;
        this.situacao = situacao;
    }
    /**
     * Obtém o identificador da carga.
     *
     * @return O identificador da carga.
     */
    public int getIdentificador() {
        return identificador;
    }
    /**
     * Define o identificador da carga.
     *
     * @param identificador O identificador da carga.
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    /**
     * Obtém o identificador do cliente responsável pela carga.
     *
     * @return O identificador do cliente responsável pela carga.
     */
    public int getCliente() {
        return cliente;
    }
    /**
     * Define o identificador do cliente responsável pela carga.
     *
     * @param cliente O identificador do cliente responsável pela carga.
     */
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    /**
     * Obtém o identificador do local de origem da carga.
     *
     * @return O identificador do local de origem da carga.
     */
    public int getOrigem() {
        return origem;
    }
    /**
     * Define o identificador do local de origem da carga.
     *
     * @param origem O identificador do local de origem da carga.
     */
    public void setOrigem(int origem) {
        this.origem = origem;
    }
    /**
     * Obtém o identificador do local de destino da carga.
     *
     * @return O identificador do local de destino da carga.
     */
    public int getDestino() {
        return destino;
    }
    /**
     * Define o identificador do local de destino da carga.
     *
     * @param destino O identificador do local de destino da carga.
     */
    public void setDestino(int destino) {
        this.destino = destino;
    }
    /**
     * Obtém o peso da carga em quilogramas.
     *
     * @return O peso da carga em quilogramas.
     */
    public double getPeso() {
        return peso;
    }
    /**
     * Define o peso da carga em quilogramas.
     *
     * @param peso O peso da carga em quilogramas.
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    /**
     * Obtém o valor declarado da carga.
     *
     * @return O valor declarado da carga.
     */
    public double getValorDeclarado() {
        return valorDeclarado;
    }
     /**
     * Define o valor declarado da carga.
     *
     * @param valorDeclarado O valor declarado da carga.
     */
    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }
    /**
     * Obtém o tempo máximo para entrega da carga.
     *
     * @return O tempo máximo para entrega da carga.
     */
    public int getTempoMaximo() {
        return tempoMaximo;
    }
    /**
     * Define o tempo máximo para entrega da carga.
     *
     * @param tempoMaximo O tempo máximo para entrega da carga.
     */
    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }
    /**
     * Obtém o tipo de carga.
     *
     * @return O tipo de carga.
     */
    public int getTipoCarga() {
        return tipoCarga;
    }
    /**
     * Define o tipo de carga.
     *
     * @param tipoCarga O tipo de carga.
     */
    public void setTipoCarga(int tipoCarga) {
        this.tipoCarga = tipoCarga;
    }
    /**
     * Obtém a prioridade da carga.
     *
     * @return A prioridade da carga.
     */
    public Prioridade getPrioridade() {
        return prioridade;
    }
    /**
     * Define a prioridade da carga.
     *
     * @param prioridade A prioridade da carga.
     */
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
    /**
     * Obtém a situação atual da carga.
     *
     * @return A situação atual da carga.
     */
    public Situacao getSituacao() {
        return situacao;
    }
    /**
     * Define a situação atual da carga.
     *
     * @param situacao A situação atual da carga.
     */
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

}
