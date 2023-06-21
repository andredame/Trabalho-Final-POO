package Objetos;

/**
 * A classe Porto representa um porto marítimo.
 */
public class Porto {
    private int id;
    private String nome;
    private String pais;

    /**
     * Construtor da classe Porto.
     *
     * @param id    O identificador do porto.
     * @param nome  O nome do porto.
     * @param pais  O país onde o porto está localizado.
     */
    public Porto(int id, String nome, String pais) {
        this.id = id;
        this.nome = nome;
        this.pais = pais;
    }

    /**
     * Obtém o identificador do porto.
     *
     * @return O identificador do porto.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o identificador do porto.
     *
     * @param id O identificador do porto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do porto.
     *
     * @return O nome do porto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do porto.
     *
     * @param nome O nome do porto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o país onde o porto está localizado.
     *
     * @return O país onde o porto está localizado.
     */
    public String getPais() {
        return pais;
    }

    /**
     * Define o país onde o porto está localizado.
     *
     * @param pais O país onde o porto está localizado.
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
}
