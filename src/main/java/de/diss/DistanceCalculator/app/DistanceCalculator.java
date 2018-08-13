package de.diss.DistanceCalculator.app;

import java.util.ArrayList;

import de.diss.DistanceCalculator.controller.Calculator;
import de.diss.DistanceCalculator.input.CSVReader;
import de.diss.DistanceCalculator.model.EvaluationObject;
import de.diss.DistanceCalculator.model.HistoricTrack;
import de.diss.DistanceCalculator.model.Prediction;
import de.diss.DistanceCalculator.output.CSVWriter;

public class DistanceCalculator {

	public static void main(String[] args) {
		System.out.println("Starting app...");
		System.out.println("Reading historic tracks...");
		ArrayList<HistoricTrack> historicTracks = CSVReader.readHistoricTracks("historicTracks");

		System.out.println("Reading predicted tracks...");
		ArrayList<Prediction> predictedTracks = CSVReader.readPrediction("predictedTracks");

		if (!historicTracks.isEmpty() && !predictedTracks.isEmpty()) {
			Calculator calculator = new Calculator();
			ArrayList<EvaluationObject> evaluationObjs = calculator.calculateDistances(predictedTracks, historicTracks);
			CSVWriter.writeHistoricTrack(evaluationObjs);
		}

	}

}
