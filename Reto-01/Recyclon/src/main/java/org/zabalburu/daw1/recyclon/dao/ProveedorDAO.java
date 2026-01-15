/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Proveedor;

/**
 *
 * @author Equipo 03 Interfaz DAO para la gestión de proveedores. Define los
 * métodos necesarios para realizar operaciones CRUD sobre los proveedores.
 */
public interface ProveedorDAO {

    /**
     * Obtiene la lista completa de todos los Proveedores registrados.
     *
     * @return Una lista con todos los Proveedores. Retorna una lista vacía si
     * no hay Proveedores.
     */
    List<Proveedor> getProveedores();

    /**
     * Obtiene un proveedor específico por su ID.
     *
     * @param id El ID del proveedor a buscar.
     * @return El proveedor encontrado, o null si no existe.
     */
    public Proveedor getProveedor(Integer id);

    /**
     * Obtiene un proveedor específico por su nombre.
     *
     * @param nombre El nombre del proveedor a buscar.
     * @return El proveedor encontrado, o null si no existe.
     */
    public Proveedor getProveedor(String nombre);

    /**
     * Elimina un proveedor de la base de datos por su ID.
     *
     * @param id El ID del proveedor a eliminar.
     */
    public void deleteProveedor(Integer id);

    /**
     * Agrega un nuevo proveedor.
     *
     * @param nuevo El proveedor a agregar. No puede ser null.
     * @return El proveedor agregado con su ID asignado.
     */
    public Proveedor addProveedor(Proveedor nuevo);

    /**
     * Modifica los datos de un proveedor existente.
     *
     * @param modificar El proveedor con los datos actualizados. No puede ser
     * null.
     */
    public void modificarProveedor(Proveedor modificar);
}
