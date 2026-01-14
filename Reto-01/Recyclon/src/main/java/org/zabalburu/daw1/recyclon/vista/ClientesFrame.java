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
import java.util.ArrayList;
import java.util.Date;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.config.Config;
import org.zabalburu.daw1.recyclon.modelo.Cliente;
import org.zabalburu.daw1.recyclon.servicio.RecyclonServicio;
import org.zabalburu.daw1.recyclon.util.EstadoCliente;

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

    JLabel lblCiudad = new JLabel("Municipio");
    JTextField txtCiudad = new JTextField();


    JButton btnAnterior = new JButton();
    JButton btnSiguiente = new JButton();
    JButton btnNuevo = new JButton(); //Le quito los nombres porque ocupa mucho, mañana lo miramos bien
    JButton btnEditar = new JButton(); //Le quito los nombres porque ocupa mucho, mañana lo miramos bien
    JButton btnEliminar = new JButton(); //Le quito los nombres porque ocupa mucho, mañana lo miramos bien
    JButton btnVolver = new JButton(); //Le quito los nombres porque ocupa mucho, mañana lo miramos bien
    JButton btnGuardar = new JButton(); //Le quito los nombres porque ocupa mucho, mañana lo miramos bien
    JButton btnDeshacer = new JButton(); //Le quito los nombres porque ocupa mucho, mañana lo miramos bien
    JButton btnPrimero = new JButton();
    JButton btnUltimo = new JButton();

    JPanel pnlCabecera = new JPanel(new FlowLayout(FlowLayout.LEFT));

    JPanel pnlBotones = new JPanel();
    private BoxLayout bx = new BoxLayout(pnlBotones, BoxLayout.X_AXIS);

    Dimension dmVentana = new Dimension(850, 750);
    JTabbedPane tb = new JTabbedPane();

    private int posicionActual = 0;

    //GridbBagConstra
    GridBagLayout grid1 = new GridBagLayout();
    GridBagLayout grid2 = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel pnlDatos = new JPanel(grid1);
    JPanel pnlDatos2 = new JPanel(grid2);

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
        grid1.setConstraints(lblLogoEmpresa, gbc);
        lblLogoEmpresa.setOpaque(true);
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

        tb.addTab("Datos Personales", pnlDatos);
        this.add(tb, BorderLayout.CENTER);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 40;

        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(15, 15, 15, 15);
        grid2.setConstraints(lblEstado, gbc);
        pnlDatos2.add(lblEstado);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 60;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid2.setConstraints(txtEstado, gbc);
        pnlDatos2.add(txtEstado);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 40;
        gbc.fill = GridBagConstraints.NONE;
        grid2.setConstraints(lblProvincia, gbc);
        pnlDatos2.add(lblProvincia);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 60;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid2.setConstraints(txtProvincia, gbc);
        pnlDatos2.add(txtProvincia);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 40;
        gbc.fill = GridBagConstraints.NONE;
        grid2.setConstraints(lblTelefono, gbc);
        pnlDatos2.add(lblTelefono);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 60;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        grid2.setConstraints(txtTelefono, gbc);
        pnlDatos2.add(txtTelefono);

        tb.addTab("Datos 2", pnlDatos2);

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
                mostrarCliente(posicionActual);
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
            mostrar();
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

    private void mostrarCliente(int posicion) {
        Cliente c = clientes.get(posicion);
        txtId.setText(String.valueOf(c.getId()));
        txtNombre.setText(c.getNombre());
        txtCif.setText(String.valueOf(c.getCif()));
        txtEmail.setText(c.getEmail());
        txtTelefono.setText(c.getTelefono());
        txtEstado.setText(c.getEstado().toString());
        fmtFecha.setText(c.getFechaAlta().toString());
        txtProvincia.setText(c.getProvincia());
        txtCiudad.setText(c.getCiudad());
        lblLogoEmpresa.setIcon(Config.cargarIcono(c.getLogo(), 100, 100));
    }

    public static void main(String[] args) {
        FlatGradiantoNatureGreenIJTheme.setup();
        new ClientesFrame(null);
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
            /*Image imag;
            if (actual.getFoto()!=null){
                imag = new ImageIcon("imagenes/"+actual.getFoto()).getImage();
            } else {
                imag = new ImageIcon("imagenes/nouser.png").getImage();                
            }
            imag = CircleImage.getCircleImage(imag);
            lblFoto.setIcon(new ImageIcon(imag.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
        } */
        }
        txtNombre.setEnabled(estado != CONSULTA);
        txtCif.setEnabled(estado != CONSULTA);
        txtEmail.setEnabled(estado != CONSULTA);
        fmtFecha.setEnabled(estado != CONSULTA);
        txtProvincia.setEnabled(estado != CONSULTA);
        txtCiudad.setEnabled(estado != CONSULTA);
        txtEstado.setEnabled(estado != CONSULTA);
        txtTelefono.setEnabled(estado != CONSULTA);

        btnPrimero.setEnabled(clientes.size() > 0 && estado == CONSULTA);
        btnAnterior.setEnabled(estado == CONSULTA && posicionActual > 0);
        btnSiguiente.setEnabled(estado == CONSULTA && posicionActual < clientes.size() - 1);
        btnUltimo.setEnabled(estado == CONSULTA && posicionActual < clientes.size() - 1);
        btnPrimero.setEnabled(estado == CONSULTA && posicionActual > 0);
        
        btnNuevo.setEnabled(estado == CONSULTA);
        btnEditar.setEnabled(estado == CONSULTA);
        btnDeshacer.setEnabled(estado != CONSULTA && clientes.size() > 0);
        btnGuardar.addActionListener(e -> guardar());
        btnGuardar.setEnabled(estado != CONSULTA);
        btnEliminar.setEnabled(estado == CONSULTA);

    }

    public void eliminarCliente() {
        if ((JOptionPane.showConfirmDialog(this,
                "Quieres eliminar el Cliente".formatted(clientes.get(posicionActual).getNombre()),
                "AVISO!!!",
                JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION)) {
            servicio.deleteCliente(clientes.get(posicionActual).getId());
            if (posicionActual == clientes.size()) {
                posicionActual--;
            }
            mostrar();

        }

    }

    public void guardar() {
        Cliente cli;
        if (estado == ALTA) {
            cli = new Cliente();
        } else {
            cli = clientes.get(posicionActual);
            cli.setId(Integer.parseInt(txtId.getText()));
        }
        cli.setNombre(txtNombre.getText());
        cli.setCif(Integer.parseInt(txtCif.getText()));
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
            posicionActual = clientes.size() - 1;
        } else {
            servicio.modificarCliente(cli);
        }
        estado = CONSULTA;
        mostrar();
    }

    public void nuevo() {

    }
}

/*Arreglar el conteo de cuando cambias de cliente, mirar el ESTADO cuando editas un cliente y lo dejas vacion,
/mirar bien la posicio de los botones y los tamaños, elegir unos botones mas pequeños, añadir un tabed pane para poner 
mas datos y no quede tan pegado, darle separacionn a los botones, añadir comentarios y ponerlo ordenado*/