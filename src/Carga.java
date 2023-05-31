public class Carga {
    private int identificador;
    private int peso;
    private double valorDeclarado;
    private int tempoMaximo;
    private TipoCarga tipoCarga;

    public Carga(int identificador, int peso, double valorDeclarado, int tempoMaximo, TipoCarga tipoCarga) {
        this.identificador = identificador;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
        this.tempoMaximo = tempoMaximo;
        this.tipoCarga=tipoCarga;
    }

    public double calculaPrecoFrete() {

        return calculaPrecoDistancia()+calculaPrecoPeso()+calculaPrecoRegiao();
    }

    public double calculaPrecoDistancia() {
        return 0.0;
    }

    public double calculaPrecoPeso() {
        if (tipoCarga instanceof Perecivel){
            return peso*2.0;
        }else if (tipoCarga instanceof Duravel){
            Duravel aux=(Duravel) tipoCarga;
            return peso*1.5*aux.getPercentualImposto();
        }else{
           return 0.0;
        }
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

    public int getPeso() {
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
