import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	private int numAlcoholicDrinks = 0;
	private ArrayList<Order> orderList = new ArrayList<>();
	
	public BevShop() {
		
	}
	
	@Override
	public boolean isValidTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		return false;
	}

	@Override
	public int getMaxNumOfFruits() {
		
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return 21;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits >= MAX_FRUIT) {
			return true;
		}
		return false;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		// TODO Auto-generated method stub
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if (numAlcoholicDrinks >= 3) {
			return false;
		}
		return true;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return this.numAlcoholicDrinks;
	}

	@Override
	public boolean isValidAge(int age) {
		// TODO Auto-generated method stub
		if (age >= 21) {
			return true;
		}
		return false;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orderList.add(new Order(time, day, new Customer(customerName, customerAge)));
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		// TODO Auto-generated method stub
		for (Order i: orderList) {
			i.addNewBeverage(bevName, size, extraShot, extraSyrup);
		}
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		for (Order i: orderList) {
			i.addNewBeverage(bevName, size);
		}
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		for (Order i: orderList) {
			i.addNewBeverage(bevName, size, numOfFruits, addProtein);
		}
	}

	@Override
	public int findOrder(int orderNo) {
		// TODO Auto-generated method stub
		
		for(int i = 0 ; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		
		return -1;
		
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderNo() == orderNo) {
				return orderList.get(i).calcOrderTotal();
			}
		}
		return 0;
	}

	@Override
	public double totalMonthlySale() {
		double total = 0.0;
		for(int i = 0 ; i < orderList.size(); i++) {
			total += orderList.get(i).calcOrderTotal();
		}
		return total;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		// TODO Auto-generated method stub
		return orderList.size();
	}

	@Override
	public Order getCurrentOrder() {
		// TODO Auto-generated method stub
		return orderList.getFirst();
	}

	@Override
	public Order getOrderAtIndex(int index) {
		if(orderList.get(index) != null) {
			return orderList.get(index);
		}
		return null;
	}

	@Override
	public void sortOrders() {
	    for (int i = 0; i < orderList.size() - 1; i++) {
	        int minIndex = i;
	        for (int j = i + 1; j < orderList.size(); j++) {
	            if (orderList.get(j).getOrderNo() < orderList.get(minIndex).getOrderNo()) {
	                minIndex = j;
	            }
	        }
	        // Swap elements
	        Order temp = orderList.get(i);
	        orderList.set(i, orderList.get(minIndex));
	        orderList.set(minIndex, temp);
	    }
	}

}
