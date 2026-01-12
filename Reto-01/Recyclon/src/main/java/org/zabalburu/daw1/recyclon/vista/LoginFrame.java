/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.vista;

import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.zabalburu.daw1.recyclon.config.Config;

/**
 *
 * @author Aaron David
 */
public class LoginFrame extends JFrame {
    
    private Dimension dmVentana = new Dimension(Config.LOGIN_WIDTH, Config.LOGIN_HEIGHT);
    
    private JLabel lblUsuario = new JLabel("Usuario");
    private JTextField txtUsuario = new JTextField();
    
    private JLabel lblPassword = new JLabel("Contraseña");
    private JPasswordField pwdPassword = new JPasswordField();
    
    private JLabel lblLogo = new JLabel(new ImageIcon(getClass().getResource(Config.RUTA_IMAGENES + "logo.png")));
    
    private JButton btnEntrar = new JButton("Entrar");
    private JButton btnSalir = new JButton("Salir");    //Panel Principal
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
        pnlLogo.add(lblLogo);

        //Panel Central
        lblUsuario.setFont(Config.FUENTE_NORMAL);
        pnlCentral.add(lblUsuario);
        pnlCentral.add(txtUsuario);
        
        lblPassword.setFont(Config.FUENTE_NORMAL);
        pnlCentral.add(lblPassword);
        pnlCentral.add(pwdPassword);
        pnlFormulario.add(pnlCentral);

        pnlCentral.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
        
        //Panel Botones
        pnlBotones.add(btnEntrar);
        
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
        
        
    }
    
    public static void main(String[] args) {
        FlatGradiantoNatureGreenIJTheme.setup();
        new LoginFrame();
        
    }
    
}
