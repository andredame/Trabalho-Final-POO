package Colecoes;

import java.util.ArrayList;

import Objetos.Navio;
import Objetos.Viagem;
import Objetos.*;

public class ColecaoViagens {

    private ArrayList<Viagem> viagens;

    

    public ColecaoViagens() {
        viagens = new ArrayList<>();
    }

    public boolean addViagem(Viagem viagem) {
        return viagens.add(viagem);
    }
    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    public void setViagens(ArrayList<Viagem> viagens) {
        this.viagens = viagens;
    }
    public Carga procurarNavio(Navio navio){
        for(Viagem viagem : viagens){
            if(viagem.getNavio().getNome().equals(navio.getNome()) ){
                return viagem.getCarga();
            }
        }
        return null;
    }

}
