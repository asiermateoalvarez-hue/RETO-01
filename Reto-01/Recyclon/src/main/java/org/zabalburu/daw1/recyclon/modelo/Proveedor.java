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

    public Proveedor(Integer id, Integer cif, String nombre, String email, String telefono, String codigoPostal, String ciudad, String provincia, String logo, Date fechaAlta, TipoProveedor tipo, List<Movimiento> movimientos, EstadoProveedor estado, String categoria, String cuentaBanco, Integer diasPago, String personaContacto, String descMovimiento) {
        super(id, cif, nombre, email, telefono, codigoPostal, ciudad, provincia, logo);
        this.fechaAlta = fechaAlta;
        this.tipo = tipo;
        this.movimientos = movimientos;
        this.estado = estado;
        this.categoria = categoria;
        this.cuentaBanco = cuentaBanco;
        this.diasPago = diasPago;
        this.personaContacto = personaContacto;
        this.descMovimiento = descMovimiento;
    }

    private Date fechaAlta;
    private TipoProveedor tipo;
    private List<Movimiento> movimientos;
    private EstadoProveedor estado;
    private String categoria;
    private String cuentaBanco;
    private Integer diasPago;
    private String personaContacto;
    private String descMovimiento;
}
