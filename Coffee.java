
public class Coffee extends Beverage{
	private boolean extraShot;
	private boolean extraSyrup;
	final static double extraShotCost = 0.50;
	final static double extraSyrupCost = 0.50;
	
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	public boolean getExtraShot() {
		return this.extraShot;
	}
	
	public boolean getExtraSyrup() {
		return this.extraSyrup;
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
		
		if (this.extraShot) {
			total += extraShotCost;
		}
		if(this.extraSyrup) {
			total += extraSyrupCost;
		}
		
		return total;
	}
	
	
	public String toString() {
		return super.toString() + "Extra Shot: " + this.extraShot + "," + "ExtraSyrup: " + this.extraSyrup + " " + this.calcPrice();
 	}
	
	@Override
	public boolean equals(Object anotherBev) {
		if (anotherBev instanceof Coffee) {
			Coffee temp = (Coffee)anotherBev;
			if(super.equals(anotherBev) && this.extraShot == temp.getExtraShot() && this.extraSyrup == temp.getExtraSyrup()) {
				return true;
			}
		}
		return false;
	}

}
