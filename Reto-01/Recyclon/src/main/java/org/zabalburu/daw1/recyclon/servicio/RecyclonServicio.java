/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.zabalburu.daw1.recyclon.servicio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import org.zabalburu.daw1.gestionempleados.modelo.Usuario;
import org.zabalburu.daw1.recyclon.dao.UsuarioDAOImpl;
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
    
    private static RecyclonServicio servicio = new RecyclonServicio();
    
    public static RecyclonServicio getServicio(){
        return servicio;
    }

    private ClienteDAO clienteDao = new ClienteList();
    private MovimientoDAO movimientoDao = new MovimientoList();
    private ProveedorDAO proveedorDao = new ProveedorList();
    private UsuarioDAOImpl usuarioDao = new UsuarioDAOImpl();

    // ==================== CREACION DE DATOS ====================
    // ==================== CREACION DE DATOS ====================
    private RecyclonServicio() {
        if (clienteDao.getClientes().size() > 0){
            return;
        }
        // ==================== USUARIOS ====================
        registrarUsuariosPrueba(new Usuario(1, "David", "Duque", "DavidDuque", "david"), "david");
        registrarUsuariosPrueba(new Usuario(2, "Asier", "Mateo", "AsierMateo", "asier"), "asier");
        registrarUsuariosPrueba(new Usuario(3, "Aaron", "Marrero", "AaronMarrero", "aaron"), "aaron");
        registrarUsuariosPrueba(new Usuario(4, "Diego", "Castillo", "DiegoCastillo", "diego"), "diego");

        // ==================== CLIENTES (10 - Empresas que compran muebles) ====================
        Cliente c1 = new Cliente(1, "12345678D", "TechNova Startups", "compras@technova.es", "944112233", "48001", "Bilbao", "Bizkaia", "logo_tech.png",
                new GregorianCalendar(2023, 0, 10).getTime(), 15000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c2 = new Cliente(2, "87654321E", "Bufete Abogados Martínez", "admin@martinezlegal.com", "911223344", "28001", "Madrid", "Madrid", "logo_bufete.png",
                new GregorianCalendar(2023, 1, 15).getTime(), 5000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c3 = new Cliente(3, "11223344T", "Coworking Espacio Vivo", "hola@espaciovivo.com", "933445566", "08005", "Barcelona", "Barcelona", "logo_cowork.png",
                new GregorianCalendar(2022, 5, 20).getTime(), 8000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c4 = new Cliente(4, "99887766G", "Call Center Conecta", "infraestructura@conecta.es", "954112233", "41001", "Sevilla", "Sevilla", "logo_call.png",
                new GregorianCalendar(2023, 8, 1).getTime(), 20000.0, new ArrayList<>(), EstadoCliente.SUSPENDIDO);

        Cliente c5 = new Cliente(5, "55667788D", "Academia Formación Futuro", "info@futuro.eus", "945666333", "01001", "Vitoria", "Álava", "logo_acad.png",
                new GregorianCalendar(2021, 10, 5).getTime(), 3000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c6 = new Cliente(6, "44332211F", "Clínica Dental Sonrisas", "recepcion@sonrisas.com", "963221100", "46001", "Valencia", "Valencia", "logo_dent.png",
                new GregorianCalendar(2023, 3, 12).getTime(), 2500.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c7 = new Cliente(7, "66778899X", "Arquitectos Verticales", "estudio@vertical.com", "944888999", "48991", "Getxo", "Bizkaia", "logo_arq.png",
                new GregorianCalendar(2022, 2, 28).getTime(), 6000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c8 = new Cliente(8, "22334455S", "Hotel Business Center", "eventos@hotelbc.com", "952001122", "29001", "Málaga", "Málaga", "logo_hotel.png",
                new GregorianCalendar(2023, 6, 25).getTime(), 12000.0, new ArrayList<>(), EstadoCliente.INACTIVO);

        Cliente c9 = new Cliente(9, "77889900V", "Consultoría Estratégica", "admin@consultoria.es", "910001122", "28050", "Madrid", "Madrid", "logo_consul.png",
                new GregorianCalendar(2023, 9, 10).getTime(), 4000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        Cliente c10 = new Cliente(10, "33445566L", "Biblioteca Municipal", "compras@biblio.org", "942334455", "39001", "Santander", "Cantabria", "logo_biblio.png",
                new GregorianCalendar(2020, 0, 15).getTime(), 10000.0, new ArrayList<>(), EstadoCliente.ACTIVO);

        // Añadir clientes
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

        // ==================== PROVEEDORES (10 - Fabricantes y servicios) ====================
        Proveedor p1 = new Proveedor(11, "90011122L", "Sillas Ergonómicas S.L.", "pedidos@sillas.com", "961234567", "46020", "Valencia", "Valencia", "logo_silla.png",
                new GregorianCalendar(2020, 0, 10).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.INACTIVO, "Mobiliario", "ES980000111122223333", 30, "Juan Sillería", "Stock Sillas");

        Proveedor p2 = new Proveedor(12, "90033344H", "Maderas del Norte", "almacen@maderas.es", "943112233", "20009", "San Sebastián", "Gipuzkoa", "logo_mad.png",
                new GregorianCalendar(2019, 5, 15).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Materia Prima", "ES120000111122223333", 45, "Mikel Roble", "Tableros mesa");

        Proveedor p3 = new Proveedor(13, "80055566L", "Lámparas y Diseño", "ventas@lyd.com", "934000000", "08040", "Barcelona", "Barcelona", "logo_lamp.png",
                new GregorianCalendar(2021, 2, 20).getTime(), TipoProveedor.OCASIONAL, new ArrayList<>(), EstadoProveedor.ACTIVO, "Iluminación", "ES450000111122223333", 15, "Carla Luz", "Lámparas despacho");

        Proveedor p4 = new Proveedor(14, "70088899K", "Transportes Rápidos", "logistica@transportes.es", "900100200", "28030", "Madrid", "Madrid", "logo_trans.png",
                new GregorianCalendar(2020, 8, 1).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Logística", "ES780000111122223333", 30, "Paco Camión", "Envíos clientes");

        Proveedor p5 = new Proveedor(15, "60011100F", "Iberdrola Empresas", "facturas@iberdrola.es", "900225235", "48008", "Bilbao", "Bizkaia", "logo_iber.png",
                new GregorianCalendar(2018, 0, 1).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.INACTIVO, "Suministros", "ES990000111122223333", 10, "Att. Cliente", "Luz almacén");

        Proveedor p6 = new Proveedor(16, "50022233J", "Herrajes Industriales", "pedidos@herrajes.com", "976112233", "50001", "Zaragoza", "Zaragoza", "logo_herr.png",
                new GregorianCalendar(2022, 3, 10).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Componentes", "ES110000111122223333", 60, "Ana Tuercas", "Tornillería");

        Proveedor p7 = new Proveedor(17, "40044455D", "Inmobiliaria Industrial", "alquileres@inmo.com", "944555666", "48010", "Bilbao", "Bizkaia", "logo_inmo.png",
                new GregorianCalendar(2018, 0, 1).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Alquiler", "ES330000111122223333", 5, "Luis Casero", "Alquiler Nave");

        Proveedor p8 = new Proveedor(18, "30066677M", "Oficina Total Mayorista", "b2b@oficinatotal.com", "911888999", "28900", "Getafe", "Madrid", "logo_ofi.png",
                new GregorianCalendar(2023, 1, 5).getTime(), TipoProveedor.OCASIONAL, new ArrayList<>(), EstadoProveedor.ACTIVO, "Complementos", "ES550000111122223333", 0, "Sara Stock", "Pizarras/Archivadores");

        Proveedor p9 = new Proveedor(19, "20088899P", "Limpiezas Brillo", "servicios@brillo.com", "944222333", "48901", "Barakaldo", "Bizkaia", "logo_limp.png",
                new GregorianCalendar(2021, 6, 15).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Servicios", "ES770000111122223333", 30, "Elena Limpia", "Limpieza exposición");

        Proveedor p10 = new Proveedor(20, "10099900E", "Movistar Negocios", "pymes@movistar.es", "1004", "28050", "Madrid", "Madrid", "logo_mov.png",
                new GregorianCalendar(2019, 4, 20).getTime(), TipoProveedor.RECURRENTE, new ArrayList<>(), EstadoProveedor.ACTIVO, "Telecomunicaciones", "ES220000111122223333", 30, "Soporte", "Fibra y Móvil");

        // Añadir proveedores
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

        // ==================== MOVIMIENTOS (10 - Compras y Ventas de muebles) ====================
        // Mov 1: Venta a TechNova (Cobro)
        addMovimiento(new Movimiento(1, new GregorianCalendar(2023, 10, 2).getTime(), 4500.00,
                "Venta 20 sillas ergonómicas modelo 'Tech'", TipoMovimiento.COBRO, EstadoMovimiento.PAGADO, c1, null));

        // Mov 2: Compra a Sillas Ergonómicas S.L. (Gasto)
        addMovimiento(new Movimiento(2, new GregorianCalendar(2023, 10, 5).getTime(), 2100.00,
                "Compra stock 30 sillas base", TipoMovimiento.GASTO, EstadoMovimiento.PENDIENTE, null, p1));

        // Mov 3: Venta a Bufete Martínez (Cobro)
        addMovimiento(new Movimiento(3, new GregorianCalendar(2023, 10, 8).getTime(), 3200.50,
                "Equipamiento sala de juntas (Mesa Roble)", TipoMovimiento.COBRO, EstadoMovimiento.PAGADO, c2, null));

        // Mov 4: Gasto Luz Almacén (Gasto)
        addMovimiento(new Movimiento(4, new GregorianCalendar(2023, 10, 10).getTime(), 340.20,
                "Factura luz almacén Octubre", TipoMovimiento.GASTO, EstadoMovimiento.PAGADO, null, p5));

        // Mov 5: Venta a Coworking Espacio Vivo (Cobro)
        addMovimiento(new Movimiento(5, new GregorianCalendar(2023, 10, 12).getTime(), 1250.00,
                "10 Mesas compartidas blancas", TipoMovimiento.COBRO, EstadoMovimiento.PENDIENTE, c3, null));

        // Mov 6: Compra Transporte (Gasto)
        addMovimiento(new Movimiento(6, new GregorianCalendar(2023, 10, 13).getTime(), 180.00,
                "Portes entrega pedido Bufete Martínez", TipoMovimiento.GASTO, EstadoMovimiento.PAGADO, null, p4));

        // Mov 7: Compra Maderas (Gasto)
        addMovimiento(new Movimiento(7, new GregorianCalendar(2023, 10, 15).getTime(), 1500.00,
                "Compra tableros haya para fabricación", TipoMovimiento.GASTO, EstadoMovimiento.PENDIENTE, null, p2));

        // Mov 8: Venta a Clínica Dental (Cobro)
        addMovimiento(new Movimiento(8, new GregorianCalendar(2023, 10, 18).getTime(), 890.00,
                "Mueble recepción a medida y sillas espera", TipoMovimiento.COBRO, EstadoMovimiento.PAGADO, c6, null));

        // Mov 9: Gasto Alquiler Nave (Gasto)
        addMovimiento(new Movimiento(9, new GregorianCalendar(2023, 10, 1).getTime(), 1200.00,
                "Alquiler Nave Industrial Octubre", TipoMovimiento.GASTO, EstadoMovimiento.PAGADO, null, p7));

        // Mov 10: Venta a Academia Futuro (Cobro)
        addMovimiento(new Movimiento(10, new GregorianCalendar(2023, 10, 25).getTime(), 2800.00,
                "Renovación pupitres aula 3", TipoMovimiento.COBRO, EstadoMovimiento.PENDIENTE, c5, null));
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
