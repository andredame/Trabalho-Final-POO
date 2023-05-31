public class Duravel extends TipoCarga{

    
    private String setor;
    private String materialPrincipal;
    private double percentualImposto;


    public Duravel(int numero, String descricao, String setor, String materialPrincipal, double percentualImposto) {
        super(numero, descricao);
        this.setor = setor;
        this.materialPrincipal = materialPrincipal;
        this.percentualImposto = percentualImposto;
    }

    public String getSetor() {
        return setor;
    }
    
    public void setSetor(String setor) {
        this.setor = setor;
    }


    public String getMaterialPrincipal() {
        return materialPrincipal;
    }


    public void setMaterialPrincipal(String materialPrincipal) {
        this.materialPrincipal = materialPrincipal;
    }


    public double getPercentualImposto() {
        return percentualImposto;
    }


    public void setPercentualImposto(double percentualImposto) {
        this.percentualImposto = percentualImposto;
    }


    
    

}
