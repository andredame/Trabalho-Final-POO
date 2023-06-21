package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.Carga;
import Objetos.Distancia;
import Objetos.Espaco;
import Objetos.Navio;
import Objetos.Prioridade;

/**
 * ColecaoNavio representa uma coleção de objetos Navio.
 */
public class ColecaoNavio {
    private ArrayList<Navio> navios;

    /**
     * Construtor da classe ColecaoNavio.
     * Inicializa a lista de navios.
     */
    public ColecaoNavio() {
        navios = new ArrayList<>();
    }

    /**
     * Adiciona um navio à coleção.
     * O navio é adicionado à lista de navios.
     * @param navio O navio a ser adicionado.
     * @return true se o navio foi adicionado com sucesso, false caso contrário.
     */
    public boolean addNavio(Navio navio) {
        boolean adicionado = navios.add(navio);
        if (adicionado) {
            Collections.sort(navios, Comparator.comparing(Navio::getNome));
        }
        return adicionado;
    }

    /**
     * Obtém todos os navios da coleção.
     * @return A lista de navios.
     */
    public ArrayList<Navio> getNavios() {
        return navios;
    }

    /**
     * Obtém o navio na posição especificada na lista.
     * @param i A posição do navio na lista.
     * @return O objeto Navio correspondente.
     */
    public Navio getNavio(int i) {
        return navios.get(i);
    }

    /**
     * Retorna um navio que esteja com o espaço livre.
     * @return O primeiro navio com espaço livre encontrado, ou null se nenhum navio estiver livre.
     */
    public Navio retornaUmNavioLivre() {
        for (Navio navio : navios) {
            if (navio.getEspacoDoNavio() == Espaco.LIVRE) {
                return navio;
            }
        }
        return null;
    }

    /**
     * Verifica se um navio com o nome especificado existe na coleção.
     * @param nome O nome do navio a ser verificado.
     * @return true se o navio existe na coleção, false caso contrário.
     */
    public boolean containsNavio(String nome) {
        for (Navio navio : navios) {
            if (navio.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Procura um navio pelo nome na coleção.
     * @param nome O nome do navio a ser procurado.
     * @return O objeto Navio correspondente, ou null se o navio não for encontrado.
     */
    public Navio procuraNomeNavio(String nome) {
        for (Navio navio : navios) {
            if (navio.getNome().equalsIgnoreCase(nome)) {
                return navio;
            }
        }
        return null;
    }

    /**
     * Seleciona o navio ideal com base na carga e na distância especificadas.
     * O navio ideal é selecionado levando em consideração a autonomia do navio, o tempo máximo da carga e a prioridade da carga.
     * @param carga A carga a ser transportada.
     * @param distancia A distância a ser percorrida.
     * @return O objeto Navio ideal para a carga e distância especificadas, ou null se nenhum navio atender aos critérios.
     */
    public Navio selecionaNavioIdeal(Carga carga, Distancia distancia) {
        Navio n = null;
        for (Navio navio : navios) {
            if (navio.getAutonomia() >= distancia.getDistancia()) {
                double tempoDoNavio = distancia.getDistancia() / navio.getVelocidade();
                if (carga.getTempoMaximo() * 24 > tempoDoNavio) {
                    if (carga.getPrioridade() == Prioridade.RAPIDO) {
                        if (n == null || navio.getVelocidade() > n.getVelocidade()) {
                            n = navio;
                        }
                    }
                    if (carga.getPrioridade() == Prioridade.BARATO) {
                        if (n == null || navio.getCustoPorMilhaBasico() < n.getCustoPorMilhaBasico()) {
                            n = navio;
                        }
                    }
                }
            }
        }
        return n;
    }
}
