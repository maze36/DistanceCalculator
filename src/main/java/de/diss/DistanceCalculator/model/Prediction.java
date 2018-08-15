package de.diss.DistanceCalculator.model;

import java.util.ArrayList;

import com.vividsolutions.jts.geom.Coordinate;

public class Prediction {

	private String id;

	private ArrayList<Coordinate> predictedTrack;

	public Prediction(String id, ArrayList<Coordinate> predictedTrack) {
		this.setId(id);
		this.setPredictedTrack(predictedTrack);
	}

	public ArrayList<Coordinate> getPredictedTrack() {
		return predictedTrack;
	}

	public void setPredictedTrack(ArrayList<Coordinate> predictedTrack) {
		this.predictedTrack = predictedTrack;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
