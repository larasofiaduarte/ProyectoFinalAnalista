
package com.mycompany.persistencia;

import com.mycompany.proyectofinal.Usuario;
import java.util.List;

public class ControladoraPersistencia {
    UsuarioJpaController usuJpa = new UsuarioJpaController();

    public List<Usuario> traerUsuarios() {
        return usuJpa.findUsuarioEntities();
    }
    
    
    
}
