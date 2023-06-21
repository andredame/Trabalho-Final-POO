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
    /**
     * Adiciona um cliente à coleção.
     * O cliente é adicionado à lista de clientes e a lista é ordenada por código.
     * @param cliente O cliente a ser adicionado.
     * @return true se o cliente foi adicionado com sucesso, false caso contrário.
     */
    public boolean addCliente(Cliente cliente) {
        boolean adicionado = clientes.add(cliente);
        if (adicionado) {
            Collections.sort(clientes, Comparator.comparingInt(Cliente::getCod));
        }
        return adicionado;
    }
    /**
     * Obtém todos os clientes da coleção.
     * @return A lista de clientes.
     */
    public ArrayList<Cliente> getCliente() {
        return clientes;
    }
    /**
     * Verifica se um cliente com o email especificado existe na coleção.
     * @param email O email a ser procurado.
     * @return true se o email existe na coleção, false caso contrário.
     */
    public boolean procuraEmail(String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Verifica se a coleção contém um cliente com o ID especificado.
     * @param id O ID do cliente a ser verificado.
     * @return true se o cliente existe na coleção, false caso contrário.
     */
    public boolean containsId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getCod() == id) {
                return true;
            }
        }
        return false;
    }
    /**
     * Procura um cliente pelo seu ID.
     * @param id O ID do cliente.
     * @return O cliente correspondente ao ID, ou null se não encontrado.
     */
    public Cliente procuraId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getCod() == id) {
                return cliente;
            }
        }
        return null;
    }

    

}