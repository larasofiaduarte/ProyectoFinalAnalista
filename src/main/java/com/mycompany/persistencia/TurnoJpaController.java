/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistencia;

import com.mycompany.proyectofinal.Turno;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

/**
 *
 * @author duart
 */
public class TurnoJpaController {
    private EntityManagerFactory emf;

    public TurnoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public TurnoJpaController(){
        emf = Persistence.createEntityManagerFactory("com.mycompany_ProyectoFinal_jar_1.0-SNAPSHOTPU");
    }
    
    // Create
    public void create(Turno turno) {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(turno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error cargando turno", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    // Read
    public Turno findTurno(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Turno.class, id);
        } finally {
            em.close();
        }
    }

    public List<Turno> findTurnoEntities() {
        return findTurnoEntities(true, -1, -1);
    }
    
    public List<Turno> findTurnoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Turno> query = em.createQuery("SELECT u FROM Turno u", Turno.class);
            if (!all) {
                query.setMaxResults(maxResults);
                query.setFirstResult(firstResult);
            }
            return query.getResultList();
        } finally {
            em.close();
        }
    }
    
    // Update
    public void edit(Turno turno) {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(turno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error updating turno", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    // Delete
    public void destroy(int id) {
        EntityManager em = null;
        EntityTransaction transaction = null;

        try {
            em = emf.createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            Turno turno = em.getReference(Turno.class, id);
            em.remove(turno);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error deleting turno", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
}
