package textView;

import java.util.Scanner;

import constants.Constants.EFileName;
import valueObject.OHwewon;
import valueObject.OLecture;

public class VSugansincheon {

	private Scanner scanner;

	private VIndex vIndex;
	private VLecture vLecture;
	private VMiridamgi vMiridamgi;

	public VSugansincheon(Scanner scanner) {
		this.scanner = scanner;
		this.vIndex = new VIndex(this.scanner);
		this.vLecture = new VLecture(this.scanner);
		this.vMiridamgi = new VMiridamgi();
	}

	// refactoring, 렉쳐 예외처리

	public void show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName() + "님 안녕하세요");
		System.out.println("강좌 조회를 진행할까요? O(1), X(2)");
		String input = this.scanner.next();
		if (input.equals("1")) {
			System.out.println("강좌 조회를 시작합니다.");
			String lectureName = this.fileName();
			if (lectureName != null) {
				OLecture oLecture = this.vLecture.show(lectureName, "강좌를");
				if (oLecture != null)
					this.vMiridamgi.miridamgi(oHwewon.getId(), oLecture);
			} else
				System.out.println("잘못 입력하셨습니다. 다시 시도해주세요");
			this.show(oHwewon);
		}else if(input.equals("2")) {
			this.vMiridamgi.miridamgi(oHwewon.getId(), null);
		}
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

	// 기존
//	String campusFileName = this.vIndex.show("root", "소속 캠퍼스를");
//	if (campusFileName != null) {
//		String collegeFileName = this.vIndex.show(campusFileName, "단과대를");
//		if (collegeFileName != null) {
//			String departmentFileName = this.vIndex.show(collegeFileName, "학과를");
//			if (departmentFileName != null) {
//				OLecture oLecture = this.vLecture.show(departmentFileName, "강좌를");
//				this.vMiridamgi.miridamgi(oHwewon.getId(), oLecture);
//			} else
//				System.out.println("해당 파일이 없습니다.");
//		} else
//			System.out.println("해당 파일이 없습니다.");
//	} else
//		System.out.println("해당 파일이 없습니다.");

}
