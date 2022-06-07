package model;

import java.util.Scanner;

public class MLecture {

	// setter getter사용 , public 사용 x
	private String id;
	private String name;
	private String professor;
	private String credit;
	private String time;
	
	public MLecture() {

	}

	public boolean read(Scanner scanner) {

		while (scanner.hasNext()) {
			String line =scanner.nextLine();
			String[] data = line.split("\\s");
				
			this.id = data[0];
			this.name = data[1];
			this.professor = data[2];
			this.credit = data[3];
			this.time = data[4];

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

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}
