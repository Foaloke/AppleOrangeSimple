package com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy;

import java.math.BigDecimal;

public interface CalculationStrategy {
	BigDecimal calculatePrice(int productAmount, BigDecimal price);
}
