package Objetos;

/**
 * A classe Frete representa o frete de transporte de carga entre portos.
 */
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

    /**
     * Construtor da classe Frete.
     *
     * @param distancia     O objeto Distancia que representa a distância do frete.
     * @param carga         O objeto Carga que está sendo transportada no frete.
     * @param porto         O objeto Porto de destino do frete.
     * @param navio         O objeto Navio utilizado no frete.
     * @param tipoCarga     O objeto TipoCarga representando o tipo de carga transportada.
     * @param portoOrigem   O objeto Porto de origem do frete.
     */
    public Frete(Distancia distancia, Carga carga, Porto porto, Navio navio, TipoCarga tipoCarga, Porto portoOrigem) {
        this.distancia = distancia;
        this.carga = carga;
        this.porto = porto;
        this.navio = navio;
        this.tipoCarga = tipoCarga;
        this.portoOrigem = portoOrigem;
    }

    /**
     * Obtém o valor do frete.
     *
     * @return O valor do frete.
     */
    public double getValorDoFrete() {
        return valorDoFrete;
    }

    /**
     * Calcula o valor do frete com base nos preços de distância, peso e custo da região.
     */
    public void calculaFrete() {
        precoDistancia();
        precoPeso();
        precoCustoRegiao();
        this.valorDoFrete = precoDistancia + precoPeso + precoCustoRegiao;
    }
    /**
     * Calcula o preço baseado na distancia do frete.
     * O preço é duplicado se a carga tiver prioridade "RÁPIDO".
     */
    private void precoDistancia() {
        if (carga.getPrioridade() == Prioridade.RAPIDO) {
            this.precoDistancia = distancia.getDistancia() * navio.getCustoPorMilhaBasico() * 2;
        } else {
            this.precoDistancia = distancia.getDistancia() * navio.getCustoPorMilhaBasico();
        }
    }
    /**
     * Calcula o preço baseado no peso da carga.
     * Se a carga for do tipo Duravel, o preço é multiplicado por 1.5 e adicionado ao percentual de imposto.
     * Caso contrário, o preço é multiplicado por 2.
     */
    private void precoPeso() {
        if (tipoCarga instanceof Duravel) {
            Duravel aux = (Duravel) tipoCarga;
            this.precoPeso = carga.getPeso() * 1.5 + aux.getPercentualImposto();
        } else {
            this.precoPeso = carga.getPeso() * 2;
        }
    }

    /**
     * Calcula o preço baseado no custo da região.
     * Se o porto de origem e o porto de destino estiverem no Brasil, o preço é de 10.000.
     * Caso contrário, o preço é de 50.000.
     */
    private void precoCustoRegiao() {
        if (porto.getPais().equalsIgnoreCase("brasil") && portoOrigem.getPais().equalsIgnoreCase("brasil")) {
            this.precoCustoRegiao = 10_000;
        } else {
            this.precoCustoRegiao = 50_000;
        }
    }
}
