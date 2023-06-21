package GerenciadorDeArquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import Colecoes.*;
import Objetos.*;

public class ArquivosCSV {
    private ColecaoPortos colecaoPortos = new ColecaoPortos();
    private ColecaoTipoCarga colecaoTipoCarga = new ColecaoTipoCarga();
    private ColecaoCarga colecaoCarga = new ColecaoCarga();
    private ColecaoCliente colecaoClientes = new ColecaoCliente();
    private ColecaoNavio colecaoNavios = new ColecaoNavio();
    private ColecaoDistancia colecaoDistancias = new ColecaoDistancia();
    private ColecaoViagens colecaoViagens = new ColecaoViagens();
    private Scanner lePorto = null;
    private Scanner leDistancia = null;
    private Scanner leNavios = null;
    private Scanner leCliente = null;
    private Scanner leTipoCarga = null;
    private Scanner leCarga = null;
    private String palavraPrefixo;
    private boolean deuErroNaLeitura = false;
    
    private StringBuilder lePortoEntries = new StringBuilder();
    private StringBuilder leDistanciaEntries = new StringBuilder();
    private StringBuilder leNaviosEntries = new StringBuilder();
    private StringBuilder leClienteEntries = new StringBuilder();
    private StringBuilder leTipoCargaEntries = new StringBuilder();
    private StringBuilder leCargaEntries = new StringBuilder();

    public ArquivosCSV(String palavraPrefixo) {
        
        lePorto = new Scanner(System.in);
        leDistancia = new Scanner(System.in);
        leNavios = new Scanner(System.in);
        leCliente = new Scanner(System.in);
        leTipoCarga = new Scanner(System.in);
        leCarga = new Scanner(System.in);
        this.palavraPrefixo = palavraPrefixo;

    }

    public boolean leArquivos() {
        leitorDeArquivosCSV();
        if (!deuErroNaLeitura) {

            lePorto();

            leDistancia();

            leNavios();

            leClientes();

            leTiposCargas();

            leCargas();

            return true;
        }
        return false;
    }

    private void leitorDeArquivosCSV() {
        /**
         * Buff do lePorto
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(palavraPrefixo + "-PORTOS.CSV"));
            lePorto = new Scanner(streamEntrada); // Usa como entrada um arquivo
            Charset.forName("UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo PORTOS.CSV não encontrado.");
            this.deuErroNaLeitura = true;

        }

        /**
         * Buff do leDistancia
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(palavraPrefixo + "-DISTANCIAS.CSV"));
            leDistancia = new Scanner(streamEntrada); // Usa como entrada um arquivo
            Charset.forName("UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo DISTANCIAS.CSV não encontrado.");
            this.deuErroNaLeitura = true;
        }

        /**
         * Buff do leNavios
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(palavraPrefixo + "-NAVIOS.CSV"));
            leNavios = new Scanner(streamEntrada); // Usa como entrada um arquivo
            Charset.forName("UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo NAVIOS.CSV não encontrado.");
            this.deuErroNaLeitura = true;
        }

        /**
         * Buff do leCliente
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(palavraPrefixo + "-CLIENTES.CSV"));
            leCliente = new Scanner(streamEntrada); // Usa como entrada um arquivo
            Charset.forName("UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo CLIENTES.CSV não encontrado.");
            this.deuErroNaLeitura = true;
        }

        /**
         * Buff do leTipoCarga
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(palavraPrefixo + "-TIPOSCARGAS.CSV"));
            leTipoCarga = new Scanner(streamEntrada); // Usa como entrada um arquivo
            Charset.forName("UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo TIPOSCARGAS.CSV não encontrado.");
            this.deuErroNaLeitura = true;
        }

        /**
         * Buff do leCarga
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(palavraPrefixo + "-CARGAS.CSV"));
            leCarga = new Scanner(streamEntrada); // Usa como entrada um arquivo
            Charset.forName("UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo CARGAS.CSV não encontrado.");
            this.deuErroNaLeitura = true;
        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Porto
     */
    private void lePorto() {
        int codigoPorto;
        String nomePorto;
        String paisPorto;
        String a = lePorto.nextLine();
        while (lePorto.hasNextLine()) {
            a = lePorto.nextLine();
            lePortoEntries.append(a).append("\n");
            String linhaDoArquivo[] = a.split(";");
            codigoPorto = Integer.parseInt(linhaDoArquivo[0]);
            nomePorto = linhaDoArquivo[1];
            paisPorto = linhaDoArquivo[2];
            Porto porto = new Porto(codigoPorto, nomePorto, paisPorto);
            colecaoPortos.addPorto(porto);

        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para a Distancia
     */
    private void leDistancia() {
        int origem;
        int destino;
        double distancia;
        String a = leDistancia.nextLine();
        while (leDistancia.hasNextLine()) {
            a = leDistancia.nextLine();
            leDistanciaEntries.append(a).append("\n");
            String linhaDoArquivo[] = a.split(";");
            origem = Integer.parseInt(linhaDoArquivo[0]);
            ;
            destino = Integer.parseInt(linhaDoArquivo[1]);
            ;
            distancia = Double.parseDouble(linhaDoArquivo[2].replace(",", "."));

            Distancia obj = new Distancia(origem, destino, distancia);
            colecaoDistancias.addNoMapa(obj);

        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Navio
     */
    private void leNavios() {
        String nome;
        double velocidade;
        double autonomia;
        double customilhaBasico;

        String a = leNavios.nextLine();
        while (leNavios.hasNextLine()) {
            a = leNavios.nextLine();
            leNaviosEntries.append(a).append("\n");
            String linhaDoArquivo[] = a.split(";");
            nome = linhaDoArquivo[0];
            velocidade = Double.parseDouble(linhaDoArquivo[1].replace(",", "."));
            autonomia = Double.parseDouble(linhaDoArquivo[2].replace(",", "."));
            customilhaBasico = Double.parseDouble(linhaDoArquivo[3].replace(",", "."));

            Navio navio = new Navio(nome, velocidade, autonomia, customilhaBasico);
            colecaoNavios.addNavio(navio);
        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para Cliente
     */
    private void leClientes() {
        int cod;
        String nome;
        String email;
        String a = leCliente.nextLine();
        while (leCliente.hasNextLine()) {
            a = leCliente.nextLine();
            leClienteEntries.append(a).append("\n");
            String linhaDoArquivo[] = a.split(";");
            cod = Integer.parseInt(linhaDoArquivo[0]);
            nome = linhaDoArquivo[1];
            email = linhaDoArquivo[2];

            Cliente cliente = new Cliente(cod, nome, email);
            colecaoClientes.addCliente(cliente);

        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para o TipoCarga
     */
    private void leTiposCargas() {
        int numero;
        String descricao;

        String a = leTipoCarga.nextLine();
        while (leTipoCarga.hasNextLine()) {
            a = leTipoCarga.nextLine();
            leTipoCargaEntries.append(a).append("\n");
            String linhaDoArquivo[] = a.split(";");
            numero = Integer.parseInt(linhaDoArquivo[0]);
            descricao = linhaDoArquivo[1];
            if (linhaDoArquivo[2].equals("DURAVEL") || linhaDoArquivo[2].equals("PERECIVEL")) {
                if (linhaDoArquivo[2].equals("DURAVEL")) {

                    String setor = linhaDoArquivo[3];
                    String material = linhaDoArquivo[4];
                    double ipi = Double.parseDouble(linhaDoArquivo[5].replace(",", "."));
                    Duravel carga = new Duravel(numero, descricao, setor, material, ipi);
                    colecaoTipoCarga.addTipoCarga(carga);
                } else {

                    String origem = linhaDoArquivo[3];
                    int tempomaximo = Integer.parseInt(linhaDoArquivo[4]);
                    Perecivel carga = new Perecivel(numero, descricao, origem, tempomaximo);
                    colecaoTipoCarga.addTipoCarga(carga);

                }
            }

        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Carga
     */
    private void leCargas() {
        int codigo;
        int cliente;
        int origem;
        int destino;
        int peso;
        double valorDeclarado;
        int tempoMaximo;
        int tipoCarga;
        Prioridade p;
        Situacao s = null;

        // SITUACAO
        String a = leCarga.nextLine();
        while (leCarga.hasNextLine()) {
            a = leCarga.nextLine();
            leCargaEntries.append(a).append("\n");
            String linhaDoArquivo[] = a.split(";");
            codigo = Integer.parseInt(linhaDoArquivo[0]);
            cliente = Integer.parseInt(linhaDoArquivo[1]);
            origem = Integer.parseInt(linhaDoArquivo[2]);
            destino = Integer.parseInt(linhaDoArquivo[3]);
            peso = Integer.parseInt(linhaDoArquivo[4]);
            valorDeclarado = Double.parseDouble(linhaDoArquivo[5].replace(",", "."));
            tempoMaximo = Integer.parseInt(linhaDoArquivo[6]);
            tipoCarga = Integer.parseInt(linhaDoArquivo[7]);
            if (linhaDoArquivo[8].equals("RAPIDO")) {
                p = Prioridade.RAPIDO;
            } else {
                p = Prioridade.BARATO;
            }

            switch (linhaDoArquivo[9].toUpperCase()) {
                case "PENDENTE":
                    s = Situacao.PENDENTE;
                    break;
                case "LOCADO":
                    s = Situacao.LOCADO;
                    break;
                case "CANCELADO":
                    s = Situacao.CANCELADO;
                    break;
                case "FINALIZADO":
                    s = Situacao.FINALIZADO;
                    break;
                default:
                    System.out.println("ERRO SITUACAO");
                    break;
            }
            // Ta dando algum erro
            Carga c = new Carga(codigo, cliente, origem, destino, peso, valorDeclarado, tempoMaximo, tipoCarga, p, s);
            colecaoCarga.addCarga(c);
        }
    }

    /**
 * Retorna a coleção de portos adiciionado.
 *
 * @return a coleção de portos
 */
public ColecaoPortos getColecaoPortos() {
    return colecaoPortos;
}

/**
 * Retorna a coleção de tipos de carga Adicionado.
 *
 * @return a coleção de tipos de carga
 */
public ColecaoTipoCarga getColecaoTipoCarga() {
    return colecaoTipoCarga;
}

/**
 * Retorna a coleção de cargas adicionada.
 *
 * @return a coleção de cargas
 */
public ColecaoCarga getColecaoCarga() {
    return colecaoCarga;
}

/**
 * Retorna a coleção de clientes adicionado.
 *
 * @return a coleção de clientes
 */
public ColecaoCliente getColecaoClientes() {
    return colecaoClientes;
}

/**
 * Retorna a coleção de navios adicionado.
 *
 * @return a coleção de navios
 */
public ColecaoNavio getColecaoNavios() {
    return colecaoNavios;
}

/**
 * Retorna a coleção de distâncias adicionada.
 *
 * @return a coleção de distâncias
 */
public ColecaoDistancia getColecaoDistancias() {
    return colecaoDistancias;
}

/**
 * Retorna a coleção de viagens adicionado.
 *
 * @return a coleção de viagens
 */
public ColecaoViagens getColecaoViagens() {
    return colecaoViagens;
}

/**
 * Retorna uma representação em formato de string das entradas do arquivo para os portos adicionados.
 *
 * @return uma string com as entradas do arquivo para os portos
 */
public String getLePortoEntries() {
    return lePortoEntries.toString();
}

/**
 * Retorna uma representação em formato de string das entradas do arquivo para as distâncias adicionadas.
 *
 * @return uma string com as entradas do arquivo para as distâncias
 */
public String getLeDistanciaEntries() {
    return leDistanciaEntries.toString();
}

/**
 * Retorna uma representação em formato de string das entradas do arquivo para os navios adicionados.
 *
 * @return uma string com as entradas do arquivo para os navios
 */
public String getLeNaviosEntries() {
    return leNaviosEntries.toString();
}

/**
 * Retorna uma representação em formato de string das entradas do arquivo para os clientes adicionados.
 *
 * @return uma string com as entradas do arquivo para os clientes
 */
public String getLeClienteEntries() {
    return leClienteEntries.toString();
}

/**
 * Retorna uma representação em formato de string das entradas do arquivo para os tipos de carga adicionados.
 *
 * @return uma string com as entradas do arquivo para os tipos de carga
 */
public String getLeTipoCargaEntries() {
    return leTipoCargaEntries.toString();
}

/**
 * Retorna uma representação em formato de string das entradas do arquivo para as cargas adicionadas.
 *
 * @return uma string com as entradas do arquivo para as cargas
 */
public String getLeCargaEntries() {
    return leCargaEntries.toString();
}

}
