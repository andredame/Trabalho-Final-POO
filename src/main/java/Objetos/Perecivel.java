package Objetos;
public class Perecivel extends TipoCarga {
    private String origem;
    private int validade;

    public Perecivel(int numero, String descricao, String origem, int validade) {
        super(numero, descricao);
        this.origem = origem;
        this.validade = validade;
    }
    public String getOrigem() {
        return origem;
    }


    public void setOrigem(String origem) {
        this.origem = origem;
    }


    public int getValidade() {
        return validade;
    }


    public void setValidade(int validade) {
        this.validade = validade;
    }


    


    

}
