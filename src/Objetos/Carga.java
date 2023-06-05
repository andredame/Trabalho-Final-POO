package Objetos;
public class Carga {
    private int identificador;
    private String Cliente;
    private String origem;
    private String destino;
    private double peso;
    private double valorDeclarado;
    private int tempoMaximo;
    private String tipoCarga;
    private Prioridade p;
    private Situacao s;
    
    public Carga(int identificador, String cliente, String origem, String destino, double peso, double valorDeclarado,
            int tempoMaximo, String tipoCarga, Prioridade p, Situacao s) {
        this.identificador = identificador;
        Cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximo = tempoMaximo;
        this.tipoCarga = tipoCarga;
        this.p = p;
        this.s = s;
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
}
