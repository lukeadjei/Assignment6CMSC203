

public abstract class Beverage {
	
	private String name;
	private Type type;
	private Size size;
	final static double BASE_PRICE = 2.0;
	final static double SIZE_PRICE = 0.5;
	
	public Beverage(String bevName, Type type, Size size) {
		this.name = bevName;
		this.type = type;
		this.size = size;
	}
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	public Type getType() {
		return type;
	}
	public String getBevName() {
		return name;
	}
	public Size getSize() {
		return size;
	}
	
	@Override
	public boolean equals(Object obj) {
		Beverage temp = (Beverage)obj;
		if (this.name == temp.getBevName() && this.type == temp.getType() && this.size == temp.getSize()) {
			return true;
		}
		return false;
		
	}
	
	
	public abstract double calcPrice();
	
	public double addSizePrice() {

		return BASE_PRICE + SIZE_PRICE;
	}
	
	public String toString() {
		return this.name +"," + this.size;
	}
}



