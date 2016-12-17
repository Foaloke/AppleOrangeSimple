package com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculationStrategy_ThreeForTwoTest {

	private CalculationStrategy_ThreeForTwo csThreeForTwo = new CalculationStrategy_ThreeForTwo();
	
	@Test
	public void correctCalculation (){
		assertThat(csThreeForTwo.calculatePrice(11, BigDecimal.valueOf(3)), equalTo(BigDecimal.valueOf(3*(6+2))));
		assertThat(csThreeForTwo.calculatePrice(12, BigDecimal.valueOf(3)), equalTo(BigDecimal.valueOf(3*8)));
	}
}
