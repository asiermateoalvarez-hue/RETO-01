/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.gestionempleados.dao;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;

/**
 *
 * @author Equipo03
 */
public class UsuarioDAOImpl {

    private static List<Usuario> usuarios = new ArrayList<>();

    /**
     * Constructor de UsuarioImpl. Inicializa la clase para gestionar usuarios
     * en memoria.
     */
    public UsuarioDAOImpl() {

    }

    /**
     * Obtiene un usuario específico por su nombre de usuario. Realiza una
     * búsqueda lineal en la lista de usuarios.
     *
     * @param usuario El nombre de usuario a buscar.
     * @return El usuario encontrado, o null si no existe.
     */
    public Usuario getUsuario(String usuario) {
        // Búsqueda Desordenada
        int i;
        for (i = 0; i < usuarios.size()
                && !usuario.equals(usuarios.get(i).getUsuario()); i++);
        if (i < usuarios.size()) {
            // Está en i
            return usuarios.get(i);
        } else {
            // Nos hemos salido. No está
            return null;
        }
    }

    /**
     * Agrega un nuevo usuario a la lista de usuarios. Asigna automáticamente un
     * ID único basado en el ID máximo existente.
     *
     * @param usuario El usuario a agregar. No puede ser null.
     * @return El usuario agregado con su ID asignado.
     */
    public Usuario nuevoUsuario(Usuario usuario) {
        Integer maxId = 0;
        for (Usuario u : usuarios) {
            if (u.getId().compareTo(maxId) > 0) {
                maxId = u.getId();
            }
        }
        usuario.setId(maxId + 1);
        usuarios.add(usuario);
        return usuario;
    }

    /**
     * Obtiene la lista completa de todos los usuarios registrados.
     *
     * @return Una lista con todos los usuarios. Retorna una lista vacía si no
     * hay usuarios.
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

}
