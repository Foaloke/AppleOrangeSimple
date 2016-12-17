package com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class CalculationStrategy_SumTest {

	private CalculationStrategy_Sum csSum = new CalculationStrategy_Sum();
	
	@Test
	public void correctCalculation (){
		assertThat(csSum.calculatePrice(12, BigDecimal.valueOf(3)), equalTo(BigDecimal.valueOf(3*12)));
	}
}
