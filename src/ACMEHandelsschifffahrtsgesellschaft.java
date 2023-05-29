import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ACMEHandelsschifffahrtsgesellschaft {

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
        try {
            BufferedReader streamEntrada = new BufferedReader(
                    new FileReader("dados.csv"));
           // entrada = new Scanner(streamEntrada); // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(
                    new File("resultado.csv"));
            Charset.forName("UTF-8");
            System.setOut(streamSaida); // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
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
        System.out.println(lePorto);
    }

    public void leArquivos() {

    }

    public void veSeTemSave() {

    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Porto
     */
    public void lePorto() {

    }

    /*
     * Le e cadastra as informações do arquivo especifico para a Distancia
     */
    public void leDistancia() {

    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Navio
     */
    public void leNavios() {
      
    }

    /*
     * Le e cadastra as informações do arquivo especifico para Cliente
     */
    public void leClientes() {

    }

    /*
     * Le e cadastra as informações do arquivo especifico para o TipoCarga
     */
    public void leTiposCargas() {

    }

    /*
     * Le e cadastra as informações do arquivo especifico para o Carga
     */
    public void leCargas() {

    }
}
