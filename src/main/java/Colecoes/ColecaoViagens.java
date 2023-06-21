package Colecoes;
import Objetos.*;
import java.util.ArrayList;

/**
 * ColecaoViagens representa coleção de objetos Viagem.
 */
public class ColecaoViagens {

    private ArrayList<Viagem> viagens;

    /**
     * Construtor da classe ColecaoViagens.
     * Inicializa a lista de viagens.
     */
    public ColecaoViagens() {
        viagens = new ArrayList<>();
    }

    /**
     * Adiciona uma viagem à coleção.
     * A viagem é adicionada à lista de viagens.
     * @param viagem A viagem a ser adicionada.
     * @return true se a viagem foi adicionada com sucesso, false caso contrário.
     */
    public boolean addViagem(Viagem viagem) {
        return viagens.add(viagem);
    }

    /**
     * Obtém todas as viagens da coleção.
     * @return A lista de viagens.
     */
    public ArrayList<Viagem> getViagens() {
        return viagens;
    }

    /**
     * Define a lista de viagens da coleção.
     * @param viagens A nova lista de viagens.
     */
    public void setViagens(ArrayList<Viagem> viagens) {
        this.viagens = viagens;
    }

    /**
     * Procura uma carga associada a um navio específico.
     * @param navio O navio para o qual a carga está associada.
     * @return A carga associada ao navio, ou null se não for encontrada.
     */
    public Carga procurarNavio(Navio navio) {
        for (Viagem viagem : viagens) {
            if (viagem.getNavio().getNome().equals(navio.getNome())) {
                return viagem.getCarga();
            }
        }
        return null;
    }
    /**
     * Procura o navio de acordo com a Carga passada 
     * @param carga Carga a ser procurada
     * @return Navio que esta levando essa carga 
     */
    public Navio procuraNavioQueTemACarga(Carga carga){
        for (Viagem viagem : viagens) {
            if (viagem.getCarga().getIdentificador()==carga.getIdentificador()) {
                return viagem.getNavio();
            }
        }
        return null;
    }

}

