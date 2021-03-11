/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TesteAlterarEstado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Estado e = em.find(Estado.class, 2);
        e.setNome("Santa Catarina");
        e.setUf("SC");
        
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
