package Objetos;

public class Viagem {
    private Distancia distancia;
    private Navio navio;
    private Cliente cliente;
    private TipoCarga tipoCarga;
    private Carga carga;
    private Frete frete;
    private Porto portoOrigem;
    private Porto portoDestino;
    public Viagem(Frete frete,Distancia distancia, Navio navio, Cliente cliente, TipoCarga tipoCarga, Carga carga,Porto portoOrigem, Porto portoDestino) {
        this.frete=frete;
        this.distancia = distancia;
        this.navio = navio;
        this.cliente = cliente;
        this.tipoCarga = tipoCarga;
        this.carga = carga;
        this.portoOrigem=portoOrigem;
        this.portoDestino=portoDestino;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    public Porto getPortoOrigem() {
        return portoOrigem;
    }

    public void setPortoOrigem(Porto portoOrigem) {
        this.portoOrigem = portoOrigem;
    }

    public Porto getPortoDestino() {
        return portoDestino;
    }

    public void setPortoDestino(Porto portoDestino) {
        this.portoDestino = portoDestino;
    }

    public Distancia getDistancia() {
        return distancia;
    }

    public void setDistancia(Distancia distancia) {
        this.distancia = distancia;
    }

    public Navio getNavio() {
        return navio;
    }

    public void setNavio(Navio navio) {
        this.navio = navio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(TipoCarga tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }

}
