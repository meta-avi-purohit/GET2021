import java.sql.Date;
public class Orders {
	private int id;
	private Date orderDate;
	private int orderTotal;
	
	public Orders(int id, Date orderDate, int orderTotal){
		this.id = id;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
	}
	
	@Override 
	public String toString(){
		return "\n{ Order ID : " + id + ", Order Date : " + orderDate + ", Order Total : " + orderTotal + " }\n";
	}
}
