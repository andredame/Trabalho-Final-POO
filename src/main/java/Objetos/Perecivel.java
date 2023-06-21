package Objetos;
public class Perecivel extends TipoCarga {
    private String origem;
    private int validade;
    /**
     * Construtor da classe Perecivel.
     *
     * @param numero     O número identificador do tipo de carga.
     * @param descricao  A descrição do tipo de carga.
     * @param origem     A origem do tipo de carga perecível.
     * @param validade   O tempo de validade do tipo de carga perecível.
     */
    public Perecivel(int numero, String descricao, String origem, int validade) {
        super(numero, descricao);
        this.origem = origem;
        this.validade = validade;
    }
    /**
     * Obtém a origem do tipo de carga perecível.
     *
     * @return A origem do tipo de carga perecível.
     */
    public String getOrigem() {
        return origem;
    }

    /**
     * Define a origem do tipo de carga perecível.
     *
     * @param origem A origem do tipo de carga perecível.
     */
    public void setOrigem(String origem) {
        this.origem = origem;
    }

    /**
     * Obtém a validade do tipo de carga perecível.
     *
     * @return A validade do tipo de carga perecível.
     */
    public int getValidade() {
        return validade;
    }
    /**
     * Define a validade do tipo de carga perecível.
     *
     * @param validade A validade do tipo de carga perecível.
     */
    public void setValidade(int validade) {
        this.validade = validade;
    }


}
