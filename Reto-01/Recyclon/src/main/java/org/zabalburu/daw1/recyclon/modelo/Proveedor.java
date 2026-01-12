/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.modelo;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.zabalburu.daw1.recyclon.util.EstadoProveedor;
import org.zabalburu.daw1.recyclon.util.TipoProveedor;

/**
 *
 * @author Aaron David
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor extends Empresa {

    private Date fechaAlta;
    private TipoProveedor tipo;
    private List<Movimiento> movimientos;
    private EstadoProveedor estado;
    private String categoria;
    private Integer diasPago;
    private String personaContacto;
    private String descMovimiento;
}
