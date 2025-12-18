/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Cliente;

/**
 *
 * @author Equipo03

 * Interfaz DAO para la gestión de clientes.
 * Define los métodos necesarios para realizar operaciones CRUD sobre clientes.
 */
public interface ClienteDAO {
    /**
     * Obtiene la lista completa de todos los clientes registrados.
     * 
     * @return Una lista con todos los clientes. Retorna una lista vacía si no hay clientes.
     */
    List <Cliente> getClientes();
    
    /**
     * Obtiene un cliente específico por su ID.
     * 
     * @param id El ID del cliente a buscar.
     * @return El cliente encontrado, o null si no existe.
     */
    public Cliente getCliente(Integer id);
    
    /**
     * Obtiene un cliente específico por su nombre.
     * 
     * @param nombre El nombre del cliente a buscar.
     * @return El cliente encontrado, o null si no existe.
     */
    public Cliente getCliente(String nombre);
    
    /**
     * Elimina un cliente de la base de datos por su ID.
     * 
     * @param id El ID del cliente a eliminar.
     */
    public void deleteCliente(Integer id);
    /**
     * Agrega un nuevo cliente.
     * 
     * @param nuevo El cliente a agregar. No puede ser null.
     * @return El cliente agregado con su ID asignado.
     */
    public Cliente addCliente(Cliente nuevo);
    
    /**
     * Modifica los datos de un cliente existente.
     * 
     * @param modificar El cliente con los datos actualizados. No puede ser null.
     */
    public void modificarCliente(Cliente modificar);
}