package com.matteo.tonnicchi.appleorangesimple.product;

import java.math.BigDecimal;

import com.matteo.tonnicchi.appleorangesimple.calculator.calculationstrategy.CalculationStrategyHelper.StrategyCode;

public class Product {

	private Long id;

	private String name;

	private String code;

	private BigDecimal price;
	
	private StrategyCode strategyCode;

	public Product(String code, String name, BigDecimal price, StrategyCode strategyCode) {
		super();
		this.name = name;
		this.code = code;
		this.price = price;
		this.strategyCode = strategyCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public StrategyCode getStrategyCode() {
		return strategyCode;
	}

	public void setStrategyCode(StrategyCode strategyCode) {
		this.strategyCode = strategyCode;
	}

}
