package com.matteo.tonnicchi.appleorangesimple.calculator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy.CalculationStrategyHelper;
import com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy.CalculationStrategyHelper.StrategyCode;
import com.matteo.tonnicchi.appleorangesimple.product.Product;

public class Calculator {

	public BigDecimal calculatePrice(List<Product> products) {
		return countProducts(products).stream()
				.map(this::calculatePriceAccordingToStrategy)
				.reduce((priceOne, priceTwo) -> priceOne.add(priceTwo))
				.orElse(BigDecimal.valueOf(0));
	}

	private BigDecimal calculatePriceAccordingToStrategy(Entry<Product, Long> entry){
		Product product = entry.getKey();
		int amount = entry.getValue().intValue();
		StrategyCode strategyCode = entry.getKey().getStrategyCode();
		return CalculationStrategyHelper.strategyFromCode(strategyCode).calculatePrice(amount, product.getPrice());
	}

	private Set<Entry<Product, Long>> countProducts(List<Product> products) {
		return products
				.stream()
				.collect(asProductCounts())
				.entrySet();
	}

	private Collector<Product, ?, Map<Product, Long>> asProductCounts(){
		return Collectors.groupingBy(Function.identity(), Collectors.counting());
	}

}
