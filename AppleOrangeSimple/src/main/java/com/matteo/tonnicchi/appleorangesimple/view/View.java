package com.matteo.tonnicchi.appleorangesimple.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.matteo.tonnicchi.appleorangesimple.product.Product;

public final class View {
	public static final String WELCOME_MESSAGE = "Welcome!\n";
	public static final String EMPTY_CART_MESSAGE = "Your cart is empty.\n";
	public static final String CART_LIST_MESSAGE = "Your cart contains:\n%s\n";
	public static final String PRICE_MESSAGE = "(total to be paid: £%.2f)\n";
	public static final String INSTRUCTIONS_MESSAGE
		= "Type %s to add one of them to the cart.\n"
		+ "Type \"%s\" to empty the cart\n"
		+ "Type \"%s\" to exit\n\n";
	public static final String INVALID_COMMAND_MESSAGE = "The command [%s] is not valid.";

	private View() {
	}

	public static void welcome() {
		System.out.print(View.WELCOME_MESSAGE);
	}

	public static void showInstructions(
			String emptyCommand,
			String quitCommand,
			List<Product> products) {

		System.out.format(
			View.INSTRUCTIONS_MESSAGE,
			extractProductNames(products), emptyCommand, quitCommand);
	}

	public static void showCart(List<Product> cart) {
		if (cart.isEmpty()) {
			System.out.print(EMPTY_CART_MESSAGE);
		} else {
			System.out.format(
				View.CART_LIST_MESSAGE,
				String.join("\n", readCartProductNames(cart)));
		}
	}

	public static void showAmount(BigDecimal price) {
		System.out.format(PRICE_MESSAGE, price.doubleValue());
	}

	private static List<String> readCartProductNames(List<Product> cart) {
		return cart.stream().map(p -> "-- " + p.getName()).collect(Collectors.toList());
	}

	private static Object extractProductNames(List<Product> products) {
		return String.join(
				" or ",
				products
					.stream()
					.map(p -> "\"" + p.getName() + "\"")
					.collect(Collectors.toList()));
	}

	public static void showInvalidCommandMessage(String command) {
		System.out.format(INVALID_COMMAND_MESSAGE, command);
	}
}
