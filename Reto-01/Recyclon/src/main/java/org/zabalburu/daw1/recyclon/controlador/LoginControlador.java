/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.controlador;

import javax.swing.JOptionPane;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.servicio.RecyclonServicio;
import org.zabalburu.daw1.recyclon.vista.AdminFrame;
import org.zabalburu.daw1.recyclon.vista.LoginFrame;

/**
 *
 * @author DAW1
 */
public class LoginControlador {

    private LoginFrame loginFrame;
    private RecyclonServicio servicio;

    public LoginControlador(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
        this.servicio = new RecyclonServicio();
        loginFrame.getBtnEntrar().addActionListener(e -> {
            manejarLogin();
        });

    }

    private void manejarLogin() {
        String usuario = loginFrame.getTxtUsuario();
        String password = loginFrame.getPwdPassword();
        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginFrame, "¡No pueden haber campos vacios!",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Usuario u = servicio.login(usuario, password);

        if (u != null) {
            new AdminFrame(u).setVisible(true);
            loginFrame.dispose();
        } else {
            JOptionPane.showMessageDialog(loginFrame, "Usuario / Password Erroneo",
                    "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
        }

    }
}
