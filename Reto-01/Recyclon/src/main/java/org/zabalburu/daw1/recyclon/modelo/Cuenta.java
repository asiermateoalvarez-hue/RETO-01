/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.modelo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Aaron David
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cuenta {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nombre;
    private String iban;
    private String banco;
    private Double saldo;
    private List<Movimiento> movimientos;

    /**
     * Calcula el saldo actual del banco basándose en los movimientos
     * registrados. Los COBROS suman al saldo, los GASTOS restan del saldo.
     *
     * @return El saldo total del banco después de todos los movimientos.
     */
    public Double calcularSaldo() {
        Double saldoTotal = saldo;
        //Buscar con el for de colecciones cada uno de los movimientos de la lista
        for (Movimiento mov : movimientos) {
            if (mov.getTipo() == Movimiento.COBRO) {
                saldoTotal += mov.getMonto();
            } else if (mov.getTipo() == Movimiento.GASTO) {
                saldoTotal -= mov.getMonto();
            }
        }
        return saldoTotal;
    }

    /**
     * Agrega un movimiento a la lista de movimientos del banco.
     *
     * @param movimiento El movimiento a agregar. No puede ser null.
     * @return true si el movimiento se agregó correctamente.
     * @throws IllegalArgumentException si el movimiento es null o no es válido.
     */
    public boolean agregarMovimiento(Movimiento mov) {
        if (mov == null) {
            throw new IllegalArgumentException("El movimiento no puede ser nulo");
        }
        if (!mov.esValido()) {
            throw new IllegalArgumentException("El movimiento no es valido");
        }
        movimientos.add(mov);
        return true;
    }
}
