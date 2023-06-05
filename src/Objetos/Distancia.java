package Objetos;

public class Distancia {
    private String origem;
    

    private String destino;
    
    private double distancia;

    public Distancia(String origem, String destino, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }


    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getDestino() {
        return destino;
    }



}
