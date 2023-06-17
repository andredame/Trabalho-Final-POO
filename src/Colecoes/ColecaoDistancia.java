package Colecoes;
import java.util.ArrayList;

import Objetos.Distancia;
public class ColecaoDistancia {
    private ArrayList <Distancia> mapa;

    public ColecaoDistancia() {
        mapa =  new ArrayList<>();
    }
    public boolean addNoMapa(Distancia percurso){
        return mapa.add(percurso);
    }
    public ArrayList<Distancia> getDistancia() {
        return mapa;
    } 
}
