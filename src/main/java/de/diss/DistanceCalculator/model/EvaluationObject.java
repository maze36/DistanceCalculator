package de.diss.DistanceCalculator.model;

public class EvaluationObject {

	private String identifier;

	private double average;

	private double min;

	private double max;

	private double median;

	public EvaluationObject(String identifier, double average, double min, double max, double median) {
		super();
		this.identifier = identifier;
		this.average = average;
		this.min = min;
		this.max = max;
		this.median = median;
	}

	public String getIdentifier() {
		return identifier;
	}

	public double getAverage() {
		return average;
	}

	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public double getMedian() {
		return median;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public void setMedian(double median) {
		this.median = median;
	}

}
