package Objetos;

/**
 * A classe TipoCarga representa um tipo de carga genérico.
 */
public class TipoCarga {
    private int numero;
    private String descricao;

    /**
     * Construtor da classe TipoCarga.
     *
     * @param numero     O número identificador do tipo de carga.
     * @param descricao  A descrição do tipo de carga.
     */
    public TipoCarga(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }

    /**
     * Obtém o número identificador do tipo de carga.
     *
     * @return O número identificador do tipo de carga.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Define o número identificador do tipo de carga.
     *
     * @param numero O número identificador do tipo de carga.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtém a descrição do tipo de carga.
     *
     * @return A descrição do tipo de carga.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do tipo de carga.
     *
     * @param descricao A descrição do tipo de carga.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
