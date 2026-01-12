/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.dao;

import java.util.ArrayList;
import java.util.List;
import org.zabalburu.daw1.recyclon.modelo.Movimiento;
import org.zabalburu.daw1.recyclon.util.TipoMovimiento;

/**
 *
 * @author DAW1
 */
public class MovimientoList implements MovimientoDAO {

    private static List<Movimiento> movimientos = new ArrayList<>();

    @Override
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    @Override
    public Movimiento getMovimiento(Integer id) {
        Movimiento buscar = new Movimiento();
        buscar.setId(id);
        int posc = movimientos.indexOf(buscar);
        if (posc != -1) {
            //esta e posc
            return movimientos.get(posc);
        } else {
            return null;
        }
    }

    @Override
    public void deleteMovimiento(Integer id) {
        Movimiento eliminar = getMovimiento(id);
        movimientos.remove(eliminar);
        eliminar.getCuentaBanco().getMovimientos().remove(eliminar);
        if (eliminar.getTipo() == TipoMovimiento.COBRO) {
            eliminar.getCliente().getMovimientos().remove(eliminar);
        } else {
            eliminar.getProveedor().getMovimientos().remove(eliminar);
        }

    }

    @Override
    public Movimiento addMovimiento(Movimiento nuevo) {
        Integer id = 1;
        if (!movimientos.isEmpty()) {
            Integer max = movimientos.get(0).getId();
            for (int i = 1; i < movimientos.size(); i++) {
                if (movimientos.get(i).getId() > max) {
                    max = movimientos.get(i).getId();
                }
            }
            id = max + 1;
        }
        nuevo.setId(id);
        movimientos.add(nuevo);
        nuevo.getCuentaBanco().getMovimientos().add(nuevo);
        if (nuevo.getTipo() == TipoMovimiento.COBRO) {
            nuevo.getCliente().getMovimientos().add(nuevo);
        } else {
            nuevo.getProveedor().getMovimientos().add(nuevo);
        }
        
        return nuevo;

    }

    @Override
    public void modificarMovimiento(Movimiento modificar) {
         int pos = movimientos.indexOf(modificar);
        if (pos != -1) {
            movimientos.set(pos, modificar);
        }
    }

}
