/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.servicio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
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
import org.zabalburu.daw1.recyclon.util.EstadoMovimiento;
import org.zabalburu.daw1.recyclon.util.EstadoProveedor;
import org.zabalburu.daw1.recyclon.util.PasswordManager;
import org.zabalburu.daw1.recyclon.util.TipoMovimiento;
import org.zabalburu.daw1.recyclon.util.TipoProveedor;

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

    // ==================== CREACION DE DATOS ====================
    public RecyclonServicio() {
        // ==================== USUARIOS ====================
        registrarUsuariosPrueba(new Usuario(1, "David", "Duque", "DavidDuque", "david"), "david");
        registrarUsuariosPrueba(new Usuario(2, "Asier", "Mateo", "AsierMateo", "asier"), "asier");
        registrarUsuariosPrueba(new Usuario(3, "Aaron", "Marrero", "AaronMarrero", "aaron"), "aaron");
        registrarUsuariosPrueba(new Usuario(4, "Diego", "Castillo", "DiegoCastillo", "diego"), "diego");
        // ==================== CLIENTES (10) ====================
        // Nota: Los meses en GregorianCalendar van de 0 (Enero) a 11 (Diciembre)
        Cliente c1 = new Cliente(1, 12345678, "Tech Solutions S.L.", "contacto@techsolutions.es", "944123456", "48001", "Bilbao", "Bizkaia", "logo_tech.png",
                new GregorianCalendar(2023, 0, 15).getTime(), 5000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c2 = new Cliente(2, 87654321, "Restaurante La Cuchara", "reservas@lacuchara.com", "911223344", "28001", "Madrid", "Madrid", "logo_cuchara.png",
                new GregorianCalendar(2023, 2, 10).getTime(), 2000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c3 = new Cliente(3, 11223344, "Construcciones Norte", "obras@cnorte.com", "981556677", "15001", "A Coruña", "A Coruña", "logo_cons.png",
                new GregorianCalendar(2022, 5, 20).getTime(), 15000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c4 = new Cliente(4, 99887766, "Gimnasio PowerFit", "info@powerfit.es", "933445566", "08005", "Barcelona", "Barcelona", "logo_gym.png",
                new GregorianCalendar(2023, 8, 1).getTime(), 1000.0, new ArrayList<>(), EstadoCliente.SUSPENDIDO);

        Cliente c5 = new Cliente(5, 55667788, "Ayuntamiento de Basauri", "info@basauri.eus", "944666333", "48970", "Basauri", "Bizkaia", "logo_ayto.png",
                new GregorianCalendar(2021, 0, 1).getTime(), 20000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c6 = new Cliente(6, 44332211, "Librería Cervantes", "pedidos@cervantes.com", "954112233", "41001", "Sevilla", "Sevilla", "logo_lib.png",
                new GregorianCalendar(2023, 10, 5).getTime(), 500.0, new ArrayList<>(), EstadoCliente.INACTIVO);

        Cliente c7 = new Cliente(7, 66778899, "Talleres Mecánicos Paco", "taller@paco.com", "963221100", "46001", "Valencia", "Valencia", "logo_taller.png",
                new GregorianCalendar(2022, 3, 12).getTime(), 3000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c8 = new Cliente(8, 22334455, "Hotel Miramar", "recepcion@miramar.com", "952001122", "29001", "Málaga", "Málaga", "logo_hotel.png",
                new GregorianCalendar(2023, 6, 25).getTime(), 10000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c9 = new Cliente(9, 77889900, "Panadería El Trigo", "pan@eltrigo.es", "947112233", "09001", "Burgos", "Burgos", "logo_pan.png",
                new GregorianCalendar(2023, 1, 14).getTime(), 1500.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c10 = new Cliente(10, 33445566, "Academia de Idiomas Speak", "hello@speak.com", "942334455", "39001", "Santander", "Cantabria", "logo_acad.png",
                new GregorianCalendar(2023, 9, 10).getTime(), 1200.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        // Añadir clientes al DAO
        addCliente(c1);
        addCliente(c2);
        addCliente(c3);
        addCliente(c4);
        addCliente(c5);
        addCliente(c6);
        addCliente(c7);
        addCliente(c8);
        addCliente(c9);
        addCliente(c10);

        // ==================== PROVEEDORES (10) ====================
        Proveedor p1 = new Proveedor(11, 90011122, "Iberdrola Clientes", "facturas@iberdrola.es", "900225235", "48008", "Bilbao", "Bizkaia", "logo_iber.png",
                new GregorianCalendar(2020, 0, 1).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Suministros", "ES980000111122223333", 30, "Juan Pérez", "Pago luz");

        Proveedor p2 = new Proveedor(12, 90033344, "Movistar Empresas", "pymes@movistar.es", "1004", "28050", "Madrid", "Madrid", "logo_mov.png",
                new GregorianCalendar(2020, 2, 15).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Telecomunicaciones", "ES120000111122223333", 30, "María López", "Fibra y Móvil");

        Proveedor p3 = new Proveedor(13, 80055566, "Ofiprix S.L.", "ventas@ofiprix.com", "934000000", "08040", "Barcelona", "Barcelona", "logo_ofi.png",
                new GregorianCalendar(2022, 4, 10).getTime(), TipoProveedor.OCASIONAL, new ArrayList<>(), EstadoProveedor.ACTIVO, "Mobiliario", "ES450000111122223333", 15, "Carlos Ruiz", "Compra sillas");

        Proveedor p4 = new Proveedor(14, 70088899, "Wurth España", "contacto@wurth.es", "900100200", "08184", "Palau", "Barcelona", "logo_wurth.png",
                new GregorianCalendar(2021, 6, 20).getTime(), TipoProveedor.OCASIONAL, new ArrayList<>(), EstadoProveedor.ACTIVO, "Herramientas", "ES780000111122223333", 45, "Ana García", "Tornillería");

        Proveedor p5 = new Proveedor(15, 60011100, "Limpiezas Brillante", "info@brillante.com", "944555666", "48010", "Bilbao", "Bizkaia", "logo_limp.png",
                new GregorianCalendar(2023, 0, 5).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Servicios", "ES990000111122223333", 10, "Pedro Sanz", "Limpieza mensual");

        Proveedor p6 = new Proveedor(16, 50022233, "Repsol Directo", "tarjetas@repsol.com", "901100100", "28045", "Madrid", "Madrid", "logo_rep.png",
                new GregorianCalendar(2021, 11, 1).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Combustible", "ES110000111122223333", 30, "Laura Gil", "Gasolina furgonetas");

        Proveedor p7 = new Proveedor(17, 40044455, "Amazon Business", "business@amazon.es", "900000000", "28223", "Pozuelo", "Madrid", "logo_amz.png",
                new GregorianCalendar(2023, 2, 1).getTime(), TipoProveedor.OCASIONAL, new ArrayList<>(), EstadoProveedor.ACTIVO, "Varios", "ES330000111122223333", 0, "Soporte Web", "Material vario");

        Proveedor p8 = new Proveedor(18, 30066677, "Gestoría Martínez", "martinez@gestores.com", "944111222", "48005", "Bilbao", "Bizkaia", "logo_gest.png",
                new GregorianCalendar(2020, 5, 15).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Legal", "ES550000111122223333", 15, "Luis Martínez", "Nóminas");

        Proveedor p9 = new Proveedor(19, 20088899, "Seguros Mapfre", "clientes@mapfre.com", "918000000", "28222", "Majadahonda", "Madrid", "logo_map.png",
                new GregorianCalendar(2020, 0, 10).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Seguros", "ES770000111122223333", 365, "Elena Torres", "Seguro local");

        Proveedor p10 = new Proveedor(20, 10099900, "Makro Mayorista", "clientes@makro.es", "900111000", "48950", "Erandio", "Bizkaia", "logo_makro.png",
                new GregorianCalendar(2022, 8, 25).getTime(), TipoProveedor.OCASIONAL, new ArrayList<>(), EstadoProveedor.INACTIVO, "Alimentación", "ES220000111122223333", 0, "Tienda Física", "Bebidas evento");

        // Añadir proveedores al DAO
        addProveedor(p1);
        addProveedor(p2);
        addProveedor(p3);
        addProveedor(p4);
        addProveedor(p5);
        addProveedor(p6);
        addProveedor(p7);
        addProveedor(p8);
        addProveedor(p9);
        addProveedor(p10);

        // ==================== MOVIMIENTOS (10) ====================
        // Cobros (Cliente != null, Proveedor == null)
        // Gastos (Cliente == null, Proveedor != null)
        // Mov 1: Cobro a Tech Solutions
        addMovimiento(new Movimiento(1, new GregorianCalendar(2023, 10, 1).getTime(), 1250.50,
                "Servicio de consultoría Octubre", TipoMovimiento.COBRO, EstadoMovimiento.PAGADO, c1, null));

        // Mov 2: Gasto de Iberdrola
        addMovimiento(new Movimiento(2, new GregorianCalendar(2023, 10, 5).getTime(), 250.00,
                "Factura Electricidad Noviembre", TipoMovimiento.GASTO, EstadoMovimiento.PENDIENTE, null, p1));

        // Mov 3: Cobro a Restaurante La Cuchara
        addMovimiento(new Movimiento(3, new GregorianCalendar(2023, 10, 10).getTime(), 450.00,
                "Recogida de residuos orgánicos", TipoMovimiento.COBRO, EstadoMovimiento.PAGADO, c2, null));

        // Mov 4: Gasto de Movistar
        addMovimiento(new Movimiento(4, new GregorianCalendar(2023, 10, 12).getTime(), 65.90,
                "Internet y Fijo Oficina", TipoMovimiento.GASTO, EstadoMovimiento.PAGADO, null, p2));

        // Mov 5: Cobro a Ayuntamiento de Basauri
        addMovimiento(new Movimiento(5, new GregorianCalendar(2023, 10, 15).getTime(), 5000.00,
                "Contrato anual gestión papel", TipoMovimiento.COBRO, EstadoMovimiento.PENDIENTE, c5, null));

        // Mov 6: Gasto de Repsol
        addMovimiento(new Movimiento(6, new GregorianCalendar(2023, 10, 18).getTime(), 120.50,
                "Gasolina furgoneta reparto", TipoMovimiento.GASTO, EstadoMovimiento.PAGADO, null, p6));

        // Mov 7: Cobro a Hotel Miramar
        addMovimiento(new Movimiento(7, new GregorianCalendar(2023, 10, 20).getTime(), 2100.00,
                "Gestión residuos hostelería", TipoMovimiento.COBRO, EstadoMovimiento.PAGADO, c8, null));

        // Mov 8: Gasto de Ofiprix
        addMovimiento(new Movimiento(8, new GregorianCalendar(2023, 10, 22).getTime(), 350.00,
                "Compra silla ergonómica", TipoMovimiento.GASTO, EstadoMovimiento.PAGADO, null, p3));

        // Mov 9: Cobro a Talleres Paco
        addMovimiento(new Movimiento(9, new GregorianCalendar(2023, 10, 25).getTime(), 800.00,
                "Reciclaje aceites industriales", TipoMovimiento.COBRO, EstadoMovimiento.PENDIENTE, c7, null));

        // Mov 10: Gasto de Gestoría
        addMovimiento(new Movimiento(10, new GregorianCalendar(2023, 10, 30).getTime(), 150.00,
                "Honorarios gestoría Trimestre 3", TipoMovimiento.GASTO, EstadoMovimiento.PENDIENTE, null, p8));

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

    private void registrarUsuariosPrueba(Usuario usuario, String password) {
        try {
            nuevoUsuario(usuario, password);
        } catch (Exception e) {
            System.out.println("Info: El usuario " + usuario.getNombre() + " ya esta registrado.");
        }
    }

}
