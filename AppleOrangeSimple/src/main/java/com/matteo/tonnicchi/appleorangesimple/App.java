package com.matteo.tonnicchi.appleorangesimple;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.matteo.tonnicchi.appleorangesimple.calculator.Calculator;
import com.matteo.tonnicchi.appleorangesimple.product.Product;
import com.matteo.tonnicchi.appleorangesimple.repository.Repository;
import com.matteo.tonnicchi.appleorangesimple.view.View;

/**
 * Hello world!
 *
 */
public class App {
	private static final Console console = System.console();

	private static List<Product> cart = new ArrayList<Product>();
	private static Calculator calculator = new Calculator();
	
	private static final String QUIT_COMMAND = "quit";
	private static final String EMPTY_COMMAND = "empty";

	public static void main( String[] args )
    {
		View.welcome();
		View.showInstructions(EMPTY_COMMAND, QUIT_COMMAND, Repository.getAvailableProducts());
        View.showCart(cart);
        
        String command;
        while( !(command = readLine()).equals(QUIT_COMMAND)){
        	execute(command.trim());
            View.showCart(cart);
            View.showAmount(calculator.calculatePrice(cart));
        }

        System.exit(0);
    }


	private static void execute(String command) {
		
		if(!command.isEmpty()){
			Optional<Product> correspondingProduct
				= Repository.getAvailableProducts()
					.stream()
					.filter(p -> p.getName().equals(command))
					.findFirst();
			if(correspondingProduct.isPresent()){
				cart.add(correspondingProduct.get());
			}else if(command.equals(EMPTY_COMMAND)){
				cart.clear();
			}else if(command.equals(QUIT_COMMAND)){
				System.exit(0);
			}else{
	            View.showInvalidCommandMessage(command);
			}
		}
		
	}


	private static String readLine() {
		try {
			if (console != null) {
				return console.readLine("> ");
			} else {
				throw new IllegalStateException("Can not read from terminal");
			}
		} catch (Exception e) {
			throw new IllegalStateException("Can not read from terminal", e);
		}
	}
}
