package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.Carga;
import Objetos.Navio;

public class ColecaoCarga {
    private ArrayList<Carga> cargas;

    public ColecaoCarga() {
        cargas = new ArrayList<>();
    }
    /**
     * Adiciona uma carga à coleção.
     * A carga é adicionada à lista de cargas e a lista é ordenada por código.
     * @param carga A carga a ser adicionada.
     * @return true se a carga foi adicionada com sucesso, false caso contrário.
     */
    public boolean addCarga(Carga carga) {
        boolean adicionado = cargas.add(carga);
        if (adicionado) {
            Collections.sort(cargas, Comparator.comparingInt(Carga::getIdentificador));
        }
        return adicionado;
    }
    /**
     * Obtém todas as cargas da coleção.
     * @return A lista de cargas.
     */
    public ArrayList<Carga> getCargas() {
        return cargas;
    }
    /**
     * Obtém uma carga pelo seu código.
     * @param cod O código da carga.
     * @return A carga correspondente ao código, ou null se não encontrada.
     */
    public Carga getCargaCod(int cod) {
        for (Carga c : cargas) {
            if (c.getIdentificador() == cod) {
                return c;
            }
        }
        return null;
    }
    /**
     * Verifica se a coleção contém uma carga com o código especificado.
     * @param cod O código da carga a ser verificada.
     * @return true se a carga existe na coleção, false caso contrário.
     */
    public boolean containsCod(int cod) {
        for (Carga c : cargas) {
            if (c.getIdentificador() == cod) {
                return true;
            }
        }
        return false;
    }
    /**
     * Procura uma carga pelo seu código.
     * @param cod O código da carga.
     * @return A carga correspondente ao código, ou null se não encontrada.
     */
    public Carga procuraCod(int cod) {
        for (Carga c : cargas) {
            if (c.getIdentificador() == cod) {
                return c;
            }
        }
        return null;
    }
    
}

