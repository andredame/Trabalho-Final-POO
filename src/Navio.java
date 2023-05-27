/**
 * Navio
 */
public class Navio {
    private String nome;
    private double velocidade;
    private double autonomia;
    private double custoPorMilhaBasico;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getVelocidade() {
        return velocidade;
    }
    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }
    public double getAutonomia() {
        return autonomia;
    }
    public void setAutonomia(double autonomia) {
        this.autonomia = autonomia;
    }
    public double getCustoPorMilhaBasico() {
        return custoPorMilhaBasico;
    }
    public void setCustoPorMilhaBasico(double custoPorMilhaBasico) {
        this.custoPorMilhaBasico = custoPorMilhaBasico;
    }
}