package Colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Objetos.Cliente;

public class ColecaoCliente {
    private ArrayList<Cliente> clientes;

    public ColecaoCliente() {
        clientes = new ArrayList<>();
    }

    public boolean addCliente(Cliente cliente) {
        boolean adicionado = clientes.add(cliente);
        if (adicionado) {
            Collections.sort(clientes, Comparator.comparingInt(Cliente::getCod));
        }
        return adicionado;
    }

    public ArrayList<Cliente> getCliente() {
        return clientes;
    }

    public boolean procuraEmail(String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean procuraId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getCod() == id) {
                return true;
            }
        }
        return false;
    }

}