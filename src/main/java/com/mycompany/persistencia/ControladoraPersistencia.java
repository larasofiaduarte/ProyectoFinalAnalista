
package com.mycompany.persistencia;

import com.mycompany.proyectofinal.Usuario;
import com.mycompany.proyectofinal.Cliente;
import java.util.List;

public class ControladoraPersistencia {
    //USUARIO
    UsuarioJpaController usuJpa = new UsuarioJpaController();

    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
    }

    public void guardar(Usuario nuevoUsuario) {
        usuJpa.create(nuevoUsuario);
    }
    
    //CLIENTE
    ClienteJpaController cliJpa = new ClienteJpaController();
    
    public void guardarCliente(Cliente nuevoCliente){
        cliJpa.create(nuevoCliente);
    }
    
}
