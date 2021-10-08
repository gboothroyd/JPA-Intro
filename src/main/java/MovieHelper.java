import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;





/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Sep 14, 2021
 */
public class MovieHelper {

	static	EntityManagerFactory emfactory	= Persistence.createEntityManagerFactory("JPAIntro");
	
	public void insertItem(Movie m) {
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
	}
	
	public	List<Movie>	showAllItems(){
		EntityManager em	=	emfactory.createEntityManager();
		List<Movie>	allItems = em.createQuery("SELECT i FROM Movie i").getResultList();
		return	allItems;
		}
	
	public	void	deleteItem(Movie toDelete)	{
		EntityManager	em	=	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> typedQuery = em.createQuery("select m	from Movie m where	m.movieName = :selectedMovieName and m.genre = :selectedGenre",	Movie.class);
		typedQuery.setParameter("selectedMovieName", toDelete.getMovieName());
		typedQuery.setParameter("selectedGenre",	toDelete.getGenre());
		typedQuery.setMaxResults(1);
		Movie result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}
	
	public	void	updateItem(Movie toEdit)	{
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	em.merge(toEdit);
	em.getTransaction().commit();
	em.close();
	}
	
	public	Movie searchForItemById(int	idToEdit)	{
	EntityManager em	= emfactory.createEntityManager();
	em.getTransaction().begin();
	Movie found	= em.find(Movie.class, idToEdit);
	em.close();
	return	found;
	}
	
	public	List<Movie>	searchForMovieByMovieName(String	movieName)	{

	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	TypedQuery<Movie> typedQuery	= em.createQuery("select m from Movie m where m.movieName = :selectedMovie", Movie.class);
	typedQuery.setParameter("selectedMovie", movieName);
	List<Movie> foundItems = typedQuery.getResultList();
	em.close();
	return	foundItems;
	}
	
	public	List<Movie>	searchForMovieByGenre(String genre)	{
		EntityManager em =	emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Movie> typedQuery	= em.createQuery("select m from Movie m where m.genre = :selectedGenre", Movie.class);
		typedQuery.setParameter("selectedGenre", genre);
		List<Movie> foundItems	= typedQuery.getResultList();
		em.close();
		return	foundItems;
		}
	
	public	void	cleanUp(){
		emfactory.close();
		}

}
