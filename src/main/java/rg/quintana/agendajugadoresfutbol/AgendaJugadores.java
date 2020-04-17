
package rg.quintana.agendajugadoresfutbol;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AgendaJugadores {

 public static void main(String[] args) {
        // Conectar con la base de datos

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgendaJugadoresFutbolPU");
        EntityManager em = emf.createEntityManager();

        Jugadores JugadoresBarcelona = new Jugadores (0, "Lionel", "Messi");

        Jugadores JugadoresMadrid = new Jugadores();
        JugadoresMadrid.setNombre("Ramos");

        em.getTransaction().begin();
        em.persist(JugadoresBarcelona);
        em.persist(JugadoresMadrid);
        em.getTransaction().commit();
        
        // Cerrar la conexión con la base de datos
        em.close(); 
        emf.close(); 
        try { 
            DriverManager.getConnection("jdbc:derby:AgendaJugadoresFutbolPU;shutdown=true"); 
        } catch (SQLException ex) { 
        }
    }
    
}
