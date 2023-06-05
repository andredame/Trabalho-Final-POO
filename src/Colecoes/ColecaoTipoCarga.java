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

}
