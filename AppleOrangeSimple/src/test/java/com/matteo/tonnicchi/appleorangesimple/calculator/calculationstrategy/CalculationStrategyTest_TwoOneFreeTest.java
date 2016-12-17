package com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculationStrategyTest_TwoOneFreeTest {

	private CalculationStrategy_TwoOneFree csTwoOneFree = new CalculationStrategy_TwoOneFree();
	
	@Test
	public void correctCalculation (){
		assertThat(csTwoOneFree.calculatePrice(11, BigDecimal.valueOf(3)), equalTo(BigDecimal.valueOf(3*(5+1))));
		assertThat(csTwoOneFree.calculatePrice(12, BigDecimal.valueOf(3)), equalTo(BigDecimal.valueOf(3*6)));
	}
}
