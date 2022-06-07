package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MLecture;
import valueObject.OLecture;

public class DLecture {

	private static final String PATHNAME = "lecturedata/";

	private MLecture MLecture;
	
	public DLecture() {

	}

	public Vector<OLecture> readAll(String fileName) {
		Vector<OLecture> lectures = new Vector<OLecture>();
		try {
			File file = new File(PATHNAME + fileName);
			Scanner scanner = new Scanner(file);

			this.MLecture = new MLecture();
			while (MLecture.read(scanner)) {
				OLecture oLecture = new OLecture();
				oLecture.set(MLecture);
				lectures.add(oLecture);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return lectures;
	}
}
