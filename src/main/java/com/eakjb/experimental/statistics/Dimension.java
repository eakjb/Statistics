package com.eakjb.experimental.statistics;

public class Dimension {
	private final String name;
	private final double weight;
	
	public Dimension(String name, double weight) {
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
