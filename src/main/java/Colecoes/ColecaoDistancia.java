package Colecoes;

import java.util.ArrayList;

import Objetos.Distancia;

public class ColecaoDistancia {
    private ArrayList<Distancia> mapa;

    public ColecaoDistancia() {
        mapa = new ArrayList<>();
    }
    /**
     * Adiciona um percurso ao mapa.
     * O percurso é adicionado à lista de percursos.
     * @param percurso O percurso a ser adicionado.
     * @return true se o percurso foi adicionado com sucesso, false caso contrário.
     */
    public boolean addNoMapa(Distancia percurso) {
        return mapa.add(percurso);
    }
    /**
     * Obtém todos os percursos do mapa.
     * @return A lista de percursos.
     */
    public ArrayList<Distancia> getDistancia() {
        return mapa;
    }
    /**
     * Verifica se existe uma rota no mapa entre a origem e o destino especificados.
     * @param origem O ID da origem.
     * @param destino O ID do destino.
     * @return true se a rota existe no mapa, false caso contrário.
     */
    public boolean containsRota(int origem, int destino) {
        for (Distancia rota : mapa) {
            if (rota.getDestino() == destino && rota.getOrigem() == origem) {
                return true;
            }
        }
        return false;
    }
    /**
     * Procura uma rota no mapa entre a origem e o destino especificados.
     * @param origem O ID da origem.
     * @param destino O ID do destino.
     * @return O objeto Distancia correspondente à rota, ou null se não encontrada.
     */
    public Distancia procuraRota(int origem, int destino) {
        for (Distancia rota : mapa) {
            if (rota.getDestino() == destino && rota.getOrigem() == origem) {
                return rota;
            }
        }
        return null;
    }

}
