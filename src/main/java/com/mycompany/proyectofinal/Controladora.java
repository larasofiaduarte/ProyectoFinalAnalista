
package com.mycompany.proyectofinal;

import com.mycompany.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
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
    
    //LOGICA DE CREATE, ALTA DE USUARIO
    
    //pasar user, pass, nombre, apellido, tel, rol como params
    //controlPersis.guardar

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
    
    
}