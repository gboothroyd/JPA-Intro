import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 5, 2021
 */
public class ListDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAIntro");
			public void insertNewListDetails(ListDetails c) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(c);
			em.getTransaction().commit();
			em.close();
			}
			public List<ListDetails> getLists() {
			EntityManager em = emfactory.createEntityManager();
			List<ListDetails> allDetails = em.createQuery("SELECT d FROM ListDetails d").getResultList();
			return allDetails;
			}
			}
