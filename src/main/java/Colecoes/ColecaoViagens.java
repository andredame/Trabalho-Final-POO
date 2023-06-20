package Colecoes;

import java.util.ArrayList;
import Objetos.Viagem;

public class ColecaoViagens {

    private ArrayList<Viagem> viagens;

    public ColecaoViagens() {
        viagens = new ArrayList<>();
    }

    public boolean addViagem(Viagem viagem) {
        return viagens.add(viagem);
    }

}
