package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.Porto;

/**
 * ColecaoPortos representa uma coleção de objetos Porto.
 */
public class ColecaoPortos {
    private ArrayList<Porto> portos;

    /**
     * Construtor da classe ColecaoPortos.
     * Inicializa a lista de portos.
     */
    public ColecaoPortos() {
        portos = new ArrayList<>();
    }

    /**
     * Adiciona um porto à coleção.
     * O porto é adicionado à lista de portos.
     * @param porto O porto a ser adicionado.
     * @return true se o porto foi adicionado com sucesso, false caso contrário.
     */
    public boolean addPorto(Porto porto) {
        boolean adicionado = portos.add(porto);
        if (adicionado) {
            Collections.sort(portos, Comparator.comparingInt(Porto::getId));
        }
        return adicionado;
    }

    /**
     * Obtém todos os portos da coleção.
     * @return A lista de portos.
     */
    public ArrayList<Porto> getPortos() {
        return new ArrayList<>(portos);
    }

    /**
     * Verifica se um porto com o ID especificado existe na coleção.
     * @param id O ID do porto a ser verificado.
     * @return true se o porto existe na coleção, false caso contrário.
     */
    public boolean containsPorto(int id) {
        for (Porto porto : portos) {
            if (porto.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtém o porto com o ID especificado.
     * @param id O ID do porto a ser obtido.
     * @return O objeto Porto correspondente, ou null se o porto não for encontrado.
     */
    public Porto getPortoPorId(int id) {
        for (Porto porto : portos) {
            if (porto.getId() == id) {
                return porto;
            }
        }
        return null;
    }
}
