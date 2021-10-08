

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		// TODO Auto-generated method stub
    		MovieHelper mh = new MovieHelper();
    		String listName = request.getParameter("listName");
    		System.out.println("List Name: " + listName);
    		
    		String collectorName = request.getParameter("collectorName");
    		
    		String[] selectedItems = request.getParameterValues("allItemsToAdd");
    		
    		List<Movie> selectedItemsInList = new ArrayList<Movie>();
    		
    		//make sure something was selected – otherwise we get a null pointer exception
    		if (selectedItems != null && selectedItems.length > 0) 
    		{
    		for(int i = 0; i < selectedItems.length; i++) {
    		System.out.println(selectedItems[i]);
    		Movie m = mh.searchForItemById(Integer.parseInt(selectedItems[i]));
    		selectedItemsInList.add(m);
    		}
    		}
    		MovieCollector collector = new MovieCollector(collectorName);
    		ListDetails mld = new ListDetails(listName, collector);
    		mld.setListOfMovies(selectedItemsInList);
    		ListDetailsHelper mlh = new ListDetailsHelper();
    		mlh.insertNewListDetails(mld);
    		System.out.println("Success!");
    		System.out.println(mld.toString());
    		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
