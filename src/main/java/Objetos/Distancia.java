package Objetos;
/**
 * A classe Distancia representa a distância entre dois portos.
 */
public class Distancia {
    private int origem;
    

    private int destino;
    
    private double distancia;

    public Distancia(int origem, int destino, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    /**
     * Obtém a distância entre os locais.
     *
     * @return A distância entre os locais.
     */
    public double getDistancia() {
        return distancia;
    }
    /**
     * Define a distância entre os locais.
     *
     * @param distancia A distância entre os locais.
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    /**
     * Obtém o identificador do local de origem.
     *
     * @return O identificador do local de origem.
     */
    public int getOrigem() {
        return origem;
    }
    /**
     * Define o identificador do local de origem.
     *
     * @param origem O identificador do local de origem.
     */
    public void setOrigem(int origem) {
        this.origem = origem;
    }
    /**
     * Obtém o identificador do local de destino.
     *
     * @return O identificador do local de destino.
     */
    public int getDestino() {
        return destino;
    }



}
