package GerenciadorDeArquivos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Colecoes.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivosJson {
    private ColecaoCarga colecaoCarga;
    private ColecaoPortos colecaoPorto;
    private ColecaoDistancia colecaoDistancia;
    private ColecaoNavio colecaoNavio;
    private ColecaoTipoCarga colecaoTipoCarga;
    private ColecaoCliente colecaoCliente;
    private ColecaoViagens colecaoViagem;
    private String nomeDoSave;

    public ArquivosJson(String nomedosave) {
       this.nomeDoSave=nomedosave;
    }

    public ArquivosJson(ColecaoCarga carga, ColecaoPortos porto, ColecaoDistancia distancia,
            ColecaoNavio navio, ColecaoTipoCarga tipoCarga, ColecaoCliente cliente,
            ColecaoViagens viagem, String nomedoSave) {
        this.colecaoCarga = carga;
        this.colecaoPorto = porto;
        this.colecaoDistancia = distancia;
        this.colecaoNavio = navio;
        this.colecaoTipoCarga = tipoCarga;
        this.colecaoCliente = cliente;
        this.colecaoViagem = viagem;
        this.nomeDoSave = nomedoSave;
    }

    public void salvar() {
        // Criação do objeto Gson para serialização em JSON
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Criação do objeto que contém todas as coleções
        ObjetoPrincipal objetoPrincipal = new ObjetoPrincipal(colecaoCarga, colecaoPorto, colecaoDistancia,
                colecaoNavio, colecaoTipoCarga, colecaoCliente, colecaoViagem);

        // Conversão do objeto principal para JSON
        String jsonPrincipal = gson.toJson(objetoPrincipal);

        // Caminho do arquivo para salvar o JSON
        String pathSalvaJson = nomeDoSave + ".json";

        // Salvando o JSON em um arquivo
        try {
            FileWriter salvaJson = new FileWriter(pathSalvaJson);
            salvaJson.write(jsonPrincipal);
            salvaJson.close();
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean carregar() {
        // Criação do objeto Gson para desserialização do JSON
        Gson gson = new Gson();

        try {
            // Caminho do arquivo JSON a ser carregado
            String pathCarregaJson = nomeDoSave + ".json";

            // Leitura do arquivo JSON
            FileReader carregaJson = new FileReader(pathCarregaJson);

            // Desserialização do JSON para objeto principal
            ObjetoPrincipal objetoPrincipal = gson.fromJson(carregaJson, ObjetoPrincipal.class);

            // Atribuição das coleções separadas do objeto principal
            this.colecaoCarga = objetoPrincipal.colecaoCarga;
            this.colecaoPorto = objetoPrincipal.colecaoPorto;
            this.colecaoDistancia = objetoPrincipal.colecaoDistancia;
            this.colecaoNavio = objetoPrincipal.colecaoNavio;
            this.colecaoTipoCarga = objetoPrincipal.colecaoTipoCarga;
            this.colecaoCliente = objetoPrincipal.colecaoCliente;
            this.colecaoViagem = objetoPrincipal.colecaoViagem;

           
            

            carregaJson.close();
            return true;
        } catch (IOException e) {
           return false;
        }
    }

    private class ObjetoPrincipal {
        private ColecaoCarga colecaoCarga;
        private ColecaoPortos colecaoPorto;
        private ColecaoDistancia colecaoDistancia;
        private ColecaoNavio colecaoNavio;
        private ColecaoTipoCarga colecaoTipoCarga;
        private ColecaoCliente colecaoCliente;
        private ColecaoViagens colecaoViagem;

        public ObjetoPrincipal(ColecaoCarga carga, ColecaoPortos porto, ColecaoDistancia distancia,
                ColecaoNavio navio, ColecaoTipoCarga tipoCarga, ColecaoCliente cliente,
                ColecaoViagens viagem) {
            this.colecaoCarga = carga;
            this.colecaoPorto = porto;
            this.colecaoDistancia = distancia;
            this.colecaoNavio = navio;
            this.colecaoTipoCarga = tipoCarga;
            this.colecaoCliente = cliente;
            this.colecaoViagem = viagem;
        }
    }

    public ColecaoCarga getColecaoCarga() {
        return colecaoCarga;
    }

    public ColecaoPortos getColecaoPorto() {
        return colecaoPorto;
    }

    public ColecaoDistancia getColecaoDistancia() {
        return colecaoDistancia;
    }

    public ColecaoNavio getColecaoNavio() {
        return colecaoNavio;
    }

    public ColecaoTipoCarga getColecaoTipoCarga() {
        return colecaoTipoCarga;
    }

    public ColecaoCliente getColecaoCliente() {
        return colecaoCliente;
    }

    public ColecaoViagens getColecaoViagem() {
        return colecaoViagem;
    }
}
