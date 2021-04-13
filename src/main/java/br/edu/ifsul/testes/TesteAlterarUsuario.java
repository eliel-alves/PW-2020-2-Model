/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TesteAlterarUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Usuario u = em.find(Usuario.class, "eliel.alves");
        //u.setNomeUsuario("elielalves");
        System.out.println("Usuário: " + u.getNomeUsuario() + "\nNome: " +
                u.getNome() + "\nSenha: " +
                u.getSenha());
        
        u.setNomeUsuario("eliel");
        
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
