package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Objetos.Navio;


public class ColecaoNavio {
    private ArrayList<Navio> navios;

    public ArrayList<Navio> getNavios() {
        return navios;
    }

    public ColecaoNavio() {
        navios = new ArrayList<>();
    }

    public boolean addNavio(Navio navio) {
    boolean adicionado = navios.add(navio);
    if (adicionado) {
        Collections.sort(navios, Comparator.comparing(Navio::getNome));
    }
    return adicionado;
}

    public Navio getNavio(int i){
        return navios.get(i);
    }

    
}