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
import org.zabalburu.daw1.recyclon.util.EstadoCliente;

/**
 *
 * @author Aaron David
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente extends Empresa {

    private Date fechaAlta;
    private Double limiteCredito;
    private List<Movimiento> movimientos;
    private EstadoCliente estado;

    public Cliente(Integer id, Integer cif, String nombre, String email, String telefono, String codigoPostal, String ciudad, String provincia, String logo, Date fechaAlta, Double limiteCredito, List<Movimiento> movimientos, EstadoCliente estado) {
        super(id, cif, nombre, email, telefono, codigoPostal, ciudad, provincia, logo);
        this.fechaAlta = fechaAlta;
        this.limiteCredito = limiteCredito;
        this.movimientos = movimientos;
        this.estado = estado;
    }
    
    
}
