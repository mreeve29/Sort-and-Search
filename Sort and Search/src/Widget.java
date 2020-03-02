
public class Widget implements Comparable<Widget>{

	private int productNumber;
	private int numberSold;
	
	public Widget(int productNumber, int numberSold) {
		this.productNumber = productNumber;
		this.numberSold = numberSold;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(int productNumber) {
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

}
