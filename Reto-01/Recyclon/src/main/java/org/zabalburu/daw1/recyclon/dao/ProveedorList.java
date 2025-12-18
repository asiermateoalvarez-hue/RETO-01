/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Cliente;
import org.zabalburu.daw1.recyclon.modelo.Proveedor;

/**
 *
 * @author DAW1
 */
public class ProveedorList implements ProveedorDAO {

    private List<Proveedor> proveedores = new ArrayList<>();

    @Override
    public List<Proveedor> getProveedores() {
        return proveedores;
    }

    @Override
    public Proveedor getProveedor(Integer id) {
        Proveedor buscar = new Proveedor();
        buscar.setId(id);

        int posc = proveedores.indexOf(buscar);
        if (posc != -1) {
            return proveedores.get(id);
        } else {
            return null;
        }

    }

    @Override
    public Proveedor getProveedor(String nombre) {
        int i;
        for (i = 0; i < proveedores.size()
                && !nombre.equalsIgnoreCase(proveedores.get(i).getNombre());
                i++);
        if (i < proveedores.size()) {
            // Está en la posición i
            return proveedores.get(i);
        } else {
            // No está
            return null;
        }
    }

    @Override
    public void deleteProveedor(Integer id) {
        Proveedor eliminar = new Proveedor();
        eliminar.setId(id);
        proveedores.remove(eliminar);
    }

    @Override
    public Proveedor addProveedor(Proveedor nuevo) {
        Integer id = 1;
        if (!proveedores.isEmpty()) {
            Integer max = proveedores.get(0).getId();
            for (int i = 0; i < proveedores.size(); i++) {
                if (proveedores.size() > max) {
                    max = proveedores.get(i).getId();
                }
            }
            id = max + 1;

        }
        nuevo.setId(id);
        proveedores.add(nuevo);
        return nuevo;
    }

    @Override
    public void modificarProveedor(Proveedor modificar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
