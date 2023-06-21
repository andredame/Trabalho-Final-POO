package Colecoes;

import java.util.ArrayList;

import Objetos.Distancia;

public class ColecaoDistancia {
    private ArrayList<Distancia> mapa;

    public ColecaoDistancia() {
        mapa = new ArrayList<>();
    }

    public boolean addNoMapa(Distancia percurso) {
        return mapa.add(percurso);
    }

    public ArrayList<Distancia> getDistancia() {
        return mapa;
    }

    public boolean containsRota(int origem, int destino) {
        for (Distancia rota : mapa) {
            if (rota.getDestino() == destino && rota.getOrigem() == origem) {
                return true;
            }
        }
        return false;
    }

    public Distancia procuraRota(int origem, int destino) {
        for (Distancia rota : mapa) {
            if (rota.getDestino() == destino && rota.getOrigem() == origem) {
                return rota;
            }
        }
        return null;
    }

}
