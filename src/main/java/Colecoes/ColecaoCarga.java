package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.Carga;

public class ColecaoCarga {
    private ArrayList<Carga> cargas;

    public ColecaoCarga() {
        cargas = new ArrayList<>();
    }

    public boolean addCarga(Carga carga) {
        boolean adicionado = cargas.add(carga);
        if (adicionado) {
            Collections.sort(cargas, Comparator.comparingInt(Carga::getIdentificador));
        }
        return adicionado;
    }

    public ArrayList<Carga> getCargas() {
        return cargas;
    }

    public Carga getCargaCod(int cod) {
        for (Carga c : cargas) {
            if (c.getIdentificador() == cod) {
                return c;
            }
        }
        return null;
    }
     public boolean containsCod(int cod) {
        for (Carga c : cargas) {
            if (c.getIdentificador() == cod) {
                return true;
            }
        }
        return false;
    }

}
