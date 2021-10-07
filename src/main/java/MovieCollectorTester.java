import java.util.List;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 5, 2021
 */
public class MovieCollectorTester {

	public static void main(String[] args) {
		MovieCollector bill = new MovieCollector("Bill");
		MovieCollectorHelper ch = new MovieCollectorHelper();
		ch.insertMovieCollector(bill);
		List<MovieCollector> allCollectors = ch.showAllMovieCollectors();
		
		for(MovieCollector a: allCollectors) {
		System.out.println(a.toString());
		}
		}
		}
