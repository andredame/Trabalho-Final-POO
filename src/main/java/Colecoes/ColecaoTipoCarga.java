package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.TipoCarga;

/**
 * ColecaoTipoCarga representa coleção de objetos TipoCarga.
 */
public class ColecaoTipoCarga {
    private ArrayList<TipoCarga> tipos;

    /**
     * Construtor da classe ColecaoTipoCarga.
     * Inicializa a lista de tipos de carga.
     */
    public ColecaoTipoCarga() {
        tipos = new ArrayList<>();
    }

    /**
     * Adiciona um tipo de carga à coleção.
     * O tipo de carga é adicionado à lista de tipos.
     * @param tipoCarga O tipo de carga a ser adicionado.
     * @return true se o tipo de carga foi adicionado com sucesso, false caso contrário.
     */
    public boolean addTipoCarga(TipoCarga tipoCarga) {
        boolean adicionado = tipos.add(tipoCarga);
        if (adicionado) {
            Collections.sort(tipos, Comparator.comparingInt(TipoCarga::getNumero));
        }
        return adicionado;
    }

    /**
     * Obtém todos os tipos de carga da coleção.
     * @return A lista de tipos de carga.
     */
    public ArrayList<TipoCarga> getTipos() {
        return tipos;
    }

    /**
     * Verifica se um tipo de carga com o número especificado existe na coleção.
     * @param numero O número do tipo de carga a ser verificado.
     * @return true se o tipo de carga existe na coleção, false caso contrário.
     */
    public boolean containsTipoCarga(int numero) {
        for (TipoCarga tipoCarga : tipos) {
            if (tipoCarga.getNumero() == numero) {
                return true;
            }
        }
        return false;
    }

    /**
     * Procura um tipo de carga pelo número especificado.
     * @param numero O número do tipo de carga a ser procurado.
     * @return O objeto TipoCarga correspondente, ou null se o tipo de carga não for encontrado.
     */
    public TipoCarga procurarNumeroCarga(int numero) {
        for (TipoCarga tipoCarga : tipos) {
            if (tipoCarga.getNumero() == numero) {
                return tipoCarga;
            }
        }
        return null;
    }
}
