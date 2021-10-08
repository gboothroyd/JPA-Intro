import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 5, 2021
 */
@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne (cascade=CascadeType.PERSIST)
	private MovieCollector collector;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Movie> listOfMovies;
	public ListDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public ListDetails(int id, String listName, MovieCollector collector, List<Movie> listOfMovies) {
		super();
		this.id = id;
		this.listName = listName;
		this.collector = collector;
		this.listOfMovies = listOfMovies;
			 }
			public ListDetails(String listName, MovieCollector collector, List<Movie> listOfMovies) {
				super();
				this.listName = listName;
				this.collector = collector;
				this.listOfMovies = listOfMovies;
			 }
			public ListDetails(String listName, MovieCollector collector) {
				super();
				this.listName = listName;
				this.collector = collector;
			 }

			/**
			 * @return the id
			 */
			public int getId() {
				return id;
			}

			/**
			 * @param id the id to set
			 */
			public void setId(int id) {
				this.id = id;
			}

			/**
			 * @return the listName
			 */
			public String getListName() {
				return listName;
			}

			/**
			 * @param listName the listName to set
			 */
			public void setListName(String listName) {
				this.listName = listName;
			}

			/**
			 * @return the collector
			 */
			public MovieCollector getCollector() {
				return collector;
			}

			/**
			 * @param collector the collector to set
			 */
			public void setCollector(MovieCollector collector) {
				this.collector = collector;
			}

			/**
			 * @return the listOfMovies
			 */
			public List<Movie> getListOfMovies() {
				return listOfMovies;
			}

			/**
			 * @param listOfMovies the listOfMovies to set
			 */
			public void setListOfMovies(List<Movie> listOfMovies) {
				this.listOfMovies = listOfMovies;
			}

			@Override
			public String toString() {
				return "ListDetails [id=" + id + ", listName=" + listName + ", collector=" + collector
						+ ", listOfMovies=" + listOfMovies + "]";
			}
			
			

}
