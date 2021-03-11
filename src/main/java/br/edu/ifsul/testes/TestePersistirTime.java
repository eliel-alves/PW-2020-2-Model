/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Time;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author eliel
 */
public class TestePersistirTime {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2020-2-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Time t = new Time();
        t.setNome("Grêmio FBPA");
        t.setHistoria("Time fundado em 1903 na cidade de Porto Alegre.");
        t.setDataFundacao(new GregorianCalendar(1903, Calendar.SEPTEMBER, 15));
        t.setCidade(em.find(Cidade.class, 2));
        t.setTecnico(em.find(Pessoa.class, 1));
        t.setUsuario(em.find(Usuario.class, "eliel.a"));
        
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
