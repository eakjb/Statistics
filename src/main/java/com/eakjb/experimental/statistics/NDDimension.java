package com.eakjb.experimental.statistics;

public class NDDimension {
	private final String name;
	private final double weight;
	
	public NDDimension(String name, double weight) {
		this.name=name;
		this.weight=weight;
	}
	
	public String getName() {
		return name;
	}
	public double getWeight() {
		return weight;
	}
}
