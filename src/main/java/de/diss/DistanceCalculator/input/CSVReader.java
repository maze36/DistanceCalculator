package de.diss.DistanceCalculator.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.vividsolutions.jts.geom.Coordinate;

import de.diss.DistanceCalculator.model.HistoricTrack;
import de.diss.DistanceCalculator.model.Prediction;

public class CSVReader {
	private static String LINE = "";

	private final static String SPLITTER = ",";

	public static ArrayList<Prediction> readPrediction(String directory) {

		File[] files = getFilesInDirectory(directory);

		ArrayList<Prediction> predictionList = new ArrayList<Prediction>();

		int id = 0;

		for (File file : files) {
			String location = file.getPath();
			ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();

			try {
				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(location));
				while ((LINE = reader.readLine()) != null) {
					String[] predTrackLine = LINE.split(SPLITTER);
					if (!predTrackLine[0].contains("lat")) {
						coordinates.add(
								new Coordinate(Double.valueOf(predTrackLine[0]), Double.valueOf(predTrackLine[1])));
					}
				}
				String filename = file.getPath().substring(16, file.getPath().length() - 4);
				predictionList.add(new Prediction(filename, coordinates));
				id++;
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		return predictionList;
	}

	public static ArrayList<HistoricTrack> readHistoricTracks(String directory) {
		File[] files = getFilesInDirectory(directory);

		ArrayList<HistoricTrack> historicTrackList = new ArrayList<HistoricTrack>();

		for (File file : files) {
			String location = file.getPath();
			ArrayList<Coordinate> coordinates = new ArrayList<Coordinate>();

			try {
				@SuppressWarnings("resource")
				BufferedReader reader = new BufferedReader(new FileReader(location));
				while ((LINE = reader.readLine()) != null) {
					String[] predTrackLine = LINE.split(SPLITTER);
					if (!predTrackLine[0].contains("mmsi")) {
						coordinates.add(
								new Coordinate(Double.valueOf(predTrackLine[4]), Double.valueOf(predTrackLine[5])));
					}
				}
				String id = file.getPath().substring(15, file.getPath().length() - 4);
				historicTrackList.add(new HistoricTrack(id, coordinates));
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		return historicTrackList;
	}

	/**
	 * Returns all files in the given directory.
	 * 
	 * @param directory
	 * @return
	 */
	private static File[] getFilesInDirectory(String directory) {
		File folder = new File(directory);
		File[] result = folder.listFiles();
		return result;
	}
}
