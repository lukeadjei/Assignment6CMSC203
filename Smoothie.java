
public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean addProtein;
	final static double PROTEIN_COST = 1.50;
	final static double FRUIT_COST = 0.50;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	public boolean getAddProtein() {
		return this.addProtein;
	}
	
	public int getNumOfFruits() {
		return this.numOfFruits;
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
		
		if (this.addProtein) {
			total += PROTEIN_COST;
		}
		
		total += this.numOfFruits * FRUIT_COST;
		
		return total;
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		if (anotherBev instanceof Smoothie) {
			Smoothie temp = (Smoothie)anotherBev;
			if(super.equals(anotherBev) && this.numOfFruits == temp.getNumOfFruits() && this.addProtein == temp.getAddProtein()) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return super.toString() + " AddProtein: " + this.getAddProtein() + " Number Of Fruits: " + this.getNumOfFruits() + this.calcPrice();
	}

}
