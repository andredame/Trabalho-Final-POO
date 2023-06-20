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

    public double calculaPrecoFrete() {

        return calculaPrecoDistancia()+calculaPrecoPeso()+calculaPrecoRegiao();
    }

    public double calculaPrecoDistancia() {
        return 0.0;
    }

    public double calculaPrecoPeso() {
        return 0.0;
    }

    public double calculaPrecoRegiao() {
       return 0.0;
    }


    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public void setValorDeclarado(double valorDeclarado) {
        this.valorDeclarado = valorDeclarado;
    }

    public int getTempoMaximo() {
        return tempoMaximo;
    }

    public void setTempoMaximo(int tempoMaximo) {
        this.tempoMaximo = tempoMaximo;
    }

    public int getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(int tipoCarga) {
        this.tipoCarga = tipoCarga;
    }
    
    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Situacao getSituacao() {
        return situacao;
    }

    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }


}
