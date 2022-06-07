package model;

import java.util.Scanner;

public class MIndex {

	// setter getter사용 , public 사용 x
	private String id;
	private String name;
	private String fileName;
	

	public MIndex() {

	}

	public boolean read(Scanner scanner) {

		while (scanner.hasNext()) {
			String line =scanner.nextLine();
			String[] data = line.split("\\s");
				
			this.id = data[0];
			this.name = data[1];
			this.fileName = data[2];


			return true;
		}
		return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
