package de.diss.DistanceCalculator.model;

import java.util.ArrayList;

import com.vividsolutions.jts.geom.Coordinate;

public class Prediction {

	private int id;

	private ArrayList<Coordinate> predictedTrack;

	public Prediction(int id, ArrayList<Coordinate> predictedTrack) {
		this.setId(id);
		this.setPredictedTrack(predictedTrack);
	}

	public ArrayList<Coordinate> getPredictedTrack() {
		return predictedTrack;
	}

	public void setPredictedTrack(ArrayList<Coordinate> predictedTrack) {
		this.predictedTrack = predictedTrack;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
