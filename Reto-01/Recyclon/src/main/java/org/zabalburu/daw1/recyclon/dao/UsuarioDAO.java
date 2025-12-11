/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Usuario;

/**
 *
 * @author DAW1
 */
public interface UsuarioDAO {
    public List <Usuario> getUsuarios();
    public void modificarPassword(String password);
    public Usuario addUsuario(Integer id);
    public void deleteUsuario(Integer id);
    public void modificarNombreUsuario(String nombre);
    public void modificarUsuario(Usuario modificar);
    public Usuario getUsuario(String nombre);
    public Usuario getUsuario(Integer id);
}
