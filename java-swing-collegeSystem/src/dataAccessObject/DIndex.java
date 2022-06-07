package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import model.MIndex;
import valueObject.OIndex;

public class DIndex {

	private static final String PATHNAME = "lecturedata/";

	private MIndex mIndex;
	
	public DIndex() {

	}

	public Vector<OIndex> readAll(String fileName) {
		Vector<OIndex> indices = new Vector<OIndex>();
		try {
			File file = new File(PATHNAME + fileName);
			Scanner scanner = new Scanner(file);

			this.mIndex = new MIndex();
			while (mIndex.read(scanner)) {
				OIndex oIndex = new OIndex();
				oIndex.set(mIndex);
				indices.add(oIndex);
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return indices;
	}
}
