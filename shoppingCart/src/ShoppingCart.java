public class ShoppingCart{
	// Define final parameters
	private static final int CART_CAPACITY = 20; // shopping cart max capacity
	private static final double TAX_RATE = 0.05; // sales tax

	// a perfect-size two-dimensional array that stores the available items in the market
	// MARKET_ITEMS[i][0] refers to a String that represents the description of the item
	//                   identified by index i
	// MARKET_ITEMS[i][1] refers to a String that represents the unit price of the item
	//                   identified by index i in dollars.
	public static final String[][] MARKET_ITEMS = new String[][] {{"Apple", "$1.59"},
		{"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
		{"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
		{"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
		{"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
		{"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
		{"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};
		// adds the item with the given its identifier (index) at the end of the cart
		public static int add(int index, String[] cart, int count) {
			if(cart[cart.length-1]!=null) {
				System.out.println("WARNING: The cart is full. You cannot add any new item.");
				return count;
			}
			cart[count]=MARKET_ITEMS[index][0];
			return count + 1;
		}

		// Returns how many occurrences of the item with index itemIndex are present in the shopping cart
		public static int occurrencesOf(int itemIndex, String[] cart, int count) {
			int numOfItem = 0;
			for (int i = 0; i < count; i++) {
				if (cart[i].equals(MARKET_ITEMS[itemIndex][0])) {
					numOfItem++;
				}
			}
			return numOfItem;
		}

		// Removes the first (only one) occurrence of itemToRemove if found and returns the number of 
		// items in the cart after remove operation is completed either successfully or not
		public static int remove(String itemToRemove, String[] cart, int count) {
			if (count == 0) {
				System.out.println("cart empty");
				return count;
			}
			if(indexOf(itemToRemove, cart, count) == -1) {
				System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");
				return count;
			}
			cart[indexOf(itemToRemove, cart, count)] = cart[count - 1];
			cart[count-1] = null;
			count--;
			return count;
		}
		/**
		   * Returns the index of an item within the shopping cart
		   * 
		   * @param item description
		   * @param cart Shopping cart
		   * @param count number of items present in the shopping cart
		   * @return index of the item within the shopping cart, and -1 if the item does not exist in the
		   *         cart
		   */
		  private static int indexOf(String item, String[] cart, int count) {
			  for (int i = 0; i < count; i++) {
				  if (cart[i].equals(item)) {
					  return i;
				  }
			  }
			  return -1;
		  }
		// returns the total value (cost) of the cart without tax in $ (double)
		public static double getSubTotalPrice(String[] cart, int count) {}

		// prints the Market Catalog (item identifiers, description, and unit prices)
		public static void printMarketCatalog() {}

		// Displays the cart content (items separated by commas)
		public static void displayCartContent(String[] cart, int count) {}
}