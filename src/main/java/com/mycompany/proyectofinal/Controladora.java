
package com.mycompany.proyectofinal;

import com.mycompany.persistencia.ControladoraPersistencia;
import java.util.List;
import com.mycompany.proyectofinal.Cliente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    private int loggedInUserId = -1;
    public String userRole;
    
    //USUARIO
    //LOGICA DE VALIDAR USUARIO PARA LOGIN
    public boolean validarUsuario(String user, String pass){
        boolean estadoLogin = false;
        
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        
        for(Usuario usu : listaUsuarios){
            if (usu.getUsername().equals(user)){
                if(usu.getPassword().equals(pass)){
                    estadoLogin = true;
                }
                else{
                    estadoLogin = false;
                }
            }else{
                estadoLogin = false;
            }
        }
        
        return estadoLogin;
    }
    
    public int validarUsuario2(String user, String pass){
        int idUser = -1;
        
        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        
        for(Usuario usu : listaUsuarios){
            if (usu.getUsername().equals(user)){
                if(usu.getPassword().equals(pass)){
                    idUser = usu.getId();
                }
            }
        }
        
        return idUser;
    }
    
    
    
    //LOGICA DE ALTA DE USUARIO
    public void guardar(String user, String pass, String nombre, String apellido, String tel, String rol) {
        // Crear una nueva instancia de Usuario
        Usuario nuevoUsuario = new Usuario();
        
        // Asignar los valores a las propiedades del objeto Usuario
        nuevoUsuario.setUsername(user);
        nuevoUsuario.setPassword(pass);
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setTelefono(tel);
        nuevoUsuario.setRol(rol);

        // Llamar al método para guardar el usuario en la base de datos
        controlPersis.guardar(nuevoUsuario);
    }
    
    //READ USUARIOS
    public List <Usuario> traerUsuarios(){
        
        
        return controlPersis.traerUsuarios();
       
    }
    //by id
    

    public Usuario findUsuario(int numEmpleado) {
       
        return controlPersis.findUsuario(numEmpleado);
    }
    
    public boolean doesUsernameExist(String username) {
            return controlPersis.doesUsernameExist(username);
    }
    
    //DELETE USUARIO
    public void borrarUsuario(int numUsuario) {
        controlPersis.borrarUsuario(numUsuario);
    }
    
    //edit
    public void modificarUsuario(Usuario usu, String user, String pass, String nombre, String apellido, String tel, String rol) {
        
        usu.setUsername(user);
        usu.setPassword(pass);
        usu.setNombre(nombre);
        usu.setApellido(apellido);
        usu.setRol(rol);
        usu.setTelefono(tel);
        
        controlPersis.modificarUsuario(usu);
    }
    
    
    //CLIENTE
    //CREATE
    public void guardarCliente(String nombre, String apellido, String telefono, String genero){
        Cliente nuevoCliente = new Cliente();
        
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellido(apellido);
        nuevoCliente.setTelefono(telefono);
        nuevoCliente.setGenero(genero);
        
        controlPersis.guardarCliente(nuevoCliente);
        
    }
    //READ
    public List <Cliente> traerClientes(){
        
        
        return controlPersis.traerClientes();
       
    }
    
        //by id
    
    public Cliente findCliente(int id){
        return controlPersis.findCliente(id);
    }
    
    
    //UPDATE
    public void modificarCliente(Cliente cli, String nombre, String apellido, String telefono, String genero) {
        
        cli.setApellido(apellido);
        cli.setNombre(nombre);
        cli.setGenero(genero);
        cli.setTelefono(telefono);
        
        controlPersis.modificarCliente(cli);
        
    }
    
    //DELETE
    public void borrarCliente(int numCliente) {
        controlPersis.borrarCliente(numCliente);
    }
    
    
    
    
    
    //PROVEEDOR
    //ALTA
    public void guardarProveedor(String nombre, String telefono, String email){
        Proveedor nuevoProveedor = new Proveedor();
        
        nuevoProveedor.setNombre(nombre);
        nuevoProveedor.setTelefono(telefono);
        nuevoProveedor.setEmail(email);
        
        controlPersis.guardarProveedor(nuevoProveedor);
    }
    public Proveedor findProveedor(int idProveedor) {
       
        return controlPersis.findProveedor(idProveedor);
    }
    //PRODUCTO
    //ALTA
    public void guardarProducto(String nombre, String stock, String minimo, Proveedor proveedor){
        Producto nuevoProducto = new Producto();
        
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setStock(stock);
        nuevoProducto.setMinimo(minimo);
        nuevoProducto.setProveedor(proveedor);
        
        controlPersis.guardarProducto(nuevoProducto);
        
    }
    
    
    //SERVICIO
    //ALTA
        public void guardarServicio(String nombre, String precio, String empleado){
        Servicio nuevoServicio = new Servicio();
        
        nuevoServicio.setNombre(nombre);
        nuevoServicio.setPrecio(precio);
        nuevoServicio.setIdEmpleado(empleado);
        
        controlPersis.guardarServicio(nuevoServicio);
        
    }
    //READ
        public List <Servicio> traerServicios(){


            return controlPersis.traerServicios();

        }
     //ELIMINAR
        public void borrarServicio(int id){
            
            controlPersis.borrarServicio(id);
        }
        
    //TURNOS
        //ALTA
        public void guardarTurno(String servicio, LocalDateTime fecha, Cliente cliente, String estado){
        Turno nuevoTurno = new Turno();
        
        nuevoTurno.setServicio(servicio);
        nuevoTurno.setFecha(fecha);
        nuevoTurno.setCliente(cliente);
        nuevoTurno.setEstado(estado);
        
        controlPersis.guardarTurno(nuevoTurno);
        
    }
        
        //READ
        public List <Turno> traerTurnos(){


            return controlPersis.traerTurnos();

        }
        //by id
        public Turno findTurno(int id){
            return controlPersis.findTurno(id);
        }
        
        //DELETE
        
        public void borrarTurno(int id){
            
            controlPersis.borrarTurno(id);
        }

    public void modificarTurno(Turno tur, String servicio, LocalDateTime fechafinal, Cliente clienteEnt, String estado) {
        
        
        tur.setServicio(servicio);
        tur.setCliente(clienteEnt);
        tur.setFecha(fechafinal);
        tur.setEstado(estado);
        
        controlPersis.modificarTurno(tur);
        
    
    }

    public Servicio findServicio(int numServicio) {
    
            return controlPersis.findServicio(numServicio);
    }

    public void modificarServicio(Servicio ser, String nombre, String precio, String emp) {
        
        ser.setIdEmpleado(emp);
        ser.setNombre(nombre);
        ser.setPrecio(precio);
        
        controlPersis.modificarServicio(ser);
    
    }

     public void setLoggedInUserId(int userId) {
        this.loggedInUserId = userId;
    }

    public int getLoggedInUserId() {
        return this.loggedInUserId;
    }

    public String getUserRole(int userId) {
        Usuario user = controlPersis.findUsuario(userId);
        return user != null ? user.getRol() : null; // Returns the role or null if user not found
    }

    public void setLoggedInUserRole(String role) {
        this.userRole = role;
    }

    public String getLoggedInUserRole() {
        return userRole;
    }

    public List<Producto> traerProductos() {
        
        return controlPersis.traerProductos();
    
    }

    public void borrarProducto(int numProducto) {
        controlPersis.borrarProducto(numProducto);
    }

    public Producto findProducto(int numProducto) {
        return controlPersis.findProducto(numProducto);
    }

    public void modificarProducto(Producto prod, String nombre, String stock, String minimo, Proveedor proveedor) {
        prod.setMinimo(minimo);
        prod.setStock(stock);
        prod.setNombre(nombre);
        prod.setProveedor(proveedor);
                
    }

    public List<Proveedor> traerProveedores() {
        return controlPersis.traerProveedores();
    }

    public void borrarProveedor(int numProv) {
        controlPersis.borrarProveedor(numProv);
    }

    public void modificarProveedor(Proveedor prov, String nombre, String telefono, String email) {
        prov.setEmail(email);
        prov.setNombre(nombre);
        prov.setTelefono(telefono);
        
        controlPersis.modificarProveedor(prov);
    
    }

    //CAJA
        //ALTA
        public void guardarConcepto(String tipo, String monto, String medio, String detalle){
        Caja nuevoConcepto = new Caja();
        
        nuevoConcepto.setTipo(tipo);
        nuevoConcepto.setDetalle(detalle);
        nuevoConcepto.setMedio(medio);
        nuevoConcepto.setMonto(monto);
        
        controlPersis.guardarCaja(nuevoConcepto);
        
    }
        
        //READ all
        public List <Caja> traerConceptos(){


            return controlPersis.traerConceptos();

        }
        //by id
        public Caja findConcepto(int id){
            return controlPersis.findConcepto(id);
        }
        
        //DELETE
        
        public void borrarConcepto(int id){
            
            controlPersis.borrarConcepto(id);
        }
        
        //EDIT
        public void modificarConcepto(Caja concepto, String tipo, String monto, String medio, String detalle) {
            concepto.setDetalle(detalle);
            concepto.setMedio(medio);
            concepto.setMonto(monto);
            concepto.setTipo(tipo);
            
            controlPersis.modificarConcepto(concepto);

        }
    
    
    
}