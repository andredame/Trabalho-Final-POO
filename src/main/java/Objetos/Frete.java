package Objetos;

public class Frete {
    private Distancia distancia;
    private Cliente cliente;
    private Carga carga;
    private Porto porto;
    private Navio navio;
    private TipoCarga tipoCarga;

    private double valorDoFrete;

    private double precoDistancia;
    private double precoPeso;
    private double precoCustoRegiao;

    public Frete(Distancia distancia, Carga carga, Porto porto, Navio navio, TipoCarga tipoCarga) {
        this.distancia = distancia;
        this.carga = carga;
        this.porto = porto;
        this.navio = navio;
        this.tipoCarga = tipoCarga;
    }

    public double calculaFrete() {

        return 1.0;

    }

    public double precoDistancia() {
        if (carga.getPrioridade() == Prioridade.RAPIDO) {
            return distancia.getDistancia() * navio.getCustoPorMilhaBasico() * 2;
        }

        return distancia.getDistancia() * navio.getCustoPorMilhaBasico();

    }

    public double precoPeso(){

        if (tipoCarga instanceof Duravel) {
            Duravel aux=(Duravel) tipoCarga; 
            return carga.getPeso()*1.5+aux.getPercentualImposto();
        }
        return carga.getPeso()*2;
    }
}
