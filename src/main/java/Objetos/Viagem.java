package Objetos;

public class Viagem {
    private Distancia distancia;
    private Navio navio;
    private Cliente cliente;
    private TipoCarga tipoCarga;
    private Carga carga;

    public Viagem(Distancia distancia, Navio navio, Cliente cliente, TipoCarga tipoCarga, Carga carga,Prioridade p,Situacao s) {
        this.distancia = distancia;
        this.navio = navio;
        this.cliente = cliente;
        this.tipoCarga = tipoCarga;
        this.carga = carga;
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
