package com.mycompany.proyectofinal;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-10-29T15:49:34", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Turno.class)
public class Turno_ { 

    public static volatile SingularAttribute<Turno, LocalDateTime> fecha;
    public static volatile SingularAttribute<Turno, Integer> idCliente;
    public static volatile SingularAttribute<Turno, String> Servicio;
    public static volatile SingularAttribute<Turno, Integer> id;

}