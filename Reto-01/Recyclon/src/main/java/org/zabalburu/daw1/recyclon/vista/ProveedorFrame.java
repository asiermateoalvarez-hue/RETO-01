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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.config.Config;
import org.zabalburu.daw1.recyclon.modelo.Proveedor;
import org.zabalburu.daw1.recyclon.servicio.RecyclonServicio;
import org.zabalburu.daw1.recyclon.util.EstadoProveedor;
import org.zabalburu.daw1.recyclon.util.TipoProveedor;

/**
 *
 * @author DAW1
 */
public class ProveedorFrame extends JFrame {

    private RecyclonServicio servicio;
    private Usuario usuarioLogeado;
    private List<Proveedor> proveedores = new ArrayList<>();

    // ============ Datos =============
    JLabel lblTitulo = new JLabel("GESTION DE PROVEEDORES");
    JLabel lblLogo = new JLabel();
    JLabel lblLogoEmpresa = new JLabel("Logo Empresa");

    JLabel lblNombre = new JLabel("Nombre");
    JTextField txtNombre = new JTextField();

    JLabel lblCif = new JLabel("CIF");
    JTextField txtCif = new JTextField();

    JLabel lblEmail = new JLabel("Email");
    JTextField txtEmail = new JTextField();

    JLabel lblTelefono = new JLabel("Teléfono");
    JTextField txtTelefono = new JTextField();

    JLabel lblTipo = new JLabel("Tipo");
    JTextField txtTipo = new JTextField();

    JLabel lblCuenta = new JLabel("Cuenta");
    JTextField txtCuenta = new JTextField();

    JLabel lblDiasPago = new JLabel("Días de Pago");
    JTextField txtDiasPago = new JTextField();

    JLabel lblContacto = new JLabel("Contacto");
    JTextField txtContacto = new JTextField();

    JLabel lblDescripcion = new JLabel("Descripcion");
    JTextField txtDescripcion = new JTextField();

    JLabel lblEstado = new JLabel("Estado");
    JTextField txtEstado = new JTextField();

    JLabel lblFecha = new JLabel("Fecha");
    JFormattedTextField fmtFecha
            = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));

    JLabel lblPosicionDatos = new JLabel();

    JButton btnAnterior = new JButton();

    JButton btnSiguiente = new JButton();

    JButton btnNuevo = new JButton("Nuevo");

    JButton btnEditar = new JButton("Editar");

    JButton btnGuardar = new JButton("Guardar");

    JButton btnCancelar = new JButton("Cancelar");

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

    public ProveedorFrame(Usuario usuario) {

        super();
        this.setTitle("Recyclon - GESTION PROVEEDORES");
        this.setSize(dmVentana);
        this.setUndecorated(true);
        this.servicio = new RecyclonServicio();
        this.proveedores = servicio.getProveedores();
        if (!proveedores.isEmpty()) {
            mostrarProveedores(0);
        }

        this.usuarioLogeado = usuario;

        //Cabecera
        lblLogo.setIcon(Config.cargarLogo(250, 130));
        pnlCabecera.add(lblLogo);
        lblTitulo.setFont(Config.FUENTE_TITULO);
        lblTitulo.setForeground(Config.COLOR_TEXTO);
        pnlCabecera.add(lblTitulo);

        //Datos
        gbc.insets = new Insets(10, 0, 0, 0);
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
        grid.setConstraints(lblTelefono, gbc);
        pnlDatos.add(lblTelefono);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtTelefono, gbc);
        pnlDatos.add(txtTelefono);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblTipo, gbc);
        pnlDatos.add(lblTipo);

        gbc.gridx = 2;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtTipo, gbc);
        pnlDatos.add(txtTipo);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblCuenta, gbc);
        pnlDatos.add(lblCuenta);

        gbc.gridx = 2;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtCuenta, gbc);
        pnlDatos.add(txtCuenta);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblDiasPago, gbc);
        pnlDatos.add(lblDiasPago);

        gbc.gridx = 2;
        gbc.gridy = 7;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtDiasPago, gbc);
        pnlDatos.add(txtDiasPago);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblContacto, gbc);
        pnlDatos.add(lblContacto);

        gbc.gridx = 2;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtContacto, gbc);
        pnlDatos.add(txtContacto);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblDescripcion, gbc);
        pnlDatos.add(lblDescripcion);

        gbc.gridx = 2;
        gbc.gridy = 9;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtDescripcion, gbc);
        pnlDatos.add(txtDescripcion);

        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblEstado, gbc);
        pnlDatos.add(lblEstado);

        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(txtEstado, gbc);
        pnlDatos.add(txtEstado);

        gbc.gridx = 1;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.NONE;
        grid.setConstraints(lblFecha, gbc);
        pnlDatos.add(lblFecha);

        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid.setConstraints(fmtFecha, gbc);
        pnlDatos.add(fmtFecha);

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
                mostrarProveedores(posicionActual);
            }
        });
        pnlBotones.add(btnAnterior);

        lblPosicionDatos.setFont(Config.FUENTE_NORMAL);
        lblPosicionDatos.setForeground(Config.COLOR_TEXTO);

        pnlBotones.add(lblPosicionDatos);

        btnSiguiente.setIcon(Config.cargarIcono("siguiente.png", 30, 30));
        btnSiguiente.setBackground(null);
        btnSiguiente.addActionListener(e -> {
            if (posicionActual < proveedores.size() - 1) {
                posicionActual++;
                mostrarProveedores(posicionActual);
            }
        });
        pnlBotones.add(btnSiguiente);

        pnlBotones.add(Box.createHorizontalGlue());
        btnNuevo.setIcon(Config.cargarIcono("nuevo.png", 30, 30));
        pnlBotones.add(btnNuevo);

        btnEditar.setIcon(Config.cargarIcono("editar.png", 30, 30));
        btnEditar.addActionListener(e -> {
            setModoEdicion(true);
        });
        pnlBotones.add(btnEditar);

        btnEliminar.setIcon(Config.cargarIcono("eliminar.png", 30, 30));

        pnlBotones.add(btnEliminar);
        pnlBotones.add(Box.createHorizontalGlue());

        btnGuardar.setIcon(Config.cargarIcono("guardar.png", 30, 30));
        btnGuardar.addActionListener(e -> {
            Proveedor p = proveedores.get(posicionActual);
            p.setNombre(txtNombre.getText());

            p.setCif(Integer.parseInt(txtCif.getText()));

            p.setEmail(txtEmail.getText());

            p.setTelefono(txtTelefono.getText());

            p.setTipo(TipoProveedor.valueOf(txtTipo.getText()));

            p.setCuentaBanco(txtCuenta.getText());

            p.setDiasPago(Integer.parseInt(txtDiasPago.getText()));

            p.setTelefono(txtTelefono.getText());

            p.setDescMovimiento(txtDescripcion.getText());

            p.setEstado(EstadoProveedor.valueOf(txtEstado.getText()));

            servicio.modificarProveedor(p);
            setModoEdicion(false);
            mostrarProveedores(posicionActual);
        });
        pnlBotones.add(btnGuardar);

        btnCancelar.setIcon(Config.cargarIcono("cancelar.png", 30, 30));
        btnCancelar.addActionListener(e -> {
            mostrarProveedores(posicionActual);
            setModoEdicion(false);
        });
        pnlBotones.add(btnCancelar);

        btnGuardar.setVisible(false);
        btnCancelar.setVisible(false);

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
        setCamposEditables(false);

    }

    public JButton getBtnAnterior() {
        return btnAnterior;
    }

    public JButton getBtnSiguiente() {
        return btnSiguiente;
    }

    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public static void main(String[] args) {
        FlatGradiantoNatureGreenIJTheme.setup();
        new ProveedorFrame(null);
    }

    private void setCamposEditables(boolean editable) {
        txtNombre.setEnabled(editable);
        txtCif.setEnabled(editable);
        txtEmail.setEnabled(editable);
        txtTelefono.setEnabled(editable);
        txtTipo.setEnabled(editable);
        txtCuenta.setEnabled(editable);
        txtDiasPago.setEnabled(editable);
        txtContacto.setEnabled(editable);
        txtDescripcion.setEnabled(editable);
        txtEstado.setEnabled(editable);
        fmtFecha.setEnabled(editable);
    }

    private void setModoEdicion(boolean editando) {
        // Si estamos editando ocultamos Nuevo Editar Eliminar 
        //y mostramos Guardar/Cancelar
        btnNuevo.setVisible(!editando);
        btnEditar.setVisible(!editando);
        btnEliminar.setVisible(!editando);

        btnGuardar.setVisible(editando);
        btnCancelar.setVisible(editando);

        //Ocultamos las flechas de navegacion
        btnAnterior.setEnabled(!editando);
        btnSiguiente.setEnabled(!editando);
        btnVolver.setVisible(!editando);

        //Se actualizan los cambios
        setCamposEditables(editando);

    }

    private void mostrarProveedores(int posicion) {
        Proveedor p = proveedores.get(posicion);
        lblPosicionDatos.setText(" %2d / %2d".formatted((posicion + 1), proveedores.size()));
        txtNombre.setText(p.getNombre());
        txtCif.setText(String.valueOf(p.getCif()));
        txtEmail.setText(p.getEmail());
        txtTelefono.setText(p.getTelefono());
        txtTipo.setText(p.getTipo().toString());
        txtCuenta.setText(p.getCuentaBanco());
        txtDiasPago.setText(String.valueOf(p.getDiasPago()));
        txtContacto.setText(p.getTelefono());
        txtDescripcion.setText(p.getDescMovimiento());
        txtEstado.setText(p.getEstado().toString());

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        fmtFecha.setText(df.format(p.getFechaAlta()));
        lblLogoEmpresa.setIcon(Config.cargarIcono(p.getLogo(), 100, 100));

    }

}
