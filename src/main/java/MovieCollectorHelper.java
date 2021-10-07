import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 5, 2021
 */
public class MovieCollectorHelper {
		static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAIntro");
		public void insertMovieCollector(MovieCollector c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
		}
		
		public List<MovieCollector> showAllMovieCollectors() {
		EntityManager em = emfactory.createEntityManager();
		List<MovieCollector> allMovieCollectors = em.createQuery("SELECT c FROM MovieCollector c").getResultList();
		return allMovieCollectors;
		}
		}

