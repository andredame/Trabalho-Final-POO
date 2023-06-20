package Colecoes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.TipoCarga  ;
public class ColecaoTipoCarga {
    private ArrayList <TipoCarga> tipos;

    
    public ColecaoTipoCarga() {
        tipos= new ArrayList<>();
    }
    public boolean addTipoCarga(TipoCarga tipoCarga) {
    boolean adicionado = tipos.add(tipoCarga);
    if (adicionado) {
        Collections.sort(tipos, Comparator.comparingInt(TipoCarga::getNumero));
    }
    return adicionado;
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
