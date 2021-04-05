public class Category {
	private String categoryTitle;
	private int numberOfProducts;

	public Category(String title, int number) {
		this.categoryTitle = title;
		this.numberOfProducts = number;
	}

	@Override
	public String toString() {
		return "\n{ Category Title : " + categoryTitle
				+ ", Number of Products " + numberOfProducts + "}\n";
	}
}
