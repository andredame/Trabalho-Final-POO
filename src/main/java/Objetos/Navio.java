package Objetos;

/**
 * Navio
 */
public class Navio {
    private String nome;
    private double velocidade;
    private double autonomia;
    private double custoPorMilhaBasico;
    private Espaco espacoDoNavio=Espaco.LIVRE;

    public Navio(String nome, double velocidade, double autonomia, double custoPorMilhaBasico) {
        this.nome = nome;
        this.velocidade = velocidade;
        this.autonomia = autonomia;
        this.custoPorMilhaBasico = custoPorMilhaBasico;
    }
    /**
     * Obtém o nome do navio.
     *
     * @return O nome do navio.
     */
    public String getNome() {
        return nome;
    }
    /**
     * Define o nome do navio.
     *
     * @param nome O nome do navio.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Obtém a velocidade do navio.
     *
     * @return A velocidade do navio.
     */
    public double getVelocidade() {
        return velocidade;
    }
     /**
     * Define a velocidade do navio.
     *
     * @param velocidade A velocidade do navio.
     */
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    /**
     * Obtém a autonomia do navio.
     *
     * @return A autonomia do navio.
     */
    public double getAutonomia() {
        return autonomia;
    }
    /**
     * Define a autonomia do navio.
     *
     * @param autonomia A autonomia do navio.
     */
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }
    /**
     * Obtém o custo por milha básico do navio.
     *
     * @return O custo por milha básico do navio.
     */
    public double getCustoPorMilhaBasico() {
        return custoPorMilhaBasico;
    }
    /**
     * Define o custo por milha básico do navio.
     *
     * @param custoPorMilhaBasico O custo por milha básico do navio.
     */
    public void setCustoPorMilhaBasico(double custoPorMilhaBasico) {
        this.custoPorMilhaBasico = custoPorMilhaBasico;
    }
    /**
     * Obtém o espaço disponível no navio.
     *
     * @return O espaço disponível no navio.
     */
    public Espaco getEspacoDoNavio() {
        return espacoDoNavio;
    }
    /**
     * Define o espaço disponível no navio.
     *
     * @param espacoDoNavio O espaço disponível no navio.
     */
    public void setEspacoDoNavio(Espaco espacoDoNavio) {
        this.espacoDoNavio = espacoDoNavio;
    }

    
}