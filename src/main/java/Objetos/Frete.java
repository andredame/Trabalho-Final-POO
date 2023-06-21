package Objetos;

public class Frete {
    private Distancia distancia;
    private Carga carga;
    private Porto porto;
    private Navio navio;
    private TipoCarga tipoCarga;
    private Porto portoOrigem;

    private double valorDoFrete;

    private double precoDistancia;
    private double precoPeso;
    private double precoCustoRegiao;

    public Frete(Distancia distancia, Carga carga, Porto porto, Navio navio, TipoCarga tipoCarga,Porto portoOrigem) {
        this.distancia = distancia;
        this.carga = carga;
        this.porto = porto;
        this.navio = navio;
        this.tipoCarga = tipoCarga;
        this.portoOrigem=portoOrigem;
    }

    public double getValorDoFrete() {
        return valorDoFrete;
    }

    public void calculaFrete() {
        precoDistancia();
        precoPeso();
        precoCustoRegiao();
        this.valorDoFrete = precoDistancia + precoPeso + precoCustoRegiao;

    }

    private void precoDistancia() {
        if (carga.getPrioridade() == Prioridade.RAPIDO) {
            this.precoDistancia = distancia.getDistancia() * navio.getCustoPorMilhaBasico() * 2;
        } else {
            this.precoDistancia = distancia.getDistancia() * navio.getCustoPorMilhaBasico();
        }

    }

    private void precoPeso() {

        if (tipoCarga instanceof Duravel) {
            Duravel aux = (Duravel) tipoCarga;
            this.precoPeso = carga.getPeso() * 1.5 + aux.getPercentualImposto();
        } else {
            this.precoPeso = carga.getPeso() * 2;
        }

    }

    private void precoCustoRegiao() {
        if (porto.getPais().equalsIgnoreCase("brasil")&& portoOrigem.getPais().equalsIgnoreCase("brasil")) {
            this.precoCustoRegiao = 10.000;
        } else {
            this.precoCustoRegiao = 50.000;
        }

    }
}
