package com.eakjb.experimental.statistics;

public class NDInstance extends NDObject  implements Comparable<NDInstance> {
	private static final long serialVersionUID = -5504472211508480634L;
	
	private NDObject architype;
	
	public NDInstance(String name, NDObject architype) {
		super(name);
		this.setArchitype(architype);
	}

	public int compareTo(NDInstance o) {
		if (!this.canCompare(o)) throw new IllegalArgumentException("Objects must be comarable!");
		double delta = 0;
		for (NDDimension d : this.keySet()) {
			delta+=Math.round(Math.abs((this.getWeightedProperty(d)
					-this.getArchitype().getWeightedProperty(d)))-Math.abs((o.getWeightedProperty(d)
					-this.getArchitype().getWeightedProperty(d))));
			//System.out.println(d.getName()+">"+this.getWeightedProperty(d)+", "+(this.getWeightedProperty(d)
			//		-this.getArchitype().getWeightedProperty(d)));
		}
		return (int) Math.round(delta);
	}

	public NDObject getArchitype() {
		return architype;
	}

	public void setArchitype(NDObject architype) {
		this.architype = architype;
	}

}
