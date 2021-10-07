import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 5, 2021
 */
@Entity
@Table(name="collector")
public class MovieCollector {
	@Id
	@GeneratedValue
	private int id;
	private String collectorName;
	public MovieCollector() {
		// TODO Auto-generated constructor stub
	}
	
	public MovieCollector(int id, String collectorName) {
		super();
		this.id = id;
		this.collectorName = collectorName;
		}
		public MovieCollector(String collectorName) {
		super();
		this.collectorName = collectorName;
		
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
		 * @return the collectorName
		 */
		public String getCollectorName() {
			return collectorName;
		}

		/**
		 * @param collectorName the collectorName to set
		 */
		public void setCollectorName(String collectorName) {
			this.collectorName = collectorName;
		}

		@Override
		public String toString() {
			return "MovieCollector [id=" + id + ", collectorName=" + collectorName + "]";
		}
		
		

}
