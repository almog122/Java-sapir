package assign3_2;
import java.sql.*;
import java.util.Scanner;

public class MySQLConnection {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		Connection con = null;
		
		try {
			String conURLPart1 = "jdbc:mysql://localhost:3306/";
			String conURLPart2 = "?serverTimezone=UTC";
			System.out.println("Please enter the database name: ");
			String getURL = sc.next();
			String connectionURL = conURLPart1 + getURL + conURLPart2;
			System.out.println("Enter the user:");
			String username = sc.next();
			System.out.println("Enter the pass:");
			String password = sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(connectionURL, username, password);
			Statement stmt = con.createStatement();
			
			int option = -1;
			while(option != 4) {
				System.out.println("Enter a choice from the menu");
				System.out.println("1 - Add a new catagory");
				System.out.println("2 - Execute a user query");
				System.out.println("3 - Execute a pramaterized query");
				System.out.println("4 - Exit Menu");
				
				option = sc.nextInt();
				switch(option) {
				
				case 1: 
					String insertCat = "INSERT INTO category(name) " + "values(?)";
					PreparedStatement stmt_cat = con.prepareStatement(insertCat);
					insertToCat(stmt_cat);
					break;
				case 2:
					Scanner scUser = new Scanner(System.in);
					System.out.println("Please enter a query: ");
					String userQuery = scUser.nextLine();
					
					PreparedStatement stmt_user = con.prepareStatement(userQuery);
					userQuery(stmt_user, userQuery);
					break;
				case 3:
					paramQuery(con);
					break;
				case 4:
					con.close();
					stmt.close();
					System.out.println("Bye for now");
					break;
				}
				
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertToCat(PreparedStatement stmt_cat) throws SQLException {
		Scanner input = new Scanner(System.in);
		String name = null;
		
		while (name == null){
			System.out.println("Please enter a category name: ");
			name = input.nextLine();
		}
		
		stmt_cat.setString(1, name);
		if (stmt_cat.executeUpdate() != 0) {
			System.out.println("Succesfull addition to DB");
		}
	}
	
	public static void userQuery(PreparedStatement stmt_user) throws SQLException {
		
		ResultSet result = stmt_user.executeQuery();
		ResultSetMetaData rsmd = result.getMetaData();
		int sizeCol = rsmd.getColumnCount();
		
		while (result.next()) {
			for (int i = 0; i < sizeCol; i++) {
				System.out.println(result.getString(i) + ", ");
			}
			System.out.println();
		}
		
		result.close();
	}
	
	public static void userQuery(PreparedStatement stmt_user, String q) throws SQLException {
		
		ResultSet result = stmt_user.executeQuery(q);
		ResultSetMetaData rsmd = result.getMetaData();
		int sizeCol = rsmd.getColumnCount();
		
		while (result.next()) {
			for (int i = 0; i < sizeCol; i++) {
				System.out.println(result.getString(i) + ", ");
			}
			System.out.println();
		}
		
		result.close();
	}
	
	public static void paramQuery(Connection con) throws SQLException {
		Scanner in = new Scanner(System.in);
		Scanner in1 = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		
		int queryOption = -1;
		
		while (queryOption != 6) {
			System.out.println("Please provide a query option from the menu");
			System.out.println("1 - Search for an actor by first name or last name");
			System.out.println("2 - Search for all actors by a movie name that they played in");
			System.out.println("3 - Search by original language");
			System.out.println("4 - Search for a movie by category name");
			System.out.println("5 - Search for all the actors the played in exactly X number of movies");
			System.out.println("6 - Exit");
			
			switch(queryOption) {
			
			case 1:
				String query1 = "SELECT * FROM `actor` WHERE actor.first_name=? or actor.last_name=?";
				PreparedStatement q1 = con.prepareStatement(query1);
				
				String fName=null;
				String lName=null;
				
				while(fName == null || lName == null) {
					System.out.println("Enter first_name: ");
					fName = in1.nextLine();
					System.out.println("Enter last_name: ");
					lName = in2.nextLine();
				}
				
				q1.setString(1, fName);
				q1.setString(2, lName);
				
				userQuery(q1);
				break;
				
			case 2:
				String query2 = "SELECT actor.first_name, actor.last_name "
								+ "FROM actor, film_actor, film "
								+ "WHERE actor.actor_id = film_actor.actor_id AND film_actor.film_id=film.film_id AND film.title=?";
				PreparedStatement q2 = con.prepareStatement(query2);
				
				String movieName = null;
				while(movieName == null) {
					System.out.println("Enter a name of a movie: ");
					movieName  = in1.nextLine();
				}
				
				q2.setString(1, movieName);
				userQuery(q2);
				break;
			case 3:
				String query3 = "SELECT film.title, film.language "
								+ "FROM film, language "
								+ "WHERE film.language_id = language.language_id AND language.name=? ";
				PreparedStatement q3 = con.prepareStatement(query3);
				
				String languageName = null;
				while(languageName == null) {
					System.out.println("Enter a language name: ");
					languageName = in2.nextLine();
				}
				
				q3.setString(1, languageName);
				userQuery(q3);
				break;
			case 4:
				String query4 = "SELECT film.title, film_category.film_id "
						+ "FROM film, film_category, category "
						+ "WHERE film.film_id = film_category.film_id AND film_category.category_id = category.category_id AND category.name=? ";
				PreparedStatement q4 = con.prepareStatement(query4);
				
				String categoryName = null;
				while(categoryName == null) {
					System.out.println("Enter a category: ");
					categoryName  = in1.nextLine();
				}
				
				q4.setString(1, categoryName);
				userQuery(q4);
				break;
			case 5:
				String query5 = "SELECT actor.first_name, actor.last_name "
								+ "FROM actor, film_actor, film "
								+ "WHERE actor.actor_id IN (SELECT actor_id FROM film_actor GROUP BY actor_id HAVING COUNT(film_id)=?) ";
				PreparedStatement q5 = con.prepareStatement(query5);
				
				int accurateMovieNum;
				System.out.println("Enter accurate number of movies played by an actor: ");
				accurateMovieNum = in2.nextInt();
				
				while(accurateMovieNum <= 0) {
					System.out.println("Enter accurate number of movies played by an actor: ");
					accurateMovieNum = in2.nextInt();
				}
				
				q5.setInt(1, accurateMovieNum);
				userQuery(q5);
				break;
			case 6:
				System.out.println("Welcome to the end");
				con.close();
				
			}
		}
	}
	
	
	
}
