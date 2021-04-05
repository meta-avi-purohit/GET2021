import java.sql.*;
import java.util.ArrayList;

public class Queries {
	private static final String host = "jdbc:mysql://localhost:3306/";
	private static final String dbName = "storefront";
	private static final String mysqlURL = host + dbName;
	private static final String userId = "root";
	private static final String password = "metacube#123";

	private static final String getOrderDetails = "SELECT O.order_id,O.order_date,O.order_total " +
													"FROM orders O " +
													"JOIN address A ON A.address_ID = O.address_ID " +
													"JOIN shopper S ON S.shopper_ID = A.shopper_ID " +
													"WHERE S.shopper_ID = ? " +
													"AND O.order_status IN ('Shipped','Complete') " +
													"GROUP BY O.order_ID " + 
													"ORDER BY O.order_date;";
	
	private static final String Path = "C:/Users/avi.purohit_metacube/Downloads/";
	private static final String image[] = { Path + "Parking.jpg",Path + "Parking.jpg", Path + "Parking.jpg" };
	private static final String insertImage = "INSERT INTO images(image,product_ID) " + 
												"VALUES(LOAD_FILE(" + "?)" + ",?);";
	
	private static final String deleteProduct = "DELETE FROM product " + "WHERE product_ID NOT IN " +
												"(SELECT Pr.product_ID FROM " +"(SELECT Pd.product_ID " + " FROM product Pd " 
												+"JOIN orderdetails D ON D.product_ID = pd.product_ID " +
												"JOIN orders O ON O.order_ID = D.order_ID "+
												"WHERE O.order_date >= DATE(CURDATE() - INTERVAL 1 YEAR)) AS Pr);";
	
	
	private static final String categorycount = "SELECT C1.category_title, COUNT(*) " +
												"FROM categories C1 JOIN categories C2 " +
												"WHERE C1.parent_ID = C2.category_ID " +
												"GROUP BY C1.parent_ID ;";
	
	
	public static Connection getConnection() throws SQLException,
			SQLTimeoutException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(mysqlURL, userId,
				password);
		return connection;
	}
	
	public static ArrayList<Orders> getOrderDetails(int userID){
		ArrayList<Orders> listOfOrder = new ArrayList<Orders>();
		try {
			Connection connection = getConnection();
			Orders orderDetails;
			PreparedStatement preparedStatement = connection.prepareStatement(getOrderDetails);
			preparedStatement.setInt(1, userID);
			ResultSet resultSetOfUser = preparedStatement.executeQuery();
			while(resultSetOfUser.next()){
				orderDetails = new Orders(resultSetOfUser.getInt(1), resultSetOfUser.getDate(2), resultSetOfUser.getInt(3));
				listOfOrder.add(orderDetails);
			}
			preparedStatement.close();
			connection.close();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return listOfOrder;
	}
	
	public static void insertImages(){
		try{
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(insertImage);
			int index = 0;
			while(index < image.length){
				preparedStatement.setString(1, image[index]);
				preparedStatement.setInt(2, index+1);
				preparedStatement.addBatch();
				index++;
			}
			preparedStatement.executeBatch();
			preparedStatement.close();
			connection.close();
			System.out.println("Images are inserted in Database.");
		}catch(Exception e){
			System.out.println("\n" + e.getMessage());
		}
	}
	
	public static int deleteProducts(){
		int total = 0;
		try{
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(deleteProduct);
			total = preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		}catch(Exception e){
			System.out.println("\n" + e.getMessage());
		}
		return total;
	}
	
	public static ArrayList<Category> getCategory(){
		ArrayList<Category> listOfCategory = new ArrayList<Category>();
		try {
			Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(categorycount);
			ResultSet resultCategory = preparedStatement.executeQuery();
			Category cate;
			while(resultCategory.next()){
				cate = new Category(resultCategory.getString(1), resultCategory.getInt(2));
				listOfCategory.add(cate);
			}
			preparedStatement.close();
			connection.close();
		}catch(Exception e){
			System.out.println("\n"+ e.getMessage());
		}
		return listOfCategory;
	}

	public static void main(String[] args){
		
		System.out.println("Order Details : ");
		System.out.println(Queries.getOrderDetails(4));
		
		System.out.println("#################################");
		Queries.insertImages();
		
		
		System.out.println("#################################");
		System.out.println("Number of Product Deleted : " + Queries.deleteProducts());
		
		System.out.println("#################################");
		System.out.println("Top Parent Categories : " + Queries.getCategory());
	}
}
