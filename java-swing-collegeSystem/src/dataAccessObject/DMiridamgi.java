package dataAccessObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

import constants.Constants.EDAO;
import valueObject.OLecture;
import windowsView.VMainFrame;

public class DMiridamgi {

	private Scanner scanner;
	private BufferedReader br;
	private FileWriter fileWriter;

	private VMainFrame mf;
	
	public DMiridamgi() {

	}

	private static final String PATHNAME = "userdata/";

	public void add(String user, OLecture oLecture) {

		try {
			// 중복 방지
			fileWriter = new FileWriter(new File(PATHNAME + user + EDAO.eMiriPath.getText()), true);

			scanner = new Scanner(new File(PATHNAME + user + EDAO.eMiriPath.getText()));
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (line.indexOf(oLecture.getId()) == 0) {
					System.out.println(EDAO.eRepeatErr.getText());
//					if (this.mf != null) {
						JOptionPane.showConfirmDialog(this.mf, "중복으로 담을 수 없습니다.", "중복 방지", JOptionPane.OK_CANCEL_OPTION);
//					}
					return;
				}
			}
			// user별 파일 저장
			fileWriter.write(oLecture.getId() + " " + oLecture.getName() + " " + oLecture.getProfessor() + " "
					+ oLecture.getCredit() + " " + oLecture.getTime());
			fileWriter.write("\n");
			fileWriter.close();
			System.out.println(oLecture.getId() + EDAO.eMiriAdd.getText());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void show(String user) {
		try {
			scanner = new Scanner(new File(PATHNAME + user + EDAO.eMiriPath.getText()));
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(String user, String key) {
		try {
			br = new BufferedReader(new FileReader(new File(PATHNAME + user + EDAO.eMiriPath.getText())));
			Vector<String> lines = new Vector<>();
			String line = "";
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();

			for (int i = 0; i < lines.size(); i++) {
				String[] data = new String[5];
				data = lines.get(i).split("\\s");

				if (data[0].equals(key)) {
					lines.remove(i);
					System.out.println(data[0] + EDAO.eMiriDel.getText());
				}
				fileWriter = new FileWriter(new File(PATHNAME + user + EDAO.eMiriPath.getText()));
				for (int j = 0; j < lines.size(); j++) {
					fileWriter.write(lines.get(j));
					fileWriter.write("\n");
				}
				fileWriter.close();

			}
			System.out.println(EDAO.eMiriShow.getText());
			this.show(user);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String find(String user, int row) {
		try {
			br = new BufferedReader(new FileReader(new File(PATHNAME + user + EDAO.eMiriPath.getText())));
			Vector<String> lines = new Vector<>();
			String line = "";
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
			line =lines.get(row);
			String[] data = new String[5];
			data = line.split("\\s");
			return data[0];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";
			
	}

	public Vector<String> miridamgi(String fileName) {
		try {
			br = new BufferedReader(new FileReader(new File(PATHNAME + fileName)));
			Vector<String> lines = new Vector<>();
			String line = "";
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
			return lines;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
