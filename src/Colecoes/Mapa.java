package Colecoes;
import java.util.ArrayList;

import Objetos.Distancia;
public class Mapa {
    private ArrayList <Distancia> mapa;

    public Mapa() {
        mapa =  new ArrayList<>();
    }
    public boolean addNoMapa(Distancia percurso){
        return mapa.add(percurso);
    }
    public ArrayList<Distancia> getDistancia() {
        return mapa;
    } 
}
