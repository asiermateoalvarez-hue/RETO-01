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

/**
 *
 * @author Aaron David
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nombreUsuario;
    private String password;
    private String email;
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private String telefono;
    private int rol;
    public static final int ADMIN = 1;
    public static final int USER = 2;

    
    // esto irá en Servicio (hacen falta modificaciones)
    
    /*public boolean validarCredenciales(String usuario, String pass) {
        if (usuario == null || pass == null) {
            return false;
        }
        return this.nombreUsuario.equals(usuario) && this.password.equals(pass);
    }*/

}
