/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.util;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Equipo03
 */
public class PasswordManager {

    /**
     * Genera un hash seguro de una contraseña usando BCrypt.
     *
     * @param password La contraseña en texto plano
     * @return El hash de la contraseña
     */
    public static String getHash(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacia");
        }
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Compara una contraseña escrita por el usuario con el hash guardado en la
     * base de datos.
     *
     * @param password La contraseña real (texto plano) que ingresó el usuario.
     * @param hash La contraseña encriptada (hash) que recuperaste de la BD.
     * @return true si la contraseña es correcta; false si no coincide.
     */
    public static boolean checkPassword(String password, String hash) {

        return BCrypt.checkpw(password, hash);
    }

}
