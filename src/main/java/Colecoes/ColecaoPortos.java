package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.Porto;

public class ColecaoPortos {
    private ArrayList<Porto> portos;

    public ColecaoPortos() {
        portos = new ArrayList<>();
    }

    public boolean addPorto(Porto porto) {
        boolean adicionado = portos.add(porto);
        if (adicionado) {
            Collections.sort(portos, Comparator.comparingInt(Porto::getId));
        }
        return adicionado;
    }

    public ArrayList<Porto> getPortos() {
        return new ArrayList<>(portos);
    }

    public boolean getPortoPorId(int id) {
        for (Porto porto : portos) {
            if (porto.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
