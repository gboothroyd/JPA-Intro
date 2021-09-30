import java.util.List;
import java.util.Scanner;





/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Sep 14, 2021
 */
public class StartMovieProgram {

	static Scanner in = new Scanner(System.in);
	static MovieHelper mh = new MovieHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a Movie Name: ");
		String movie = in.nextLine();
		System.out.print("Enter a Genre: ");
		String movieGenre = in.nextLine();
		
		 Movie toAdd = new Movie(movie, movieGenre);
		 mh.insertItem(toAdd);

	}
	
	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the movie name to delete: ");
		String movie = in.nextLine();
		System.out.print("Enter the genre to delete: ");
		String movieGenre = in.nextLine();
		
		Movie toDelete	=	new	Movie(movie, movieGenre);
		mh.deleteItem(toDelete);

	}
	
	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Movie name");
		System.out.println("2 : Search by Genre");
		int searchBy = in.nextInt();
		in.nextLine();
		
		List<Movie> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the movie name: ");
			String movie = in.nextLine();
			foundItems	=	mh.searchForMovieByMovieName(movie);
			
		} else {
			System.out.print("Enter the genre: ");
			String movieGenre = in.nextLine();
			foundItems	=	mh.searchForMovieByGenre(movieGenre);
			

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Movie m : foundItems) {
				System.out.println(m.getId() + " : " + m.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Movie toEdit = mh.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getGenre() + " from " + toEdit.getMovieName());
			System.out.println("1 : Update movie name");
			System.out.println("2 : Update genre");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Movie Name: ");
				String newMovieName = in.nextLine();
				toEdit.setMovieName(newMovieName);
			} else if (update == 2) {
				System.out.print("New Genre: ");
				String newGenre = in.nextLine();
				toEdit.setGenre(newGenre);
			}

			mh.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}
	public static void main(String[] args) {
		runMenu();

	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to the movie list! ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add an item");
			System.out.println("*  2 -- Edit an item");
			System.out.println("*  3 -- Delete an item");
			System.out.println("*  4 -- View the list");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				mh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}
	
	private static void viewTheList() {
		List<Movie>	allItems = mh.showAllItems();
		for(Movie singleMovie : allItems){
		System.out.println(singleMovie.returnMovieDetails());
		}
		

	}

}
