
package com.mycompany.proyectofinal;

import com.mycompany.persistencia.ControladoraPersistencia;
import java.util.List;
import com.mycompany.proyectofinal.Cliente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
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
    
    //LOGICA DE ALTA DE USUARIO
    public void guardar(String user, String pass, String nombre, String apellido, String tel, String rol, String dni) {
        // Crear una nueva instancia de Usuario
        Usuario nuevoUsuario = new Usuario();
        
        // Asignar los valores a las propiedades del objeto Usuario
        nuevoUsuario.setUsername(user);
        nuevoUsuario.setPassword(pass);
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setTelefono(tel);
        nuevoUsuario.setRol(rol);
        nuevoUsuario.setDni(dni);

        // Llamar al método para guardar el usuario en la base de datos
        controlPersis.guardar(nuevoUsuario);
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
    
    //PRODUCTO
    //ALTA
    public void guardarProducto(String nombre, String stock, String minimo, String idProveedor){
        Producto nuevoProducto = new Producto();
        
        nuevoProducto.setNombre(nombre);
        nuevoProducto.setStock(stock);
        nuevoProducto.setMinimo(minimo);
        nuevoProducto.setIdProveedor(idProveedor);
        
        controlPersis.guardarProducto(nuevoProducto);
        
    }
    
    //SERVICIO
    //ALTA
        public void guardarServicio(String nombre, String precio, String idEmpleado){
        Servicio nuevoServicio = new Servicio();
        
        nuevoServicio.setNombre(nombre);
        nuevoServicio.setPrecio(precio);
        nuevoServicio.setIdEmpleado(idEmpleado);
        
        controlPersis.guardarServicio(nuevoServicio);
        
    }
        
    //TURNOS
        //ALTA
        public void guardarTurno(int cliente, String servicio, LocalDateTime fecha, Cliente clientee){
        Turno nuevoTurno = new Turno();
        
        nuevoTurno.setIdCliente(cliente);
        nuevoTurno.setServicio(servicio);
        nuevoTurno.setFecha(fecha);
        nuevoTurno.setCliente(clientee);
        
        controlPersis.guardarTurno(nuevoTurno);
        
    }
        
        //READ
        public List <Turno> traerTurnos(){


            return controlPersis.traerTurnos();

        }
        
        //DELETE
        
        public void borrarTurno(int id){
            
            controlPersis.borrarTurno(id);
        }
    
    
}