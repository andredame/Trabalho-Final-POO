package Objetos;
public class  TipoCarga {
    private int numero;
    private String descricao;

    
    public TipoCarga(int numero, String descricao) {
        this.numero = numero;
        this.descricao = descricao;
    }
    
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
