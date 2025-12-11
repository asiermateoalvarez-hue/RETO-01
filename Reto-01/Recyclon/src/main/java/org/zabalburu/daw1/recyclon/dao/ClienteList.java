/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Cliente;

/**
 *
 * @author DAW1
 */
public class ClienteList implements ClienteDAO{
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public Cliente getCliente(Integer id) {
        
      
    }

    @Override
    public Cliente getCliente(String nombre) {
        
    }

    @Override
    public void deleteCliente(Integer id) {
        Cliente eliminar = new Cliente();
        eliminar.setId(id);
        clientes.remove(eliminar);
        
    }

    @Override
    public Cliente addCliente(Cliente nuevo) {
        Integer id = 1;
        if (!clientes.isEmpty()) {
            Integer max= clientes.get(0).getId();
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.size()> max) {
                   max = clientes.get(i).getId();
                }
            
            }
          id = max + 1;
        }
        nuevo.setId(id);
        clientes.add(nuevo);
        return nuevo;
    }

    @Override
    public void modificarCliente(Cliente modificar) {
        int posc = clientes.indexOf(modificar);
        
        if (posc != -1) {
             clientes.set(posc, modificar);
        }
    }
    
}
