/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Jogador;
import br.edu.ifsul.modelo.Posicao;
import br.edu.ifsul.modelo.Time;
import java.util.Calendar;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TestePersistirJogador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Jogador j = new Jogador();
        j.setNome("Lucas");
        j.setPeso(89.600);
        j.setAltura(1.84);
        j.setCpf("162.006.500-20");
        j.setNascimento(Calendar.getInstance());
        j.setPosicao(em.find(Posicao.class, 1));
        j.setTime(em.find(Time.class, 1));
        
        em.getTransaction().begin();
        em.persist(j);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
