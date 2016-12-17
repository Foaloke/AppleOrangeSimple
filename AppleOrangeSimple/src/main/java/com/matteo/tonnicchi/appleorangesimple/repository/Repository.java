package com.matteo.tonnicchi.appleorangesimple.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy.CalculationStrategyHelper.StrategyCode;
import com.matteo.tonnicchi.appleorangesimple.product.Product;

public final class Repository {
	
	private static List<Product> availableProducts;

	private Repository(){ }
	
	public static List<Product> getAvailableProducts(){
		if(availableProducts == null){
			initAvailableProducts();
		}
		return availableProducts;
	}

	private static void initAvailableProducts() {
		availableProducts = new ArrayList<>();
		availableProducts.add(
			new Product(
				"apple",
				"Apple",
				BigDecimal.valueOf(0.6),
				StrategyCode.TWOONEFREE));
		availableProducts.add(
			new Product(
				"orange",
				"Orange",
				BigDecimal.valueOf(0.25),
				StrategyCode.THREEFORTWO));
	}
}
