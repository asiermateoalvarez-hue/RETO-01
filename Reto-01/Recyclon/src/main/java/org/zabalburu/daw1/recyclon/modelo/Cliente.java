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

/**
 *
 * @author Aaron David
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente extends Empresa {
    @EqualsAndHashCode.Include
    private Integer id;
    private Date fechaAlta;
    private Double limiteCredito;
    private List<Movimiento> movimientos;
    private int estado;
    public static final int INACTIVO = 0;
    public static final int ACTIVO = 1;
    public static final int SUSPENDIDO = 2;
}
