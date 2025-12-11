/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Movimiento;

/**
 *
 * @author DAW1
 */
public interface MovimientoDAO {
    List <Movimiento> getMovimientos();
    public Movimiento getMovimiento(Integer id);
    public void deleteMovimiento(Integer id);
    public Movimiento addMovimiento(Movimiento nuevo);
    public void modificarMovimiento(Movimiento modificar);
}
