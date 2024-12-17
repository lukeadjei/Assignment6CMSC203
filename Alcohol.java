
public class Alcohol extends Beverage {
	private boolean isWeekend;
	final static double WEEKEND_COST = 0.60;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	public boolean getIsWeekend() {
		return this.isWeekend;
	}

	@Override
	public boolean equals(Object anotherBev) {
		if (anotherBev instanceof Alcohol) {
			Alcohol temp = (Alcohol)anotherBev;
			if(super.equals(anotherBev) && this.isWeekend == temp.getIsWeekend()){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public double calcPrice() {
		double total = BASE_PRICE;
		
		if (this.getSize() == Size.LARGE) {
			total += 2*this.addSizePrice();
		}
		else if(this.getSize() == Size.MEDIUM) {
			total += this.addSizePrice();
		}
		
		if (this.isWeekend) {
			total += WEEKEND_COST;
		}
		
		
		return total;
	}
	
	public String toString() {
		return super.toString() + " Offered during the weekend: " + this.getIsWeekend() + " Price: ";
	}
}
