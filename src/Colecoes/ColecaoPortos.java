package Colecoes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

import Objetos.Porto;
public class ColecaoPortos {
    private TreeSet<Porto> portos;

    public ColecaoPortos() {
        portos = new TreeSet<>(Comparator.comparingInt(Porto::getId));
    }

    public boolean addPorto(Porto porto) {
        return portos.add(porto);
    }

    public ArrayList<Porto> getPortos() {
        return new ArrayList<>(portos);
    }

    public Porto getPortoPorId(int id) {
        for (Porto porto : portos) {
            if (porto.getId() == id) {
                return porto;
            }
        }
        return null;
    }
}
