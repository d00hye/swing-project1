package textView;

import java.util.Scanner;

import constants.Constants.EFileName;
import constants.Constants.EMessage;
import constants.Constants.EMiridamgi;
import dataAccessObject.DMiridamgi;
import dataAccessObject.DSincheong;
import valueObject.OLecture;

public class VMiridamgi {

	private Scanner scanner;
	private DMiridamgi dMiridamgi;
	private DSincheong dSincheong;
	private VSincheong vSincheong;
	private VIndex vIndex;
	private VLecture vLecture;

	public VMiridamgi() {
		this.scanner = new Scanner(System.in);
		this.dMiridamgi = new DMiridamgi();
		this.dSincheong = new DSincheong();
		this.vSincheong = new VSincheong();
		this.vIndex = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
	}

	public void miridamgi(String user, OLecture oLecture) {

		System.out.println(EMessage.eSelect.getText());

		for (EMiridamgi eMiridamgi : EMiridamgi.values()) {
			System.out.print(eMiridamgi.getText() + "(" + eMiridamgi.getNum() + "), ");
		}
		System.out.println();

		int input = 0;
		while (input != 7) {
			input = scanner.nextInt();
			if (input == EMiridamgi.eAddM.getNum()) {
				if(oLecture!=null) {
				dMiridamgi.add(user, oLecture);
				}else {
				System.out.println("강좌번호 조회 후 시도해주세요");
				}
			} else if (input == EMiridamgi.eShow.getNum()) {
				dMiridamgi.show(user);
			} else if (input == EMiridamgi.eDelete.getNum()) {
				dMiridamgi.show(user);
				System.out.println("삭제할 강좌의 강좌번호를 입력하세요(취소시 0 입력)");
				String key = scanner.next();
				if(key.equals("0")) {
					System.out.println("삭제를 종료합니다.");
					this.miridamgi(user, oLecture);
				}
				else {
				dMiridamgi.delete(user, key);
				}
			} else if (input == EMiridamgi.eSincheong.getNum()) {
				dMiridamgi.show(user);
				vSincheong.sincheong(user);
			} else if (input == EMiridamgi.eAddS.getNum()) {
				if(oLecture!=null) {
					dSincheong.add(user, oLecture);
					}
				else {
					System.out.println("강좌번호 조회 후 시도해주세요");
				}
			} else if (input == EMiridamgi.eLecture.getNum()) {
				String lectureName = this.fileName();
				if (lectureName != null) {
					OLecture oLectures = this.vLecture.show(lectureName, "강좌를");
					if (oLectures != null)
						this.miridamgi(user, oLectures);
				} else
					System.out.println("잘못 입력하셨습니다. 다시 시도해주세요");
			}
		}
		System.out.println("------시스템 종료 --------");
		System.exit(0);
	}

	public String fileName() {
		String fileName = "root";
		for (EFileName eFileName : EFileName.values()) {
			if (fileName != null)
				fileName = this.vIndex.show(fileName, eFileName.getText());
			else
				return null;
		}
		return fileName;
	}

}
