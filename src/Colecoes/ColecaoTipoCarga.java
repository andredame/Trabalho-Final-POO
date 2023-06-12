package Colecoes;
import java.util.ArrayList;

import Objetos.TipoCarga  ;
public class ColecaoTipoCarga {
    private ArrayList <TipoCarga> tipos;

    
    public ColecaoTipoCarga() {
        tipos= new ArrayList<>();
    }
    public boolean addTipoCarga(TipoCarga tipoCarga){
        return tipos.add(tipoCarga);
    }
    public ArrayList<TipoCarga> getTipos() {
        return tipos;
    }
    public boolean procurarNumeroCarga(int numero){
        for (TipoCarga tipoCarga : tipos) {
             if (tipoCarga.getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

}
