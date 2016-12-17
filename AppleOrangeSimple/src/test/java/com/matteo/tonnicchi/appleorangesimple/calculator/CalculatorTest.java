package com.matteo.tonnicchi.appleorangesimple.calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy.CalculationStrategyHelper.StrategyCode;
import com.matteo.tonnicchi.appleorangesimple.product.Product;

public class CalculatorTest {

	private static final String APPLE_CODE = "apple";
	private static final String APPLE_NAME = "Apple";
	private static final BigDecimal APPLE_PRICE = BigDecimal.valueOf(5);
	private static final StrategyCode APPLE_STRATEGY = StrategyCode.SUM;

	private static final String ORANGE_CODE = "orange";
	private static final String ORANGE_NAME = "Orange";
	private static final BigDecimal ORANGE_PRICE = BigDecimal.valueOf(7);
	private static final StrategyCode ORANGE_STRATEGY = StrategyCode.SUM;
	
	private static final Product APPLE_MOCK = new Product(APPLE_CODE, APPLE_NAME, APPLE_PRICE, APPLE_STRATEGY);
	private static final Product ORANGE_MOCK = new Product(ORANGE_CODE, ORANGE_NAME, ORANGE_PRICE, ORANGE_STRATEGY);

	private Calculator calculator = new Calculator();
	
	@Test
	public void shouldCalculatePrice(){
		// arrange
		List<Product> products = new ArrayList<>();
		products.add(APPLE_MOCK);
		products.add(APPLE_MOCK);
		products.add(APPLE_MOCK);
		products.add(ORANGE_MOCK);
		products.add(ORANGE_MOCK);
		// act
		BigDecimal total = calculator.calculatePrice(products);
		// assert
		BigDecimal applesPrice = APPLE_PRICE.multiply(BigDecimal.valueOf(3));
		BigDecimal orangesPrice = ORANGE_PRICE.multiply(BigDecimal.valueOf(2));
		assertThat(total, equalTo(applesPrice.add(orangesPrice)));
	}
	
}
