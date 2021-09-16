import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Sep 14, 2021
 */

@Entity
@Table(name="movies")
public class Movie {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="MOVIE_NAME")
	private String movieName;
	
	@Column(name="GENRE")
	private String genre;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	
	public Movie(String movieName, String genre) {
		super();
		this.movieName = movieName;
		this.genre = genre;
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
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}


	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}


	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String returnMovieDetails() {
		return	this.movieName + ": " +	this.genre;
	}
	
	

}
