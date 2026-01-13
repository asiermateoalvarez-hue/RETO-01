/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.vista;

import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.config.Config;
import org.zabalburu.daw1.recyclon.modelo.Cliente;
import org.zabalburu.daw1.recyclon.servicio.RecyclonServicio;

/**
 *
 * @author DAW1
 */
public class ClientesFrame extends JFrame {

    //Usuario que se registra//////
    private RecyclonServicio servicio;
    private Usuario usuarioLogeado;
    private List<Cliente> clientes = new ArrayList<>();

    //////Cabecera/////////
    JLabel lblTitulo = new JLabel("GESTION DE CLIENTES");
    JLabel lblLogo = new JLabel();
    JLabel lblLogoEmpresa = new JLabel("Logo Empresa");

    JLabel lblNombre = new JLabel("Nombre");
    JTextField txtNombre = new JTextField();

    JLabel lblCif = new JLabel("CIF");
    JTextField txtCif = new JTextField();

    JLabel lblEmail = new JLabel("Email");
    JTextField txtEmail = new JTextField();

    JLabel lblTelefono = new JLabel("Telefono");
    JTextField txtTelefono = new JTextField();

    JLabel lblEstado = new JLabel("Estado");
    JTextField txtEstado = new JTextField();

    JLabel lblFecha = new JLabel("Fecha");
    JFormattedTextField fmtFecha
            = new JFormattedTextField(DateFormat.SHORT);

    JLabel lblProvincia = new JLabel("Provincia");
    JTextField txtProvincia = new JTextField();

    JLabel lblMunicipio = new JLabel("Municipio");
    JTextField txtMunicipio = new JTextField();

    JButton btnAnterior = new JButton();
    JButton btnSiguiente = new JButton();
    JButton btnNuevo = new JButton("Nuevo");
    JButton btnEditar = new JButton("Editar");
    JButton btnEliminar = new JButton("Eliminar");
    JButton btnVolver = new JButton("Volver");

    JPanel pnlCabecera = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel pnlBotones = new JPanel();
    private BoxLayout bx = new BoxLayout(pnlBotones, BoxLayout.X_AXIS);

    Dimension dmVentana = new Dimension(Config.ADMIN_WIDTH, Config.ADMIN_HEIGHT);

    private int posicionActual = 0;

    //GridbBagConstra
    GridBagLayout grid = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel pnlDatos = new JPanel(grid);

    public ClientesFrame(Usuario usuario) {
        super();
        this.setTitle("Recyclon - GESTION CLIENTES");
        this.setSize(dmVentana);
        this.setUndecorated(true);
        this.servicio = new RecyclonServicio();
        this.clientes = servicio.getClientes();
        if (!clientes.isEmpty()) {
            mostrarCliente(0);
        }

        this.usuarioLogeado = usuario;

        //Cabecera
        lblLogo.setIcon(Config.cargarLogo(250, 130));
        pnlCabecera.add(lblLogo);
        lblTitulo.setFont(Config.FUENTE_TITULO);
        lblTitulo.setForeground(Config.COLOR_TEXTO);
        pnlCabecera.add(lblTitulo);

        //Datos
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        grid.setConstraints(lblLogoEmpresa, gbc);
        lblLogoEmpresa.setOpaque(true);
        pnlDatos.add(lblLogoEmpresa);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 40;
        grid.setConstraints(lblNombre, gbc);
        pnlDatos.add(lblNombre);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 60;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtNombre, gbc);
        pnlDatos.add(txtNombre);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblCif, gbc);
        pnlDatos.add(lblCif);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtCif, gbc);
        pnlDatos.add(txtCif);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblEmail, gbc);
        pnlDatos.add(lblEmail);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtEmail, gbc);
        pnlDatos.add(txtEmail);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblFecha, gbc);
        pnlDatos.add(lblFecha);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(fmtFecha, gbc);
        pnlDatos.add(fmtFecha);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblProvincia, gbc);
        pnlDatos.add(lblProvincia);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtProvincia, gbc);
        pnlDatos.add(txtProvincia);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblMunicipio, gbc);
        pnlDatos.add(lblMunicipio);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtMunicipio, gbc);
        pnlDatos.add(txtMunicipio);

        for (Component c : pnlDatos.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(Config.FUENTE_NORMAL);
                c.setForeground(Config.COLOR_TEXTO);
            }
        }
        pnlDatos.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // ====== BOTONES ========
        pnlBotones.setLayout(bx);
        btnAnterior.setIcon(Config.cargarIcono("atras.png", 30, 30));
        btnAnterior.setBackground(null);
        btnAnterior.addActionListener(e -> {
            if (posicionActual > 0) {
                posicionActual--;
                mostrarCliente(posicionActual);
            }
        });
        pnlBotones.add(btnAnterior);

        btnSiguiente.setIcon(Config.cargarIcono("siguiente.png", 30, 30));
        btnSiguiente.setBackground(null);
        btnSiguiente.addActionListener(e -> {
            if (posicionActual < clientes.size() - 1) {
                posicionActual++;
                mostrarCliente(posicionActual);
            }
        });
        pnlBotones.add(Box.createHorizontalGlue());
        pnlBotones.add(btnSiguiente);

        pnlBotones.add(Box.createHorizontalGlue());
        btnNuevo.setIcon(Config.cargarIcono("nuevo.png", 30, 30));
        pnlBotones.add(btnNuevo);

        btnEditar.setIcon(Config.cargarIcono("editar.png", 30, 30));
        pnlBotones.add(btnEditar);

        btnEliminar.setIcon(Config.cargarIcono("eliminar.png", 30, 30));
        pnlBotones.add(btnEliminar);
        pnlBotones.add(Box.createHorizontalGlue());

        btnVolver.setIcon(Config.cargarIcono("salir.png", 30, 30));
        btnVolver.setBackground(Config.COLOR_BOTON_SALIR);
        btnVolver.addActionListener(e -> {
            new MenuFrame(usuario).setVisible(true);
            this.dispose();
        });
        pnlBotones.add(btnVolver);
        pnlBotones.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        ////////////////////////////////////////////
        this.add(pnlDatos, BorderLayout.CENTER);
        this.add(pnlCabecera, BorderLayout.NORTH);
        this.add(pnlBotones, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void mostrarCliente(int posicion) {
        Cliente c = clientes.get(posicion);
        txtNombre.setText(c.getNombre());
        txtCif.setText(String.valueOf(c.getCif()));
        txtEmail.setText(c.getEmail());
        txtTelefono.setText(c.getTelefono());
        txtEstado.setText(c.getEstado().toString());
        fmtFecha.setText(c.getFechaAlta().toString());
        txtProvincia.setText(c.getProvincia());
        txtMunicipio.setText(c.getCiudad());
        lblLogoEmpresa.setIcon(Config.cargarIcono(c.getLogo(), 100, 100));
    }

    public static void main(String[] args) {
        FlatGradiantoNatureGreenIJTheme.setup();
        new ClientesFrame(null);
    }

}
