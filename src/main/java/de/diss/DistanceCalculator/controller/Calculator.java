package de.diss.DistanceCalculator.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.geom.Point;

import de.diss.DistanceCalculator.model.EvaluationObject;
import de.diss.DistanceCalculator.model.HistoricTrack;
import de.diss.DistanceCalculator.model.Prediction;

public class Calculator {

	private GeometryFactory geoFactory;

	public Calculator() {
		this.geoFactory = new GeometryFactory();
	}

	public ArrayList<EvaluationObject> calculateDistances(ArrayList<Prediction> predictions,
			ArrayList<HistoricTrack> historicTracks) {

		ArrayList<EvaluationObject> evalObjs = new ArrayList<EvaluationObject>();

		for (HistoricTrack historicTrack : historicTracks) {

			Coordinate[] histArray = new Coordinate[historicTrack.getTrackPoints().size()];

			for (int i = 0; i < histArray.length; i++) {
				histArray[i] = historicTrack.getTrackPoints().get(i);
			}

			LineString lineString = geoFactory.createLineString(histArray);

			ArrayList<Double> distances = calculateDistances(lineString, historicTracks.get(0));

			Collections.sort(distances);

			double median = findMedian(distances);
			double average = calculateAverage(distances);
			double max = Collections.max(distances);
			double min = Collections.min(distances);

			evalObjs.add(new EvaluationObject(historicTrack.getId(), average, min, max, median));

		}

		return evalObjs;
	}

	private double calculateAverage(ArrayList<Double> distances) {
		double sum = 0;
		for (Double distance : distances) {
			sum = sum + distance;
		}

		return sum / distances.size();
	}

	private double findMedian(ArrayList<Double> distances) {
		double median;
		if (distances.size() % 2 == 0)
			median = ((double) distances.get(distances.size() / 2)
					+ (double) distances.get((distances.size() / 2 - 1) / 2));
		else
			median = (double) distances.get(distances.size() / 2);
		return median;
	}

	private ArrayList<Double> calculateDistances(LineString lineString, HistoricTrack historicTrack) {
		ArrayList<Double> distances = new ArrayList<Double>();

		for (Coordinate coord : historicTrack.getTrackPoints()) {
			Point p = geoFactory.createPoint(coord);
			double distance = p.distance(lineString);
			distance = Math.toRadians(distance) * 3440.065;
			distances.add(distance);
		}

		return distances;
	}
}
