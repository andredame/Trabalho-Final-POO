package Objetos;

/**
 * A classe Cliente representa um cliente que solicita o transporte de cargas.
 */
public class Cliente {
    private int cod;
    private String nome;
    private String email;

    public Cliente(int cod, String nome, String email) {
        this.cod = cod;
        this.nome = nome;
        this.email = email;
    }

    /**
     * Obtém o código identificador do cliente.
     *
     * @return O código identificador do cliente.
     */
    public int getCod() {
        return cod;
    }

    /**
     * Define o código identificador do cliente.
     *
     * @param cod O código identificador do cliente.
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * Obtém o nome do cliente.
     *
     * @return O nome do cliente.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do cliente.
     *
     * @param nome O nome do cliente.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o endereço de email do cliente.
     *
     * @return O endereço de email do cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de email do cliente.
     *
     * @param email O endereço de email do cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
