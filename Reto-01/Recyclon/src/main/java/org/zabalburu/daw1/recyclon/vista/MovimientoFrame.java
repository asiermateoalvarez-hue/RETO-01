/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    private static RecyclonServicio servicio;
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

    private JButton btnCobros = new JButton("Cobros");
    private JButton btnGastos = new JButton("Gastos");

    private JPanel pnlCabecera = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnlBtnCobroyGasto = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    private JPanel pnlInferior = new JPanel(new FlowLayout());
    private JPanel pnlDatos = new JPanel(new BorderLayout());

    private Vector<String> vctTitulos = new Vector<>();
    private Vector<Vector<String>> vctDatos = new Vector<>();

    int pos = 0;

    private static final int COBROS = 1;
    private static final int GASTOS = 2;
    private int tipoMovimiento = COBROS;

    public MovimientoFrame(Usuario usuario) {
        super();
        this.setTitle("Recyclon - Admin");
        this.setSize(dmVentana);
        this.setUndecorated(true);

        this.servicio = RecyclonServicio.getServicio();
        this.usuarioLogeado = usuario;

        this.clientes = servicio.getClientes();
        this.proveedores = servicio.getProveedores();
        this.movimientos = servicio.getMovimientos();

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
        
        btnNuevo.addActionListener(e -> {
            nuevoMovimiento();
        });
        pnlInferior.add(btnNuevo);

        btnEditar.addActionListener(e -> {
            editarMovimiento();

        });
        pnlInferior.add(btnEditar);

        btnEliminar.addActionListener(e -> {
            eliminarMovimiento();
        });
        pnlInferior.add(btnEliminar);

        pnlInferior.add(btnSalir);

        //DATOS
        pnlDatos.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 10));
        pnlDatos.add(jspDatos, BorderLayout.CENTER);
        pnlDatos.add(pnlBtnCobroyGasto, BorderLayout.SOUTH);

        btnCobros.setIcon(Config.cargarIcono("cobros.png", 40, 40));
        btnCobros.addActionListener(e -> {
            tipoMovimiento = COBROS;
            cargarTabla();
            actualizarBotones();
        });
        pnlBtnCobroyGasto.add(btnCobros);

        btnGastos.setIcon(Config.cargarIcono("cuenta.png", 40, 40));
        btnGastos.addActionListener(e -> {
            tipoMovimiento = GASTOS;
            cargarTabla();
            actualizarBotones();
        });
        pnlBtnCobroyGasto.add(btnGastos);
        for (Component c : pnlBtnCobroyGasto.getComponents()) {
            if (c instanceof JButton) {
                c.setFont(Config.FUENTE_NORMAL);
                c.setForeground(Config.COLOR_TEXTO);
                ((JButton) c).setIconTextGap(20);
            }
        }
        for (Component c : pnlInferior.getComponents()) {
            if (c instanceof JButton) {
                c.setFont(Config.FUENTE_NORMAL);
                c.setForeground(Config.COLOR_TEXTO);
                ((JButton) c).setIconTextGap(20);
            }
        }
        pnlDatos.add(jspDatos, BorderLayout.CENTER);

        this.add(pnlCabecera, BorderLayout.NORTH);
        this.add(pnlDatos, BorderLayout.CENTER);
        this.add(pnlInferior, BorderLayout.SOUTH);
        cargarTabla();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void cargarTabla() {
        vctTitulos.clear();
        vctDatos.clear();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);

        if (tipoMovimiento == COBROS) {
            vctTitulos.add("ID");
            vctTitulos.add("Descripción");
            vctTitulos.add("Monto");
            vctTitulos.add("Fecha");
            vctTitulos.add("Cliente");

            for (Movimiento m : movimientos) {
                if (m.getCliente() != null) {
                    Vector<String> fila = new Vector<>();

                    fila.add(String.valueOf(m.getId()));
                    fila.add(m.getDescripcion());
                    fila.add(String.valueOf(m.getMonto()));
                    fila.add(df.format(m.getFecha()));
                    fila.add(m.getCliente().getNombre());

                    vctDatos.add(fila);
                }
            }

        } else if (tipoMovimiento == GASTOS) {
            vctTitulos.add("ID");
            vctTitulos.add("Descripción");
            vctTitulos.add("Monto");
            vctTitulos.add("Fecha");
            vctTitulos.add("Proveedor");

            for (Movimiento m : movimientos) {

                if (m.getProveedor() != null) {
                    Vector<String> fila = new Vector<>();

                    fila.add(String.valueOf(m.getId()));
                    fila.add(m.getDescripcion());
                    fila.add(String.valueOf(m.getMonto()));
                    fila.add(df.format(m.getFecha()));
                    fila.add(m.getProveedor().getNombre());
                    vctDatos.add(fila);
                }
            }
        }

        DefaultTableModel dtm = new DefaultTableModel(vctDatos, vctTitulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblDatos.setModel(dtm);
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

    /* public static void main(String[] args) {
    new MovimientoFrame(null);
    }*/
    private void cargarMovimientos() {
        List<Movimiento> movimientos = servicio.getMovimientos();
        Vector<Vector<String>> vctDatos = new Vector<>();
        for (Movimiento m : movimientos) {
            Vector<String> vctFila = new Vector<>();
            vctFila.add(String.valueOf(m.getId()));
            vctFila.add((m.getDescripcion()));
            vctFila.add(String.valueOf(m.getTipo().toString()));
            vctFila.add(String.valueOf(m.getMonto().toString()));

            DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
            vctFila.add(df.format(m.getFecha()));

            vctFila.add(m.getCliente() != null
                    ? m.getCliente().getNombre()
                    : m.getProveedor().getNombre());
            vctDatos.add(vctFila);
        }
        DefaultTableModel dtm = new DefaultTableModel(vctDatos, vctTitulos);
        tblDatos.setModel(dtm);
    }

    private void actualizarBotones() {
        if (tipoMovimiento == COBROS) {
            btnCobros.setEnabled(false);
            btnGastos.setEnabled(true);
        } else {
            btnCobros.setEnabled(true);
            btnGastos.setEnabled(false);
        }
    }

    private void eliminarMovimiento() {
        int filaSeleccionada = tblDatos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un movimiento para eliminar", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }

        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Estás seguro de que quieres eliminar este movimiento?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                String idStr = (String) tblDatos.getValueAt(filaSeleccionada, 0);
                int id = Integer.parseInt(idStr);

                servicio.deleteMovimiento(id);

                movimientos = servicio.getMovimientos();

                cargarTabla();

                JOptionPane.showMessageDialog(this, "Movimiento eliminado correctamente");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,
                        "Error al eliminar: " + e.getMessage(),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void nuevoMovimiento() {
        if (tipoMovimiento == COBROS) {
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay clientes registrados",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            Movimiento m = new Movimiento();
            MovimientoDialog dialog = new MovimientoDialog(this, COBROS, m, clientes, proveedores);
            if (dialog.estaGuardado()) {
                movimientos = servicio.getMovimientos();
                cargarTabla();
            }
        } else {
            if (proveedores.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No hay proveedores registrados",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            Movimiento m = new Movimiento();
            MovimientoDialog dialog = new MovimientoDialog(this, GASTOS, m, clientes, proveedores);
            if (dialog.estaGuardado()) {
                movimientos = servicio.getMovimientos();
                cargarTabla();
            }
        }
    }

    private void editarMovimiento() {
        int filaSeleccionada = tblDatos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un movimiento para editar",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idStr = (String) tblDatos.getValueAt(filaSeleccionada, 0);
        int id = Integer.parseInt(idStr);

        Movimiento m = movimientos.stream()
                .filter(mov -> mov.getId() == id)
                .findFirst()
                .orElse(null);

        if (m != null) {
            MovimientoDialog dialog = new MovimientoDialog(this, tipoMovimiento, m, clientes, proveedores);
            if (dialog.estaGuardado()) {
                movimientos = servicio.getMovimientos();
                cargarTabla();
            }
        }
    }

}
