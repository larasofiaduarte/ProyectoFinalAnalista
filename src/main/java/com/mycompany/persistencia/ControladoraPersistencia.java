
package com.mycompany.persistencia;

import com.mycompany.proyectofinal.Usuario;
import com.mycompany.proyectofinal.Cliente;
import com.mycompany.proyectofinal.Proveedor;

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
    
    //CREATE
    public void guardarCliente(Cliente nuevoCliente){
        cliJpa.create(nuevoCliente);
    }
    
    //READ
    public List<Cliente> traerClientes() {
       return cliJpa.findClienteEntities();
    }
    
    //PROVEEDOR
    ProveedorJpaController provJpa = new ProveedorJpaController();
    
    public void guardarProveedor(Proveedor nuevoProveedor){
        provJpa.create(nuevoProveedor);
    }

    
    
}
