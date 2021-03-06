package com.eakjb.experimental.statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NDObject extends HashMap<NDDimension,Double> {
	private static final long serialVersionUID = 5352876702072155067L;
	
	private String name;
	private Map<NDDimension,Double> properties;
	
	public NDObject(String name) {
		this.name=name;
	}
	
	public double getWeightedProperty(NDDimension d) {
		return d.getWeight()*this.get(d);
	}
	
	public Set<NDDimension> getDimensions() {
		return this.properties.keySet();
	}
	
	public boolean canCompare(NDObject other) {
		return this.keySet().equals(other.keySet());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append(this.getName());
		b.append(" [");
		for (NDDimension d : this.keySet()) {
			b.append(d.getName());
			b.append(":");
			b.append(this.get(d));
			b.append(",");
		}
		b.append("]");
		return b.toString();
	}
}
