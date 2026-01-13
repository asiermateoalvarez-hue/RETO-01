/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DateFormat;
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
import javax.swing.table.DefaultTableModel;
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
public class MovimientoFrame extends JFrame {

    private RecyclonServicio servicio;
    private Usuario usuarioLogeado;
    private List<Proveedor> proveedores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Movimiento> movimientos = new ArrayList<>();

    private Dimension dmVentana = new Dimension(Config.ADMIN_WIDTH, Config.ADMIN_HEIGHT);

    private JLabel lblTitulo = new JLabel("Recyclon - Admin".toUpperCase());
    private JLabel lblLogo = new JLabel(Config.cargarLogo(150, 100));

    private JButton btnSalir = new JButton("Volver");

    private JTable tblDatos = new JTable();
    private JScrollPane jspDatos = new JScrollPane(tblDatos);

    private JButton btnNuevo = new JButton("Nuevo");
    private JButton btnEditar = new JButton("Editar");
    private JButton btnEliminar = new JButton("Eliminar");

    private JPanel pnlCabecera = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnlInferior = new JPanel(new FlowLayout());
    private JPanel pnlDatos = new JPanel(new BorderLayout());

    private Vector<String> vctTitulos = new Vector<>();
    private Vector<Vector<String>> vctDatos = new Vector<>();

    int pos = 0;

    public MovimientoFrame(Usuario usuario) {
        super();
        this.setTitle("Recyclon - Admin");
        this.setSize(dmVentana);
        this.setUndecorated(true);

        ///////////CabeCera///////////
        lblTitulo.setFont(Config.FUENTE_TITULO);
        lblTitulo.setForeground(Config.COLOR_TEXTO);
        pnlCabecera.add(lblLogo);
        pnlCabecera.add(lblTitulo);
        pnlCabecera.setBorder(new EmptyBorder(10, 20, 10, 20));

        vctTitulos.add("ID");
        vctTitulos.add("Descripcion");
        vctTitulos.add("Tipo");
        vctTitulos.add("Monto");
        vctTitulos.add("Fecha");
        vctTitulos.add("Empresa");

        this.servicio = new RecyclonServicio();
        this.usuarioLogeado = usuario;

        ///
        ///////////////////bOTONES
        btnNuevo.setIcon(Config.cargarIcono("nuevo.png", 30, 30));
        btnEditar.setIcon(Config.cargarIcono("editar.png", 30, 30));
        btnEliminar.setIcon(Config.cargarIcono("eliminar.png", 30, 30));
        btnSalir.setIcon(Config.cargarIcono("salir.png", 30, 30));
        btnSalir.setBackground(Config.COLOR_BOTON_SALIR);
        btnSalir.addActionListener(e -> {
            new MenuFrame(usuario).setVisible(true);
            this.dispose();
        });

        /////////////pANEL INFERIOR
        pnlInferior.add(btnNuevo);
        pnlInferior.add(btnEditar);
        pnlInferior.add(btnEliminar);
        pnlInferior.add(btnSalir);

        //DATOS
        pnlDatos.add(jspDatos, BorderLayout.CENTER);

        this.add(pnlCabecera, BorderLayout.NORTH);
        this.add(pnlDatos, BorderLayout.CENTER);
        this.add(pnlInferior, BorderLayout.SOUTH);
        cargarTabla();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void cargarTabla() {
        cargarMovimientos();
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

    private void cargarMovimientos() {
        List<Movimiento> movimientos = servicio.getMovimientos();
        Vector<Vector<String>> vctDatos = new Vector<>();
        for (Movimiento m : movimientos) {
            Vector<String> vctFila = new Vector<>();
            vctFila.add(String.valueOf(m.getId()));
            vctFila.add((m.getDescripcion()));
            vctFila.add(String.valueOf(m.getTipo().toString()));
            vctFila.add(String.valueOf(m.getMonto().toString()));
            vctFila.add(String.valueOf(m.getFecha().toString().formatted(DateFormat.SHORT)));
            vctFila.add(m.getCliente() != null
                    ? m.getCliente().getNombre()
                    : m.getProveedor().getNombre());
            vctDatos.add(vctFila);
        }
        DefaultTableModel dtm = new DefaultTableModel(vctDatos, vctTitulos);
        tblDatos.setModel(dtm);
    }

}
