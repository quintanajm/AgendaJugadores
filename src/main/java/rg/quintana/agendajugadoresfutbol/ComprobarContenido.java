/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rg.quintana.agendajugadoresfutbol;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ComprobarContenido {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaJugadoresFutbolPU");
        Map<String, String> emfProperties = new HashMap<String, String>();
        emfProperties.put("javax.persistence.jdbc.url", "jdbc:derby:BDAgendaJugadores;create=true");
        EntityManager em = emf.createEntityManager();

        Query queryClub = em.createNamedQuery("Club.findAll");

        List<Club> listClub = queryClub.getResultList();

        for (int i = 0; i < listClub.size(); i++) {
            Club club = listClub.get(i);
            System.out.println(club.getNombre());
        }

        // Cerrar la conexión con la base de datos
        em.close();
        emf.close();

        try {
            DriverManager.getConnection("jdbc:derby:BDAgendaJugadores;shutdown=true");
        } catch (SQLException ex) {
        }
    }

}
