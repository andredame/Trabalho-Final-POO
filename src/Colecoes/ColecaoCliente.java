package Colecoes;
import java.util.ArrayList;

import Objetos.Cliente;

public class ColecaoCliente{
    private ArrayList <Cliente> clientes;

    public ColecaoCliente() {
        clientes = new ArrayList<>();
    }
    public boolean addCliente(Cliente cliente){
        return clientes.add(cliente);
    }
    public ArrayList<Cliente> getCliente() {
        return clientes;
    }
    public boolean procuraId(int id){
        for (Cliente cliente : clientes) {
            if(cliente.getCod() == id){
                return true;
            }
        }
        return false;
    }
    public boolean procuraEmail(String email){
        for (Cliente cliente : clientes) {
            if(cliente.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

}