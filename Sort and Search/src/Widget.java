
public class Widget implements Comparable<Widget>{

	private String productNumber;
	private int numberSold;
	
	public Widget(String productNumber, int numberSold) {
		this.productNumber = productNumber;
		this.numberSold = numberSold;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public int getNumberSold() {
		return numberSold;
	}

	public void setNumberSold(int numberSold) {
		this.numberSold = numberSold;
	}

	@Override
	public int compareTo(Widget o) {
		return getNumberSold() - o.getNumberSold();
	}

	public String toString() {
		return "" + productNumber + " - " + numberSold + " unit sold";
	}
	
}
