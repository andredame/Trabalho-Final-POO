package Colecoes;
import java.util.ArrayList;

import Objetos.Porto;
public class ColecaoPortos {
    private ArrayList <Porto> portos;

    public ColecaoPortos() {
        portos = new ArrayList<>();
    }
    public boolean addPorto(Porto porto){
        return portos.add(porto);
    }

}
