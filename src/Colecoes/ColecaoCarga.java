package Colecoes;
import java.util.ArrayList;

import Objetos.Carga;

public class ColecaoCarga {
    private ArrayList <Carga> cargas;

    public ColecaoCarga() {
        cargas = new ArrayList<>();
    }
    public boolean addCarga(Carga carga){
        return cargas.add(carga);
    }
    public ArrayList<Carga> getCargas() {
        return cargas;
    }
    public Carga getCargaCod(int cod){
        for (Carga c : cargas){
            if(c.getIdentificador() == cod){
                return c;
            }
        }
        return null;
    }
}
