import java.util.ArrayList;
import java.util.List;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Oct 5, 2021
 */
public class ListDetailsTester {

	/**
	 * 
	 */
	
	public static void main(String[] args) {
		MovieCollector cameron = new MovieCollector("Cameron");

		MovieCollectorHelper ch = new MovieCollectorHelper();
		
		ch.insertMovieCollector(cameron);
		
		Movie halloween = new Movie("Halloween", "Horror");
		Movie johnWick = new Movie("John Wick", "Action");
		List<Movie> cameronsMovies = new ArrayList<Movie>();
		cameronsMovies.add(halloween);
		cameronsMovies.add(johnWick);
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListDetails cameronsList = new ListDetails("Cameron's Movies", cameron);
		cameronsList.setListOfMovies(cameronsMovies);
		ldh.insertNewListDetails(cameronsList);
		List<ListDetails> allLists = ldh.getLists();
		for(ListDetails a: allLists) {
		System.out.println(a.toString());
		}
		}

}
