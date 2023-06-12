package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import Objetos.Navio;


public class Frota {
    private ArrayList<Navio> navios;

    public ArrayList<Navio> getNavios() {
        return navios;
    }

    public Frota() {
        navios = new ArrayList<>();
    }

    public boolean addNavio(Navio navio) {
        boolean result = navios.add(navio);
        ordenarNaviosPorNome();
        return result;
    }

    public Navio getNavio(int i){
        return navios.get(i);
    }

    private void ordenarNaviosPorNome() {
        Collections.sort(navios, new Comparator<Navio>() {
            @Override
            public int compare(Navio navio1, Navio navio2) {
                return navio1.getNome().compareToIgnoreCase(navio2.getNome());
            }
        });
    }
}