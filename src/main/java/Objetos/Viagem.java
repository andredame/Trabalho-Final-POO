package Objetos;

/**
 * A classe Viagem representa uma viagem de transporte de carga.
 */
public class Viagem {
    private Distancia distancia;
    private Navio navio;
    private Cliente cliente;
    private TipoCarga tipoCarga;
    private Carga carga;
    private Frete frete;
    private Porto portoOrigem;
    private Porto portoDestino;

    /**
     * Construtor da classe Viagem.
     *
     * @param frete         O objeto Frete relacionado à viagem.
     * @param distancia     O objeto Distancia que representa a distância da viagem.
     * @param navio         O objeto Navio utilizado na viagem.
     * @param cliente       O objeto Cliente que realizou a viagem.
     * @param tipoCarga     O objeto TipoCarga representando o tipo de carga transportada.
     * @param carga         O objeto Carga que está sendo transportada na viagem.
     * @param portoOrigem   O objeto Porto de origem da viagem.
     * @param portoDestino  O objeto Porto de destino da viagem.
     */
    public Viagem(Frete frete, Distancia distancia, Navio navio, Cliente cliente, TipoCarga tipoCarga, Carga carga,
                  Porto portoOrigem, Porto portoDestino) {
        this.frete = frete;
        this.distancia = distancia;
        this.navio = navio;
        this.cliente = cliente;
        this.tipoCarga = tipoCarga;
        this.carga = carga;
        this.portoOrigem = portoOrigem;
        this.portoDestino = portoDestino;
    }

    /**
     * Obtém o objeto Frete relacionado à viagem.
     *
     * @return O objeto Frete relacionado à viagem.
     */
    public Frete getFrete() {
        return frete;
    }

    /**
     * Define o objeto Frete relacionado à viagem.
     *
     * @param frete O objeto Frete relacionado à viagem.
     */
    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    /**
     * Obtém o objeto Porto de origem da viagem.
     *
     * @return O objeto Porto de origem da viagem.
     */
    public Porto getPortoOrigem() {
        return portoOrigem;
    }

    /**
     * Define o objeto Porto de origem da viagem.
     *
     * @param portoOrigem O objeto Porto de origem da viagem.
     */
    public void setPortoOrigem(Porto portoOrigem) {
        this.portoOrigem = portoOrigem;
    }

    /**
     * Obtém o objeto Porto de destino da viagem.
     *
     * @return O objeto Porto de destino da viagem.
     */
    public Porto getPortoDestino() {
        return portoDestino;
    }

    /**
     * Define o objeto Porto de destino da viagem.
     *
     * @param portoDestino O objeto Porto de destino da viagem.
     */
    public void setPortoDestino(Porto portoDestino) {
        this.portoDestino = portoDestino;
    }

    /**
     * Obtém o objeto Distancia que representa a distância da viagem.
     *
     * @return O objeto Distancia que representa a distância da viagem.
     */
    public Distancia getDistancia() {
        return distancia;
    }

    /**
     * Define o objeto Distancia que representa a distância da viagem.
     *
     * @param distancia O objeto Distancia que representa a distância da viagem.
     */
    public void setDistancia(Distancia distancia) {
        this.distancia = distancia;
    }

    /**
     * Obtém o objeto Navio utilizado na viagem.
     *
     * @return O objeto Navio utilizado na viagem.
     */
    public Navio getNavio() {
        return navio;
    }

    /**
     * Define o objeto Navio utilizado na viagem.
     *
     * @param navio O objeto Navio utilizado na viagem.
     */
    public void setNavio(Navio navio) {
        this.navio = navio;
    }

    /**
     * Obtém o objeto Cliente que realizou a viagem.
     *
     * @return O objeto Cliente que realizou a viagem.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o objeto Cliente que realizou a viagem.
     *
     * @param cliente O objeto Cliente que realizou a viagem.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtém o objeto TipoCarga representando o tipo de carga transportada.
     *
     * @return O objeto TipoCarga representando o tipo de carga transportada.
     */
    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }

    /**
     * Define o objeto TipoCarga representando o tipo de carga transportada.
     *
     * @param tipoCarga O objeto TipoCarga representando o tipo de carga transportada.
     */
    public void setTipoCarga(TipoCarga tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    /**
     * Obtém o objeto Carga que está sendo transportada na viagem.
     *
     * @return O objeto Carga que está sendo transportada na viagem.
     */
    public Carga getCarga() {
        return carga;
    }

    /**
     * Define o objeto Carga que está sendo transportada na viagem.
     *
     * @param carga O objeto Carga que está sendo transportada na viagem.
     */
    public void setCarga(Carga carga) {
        this.carga = carga;
    }
}
