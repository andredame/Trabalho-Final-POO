package Objetos;
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
    /**
     * Obtém o setor do tipo de carga durável.
     *
     * @return O setor do tipo de carga durável.
     */
    public String getSetor() {
        return setor;
    }
    /**
     * Define o setor do tipo de carga durável.
     *
     * @param setor O setor do tipo de carga durável.
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }

    /**
     * Obtém o material principal do tipo de carga durável.
     *
     * @return O material principal do tipo de carga durável.
     */
    public String getMaterialPrincipal() {
        return materialPrincipal;
    }

    /**
     * Define o material principal do tipo de carga durável.
     *
     * @param materialPrincipal O material principal do tipo de carga durável.
     */
    public void setMaterialPrincipal(String materialPrincipal) {
        this.materialPrincipal = materialPrincipal;
    }

    /**
     * Obtém o percentual de imposto aplicado ao tipo de carga durável.
     *
     * @return O percentual de imposto aplicado ao tipo de carga durável.
     */
    public double getPercentualImposto() {
        return percentualImposto;
    }

    /**
     * Define o percentual de imposto aplicado ao tipo de carga durável.
     *
     * @param percentualImposto O percentual de imposto aplicado ao tipo de carga durável.
     */
    public void setPercentualImposto(double percentualImposto) {
        this.percentualImposto = percentualImposto;
    }
    

}
