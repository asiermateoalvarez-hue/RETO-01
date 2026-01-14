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
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
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
    private static RecyclonServicio servicio;
    private Usuario usuarioLogeado;
    private List<Cliente> clientes = new ArrayList<>();

    //////Cabecera/////////
    JLabel lblTitulo = new JLabel("GESTION DE CLIENTES");
    JLabel lblLogo = new JLabel();
    JLabel lblLogoEmpresa = new JLabel();

    JLabel lblNumerico = new JLabel();

    JLabel lblId = new JLabel("ID");
    JTextField txtId = new JTextField();

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
            = new JFormattedTextField(new java.text.SimpleDateFormat("dd/MM/yyyy"));

    JLabel lblProvincia = new JLabel("Provincia");
    JTextField txtProvincia = new JTextField();

    JLabel lblCiudad = new JLabel("Ciudad");
    JTextField txtCiudad = new JTextField();

    JButton btnAnterior = new JButton();
    JButton btnSiguiente = new JButton();
    JButton btnNuevo = new JButton(); 
    JButton btnEditar = new JButton(); 
    JButton btnEliminar = new JButton(); 
    JButton btnVolver = new JButton(); 
    JButton btnGuardar = new JButton(); 
    JButton btnDeshacer = new JButton(); 
    JButton btnPrimero = new JButton();
    JButton btnUltimo = new JButton();

    JPanel pnlCabecera = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel pnlBotones = new JPanel();
    private BoxLayout bx = new BoxLayout(pnlBotones, BoxLayout.X_AXIS);

    Dimension dmVentana = new Dimension(Config.ADMIN_WIDTH, Config.ADMIN_HEIGHT);

    private int posicionActual = 0;

    //GridbBagConstra
    GridBagLayout grid1 = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel pnlDatos = new JPanel(grid1);

    //*****Estados****////////
    private static final int ALTA = 1;
    private static final int MODIFICACION = 2;
    private static final int CONSULTA = 3;
    private int estado = CONSULTA;

    public ClientesFrame(Usuario usuario) {
        super();
        this.setTitle("Recyclon - GESTION CLIENTES");
        this.setSize(dmVentana);
        this.setUndecorated(true);
        this.servicio = new RecyclonServicio();
        this.clientes = servicio.getClientes();
        if (!clientes.isEmpty()) {
            mostrar();
        }

        this.usuarioLogeado = usuario;

        //Cabecera
        lblLogo.setIcon(Config.cargarLogo(250, 130));
        pnlCabecera.add(lblLogo);
        lblTitulo.setFont(Config.FUENTE_TITULO);
        lblTitulo.setForeground(Config.COLOR_TEXTO);
        pnlCabecera.add(lblTitulo);

        //Datos
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        grid1.setConstraints(lblLogoEmpresa, gbc);
        pnlDatos.add(lblLogoEmpresa);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 40;
        grid1.setConstraints(lblId, gbc);
        pnlDatos.add(lblId);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 60;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid1.setConstraints(txtId, gbc);
        pnlDatos.add(txtId);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 40;
        gbc.fill = GridBagConstraints.NONE;
        grid1.setConstraints(lblNombre, gbc);
        pnlDatos.add(lblNombre);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 60;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid1.setConstraints(txtNombre, gbc);
        pnlDatos.add(txtNombre);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        grid1.setConstraints(lblCif, gbc);
        pnlDatos.add(lblCif);

        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid1.setConstraints(txtCif, gbc);
        pnlDatos.add(txtCif);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        grid1.setConstraints(lblEmail, gbc);
        pnlDatos.add(lblEmail);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid1.setConstraints(txtEmail, gbc);
        pnlDatos.add(txtEmail);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        grid1.setConstraints(lblFecha, gbc);
        pnlDatos.add(lblFecha);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid1.setConstraints(fmtFecha, gbc);
        pnlDatos.add(fmtFecha);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        grid1.setConstraints(lblProvincia, gbc);
        pnlDatos.add(lblProvincia);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid1.setConstraints(txtProvincia, gbc);
        pnlDatos.add(txtProvincia);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        grid1.setConstraints(lblCiudad, gbc);
        pnlDatos.add(lblCiudad);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid1.setConstraints(txtCiudad, gbc);
        pnlDatos.add(txtCiudad);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.NONE;
        grid1.setConstraints(lblEstado, gbc);
        pnlDatos.add(lblEstado);

        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid1.setConstraints(txtEstado, gbc);
        pnlDatos.add(txtEstado);
        this.add(pnlDatos, BorderLayout.CENTER);

        for (Component c : pnlDatos.getComponents()) {
            if (c instanceof JLabel) {
                c.setFont(Config.FUENTE_NORMAL);
                c.setForeground(Config.COLOR_TEXTO);
            }
        }
        pnlDatos.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // ====== BOTONES ========
        pnlBotones.setBorder(new EmptyBorder(10, 15, 10, 15));
        pnlBotones.setLayout(bx);
        btnAnterior.setIcon(Config.cargarIcono("atras.png", 30, 30));
        btnAnterior.setBackground(null);
        btnAnterior.addActionListener(e -> {
            if (posicionActual > 0) {
                posicionActual--;
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "¡¡CUIDADO!! ESTE ES EL PRIMER CLIENTE");
            }
        });

        pnlBotones.add(btnPrimero);
        btnPrimero.setIcon(Config.cargarIcono("primero.png", 30, 30));
        btnPrimero.setBackground(null);
        btnPrimero.addActionListener(e -> {
            if (posicionActual > 0) {
                posicionActual = 0;
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "¡¡CUIDADO!!, ESTE ES EL PRIMER CLIENTE");
            }
        });
        pnlBotones.add(btnAnterior);
        pnlBotones.add(lblNumerico);
        lblNumerico.setText("Estado");

        btnSiguiente.setIcon(Config.cargarIcono("siguiente.png", 30, 30));
        btnSiguiente.setBackground(null);
        btnSiguiente.addActionListener(e -> {
            if (posicionActual < clientes.size() - 1) {
                posicionActual++;
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "¡¡CUIDADO!! ESTE ES EL ULTIMO CLIENTE");
            }
        });
        //pnlBotones.add(Box.createHorizontalGlue());
        pnlBotones.add(btnSiguiente);
        pnlBotones.add(btnUltimo);
        btnUltimo.setIcon(Config.cargarIcono("ultimo.png", 30, 30));
        btnSiguiente.setBackground(null);
        btnUltimo.addActionListener(e -> {
            if (posicionActual < clientes.size() - 1) {
                posicionActual = clientes.size() - 1;
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "¡¡CUIDADO!! ESTE ES EL ULTIMO CLIENTE");
            }
        });

        pnlBotones.add(Box.createHorizontalGlue());
        btnNuevo.setIcon(Config.cargarIcono("nuevo.png", 30, 30));
        btnNuevo.addActionListener(e -> {
            estado = ALTA;
            mostrar();
        });
        pnlBotones.add(btnNuevo);

        btnEditar.setIcon(Config.cargarIcono("editar.png", 30, 30));
        btnEditar.addActionListener(e -> {
            estado = MODIFICACION;
            mostrar();
        });
        pnlBotones.add(btnEditar);

        btnEliminar.setIcon(Config.cargarIcono("eliminar.png", 30, 30));
        btnEliminar.addActionListener(e -> {
            eliminarCliente();
        });
        pnlBotones.add(btnEliminar);
        pnlBotones.add(btnDeshacer);
        btnDeshacer.setIcon(Config.cargarIcono("deshacer.png", 30, 30));
        btnDeshacer.addActionListener(e -> {
            estado = CONSULTA;
            mostrar();
        });

        pnlBotones.add(Box.createHorizontalGlue());

        btnVolver.setIcon(Config.cargarIcono("salir.png", 30, 30));
        btnVolver.setBackground(Config.COLOR_BOTON_SALIR);
        btnVolver.addActionListener(e -> {
            new MenuFrame(usuario).setVisible(true);
            this.dispose();
        });
        pnlBotones.add(btnGuardar);
        btnGuardar.addActionListener(e -> {
            guardar();
            mostrar();
        });
        btnGuardar.setIcon(Config.cargarIcono("guardar.png", 30, 30));
        btnVolver.setBackground(null);

        pnlBotones.add(btnVolver);
        pnlBotones.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        ////////////////////////////////////////////
        mostrar();
        this.add(pnlCabecera, BorderLayout.NORTH);
        this.add(pnlBotones, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void mostrar() {
        txtId.setEnabled(false);
        if (clientes.size() == 0) {
            estado = ALTA;
        }

        if (estado == ALTA) {
            lblNumerico.setText("[NUEVO]");
            txtId.setText("");
            txtNombre.setText("");
            txtCif.setText("");
            txtEmail.setText("");
            fmtFecha.setValue(new Date());
            txtProvincia.setText("");
            txtCiudad.setText("");
            txtEstado.setText("");
            txtTelefono.setText("");
            Image img = new ImageIcon("/imagenes/noUser.png").getImage();
            lblLogoEmpresa.setIcon(Config.cargarIcono("noUser.png", 50, 50));
        } else {
            lblNumerico.setText(" [ %2d / %2d ] ".formatted((posicionActual + 1), clientes.size()));
            Cliente actual = clientes.get(posicionActual);
            txtId.setText(String.valueOf(actual.getId()));
            txtNombre.setText(actual.getNombre());
            txtCif.setText(String.valueOf(actual.getCif()));
            txtEmail.setText(actual.getEmail());
            fmtFecha.setValue(actual.getFechaAlta());
            txtProvincia.setText(actual.getProvincia());
            txtCiudad.setText(actual.getCiudad());
            txtEstado.setText("");
            txtTelefono.setText(actual.getTelefono());
            Image img;
            if (actual.getLogo() != null) {
                lblLogoEmpresa.setIcon(Config.cargarIcono(actual.getLogo(), 100, 100));
            } else {
                img = new ImageIcon("imagenes/noUser.png").getImage();
            }

        }

        txtNombre.setEnabled(estado
                != CONSULTA);
        txtCif.setEnabled(estado
                != CONSULTA);
        txtEmail.setEnabled(estado
                != CONSULTA);
        fmtFecha.setEnabled(estado
                != CONSULTA);
        txtProvincia.setEnabled(estado
                != CONSULTA);
        txtCiudad.setEnabled(estado
                != CONSULTA);
        txtEstado.setEnabled(estado
                != CONSULTA);
        txtTelefono.setEnabled(estado
                != CONSULTA);

        btnPrimero.setEnabled(posicionActual
                > 0 && estado == CONSULTA);
        btnAnterior.setEnabled(estado
                == CONSULTA && posicionActual > 0);
        btnSiguiente.setEnabled(estado
                == CONSULTA && posicionActual < clientes.size()
                - 1);
        btnUltimo.setEnabled(estado == CONSULTA && posicionActual < clientes.size() - 1);

        btnNuevo.setEnabled(estado == CONSULTA);
        btnEditar.setEnabled(estado == CONSULTA);
        btnDeshacer.setEnabled(estado != CONSULTA && clientes.size() > 0);
        btnGuardar.setEnabled(estado != CONSULTA);
        btnEliminar.setEnabled(estado == CONSULTA);

    }

    public void eliminarCliente() {
        if ((JOptionPane.showConfirmDialog(this,
                "Quieres eliminar el Cliente".formatted(clientes.get(posicionActual).getNombre()),
                "AVISO!!!",
                JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION)) {
            Cliente c = clientes.get(posicionActual);
            servicio.deleteCliente(c.getId());
            clientes.remove(posicionActual);
            if (!clientes.isEmpty()) {
                if (posicionActual >= clientes.size()) {
                    posicionActual = clientes.size() - 1;
                }
            }
            mostrar();

        }

    }

    public void guardar() {
        Cliente cli;
        if (!validarCampos()) {
            return;  // Si hay error, no continúa
        }

        if (estado == ALTA) {
            cli = new Cliente();
        } else {
            cli = clientes.get(posicionActual);
            cli.setId(Integer.parseInt(txtId.getText()));
        }
        cli.setNombre(txtNombre.getText());
        cli.setCif(txtCif.getText());
        cli.setEmail(txtEmail.getText());
        cli.setFechaAlta((Date) fmtFecha.getValue());
        cli.setProvincia(txtProvincia.getText());
        cli.setCiudad(txtCiudad.getText());
        //cli.setEstado(EstadoCliente.valueOf(txtEstado.getText().toUpperCase())); 
        /*  if (txtEstado.isEmpty()) {
        // Si está vacío, le ponemos uno por defecto (ejemplo: ALTA)
         cli.setEstado(EstadoCliente.ALTA);
        } else {
         try {
        cli.setEstado(EstadoCliente.valueOf(textoEstado));
    } catch (IllegalArgumentException ex) {
        // Si escribe algo que no existe, también ponemos ALTA por defecto
        cli.setEstado(EstadoCliente.ALTA);
        javax.swing.JOptionPane.showMessageDialog(this, "Estado no válido. Se asignó ALTA.");
    }
}*/
        cli.setTelefono(txtTelefono.getText());
        if (estado == ALTA) {
            servicio.addCliente(cli);
            clientes.add(cli);
            posicionActual = clientes.size() - 1;
        } else {
            servicio.modificarCliente(cli);
        }

        estado = CONSULTA;
        mostrar();
    }

    private boolean validarCampos() {
        // Validar Nombre
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El nombre del cliente es obligatorio",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            txtNombre.requestFocus();
            return false;
        }

        // Validar CIF
        if (txtCif.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El CIF es obligatorio",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            txtCif.requestFocus();
            return false;
        }

        // Validar Email
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El email es obligatorio",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            txtEmail.requestFocus();
            return false;
        }

        // Validar Teléfono
        if (txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "El teléfono es obligatorio",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            txtTelefono.requestFocus();
            return false;
        }

        // Validar Provincia
        if (txtProvincia.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "La provincia es obligatoria",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            txtProvincia.requestFocus();
            return false;
        }

        // Validar Ciudad
        if (txtCiudad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "La ciudad es obligatoria",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            txtCiudad.requestFocus();
            return false;
        }

        // Validar Fecha
        if (fmtFecha.getValue() == null) {
            JOptionPane.showMessageDialog(this,
                    "La fecha es obligatoria",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            fmtFecha.requestFocus();
            return false;
        }

        return true;
    }
}
