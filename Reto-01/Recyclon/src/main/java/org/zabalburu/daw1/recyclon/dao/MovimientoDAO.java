/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Movimiento;

/**
 *
 * @author Equipo 03
 * Interfaz DAO para la gestión de Movimientos.
 * Define los métodos necesarios para realizar operaciones CRUD sobre movimientos.
*/
public interface MovimientoDAO {
    
     /**
     * Obtiene la lista completa de todos los Movimientos registrados.
     * 
     * @return Una lista con todos los usuarios. Retorna una lista vacía si no hay usuarios.
     */
    List <Movimiento> getMovimientos();
    
    /**
     * Obtiene un movimiento específico por su ID.
     * 
     * @param id El ID del movimineto a buscar.
     * @return El movimineto encontrado, o null si no existe.
     */
    public Movimiento getMovimiento(Integer id);
    
    /**
     * Devuelve un movimineto de la base de datos por su ID.
     * 
     * @param id El ID del movimiento a eliminar.
     */
    public void deleteMovimiento(Integer id);
    
    /**
     * Agrega un nuevo movimiento.
     * 
     * @param nuevo El movimiento a agregar. No puede ser null.
     * @return El movimiento agregado con su ID asignado.
     */
    public Movimiento addMovimiento(Movimiento nuevo);
    
    /**
     * Modifica los datos de un movimiento existente.
     * 
     * @param modificar El movimiento con los datos actualizados. No puede ser null.
     */
    public void modificarMovimiento(Movimiento modificar);
}
