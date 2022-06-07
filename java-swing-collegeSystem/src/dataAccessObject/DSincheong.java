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

public class DSincheong {

	private Scanner scanner;
	private BufferedReader br;
	private FileWriter fileWriter;
	private VMainFrame mf;

	public DSincheong() {
	}

	private static final String PATHNAME = "userdata/";

	public void add(String user, String key) {
		try {
			fileWriter = new FileWriter(new File(PATHNAME + user + EDAO.eSugangPath.getText()), true);
			// 중복 방지
			scanner = new Scanner(new File(PATHNAME + user + EDAO.eSugangPath.getText()));
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (line.indexOf(key) == 0) {
					System.out.println(EDAO.eReapeatSinchoeng.getText());
//					if (this.mf != null) {
						JOptionPane.showConfirmDialog(this.mf, "중복으로 담을 수 없습니다.", "중복 방지",
								JOptionPane.OK_CANCEL_OPTION);
//					}
					return;
				}

			}

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
				// 18학점 이상 금지
				if (data[0].equals(key)) {
					if (this.credit(user) + Integer.parseInt(data[3]) > 18) {
						System.out.println("수강 제한 학점은 18학점입니다. 더이상 수강할 수 없습니다.");
//						if (this.mf != null) {
							JOptionPane.showConfirmDialog(this.mf, "수강 제한 학점은 18학점입니다", "학점 제한",
									JOptionPane.OK_CANCEL_OPTION);
//						}
						return;
					}
					fileWriter.write(lines.get(i));
					fileWriter.write("\n");
					fileWriter.close();

					lines.remove(i);
					fileWriter = new FileWriter(new File(PATHNAME + user + EDAO.eMiriPath.getText()));
					for (int j = 0; j < lines.size(); j++) {
						fileWriter.write(lines.get(j));
						fileWriter.write("\n");
					}
					fileWriter.close();

					// 현재 수강 학점 표시 기능 추가!

					System.out.println(EDAO.eSugangAdd.getText() + " 총 " + this.credit(user) + "학점");

				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void show(String user) {
		try {
			scanner = new Scanner(new File(PATHNAME + user + EDAO.eSugangPath.getText()));
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
			br = new BufferedReader(new FileReader(new File(PATHNAME + user + EDAO.eSugangPath.getText())));
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
					System.out.println(data[0] + EDAO.eSugangDel.getText());
				}
				fileWriter = new FileWriter(new File(PATHNAME + user + EDAO.eSugangPath.getText()));
				for (int j = 0; j < lines.size(); j++) {
					fileWriter.write(lines.get(j));
					fileWriter.write("\n");
				}
				fileWriter.close();

			}
			System.out.println(EDAO.eSugangShow.getText());
			this.show(user);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String find(String user, int row) {
		try {
			br = new BufferedReader(new FileReader(new File(PATHNAME + user + EDAO.eSugangPath.getText())));
			Vector<String> lines = new Vector<>();
			String line = "";
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
			line = lines.get(row);
			String[] data = new String[5];
			data = line.split("\\s");
			return data[0];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "0";

	}

	public Vector<String> sincheong(String fileName) {
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

	public int credit(String user) {
		int sugangCredit = 0;
		try {

			br = new BufferedReader(new FileReader(new File(PATHNAME + user + EDAO.eSugangPath.getText())));
			Vector<String> lines = new Vector<>();
			String readline = "";
			while ((readline = br.readLine()) != null) {
				lines.add(readline);
			}
			br.close();
			for (String line : lines) {
				String[] data = new String[5];
				data = line.split("\\s");
				int credit = Integer.parseInt(data[3]);
				sugangCredit += credit;
			}
			return sugangCredit;

			// 형변환 예외처리 해주기
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;

	}

	public void add(String user, OLecture oLecture) {
		try {
			fileWriter = new FileWriter(new File(PATHNAME + user + EDAO.eSugangPath.getText()), true);
			// 중복 방지
			scanner = new Scanner(new File(PATHNAME + user + EDAO.eSugangPath.getText()));
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				if (line.indexOf(oLecture.getId()) == 0) {
					System.out.println(EDAO.eRepeatErr.getText());
//					if (this.mf != null) {
						JOptionPane.showConfirmDialog(this.mf, "중복으로 담을 수 없습니다.", "중복 방지",
								JOptionPane.OK_CANCEL_OPTION);
//					}
					return;
				}
			}
			// user별 파일 저장
			if (this.credit(user) + Integer.parseInt(oLecture.getCredit()) > 18) {
				System.out.println("수강 제한 학점은 18학점입니다. 더이상 수강할 수 없습니다.");
				JOptionPane.showConfirmDialog(this.mf, "수강 제한 학점은 18학점입니다", "학점 제한", JOptionPane.OK_CANCEL_OPTION);
				return;
			}
			fileWriter.write(oLecture.getId() + " " + oLecture.getName() + " " + oLecture.getProfessor() + " "
					+ oLecture.getCredit() + " " + oLecture.getTime());
			fileWriter.write("\n");
			fileWriter.close();
			System.out.println(oLecture.getId() + EDAO.eSugangAdd.getText());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
