package de.diss.DistanceCalculator.model;

import java.util.ArrayList;

import com.vividsolutions.jts.geom.Coordinate;

public class HistoricTrack {

	private String id;

	private ArrayList<Coordinate> trackPoints;

	public HistoricTrack(String id, ArrayList<Coordinate> trackPoints) {
		this.id = id;
		this.trackPoints = trackPoints;
	}

	public String getId() {
		return id;
	}

	public ArrayList<Coordinate> getTrackPoints() {
		return trackPoints;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTrackPoints(ArrayList<Coordinate> trackPoints) {
		this.trackPoints = trackPoints;
	}

}
