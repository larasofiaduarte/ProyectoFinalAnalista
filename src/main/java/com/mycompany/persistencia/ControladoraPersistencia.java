
package com.mycompany.persistencia;

import com.mycompany.GUI.exceptions.NonexistentEntityException;
import com.mycompany.proyectofinal.Usuario;
import com.mycompany.proyectofinal.Cliente;
import com.mycompany.proyectofinal.Proveedor;
import com.mycompany.proyectofinal.Producto;
import com.mycompany.proyectofinal.Servicio;
import com.mycompany.proyectofinal.Turno;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        //DELETE
        public void borrarCliente(int numCliente) {

                cliJpa.destroy(numCliente);
        }
        
        
    //PROVEEDOR
        
    ProveedorJpaController provJpa = new ProveedorJpaController();

        public void guardarProveedor(Proveedor nuevoProveedor){
            provJpa.create(nuevoProveedor);
        }

    //PRODUCTO
    
    ProductoJpaController prodJpa = new ProductoJpaController();

        //CREATE
        public void guardarProducto(Producto nuevoProducto){
            prodJpa.create(nuevoProducto);
        }

        //READ
        public List<Producto> traerProducto() {
           return prodJpa.findProductoEntities();
        }

        //DELETE
        public void borrarProducto(int numProductos) {

                prodJpa.destroy(numProductos);
        }
        
        
   //SERVICIO
        
   ServicioJpaController serJpa = new ServicioJpaController();
        //CREATE
        public void guardarServicio(Servicio nuevoServicio){
            serJpa.create(nuevoServicio);
        }

        //READ
        public List<Servicio> traerServicio() {
           return serJpa.findServicioEntities();
        }

        //DELETE
        public void borrarServicio(int numServicios) {

                serJpa.destroy(numServicios);
        }
        
        
    //TURNO
        
    TurnoJpaController turJpa = new TurnoJpaController();
    
        public void guardarTurno(Turno nuevoTurno){
            turJpa.create(nuevoTurno);
        }

        //READ
        public List<Turno> traerTurnos() {
                return turJpa.findTurnoEntities();
        }
        
        
        //DELETE
        public void borrarTurno(int numTurnos) {

            turJpa.destroy(numTurnos);
        }

    
        
        
}
