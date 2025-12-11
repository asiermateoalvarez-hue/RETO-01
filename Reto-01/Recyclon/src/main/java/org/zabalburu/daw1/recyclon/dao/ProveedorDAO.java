/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Proveedor;

/**
 *
 * @author DAW1
 */
public interface ProveedorDAO {
    List <Proveedor> getProveedores();
    public Proveedor getProveedor(Integer id);
    public Proveedor getProveedor(String nombre);
    public void deleteProveedor(Integer id);
    public Proveedor addProveedor(Proveedor nuevo);
    public void modificarProveedor(Proveedor modificar);
}
