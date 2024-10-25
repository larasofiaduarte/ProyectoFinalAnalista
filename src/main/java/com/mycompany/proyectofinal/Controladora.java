
package com.mycompany.proyectofinal;

import com.mycompany.persistencia.ControladoraPersistencia;
import java.util.List;

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
    public void guardarCliente(String nombre, String apellido, String telefono, String genero){
        Cliente nuevoCliente = new Cliente();
        
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setApellido(apellido);
        nuevoCliente.setTelefono(telefono);
        nuevoCliente.setGenero(genero);
        
        controlPersis.guardarCliente(nuevoCliente);
        
    }
    
    
}