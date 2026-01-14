/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.vista;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.config.Config;
import org.zabalburu.daw1.recyclon.servicio.RecyclonServicio;

/**
 *
 * @author Aaron David
 */
public class LoginFrame extends JFrame {
    
    private static RecyclonServicio servicio = new RecyclonServicio();

    private Dimension dmVentana = new Dimension(Config.LOGIN_WIDTH, Config.LOGIN_HEIGHT);

    private JLabel lblUsuario = new JLabel("Usuario");
    private JTextField txtUsuario = new JTextField();

    private JLabel lblPassword = new JLabel("Contraseña");
    private JPasswordField pwdPassword = new JPasswordField();

    private JLabel lblLogo = new JLabel();

    private JButton btnEntrar = new JButton("Entrar");
    private JButton btnSalir = new JButton("Salir");

    //Panel Principal
    private JPanel pnlPrincipal = new JPanel(new BorderLayout());

    //Panel Cabecera
    private JPanel pnlLogo = new JPanel();

    //Panel del Formulario
    private JPanel pnlFormulario = new JPanel(new FlowLayout());

    //Panel Central
    private JPanel pnlCentral = new JPanel(new GridLayout(2, 2, 10, 10));

    //Panel Botones
    private JPanel pnlBotones = new JPanel(new FlowLayout());

    public LoginFrame() {
        super();
        this.setTitle("Recyclon - Login");
        this.setSize(dmVentana);
        this.setUndecorated(true);

        //Cabecera
        lblLogo.setIcon(Config.cargarLogo(250, 130));
        pnlLogo.add(lblLogo);

        //Panel Central
        lblUsuario.setFont(Config.FUENTE_NORMAL);
        lblUsuario.setIcon(Config.cargarIcono("user.png", 30, 30));
        lblUsuario.setIconTextGap(20);
        lblUsuario.setBorder(new EmptyBorder(0, 25, 0, 25));
        pnlCentral.add(lblUsuario);
        pnlCentral.add(txtUsuario);

        lblPassword.setFont(Config.FUENTE_NORMAL);
        lblPassword.setIcon(Config.cargarIcono("password.png", 30, 30));
        lblPassword.setBorder(new EmptyBorder(0, 25, 0, 25));
        lblPassword.setIconTextGap(20);
        pnlCentral.add(lblPassword);
        pnlCentral.add(pwdPassword);
        pnlFormulario.add(pnlCentral);

        pnlCentral.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        //Panel Botones
        btnEntrar.setIcon(Config.cargarIcono("entrar.png", 30, 30));
        btnEntrar.setBackground(Config.COLOR_BOTON_ENTRAR);
        btnEntrar.setFont(Config.FUENTE_PEQUEÑA);
        btnEntrar.setForeground(Config.COLOR_TEXTO);
        btnEntrar.setIconTextGap(20);
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEntrar.addActionListener( e -> manejarLogin());
        pnlBotones.add(btnEntrar);

        btnSalir.setIcon(Config.cargarIcono("salir.png", 30, 30));
        btnSalir.setBackground(Config.COLOR_BOTON_SALIR);
        btnSalir.setFont(Config.FUENTE_PEQUEÑA);
        btnSalir.setForeground(Config.COLOR_TEXTO);
        btnSalir.setBackground(Config.COLOR_BOTON_SALIR);
        btnSalir.setIconTextGap(20);
        btnSalir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSalir.addActionListener(e -> {
            System.exit(0);
        });

        pnlBotones.add(btnSalir);

        this.add(pnlLogo, BorderLayout.NORTH);
        this.add(pnlFormulario, BorderLayout.CENTER);
        this.add(pnlBotones, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.getRootPane().setDefaultButton(btnEntrar);

    }

    /*private ImageIcon cargarIcono(String nombre, int ancho, int alto) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(Config.RUTA_IMAGENES + nombre));
            Image img = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(img);
        } catch (Exception e) {
            return null;
        }
    }*/

    public String getTxtUsuario() {
        return txtUsuario.getText();
    }

    public String getPwdPassword() {
        return new String(pwdPassword.getPassword());
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    private void manejarLogin() {
        String usuario = txtUsuario.getText();
        String password = new String(pwdPassword.getPassword());
        if (usuario.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No pueden haber campos vacios!",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Usuario u = servicio.login(usuario, password);

        if (u != null) {
            new MenuFrame(u).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuario / Password Erroneo",
                    "Acceso Denegado", JOptionPane.ERROR_MESSAGE);
        }    
    }
}
