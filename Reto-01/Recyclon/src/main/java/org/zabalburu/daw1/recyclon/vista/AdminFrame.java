/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.config.Config;
import org.zabalburu.daw1.recyclon.modelo.Cliente;
import org.zabalburu.daw1.recyclon.modelo.Movimiento;
import org.zabalburu.daw1.recyclon.modelo.Proveedor;
import org.zabalburu.daw1.recyclon.servicio.RecyclonServicio;

/**
 *
 * @author DAW1
 */
public class AdminFrame extends JFrame {

    private RecyclonServicio servicio;
    private Usuario usuarioLogeado;
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Movimiento> movimientos = new ArrayList<>();

    private Dimension dmVentana = new Dimension(Config.ADMIN_WIDTH, Config.ADMIN_HEIGHT);

    private JLabel lblTitulo = new JLabel("Recyclon - Admin".toUpperCase());
    private JLabel lblLogo = new JLabel(Config.cargarLogo(150, 100));

    private JButton btnCliente = new JButton("Cliente");
    private JButton btnProveedor = new JButton("Proveedor");
    private JButton btnMovimiento = new JButton("Movimiento");
    private JButton btnSalir = new JButton("Cerrar Sesión");

    private JTable tblDatos = new JTable();
    private JScrollPane jspDatos = new JScrollPane(tblDatos);

    private JButton btnNuevo = new JButton("Nuevo");
    private JButton btnEditar = new JButton("Editar");
    private JButton btnEliminar = new JButton("Eliminar");

    private JPanel pnlCabecera = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JPanel pnlClientesContenido = new JPanel(new GridBagLayout());
    private JPanel pnlProveedoresContenido = new JPanel(new GridBagLayout());
    private JPanel pnlMovimientosContenido = new JPanel(new BorderLayout());

    private JPanel pnlDatos = new JPanel(new CardLayout());
    private JPanel pnlIzquierda = new JPanel(new GridLayout(5, 1, 10, 10));
    private JPanel pnlInferior = new JPanel(new FlowLayout());

    private Vector<String> vctTitulos = new Vector<>();
    private Vector<Vector<String>> vctDatos = new Vector<>();

    int pos = 0;

    public AdminFrame(Usuario usuario) {
        super();
        this.setTitle("Recyclon - Admin");
        this.setSize(dmVentana);
        this.setUndecorated(true);

        vctTitulos.add("Nombre");
        vctTitulos.add("CIF");
        vctTitulos.add("Telefono");
        vctTitulos.add("Tipo de Movimiento");
        vctTitulos.add("Fecha");
        vctTitulos.add("Estado");

        this.usuarioLogeado = usuario;
        this.servicio = new RecyclonServicio();

        // ======= Cabecera =======
        lblTitulo.setFont(Config.FUENTE_TITULO);
        lblTitulo.setForeground(Config.COLOR_TEXTO);
        pnlCabecera.add(lblLogo);
        pnlCabecera.add(lblTitulo);
        pnlCabecera.setBorder(new EmptyBorder(10, 20, 10, 20));

        // ======= Panel Izquierda =======
        btnCliente.addActionListener(e -> {
            CardLayout cl = (CardLayout) pnlDatos.getLayout();
            cl.show(pnlDatos, "Clientes");
        });
        btnCliente.setIcon(Config.cargarIcono("cliente.png", 30, 30));
        pnlIzquierda.add(btnCliente);

        btnProveedor.setIcon(Config.cargarIcono("proveedor.png", 30, 30));
        btnProveedor.addActionListener(e -> {
            CardLayout c2 = (CardLayout) pnlDatos.getLayout();
            c2.show(pnlDatos, "Proveedores");
        });
        pnlIzquierda.add(btnProveedor);

        btnMovimiento.setIcon(Config.cargarIcono("movimiento.png", 30, 30));
        btnMovimiento.addActionListener(e -> {
            CardLayout c3 = (CardLayout) pnlDatos.getLayout();
            c3.show(pnlDatos, "Movimientos");
        });
        pnlIzquierda.add(btnMovimiento);

        btnSalir.setIcon(Config.cargarIcono("salir.png", 30, 30));
        btnSalir.setBackground(Config.COLOR_BOTON_SALIR);
        btnSalir.addActionListener(e -> {
            new LoginFrame().setVisible(true);
            this.dispose();
        });
        pnlIzquierda.add(btnSalir);
        pnlIzquierda.setBorder(new EmptyBorder(10, 20, 10, 20));
        for (Component c : pnlIzquierda.getComponents()) {
            if (c instanceof JButton) {
                c.setFont(Config.FUENTE_NORMAL);
                c.setForeground(Config.COLOR_TEXTO);
                ((JButton) c).setIconTextGap(20);
            }
        }

        // ======= Panel Inferior =======
        btnNuevo.setIcon(Config.cargarIcono("nuevo.png", 30, 30));;
        pnlInferior.add(btnNuevo);

        btnEditar.setIcon(Config.cargarIcono("editar.png", 30, 30));
        pnlInferior.add(btnEditar);

        btnEliminar.setIcon(Config.cargarIcono("eliminar.png", 30, 30));
        pnlInferior.add(btnEliminar);

        // ======= Panel Datos =======
        pnlDatos.add(pnlClientesContenido, "Clientes");
        pnlDatos.add(pnlProveedoresContenido, "Proveedores");
        pnlDatos.add(pnlMovimientosContenido, "Movimientos");
        pnlDatos.add(pnlInferior, BorderLayout.SOUTH);

        this.add(pnlCabecera, BorderLayout.NORTH);
        this.add(pnlIzquierda, BorderLayout.WEST);
        this.add(pnlDatos, BorderLayout.CENTER);
        cargarTabla();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void cargarTabla() {

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

    public JTable getTblDatos() {
        return tblDatos;
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

    private void cargarClientes() {
        /*List<Cliente> clientes = servicio.getClientes();
        for (Cliente c : clientes) {
            Vector<String> vctFila = new Vector<>();
            vctFila.add(String.valueOf(c.getId()));
            vctFila.add((c.getNombre()));
            vctFila.add(String.valueOf(c.getCif()));
            vctFila.add((c.getTelefono()));
            vctDatos.add(vctFila);
            DefaultTableModel dtm = (DefaultTableModel) tblDatos.getModel();
            dtm.setDataVector(vctDatos, vctTitulos);

        }*/

    }

    private void cargarProveedores() {
        List<Proveedor> proveedores = servicio.getProveedores();
    }

    private void cargarMovimientos() {
        List<Movimiento> movimientos = servicio.getMovimientos();
    }

}
