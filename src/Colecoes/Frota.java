package Colecoes;
import java.util.ArrayList;

import Objetos.Navio;
public class Frota {
    private ArrayList <Navio> navios;

    public Frota() {
        navios =  new ArrayList<>();
    }
    public boolean addNavio(Navio navio){
        return navios.add(navio);
    }

}
