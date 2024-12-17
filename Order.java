import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable {
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverageList = new ArrayList<>();
	
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = cust;
	}
	
	@Override
	public boolean isWeekend() {
		if (this.orderDay == Day.SUNDAY || this.orderDay == Day.SATURDAY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int generateOrder() {
		Random rand = new Random();
		
		return rand.nextInt(80001) + 10000;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverageList.add(new Coffee(bevName, size, extraShot, extraSyrup));
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		beverageList.add(new Alcohol(bevName, size, this.isWeekend()));
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverageList.add(new Smoothie(bevName, size, numOfFruits, addProtein));
		
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		
		for(Beverage i: beverageList) {
			total += i.calcPrice();
		}
		
		return total;
	}
	
	public Customer getCustomer() {
		return new Customer(this.customer);
	}
	
	public Day getDay() {
		return this.orderDay;
	}
	
	public Day getOrderDay() {
		return this.orderDay;
	}
	
	public int getOrderNo() {
		return this.orderNum;
	}
	
	public int getOrderTime() {
		return this.orderTime;
	}
	
	public int getTotalItems() {
		return beverageList.size();
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int total = 0;
		for (Beverage i: beverageList) {
			if (i.getType() == type) {
				total += 1;
			}
		}
		return total;
	}

	@Override
	public int compareTo(Object o) {
		Order temp = (Order)o;
		if (this.orderNum == temp.getOrderNo()) {
			return 0;
		}
		else if (this.orderNum > temp.getOrderNo()) {
			return 1;
		}
		else {
			return -1;
		}
		
	}
	
	
	//String representation of the order, Includes order number, time , day, customer name and age and the list of beverages

	public String toString() {
		String beverages = "";
		
		for (Beverage i: beverageList) {
			beverages += i.getBevName() + "/n";
		}
		
		return "PLace Holder For Order Num, " + this.orderTime + ", " + this.orderDay +  ", " + this.customer.getName() + ", " + this.customer.getAge() + ", List of Beverages: \n" + beverages; 
	}

}
