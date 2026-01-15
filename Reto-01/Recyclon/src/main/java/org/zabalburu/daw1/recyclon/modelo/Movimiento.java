/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.modelo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.zabalburu.daw1.recyclon.util.EstadoMovimiento;
import org.zabalburu.daw1.recyclon.util.TipoMovimiento;

/**
 *
 * @author Aaron David
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Movimiento {

    @EqualsAndHashCode.Include
    private Integer id;
    private Date fecha;
    private Double monto;
    private String descripcion;
    private TipoMovimiento tipo;
    private EstadoMovimiento estado;
    private Cliente cliente;
    private Proveedor proveedor;

    /**
     * Valida que el movimiento tenga la estructura correcta según su tipo.
     *
     * Un movimiento es válido si: - Si es COBRO: debe tener un cliente y NO
     * tener un proveedor. - Si es GASTO: debe tener un proveedor y NO tener un
     * cliente.
     *
     * @return true si el movimiento es válido, false en caso contrario.
     */
    public boolean esValido() {
        if (tipo == TipoMovimiento.COBRO) {

            return cliente != null && proveedor == null;
        } else if (tipo == TipoMovimiento.GASTO) {

            return proveedor != null && cliente == null;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", descripcion=" + descripcion + ", tipo=" + tipo + ", estado=" + estado + '}';
    }

}
