/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.servicio;

import java.util.List;
import org.zabalburu.daw1.gestionempleados.dao.UsuarioDAOImpl;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.dao.ClienteDAO;
import org.zabalburu.daw1.recyclon.dao.ClienteList;
import org.zabalburu.daw1.recyclon.dao.MovimientoDAO;
import org.zabalburu.daw1.recyclon.dao.MovimientoList;
import org.zabalburu.daw1.recyclon.dao.ProveedorDAO;
import org.zabalburu.daw1.recyclon.dao.ProveedorList;
import org.zabalburu.daw1.recyclon.modelo.Cliente;
import org.zabalburu.daw1.recyclon.modelo.Movimiento;
import org.zabalburu.daw1.recyclon.modelo.Proveedor;
import org.zabalburu.daw1.recyclon.util.EstadoCliente;
import org.zabalburu.daw1.recyclon.util.PasswordManager;

/**
 * Servicio centralizado para la gestión de la lógica de negocio de Recyclón.
 * Proporciona métodos para gestionar clientes, proveedores, movimientos y
 * usuarios. Implementa validaciones y reglas de negocio.
 *
 * @author Equipo03
 */
public class RecyclonServicio {

    private ClienteDAO clienteDao = new ClienteList();
    private MovimientoDAO movimientoDao = new MovimientoList();
    private ProveedorDAO proveedorDao = new ProveedorList();
    private UsuarioDAOImpl usuarioDao = new UsuarioDAOImpl();

    // ==================== USUARIOS ====================
    public RecyclonServicio() {
        Usuario user = new Usuario(1, "David", "Duque", "DavidDuque", "david");
        nuevoUsuario(user, "david");
        
        user = new Usuario(2, "Asier", "Mateo", "AsierMateo", "asier");
        nuevoUsuario(user, "asier");
        
        user = new Usuario(3, "Aaron", "Marrero", "AaronMarrero", "aaron");
        nuevoUsuario(user, "aaron");
        
        user = new Usuario(4, "Diego", "Castillo", "DiegoCastillo", "diego");
        nuevoUsuario(user, "diego");

    }

    // ==================== MÉTODOS PROVEEDOR ====================
    /**
     * Obtiene la lista completa de todos los proveedores registrados.
     *
     * @return Una lista con todos los proveedores.
     */
    public List<Proveedor> getProveedores() {
        return proveedorDao.getProveedores();
    }

    /**
     * Obtiene un proveedor específico por su ID.
     *
     * @param id El ID del proveedor a buscar.
     * @return El proveedor encontrado, o null si no existe.
     */
    public Proveedor getProveedor(Integer id) {
        return proveedorDao.getProveedor(id);
    }

    /**
     * Obtiene un proveedor específico por su nombre.
     *
     * @param nombre El nombre del proveedor a buscar.
     * @return El proveedor encontrado, o null si no existe.
     */
    public Proveedor getProveedor(String nombre) {
        return proveedorDao.getProveedor(nombre);
    }

    /**
     * Elimina un proveedor de la base de datos por su ID.
     *
     * @param id El ID del proveedor a eliminar.
     */
    public void deleteProveedor(Integer id) {
        proveedorDao.deleteProveedor(id);
    }

    /**
     * Agrega un nuevo proveedor con validaciones.
     *
     * @param nuevo El proveedor a agregar. No puede ser null.
     * @return El proveedor agregado con su ID asignado.
     * @throws IllegalArgumentException si los datos del proveedor son
     * inválidos.
     */
    public Proveedor addProveedor(Proveedor nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("El proveedor no puede ser null");
        }
        if (nuevo.getNombre() == null || nuevo.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del proveedor es OBLIGATORIO");
        }
        if (nuevo.getTipo() == null) {
            throw new IllegalArgumentException("El tipo del proveedor es OBLIGATORIO");
        }
        return proveedorDao.addProveedor(nuevo);
    }

    /**
     * Modifica los datos de un proveedor existente.
     *
     * @param modificar El proveedor con los datos actualizados. No puede ser
     * null.
     * @throws IllegalArgumentException si el proveedor es null.
     */
    public void modificarProveedor(Proveedor modificar) {
        if (modificar == null) {
            throw new IllegalArgumentException("El proveedor no puede ser null");
        }
        proveedorDao.modificarProveedor(modificar);
    }

    // ==================== MÉTODOS MOVIMIENTO ====================
    /**
     * Obtiene la lista completa de todos los movimientos registrados.
     *
     * @return Una lista con todos los movimientos.
     */
    public List<Movimiento> getMovimientos() {
        return movimientoDao.getMovimientos();
    }

    /**
     * Obtiene un movimiento específico por su ID.
     *
     * @param id El ID del movimiento a buscar.
     * @return El movimiento encontrado, o null si no existe.
     */
    public Movimiento getMovimiento(Integer id) {
        return movimientoDao.getMovimiento(id);
    }

    /**
     * Elimina un movimiento de la base de datos por su ID.
     *
     * @param id El ID del movimiento a eliminar.
     */
    public void deleteMovimiento(Integer id) {
        movimientoDao.deleteMovimiento(id);
    }

    /**
     * Agrega un nuevo movimiento con validaciones. Valida que el movimiento
     * tenga estructura correcta según su tipo.
     *
     * @param nuevo El movimiento a agregar. No puede ser null.
     * @return El movimiento agregado con su ID asignado.
     * @throws IllegalArgumentException si los datos del movimiento son
     * inválidos.
     */
    public Movimiento addMovimiento(Movimiento nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("El movimiento no puede ser null");
        }
        if (nuevo.getMonto() == null || nuevo.getMonto() <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        if (nuevo.getTipo() == null) {
            throw new IllegalArgumentException("El tipo de movimiento es OBLIGATORIO");
        }
        if (!nuevo.esValido()) {
            throw new IllegalArgumentException("El movimiento no es válido: debe tener cliente para COBRO o proveedor para GASTO");
        }
        if (nuevo.getCuentaBanco() == null) {
            throw new IllegalArgumentException("La cuenta bancaria es requerida");
        }
        return movimientoDao.addMovimiento(nuevo);
    }

    /**
     * Modifica los datos de un movimiento existente.
     *
     * @param modificar El movimiento con los datos actualizados. No puede ser
     * null.
     * @throws IllegalArgumentException si el movimiento es null.
     */
    public void modificarMovimiento(Movimiento modificar) {
        if (modificar == null) {
            throw new IllegalArgumentException("El movimiento no puede ser null");
        }
        movimientoDao.modificarMovimiento(modificar);
    }

    // ==================== MÉTODOS CLIENTE ====================
    /**
     * Obtiene la lista completa de todos los clientes registrados.
     *
     * @return Una lista con todos los clientes.
     */
    public List<Cliente> getClientes() {
        return clienteDao.getClientes();
    }

    /**
     * Obtiene un cliente específico por su ID.
     *
     * @param id El ID del cliente a buscar.
     * @return El cliente encontrado, o null si no existe.
     */
    public Cliente getCliente(Integer id) {
        return clienteDao.getCliente(id);
    }

    /**
     * Obtiene un cliente específico por su nombre.
     *
     * @param nombre El nombre del cliente a buscar.
     * @return El cliente encontrado, o null si no existe.
     */
    public Cliente getCliente(String nombre) {
        return clienteDao.getCliente(nombre);
    }

    /**
     * Elimina un cliente de la base de datos por su ID.
     *
     * @param id El ID del cliente a eliminar.
     */
    public void deleteCliente(Integer id) {
        clienteDao.deleteCliente(id);
    }

    /**
     * Agrega un nuevo cliente con validaciones.
     *
     * @param nuevo El cliente a agregar. No puede ser null.
     * @return El cliente agregado con su ID asignado.
     * @throws IllegalArgumentException si los datos del cliente son inválidos.
     */
    public Cliente addCliente(Cliente nuevo) {
        if (nuevo == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }
        if (nuevo.getNombre() == null || nuevo.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de cliente es OBLIGATORIO");
        }
        if (nuevo.getEmail() == null || nuevo.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("El email del cliente es OBLIGATORIO");
        }
        return clienteDao.addCliente(nuevo);
    }

    /**
     * Modifica los datos de un cliente existente.
     *
     * @param modificar El cliente con los datos actualizados. No puede ser
     * null.
     * @throws IllegalArgumentException si el cliente es null.
     */
    public void modificarCliente(Cliente modificar) {
        if (modificar == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }
        clienteDao.modificarCliente(modificar);
    }

    // ==================== MÉTODOS USUARIO ====================
    /**
     * Valida las credenciales de un usuario para el login.
     *
     * @param usuario Nombre de usuario.
     * @param password Contraseña en texto plano.
     * @return El usuario si las credenciales son válidas, null si no.
     * @throws IllegalArgumentException si los parámetros son inválidos.
     */
    public Usuario login(String usuario, String password) {
        if (usuario == null || usuario.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es Obligatorio");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña es Obligatoria");
        }
        Usuario u = usuarioDao.getUsuario(usuario);
        if (u != null && PasswordManager.checkPassword(password, u.getHash())) {
            return u;
        }
        return null;
    }

    /**
     * Crea un nuevo usuario con contraseña hasheada de forma segura.
     *
     * @param nuevo El usuario a crear. No puede ser null.
     * @param password La contraseña en texto plano. No puede estar vacía.
     * @return El usuario creado con su ID asignado.
     * @throws IllegalArgumentException si los datos son inválidos o el usuario
     * ya existe.
     */
    public Usuario nuevoUsuario(Usuario nuevo, String password) {
        if (nuevo == null) {
            throw new IllegalArgumentException("El usuario no puede ser null");
        }
        if (nuevo.getUsuario() == null || nuevo.getUsuario().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de usuario es requerido");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }
        if (usuarioDao.getUsuario(nuevo.getUsuario()) != null) {
            throw new IllegalArgumentException("El nombre de usuario ya existe");
        }
        String hash = PasswordManager.getHash(password);
        nuevo.setHash(hash);
        return usuarioDao.nuevoUsuario(nuevo);
    }

}
