package com.mycompany.proyectofinal;

import com.mycompany.proyectofinal.Cliente;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-05T18:04:02", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, LocalDateTime> fecha;
    public static volatile SingularAttribute<Turno, Cliente> cliente;
    public static volatile SingularAttribute<Turno, String> estado;
    public static volatile SingularAttribute<Turno, String> Servicio;
    public static volatile SingularAttribute<Turno, Integer> id;

}