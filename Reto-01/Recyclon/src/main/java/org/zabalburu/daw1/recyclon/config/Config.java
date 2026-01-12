/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.config;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Aaron David
 */
public class Config {

    // ========= Tamaño de Ventanas =========
    public static final int LOGIN_WIDTH = 400;
    public static final int LOGIN_HEIGHT = 300;
    public static final int ADMIN_WIDTH = 1000;
    public static final int ADMIN_HEIGHT = 600;
    public static final int DIALOG_WIDTH = 500;
    public static final int DIALOG_HEIGHT = 400;

    // ========= COLORES =========
    public static final Color COLOR_FONDO = new Color(218, 245, 228);
    public static final Color COLOR_BOTONES = new Color(76, 175, 80);
    public static final Color COLOR_TEXTO = new Color(33, 33, 33);
    public static final Color COLOR_ERROR = new Color(244, 67, 54); // Rojo
    public static final Color COLOR_EXITO = new Color(76, 175, 80); // Verde

    // ========= FUENTE =========
    public static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 24);
    public static final Font FUENTE_NORMAL = new Font("Arial", Font.PLAIN, 14);
    public static final Font FUENTE_PEQUEÑA = new Font("Arial", Font.PLAIN, 12);

    // ========= RUTA RECURSOS =========
    public static final String RUTA_IMAGENES = "/resources/imagenes/";
}
