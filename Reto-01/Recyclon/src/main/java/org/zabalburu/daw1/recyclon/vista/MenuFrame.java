/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.config.Config;

/**
 *
 * @author DAW1
 */
public class MenuFrame extends JFrame {

    private Usuario usuarioLogeado;

    private Dimension dmVentana = new Dimension(Config.MENU_WIDTH, Config.MENU_HEIGHT);

    private JLabel lblLogo = new JLabel();

    private JButton btnCliente = new JButton("Cliente");

    private JButton btnProveedor = new JButton("Proveedor");

    private JButton btnMovimiento = new JButton("Movimiento");

    private JButton btnSalir = new JButton("Cerrar Sesión");

    //Panel Cabecera
    private JPanel pnlLogo = new JPanel();

    //Panel Central
    private JPanel pnlCentral = new JPanel(new GridLayout(4, 1, 10, 10));

    public MenuFrame(Usuario usuario) {
        super();
        this.setTitle("Recyclon - Menú");
        this.setSize(dmVentana);
        this.setUndecorated(true);
        this.usuarioLogeado = usuario;

        //Cabecera
        lblLogo.setIcon(Config.cargarLogo(250, 130));
        pnlLogo.add(lblLogo);

        // ======= Panel Central =======
        btnCliente.addActionListener(e -> {
            new ClientesFrame(usuario).setVisible(true);
            this.dispose();
        });
        btnCliente.setPreferredSize(new Dimension(150, 80));
        btnCliente.setIcon(Config.cargarIcono("cliente.png", 30, 30));
        pnlCentral.add(btnCliente);

        btnProveedor.addActionListener(e -> {
            new ProveedorFrame(usuario).setVisible(true);
            this.dispose();
        });
        btnProveedor.setPreferredSize(new Dimension(150, 80));
        btnProveedor.setIcon(Config.cargarIcono("proveedor.png", 30, 30));
        pnlCentral.add(btnProveedor);

        btnMovimiento.addActionListener(e -> {
            new MovimientoFrame(usuario).setVisible(true);
            this.dispose();
        });
        btnMovimiento.setPreferredSize(new Dimension(150, 80));
        btnMovimiento.setIcon(Config.cargarIcono("movimiento.png", 30, 30));
        pnlCentral.add(btnMovimiento);

        btnSalir.setIcon(Config.cargarIcono("salir.png", 30, 30));
        btnSalir.setBackground(Config.COLOR_BOTON_SALIR);
        btnSalir.addActionListener(e -> {
            if ((JOptionPane.showConfirmDialog(this,
                    "¿Seguro que quieres cerrar sesión?",
                    "Cerrar Sesión",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE)
                    == JOptionPane.YES_OPTION)) {
                new LoginFrame().setVisible(true);
                this.dispose();
            }
        });
        btnSalir.setPreferredSize(new Dimension(150, 80));
        pnlCentral.add(btnSalir);
        pnlCentral.setBorder(new EmptyBorder(10, 20, 10, 20));
        for (Component c : pnlCentral.getComponents()) {
            if (c instanceof JButton) {
                c.setFont(Config.FUENTE_NORMAL);
                c.setForeground(Config.COLOR_TEXTO);
                ((JButton) c).setIconTextGap(20);
            }
        }

        this.add(pnlLogo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

    public JButton getBtnCliente() {
        return btnCliente;
    }

    public JButton getBtnProveedor() {
        return btnProveedor;
    }

    public JButton getBtnMovimiento() {
        return btnMovimiento;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

}
