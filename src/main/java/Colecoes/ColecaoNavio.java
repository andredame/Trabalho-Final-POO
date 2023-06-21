package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.*;

public class ColecaoNavio {
    private ArrayList<Navio> navios;

    public ArrayList<Navio> getNavios() {
        return navios;
    }

    public ColecaoNavio() {
        navios = new ArrayList<>();
    }

    public boolean addNavio(Navio navio) {
        boolean adicionado = navios.add(navio);
        if (adicionado) {
            Collections.sort(navios, Comparator.comparing(Navio::getNome));
        }
        return adicionado;
    }

    public Navio getNavio(int i) {
        return navios.get(i);
    }

    public Navio retornaUmNavioLivre() {
        for (Navio navio : navios) {
            if (navio.getEspacoDoNavio() == Espaco.LIVRE) {
                return navio;
            }
        }
        return null;
    }

    public boolean containsNavio(String nome) {
        for (Navio navio : navios) {
            if (navio.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public Navio procuraNomeNavio(String nome) {
        for (Navio navio : navios) {
            if (navio.getNome().equalsIgnoreCase(nome)) {
                return navio;
            }
        }
        return null;
    }

    public Navio selecionaNavioIdeal(Carga carga, Distancia distancia) {

        Navio n = null;
        for (Navio navio : navios) {
            if (navio.getAutonomia() >= distancia.getDistancia()) {
                double tempoDoNavio = distancia.getDistancia() / navio.getVelocidade();
                if (carga.getTempoMaximo()*24 > tempoDoNavio) {
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