package Colecoes;
import java.util.ArrayList;

import Objetos.Cliente;

public class Freguesia{
    private ArrayList <Cliente> clientes;

    public Freguesia() {
        clientes = new ArrayList<>();
    }
    public boolean addCliente(Cliente cliente){
        return clientes.add(cliente);
    }
    public ArrayList<Cliente> getCliente() {
        return clientes;
    }

}