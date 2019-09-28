package models;





public class Order {

	Integer orderID;

	Integer tableID;

	String orders;

	String completed;

	float price;

	

	public Order(Integer orderID,Integer tableID, String orders,String completed, float price) {

		super();

		this.orders = orders;

		this.orderID = orderID;

		this.tableID = tableID;

		this.completed = completed;

		this.price = price;

	}



	public float getPrice() {

		return price;

	}



	public void setPrice(float price) {

		this.price = price;

	}



	public String getCompleted() {

		return completed;

	}



	public Integer getOrderID() {

		return orderID;

	}



	public void setOrderID(Integer orderID) {

		this.orderID = orderID;

	}



	public Integer getTableID() {

		return tableID;

	}



	public void setTableID(Integer tableID) {

		this.tableID = tableID;

	}



	public String getOrders() {

		return orders;

	}



	public void setOrders(String orders) {

		this.orders = orders;

	}



	public boolean isCompleted() {

		if(completed.equals("false"))

			return false;

		else

			return true;

	}



	public void setCompleted(String completed) {

		this.completed = completed;

	}

	

	

}