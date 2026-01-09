/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Usuario;

/**
 *
 * @author Eqipo 03
 * Interfaz DAO para la gestión de Usuarios.
 * Define los métodos necesarios para realizar operaciones CRUD sobre los usuarios.
 */
public interface UsuarioDAO {
    /**
     * Obtiene la lista completa de todos los usuarios registrados.
     * 
     * @return Una lista con todos los usuarios. Retorna una lista vacía si no hay usuarios.
     */
    public List <Usuario> getUsuarios();
    
    /**
     * Modifica la contraseña de un usuario existente.
     * 
     * @param password. No puede ser null.
     * No devuelve ningun objeto, solo actualiza la contraseña
     */
    public void modificarPassword(String password);
    
    /**
     * Agrega un nuevo usuario.
     * 
     * @param nuevo El Usuario a agregar. No puede ser null.
     * @return El Usuario agregado con su ID asignado.
     */
    public Usuario addUsuario(Integer id);
    
    /**
     * Elimina un usuario de la base de datos por su ID.
     * 
     * @param id El ID del usuario a eliminar.
     */
    public void deleteUsuario(Integer id);
    
    /**
     * Modifica los datos de un usuario existente.
     * 
     * @param modificar El usuario con los datos actualizados. No puede ser null.
     */
    public void modificarNombreUsuario(String nombre);
    
     /**
     * Modifica un usuario existente.
     * 
     * @param modificar.Tiene que ser un objeto de un Usuario existente.
     * No devuelve ningun objeto, solo actualiza el nombre de usuario
     */
    public void modificarUsuario(Usuario modificar);
    
     /**
     * Obtiene un Usuario específico por su nombre.
     * 
     * @param nombre El nombre del usuario a buscar.
     * @return El Usuario encontrado, o null si no existe.
     */
    public Usuario getUsuario(String nombre);
    
    /**
     * Obtiene un Usuario específico por su ID.
     * 
     * @param id El ID del Usuario a buscar.
     * @return El Usuario encontrado, o null si no existe.
     */
    public Usuario getUsuario(Integer id);
}
