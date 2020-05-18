package rg.quintana.agendajugadoresfutbol;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AgendaJugadores {

    public static void main(String[] args) {
        // Conectar con la base de datos

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaJugadoresFutbolPU");
        Map<String, String> emfProperties = new HashMap<String, String>();
        emfProperties.put("javax.persistence.jdbc.url", "jdbc:derby:BDAgendaJugadores;create=true");
        EntityManager em = emf.createEntityManager();   
        
        
        //        Clubes
        Club clubBarcelona = new Club(0, "FCBarcelona");

        Club clubMadrid = new Club();
        clubMadrid.setId(0);
        clubMadrid.setNombre("Real Madrid");

        Club clubBetis = new Club(0, "Real Betis Balompié");
        
        Club clubValencia = new Club();
        clubValencia.setId(0);
        clubValencia.setNombre("Valencia CF");
        
//        Jugadores

        Jugadores jugadorMessi = new Jugadores(0, "Lionel", "Messi");
        jugadorMessi.setNacionalidad("Argentina");
        jugadorMessi.setDisponible(Boolean.TRUE);
        jugadorMessi.setClub(clubBarcelona);

        Jugadores jugadorRamos = new Jugadores();
        jugadorRamos.setNombre("Sergio");
        jugadorRamos.setApellidos("Ramos");
        jugadorRamos.setNacionalidad("España");
        jugadorRamos.setDisponible(Boolean.TRUE);
        jugadorRamos.setClub(clubMadrid);

        Jugadores jugadorJoaquin = new Jugadores(0, "Joaquín", "Sánchez");
        jugadorJoaquin.setNacionalidad("España");
        jugadorJoaquin.setDisponible(Boolean.TRUE);
        jugadorJoaquin.setClub(clubBetis);

        Jugadores jugadorParejo = new Jugadores();
        jugadorParejo.setNombre("Dani");
        jugadorParejo.setApellidos("Parejo");
        jugadorParejo.setNacionalidad("España");
        jugadorParejo.setDisponible(Boolean.TRUE);
        jugadorParejo.setClub(clubValencia);

       
        em.getTransaction().begin();
        em.persist(jugadorMessi);
        em.persist(jugadorRamos);
        em.persist(jugadorJoaquin);
        em.persist(jugadorParejo);
        em.persist(clubBarcelona);
        em.persist(clubMadrid);
        em.persist(clubBetis);
        em.persist(clubValencia);
        em.getTransaction().commit();

        // Cerrar la conexión con la base de datos
        em.close();
        emf.close();

        try {
            DriverManager.getConnection("jdbc:derby:BDAgendaJugadores;shutdown=true");
        } catch (SQLException ex) {
        }
    }

}
