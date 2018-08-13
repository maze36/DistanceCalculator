package de.diss.DistanceCalculator.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import de.diss.DistanceCalculator.model.EvaluationObject;

public class CSVWriter {

	public static void writeHistoricTrack(ArrayList<EvaluationObject> evalObjs) {
		System.out.println("Writing evaluation objects ");

		try {
			PrintWriter pw = new PrintWriter(new File("evaluation.csv"));

			StringBuilder sb = new StringBuilder();
			sb.append("id");
			sb.append(',');
			sb.append("average");
			sb.append(',');
			sb.append("min");
			sb.append(',');
			sb.append("max");
			sb.append(',');
			sb.append("median");
			sb.append('\n');

			for (EvaluationObject obj : evalObjs) {
				sb.append(obj.getIdentifier());
				sb.append(',');
				sb.append(obj.getAverage());
				sb.append(',');
				sb.append(obj.getMin());
				sb.append(',');
				sb.append(obj.getMax());
				sb.append(',');
				sb.append(obj.getMedian());
				sb.append('\n');
			}

			pw.write(sb.toString());
			pw.close();
			System.out.println("Finished writing ");
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}

}
