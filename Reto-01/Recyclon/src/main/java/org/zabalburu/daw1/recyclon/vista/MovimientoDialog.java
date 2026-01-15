/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.zabalburu.daw1.recyclon.config.Config;
import org.zabalburu.daw1.recyclon.modelo.Cliente;
import org.zabalburu.daw1.recyclon.modelo.Movimiento;
import org.zabalburu.daw1.recyclon.modelo.Proveedor;
import org.zabalburu.daw1.recyclon.servicio.RecyclonServicio;
import org.zabalburu.daw1.recyclon.util.EstadoMovimiento;
import org.zabalburu.daw1.recyclon.util.TipoMovimiento;

/**
 *
 * @author DAW1
 */
public class MovimientoDialog extends JDialog {

    private static RecyclonServicio servicio = RecyclonServicio.getServicio();
    private Movimiento movimiento;
    private boolean guardado = false;
    private int tipoOperacion; // 1 = COBROS, 2 = GASTOS
    private List<Cliente> listaClientes;
    private List<Proveedor> listaProveedores;

    // Componentes de la interfaz
    private JLabel lblTitulo = new JLabel();
    private JLabel lblLogo = new JLabel();

    private JLabel lblId = new JLabel("ID");
    private JTextField txtId = new JTextField();

    private JLabel lblDescripcion = new JLabel("Descripción");
    private JTextField txtDescripcion = new JTextField();

    private JLabel lblMonto = new JLabel("Monto (€)");
    private JFormattedTextField txtMonto = new JFormattedTextField(NumberFormat.getNumberInstance());

    private JLabel lblFecha = new JLabel("Fecha");
    private JFormattedTextField txtFecha = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));

    private JLabel lblEstado = new JLabel("Estado");
    private JComboBox<EstadoMovimiento> cboEstado = new JComboBox<>(EstadoMovimiento.values());

    
    private JLabel lblEntidad = new JLabel("Entidad");
    private JComboBox<Object> cboEntidad = new JComboBox<>();

    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnCancelar = new JButton("Cancelar");

    // Paneles
    private JPanel pnlCabecera = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pnlCentral = new JPanel(new GridBagLayout());
    private JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));

   
    public MovimientoDialog(Frame parent, int tipo, Movimiento mov, List<Cliente> clientes, List<Proveedor> proveedores) {
        super(parent, true);
        this.movimiento = mov;
        this.tipoOperacion = tipo;
        this.listaClientes = clientes;
        this.listaProveedores = proveedores;

        crearVentana();
        cargarDatos();
        
        this.setSize(Config.DIALOG_WIDTH, Config.DIALOG_HEIGHT);
        this.setLocationRelativeTo(parent);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void crearVentana() {
        this.setLayout(new BorderLayout());
        this.setBackground(Config.COLOR_FONDO);

        //  CABECERA 
        lblLogo.setIcon(Config.cargarLogo(100, 50));
        pnlCabecera.add(lblLogo);
        
        lblTitulo.setFont(Config.FUENTE_TITULO);
        lblTitulo.setForeground(Config.COLOR_TEXTO);
        pnlCabecera.add(lblTitulo);
        pnlCabecera.setBorder(new EmptyBorder(10, 10, 10, 10));

        //  PANEL CENTRAL
        pnlCentral.setBorder(new EmptyBorder(10, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
    
        Component[] labels = {lblId, lblDescripcion, lblMonto, lblFecha, lblEstado, lblEntidad};
        for (Component c : labels) {
            c.setFont(Config.FUENTE_NORMAL);
            c.setForeground(Config.COLOR_TEXTO);
        }

     
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        pnlCentral.add(lblId, gbc);
        
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.7;
        txtId.setEnabled(false);
        pnlCentral.add(txtId, gbc);

       
        gbc.gridx = 0; gbc.gridy = 1;
        pnlCentral.add(lblDescripcion, gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        pnlCentral.add(txtDescripcion, gbc);

       
        gbc.gridx = 0; gbc.gridy = 2;
        pnlCentral.add(lblMonto, gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        txtMonto.setColumns(10);
        pnlCentral.add(txtMonto, gbc);

       
        gbc.gridx = 0; gbc.gridy = 3;
        pnlCentral.add(lblFecha, gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        pnlCentral.add(txtFecha, gbc);

      
        gbc.gridx = 0; gbc.gridy = 4;
        pnlCentral.add(lblEstado, gbc);
        
        gbc.gridx = 1; gbc.gridy = 4;
        pnlCentral.add(cboEstado, gbc);

        
        gbc.gridx = 0; gbc.gridy = 5;
        pnlCentral.add(lblEntidad, gbc);
        
        gbc.gridx = 1; gbc.gridy = 5;
   
        cboEntidad.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cliente) {
                    setText(((Cliente) value).getNombre());
                } else if (value instanceof Proveedor) {
                    setText(((Proveedor) value).getNombre());
                }
                return this;
            }
        });
        pnlCentral.add(cboEntidad, gbc);

        //PANEL BOTONES
        btnGuardar.setIcon(Config.cargarIcono("guardar.png", 20, 20));
        btnGuardar.setBackground(Config.COLOR_BOTON_ENTRAR);
        btnGuardar.setForeground(Config.COLOR_TEXTO);
        btnGuardar.addActionListener(e -> accionGuardar());

        btnCancelar.setIcon(Config.cargarIcono("salir.png", 20, 20));
        btnCancelar.setBackground(Config.COLOR_BOTON_SALIR);
        btnCancelar.setForeground(Config.COLOR_TEXTO);
        btnCancelar.addActionListener(e -> dispose());

        pnlBotones.add(btnGuardar);
        pnlBotones.add(btnCancelar);
        pnlBotones.setBorder(new EmptyBorder(10, 0, 10, 0));

      
        this.add(pnlCabecera, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlBotones, BorderLayout.SOUTH);
    }

    private void cargarDatos() {
        
        if (tipoOperacion == 1) { 
            this.setTitle("Gestión de COBRO");
            lblTitulo.setText(movimiento.getId() == null
                    ? "NUEVO COBRO" 
                    : "EDITAR COBRO");
            
            lblEntidad.setText("Cliente:");
            
            DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(listaClientes.toArray());
            cboEntidad.setModel(model);
        } else {        
            
            this.setTitle("Gestión de GASTO");
            lblTitulo.setText(movimiento.getId() == null 
                    ? "NUEVO GASTO" 
                    : "EDITAR GASTO");
            
            lblEntidad.setText("Proveedor:");
            DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(listaProveedores.toArray());
            cboEntidad.setModel(model);
        }

       
        if (movimiento.getId() != null) {
            
            txtId.setText(movimiento.getId().toString());
            txtDescripcion.setText(movimiento.getDescripcion());
            txtMonto.setValue(movimiento.getMonto());
            txtFecha.setValue(movimiento.getFecha());
            cboEstado.setSelectedItem(movimiento.getEstado());
            
            if (tipoOperacion == 1 && movimiento.getCliente() != null) {
                cboEntidad.setSelectedItem(movimiento.getCliente());
            } else if (tipoOperacion == 2 && movimiento.getProveedor() != null) {
                cboEntidad.setSelectedItem(movimiento.getProveedor());
            }
        } else {
            
            txtId.setText("(Auto)");
            txtFecha.setValue(new Date());
            txtMonto.setValue(0.0);
            cboEstado.setSelectedItem(EstadoMovimiento.PENDIENTE);
        }
    }

    private void accionGuardar() {
        
        if (txtDescripcion.getText().trim().isEmpty()) {
            mostrarError("La descripción es obligatoria.");
            return;
        }
        
        Double monto = 0.0;
        try {
            if (txtMonto.getValue() instanceof Number) {
                monto = ((Number) txtMonto.getValue()).doubleValue();
            } else {
                monto = Double.parseDouble(txtMonto.getText());
            }
        } catch (Exception e) {
            mostrarError("El monto debe ser un número válido.");
            return;
        }

        if (monto <= 0) {
            mostrarError("El monto debe ser mayor a 0.");
            return;
        }

        if (txtFecha.getValue() == null) {
            mostrarError("La fecha es obligatoria.");
            return;
        }

        Object entidadSeleccionada = cboEntidad.getSelectedItem();
        if (entidadSeleccionada == null) {
            mostrarError("Debe seleccionar una empresa (Cliente o Proveedor).");
            return;
        }

        movimiento.setDescripcion(txtDescripcion.getText());
        movimiento.setMonto(monto);
        movimiento.setFecha((Date) txtFecha.getValue());
        movimiento.setEstado((EstadoMovimiento) cboEstado.getSelectedItem());

        if (tipoOperacion == 1) {
            movimiento.setTipo(TipoMovimiento.COBRO);
            movimiento.setCliente((Cliente) entidadSeleccionada);
            movimiento.setProveedor(null);
        } else { 
            movimiento.setTipo(TipoMovimiento.GASTO);
            movimiento.setProveedor((Proveedor) entidadSeleccionada);
            movimiento.setCliente(null);
        }

        
        try {
            if (movimiento.getId() == null) {
                servicio.addMovimiento(movimiento);
            } else {
                servicio.modificarMovimiento(movimiento);
            }
            this.guardado = true;
            this.dispose();
        } catch (IllegalArgumentException ex) {
            mostrarError(ex.getMessage());
        } catch (Exception ex) {
            mostrarError("Error al guardar: " + ex.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, 
                mensaje, 
                "Error de Validación", 
                JOptionPane.ERROR_MESSAGE);
    }

    public boolean estaGuardado() {
        return guardado;
    }
}