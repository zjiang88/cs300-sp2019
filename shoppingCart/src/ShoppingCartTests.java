//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:     ShoppingCart   
// Files:     ShoppingCart      
// Course:    CS300,Spring 2019    
//
// Author:    Ziyan Jiang      
// Email:     zjiang88@wisc.edu
// Lecturer's Name: Gary
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:   Chengbin Liu
// Partner Email:   cliu557@wisc.edu
// Partner Lecturer's Name: Gary
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X___ Write-up states that pair programming is allowed for this assignment.
//   X___ We have both read and understand the course Pair Programming Policy.
//   X___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
// JavaDoc class Header comes here
public class ShoppingCartTests {

	/**
	 * Checks whether the total number of items within the cart is incremented after adding one item 
	 * @return true if the test passes without problems, false otherwise
	 */
	public static boolean testCountIncrementedAfterAddingOnlyOneItem() {
		boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
		// false otherwise
		String[] cart = new String[20]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// Add an item to the cart
		count = ShoppingCart.add(3, cart, count); // add an item of index 3 to the cart
		// Check that count was incremented
		if (count != 1) {
			System.out.println("Problem detected: After adding only one item to the cart, "
					+ "the cart count should be incremented. But, it was not the case.");
			testPassed = false;
		}
		return testPassed;
	}

	/**
	 * Checks whether add and OccurrencesOf return the correct output when only one item is added to
	 * the cart
	 * 
	 * @return true if test passed without problems, false otherwise
	 */
	public static boolean testAddAndOccurrencesOfForOnlyOneItem() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// check that OccurrencesOf returns 0 when called with an empty cart
		if (ShoppingCart.occurrencesOf(10, cart, count) != 0) {
			System.out.println("Problem detected: Tried calling OccurrencesOf() method when the cart is "
					+ "empty. The result should be 0. But, it was not.");
			testPassed = false;
		}

		// add one item to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart

		// check that OccurrencesOf("Apples", cart, count) returns 1 after adding the item with key 0
		if (ShoppingCart.occurrencesOf(0, cart, count) != 1) {
			System.out.println("Problem detected: After adding only one item with key 0 to the cart, "
					+ "OccurrencesOf to count how many of that item the cart contains should return 1. "
					+ "But, it was not the case.");
			testPassed = false;
		}
		return testPassed;
	}
	//Checks that items can be added more than one time and are found
	public static boolean testAddOccurrencesOfDuplicateItems() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		// add three item to the cart
		count = ShoppingCart.add(0, cart, count); // add an item of index 0 to the cart
		count = ShoppingCart.add(0, cart, count);
		count = ShoppingCart.add(0, cart, count);
		
		// check that OccurrencesOf("Apples", cart, count) returns 3 after adding the item with key 0
		if (ShoppingCart.occurrencesOf(0, cart, count) != 3) {
			System.out.println("Problem detected: After adding three item with key 0 to the cart, "
					+ "OccurrencesOf to count how many of that item the cart contains should return 3. "
					+ "But, it was not the case.");
			testPassed = false;
		}
		return testPassed;
		
	}

	// Checks that the correct output is returned when the user tries to add too much items to the cart
	// exceeding its capacity
	public static boolean testAddingTooMuchItems() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)

		for (int i = 0; i < cart.length; i++) {
			count = ShoppingCart.add(0, cart, count);
		}
		count = ShoppingCart.add(3, cart, count);
		if (count != 10) {
			System.out.println("Problem detected");
			testPassed = false;
		}
		return testPassed;
		
	}
	// Checks that when only one attempt to remove an item present in the cart is made, only one occurrence of 
	// that item is removed from the cart
	public static boolean testRemoveOnlyOneOccurrenceOfItem() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)
		
		count = ShoppingCart.add(0, cart, count);
		count = ShoppingCart.add(0, cart, count);
		count = ShoppingCart.remove("Apple", cart, count);
		if (count != 1) {
			System.out.println("Problem detected");
			testPassed = false;
		}
		return testPassed;
	}
	 
	// Checks that remove returns false when the user tries to remove an item not present within the cart
	public static boolean testRemoveItemNotFoundInCart() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)
		count = ShoppingCart.add(3, cart, count);
		count = ShoppingCart.add(3, cart, count);
		count = ShoppingCart.remove("Apple", cart, count);
		if (count != 2) {
			System.out.println("Problem detected");
			testPassed = false;
		}
		return testPassed;
	}
	public static void testgetSubTotalPrice() {
		boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
		// define the shopping cart as an oversize array of elements of type String
		// we can set an arbitrary capacity for the cart - for instance 10
		String[] cart = new String[10]; // shopping cart
		int count = 0; // number of items present in the cart (initially the cart is empty)
		count = ShoppingCart.add(3, cart, count);
		count = ShoppingCart.add(3, cart, count);
		count = ShoppingCart.add(5, cart, count);
		System.out.println(ShoppingCart.getSubTotalPrice(cart, count));
		ShoppingCart.printMarketCatalog();
		ShoppingCart.displayCartContent(cart, count);
	}
	/**
	 * main method used to call the unit tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("testCountIncrementedAfterAddingOnlyOneItem(): "
				+ testCountIncrementedAfterAddingOnlyOneItem());
		System.out.println(
				"testAddAndOccurrencesOfForOnlyOneItem(): " + testAddAndOccurrencesOfForOnlyOneItem());
		System.out.println("testAddOccurrencesOfDuplicateItems(): " + testAddOccurrencesOfDuplicateItems());
		System.out.println("testAddingTooMuchItems(): " + testAddingTooMuchItems());
		System.out.println("testRemoveOnlyOneOccurrenceOfItem(): " + testRemoveOnlyOneOccurrenceOfItem());
		System.out.println("testRemoveItemNotFoundInCart(): " + testRemoveItemNotFoundInCart());
		testgetSubTotalPrice();
	}
}