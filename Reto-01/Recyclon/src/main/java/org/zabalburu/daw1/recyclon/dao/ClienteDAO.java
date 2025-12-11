/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Cliente;

/**
 *
 * @author DAW1
 */
public interface ClienteDAO {
    List <Cliente> getClientes();
    public Cliente getCliente(Integer id);
    public Cliente getCliente(String nombre);
    public void deleteCliente(Integer id);
    public Cliente addCliente(Cliente nuevo);
    public void modificarCliente(Cliente modificar);
}
