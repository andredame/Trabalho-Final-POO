import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Scanner;

import Colecoes.*;
import Objetos.*;

public class ACMEHandelsschifffahrtsgesellschaft {

    private ColecaoPortos colecaoPortos = new ColecaoPortos();
    private ColecaoTipoCarga colecaoTipoCarga = new ColecaoTipoCarga();
    private Container colecaoCarga = new Container();
    private Freguesia colecaoClientes = new Freguesia();
    private Frota colecaoNavios = new Frota();
    private Mapa colecaoDistancias = new Mapa();

    private Scanner memoryCard = null;
    private Scanner lePorto = null;
    private Scanner leDistancia = null;
    private Scanner leNavios = null;
    private Scanner leCliente = null;
    private Scanner leTipoCarga = null;
    private Scanner leCarga = null;

    public ACMEHandelsschifffahrtsgesellschaft() {

        memoryCard = new Scanner(System.in);
        lePorto = new Scanner(System.in);
        leDistancia = new Scanner(System.in);
        leNavios = new Scanner(System.in);
        leCliente = new Scanner(System.in);
        leTipoCarga = new Scanner(System.in);
        leCarga = new Scanner(System.in);
        /**
         * Buff do MemoryCard
         */
        // try {
        // BufferedReader streamEntrada = new BufferedReader(
        // new FileReader("dados.csv"));
        // // entrada = new Scanner(streamEntrada); // Usa como entrada um arquivo
        // PrintStream streamSaida = new PrintStream(
        // new File("resultado.csv"));
        // Charset.forName("UTF-8");
        // System.setOut(streamSaida); // Usa como saida um arquivo
        // } catch (Exception e) {
        // System.out.println(e);
        // }
        /**
         * Buff do lePorto
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader("EXEMPLO-PORTOS.CSV"));
            lePorto = new Scanner(streamEntrada); // Usa como entrada um arquivo

            Charset.forName("UTF-8");

        } catch (Exception e) {
            System.out.println(e);
        }
        /**
         * Buff do leDistancia
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader("EXEMPLO-DISTANCIAS.CSV"));
            leDistancia = new Scanner(streamEntrada); // Usa como entrada um arquivo

            Charset.forName("UTF-8");

        } catch (Exception e) {
            System.out.println(e);
        }
        /**
         * Buff do leNavios
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader("EXEMPLO-NAVIOS.CSV"));
            leNavios = new Scanner(streamEntrada); // Usa como entrada um arquivo

            Charset.forName("UTF-8");

        } catch (Exception e) {
            System.out.println(e);
        }
        /**
         * Buff do leCliente
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader("EXEMPLO-CLIENTES.CSV"));
            leCliente = new Scanner(streamEntrada); // Usa como entrada um arquivo

            Charset.forName("UTF-8");

        } catch (Exception e) {
            System.out.println(e);
        }
        /**
         * Buff do leTipoCarga
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader("EXEMPLO-TIPOSCARGAS.CSV"));
            leTipoCarga = new Scanner(streamEntrada); // Usa como entrada um arquivo

            Charset.forName("UTF-8");

        } catch (Exception e) {
            System.out.println(e);
        }
        /**
         * Buff do leCarga
         */
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader("EXEMPLO-CARGAS.CSV"));
            leCarga = new Scanner(streamEntrada); // Usa como entrada um arquivo

            Charset.forName("UTF-8");

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void executa() {
        leArquivos();

    }

    public void leArquivos() {
        System.out.println("porto");
        lePorto();
        System.out.println("distancia");
        leDistancia();
        System.out.println("navios");
        leNavios();
        System.out.println("cliente");
        leClientes();
        System.out.println("tipocarga");
        leTiposCargas();
        System.out.println("carga");
        leCargas();

    }

    public void veSeTemSave() {

    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Porto
     */
    public void lePorto() {
        int codigoPorto;
        String nomePorto;
        String paisPorto;
        String a = lePorto.nextLine();
        while (lePorto.hasNextLine()) {
            a = lePorto.nextLine();
            System.out.println(a);
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
    public void leDistancia() {
        String origem;
        String destino;
        double distancia;
        String a = leDistancia.nextLine();
        while (leDistancia.hasNextLine()) {
            a = leDistancia.nextLine();
            System.out.println(a);
            String linhaDoArquivo[] = a.split(";");
            origem = linhaDoArquivo[0];
            destino = linhaDoArquivo[1];
            distancia = Double.parseDouble(linhaDoArquivo[2]);

            Distancia obj = new Distancia(origem, destino, distancia);
            colecaoDistancias.addNoMapa(obj);

        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Navio
     */
    public void leNavios() {
        String nome;
        double velocidade;
        double autonomia;
        double customilhaBasico;

        String a = leNavios.nextLine();
        while (leNavios.hasNextLine()) {
            a = leNavios.nextLine();
            System.out.println(a);
            String linhaDoArquivo[] = a.split(";");
            nome = linhaDoArquivo[0];
            velocidade = Double.parseDouble(linhaDoArquivo[1]);
            autonomia = Double.parseDouble(linhaDoArquivo[2]);
            customilhaBasico = Double.parseDouble(linhaDoArquivo[3]);

            Navio navio = new Navio(nome, velocidade, autonomia, customilhaBasico);
            colecaoNavios.addNavio(navio);
        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para Cliente
     */
    public void leClientes() {
        int cod;
        String nome;
        String email;
        String a = leCliente.nextLine();
        while (leCliente.hasNextLine()) {
            a = leCliente.nextLine();
            System.out.println(a);
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
    public void leTiposCargas() {
        int numero;
        String descricao;

        String a = leTipoCarga.nextLine();
        while (leTipoCarga.hasNextLine()) {
            a = leTipoCarga.nextLine();
            System.out.println(a);
            String linhaDoArquivo[] = a.split(";");
            numero = Integer.parseInt(linhaDoArquivo[0]);
            descricao = linhaDoArquivo[1];
            if (linhaDoArquivo[2].equals("DURAVEL")) {
                // Duravel a=linhaDoArquivo[2];
                String setor = linhaDoArquivo[3];
                String material = linhaDoArquivo[4];
                double nsei = Double.parseDouble(linhaDoArquivo[5]);
                // TipoCarga tipoCarga=new TipoCarga(numero,descricao,setor,material,nsei);
                // colecaoTipoCarga.addTipoCarga(tipoCarga);
            } else {
                // Duravel a=linhaDoArquivo[2];
                String origem = linhaDoArquivo[3];
                int tempomaximo = Integer.parseInt(linhaDoArquivo[4]);

                // TipoCarga tipoCarga=new TipoCarga(numero,descricao,origem,tempomax);
                // colecaoTipoCarga.addTipoCarga(tipoCarga);

            }

        }
    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Carga
     */
    public void leCargas() {
        int codigo;
        int cliente;
        String origem;
        String destino;
        double peso;
        double valorDeclarado;
        double tempoMaximo;
        int tipoCarga;
        // RAPIDO/BARATO
        // SITUACAO
        String a = leCarga.nextLine();
        while (leCarga.hasNextLine()) {
            a = leCarga.nextLine();
            System.out.println(a);
            String linhaDoArquivo[] = a.split(";");
            codigo = Integer.parseInt(linhaDoArquivo[0]);
            cliente = Integer.parseInt(linhaDoArquivo[1]);
            origem = linhaDoArquivo[2];
            destino = linhaDoArquivo[3];
            peso = Double.parseDouble(linhaDoArquivo[4]);
            valorDeclarado = Double.parseDouble(linhaDoArquivo[5]);
            tempoMaximo = Double.parseDouble(linhaDoArquivo[6]);
            tipoCarga = Integer.parseInt(linhaDoArquivo[7]);
            // prioridade
            // situacao
            // Carga carga=new Carga(codigo, cliente, valorDeclarado, tipoCarga, null);

            // colecaoCarga.addCarga(carga);

        }
    }
}
