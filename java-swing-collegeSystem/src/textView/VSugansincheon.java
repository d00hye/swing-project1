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

	// refactoring, ���� ����ó��

	public void show(OHwewon oHwewon) {
		System.out.println(oHwewon.getName() + "�� �ȳ��ϼ���");
		System.out.println("���� ��ȸ�� �����ұ��? O(1), X(2)");
		String input = this.scanner.next();
		if (input.equals("1")) {
			System.out.println("���� ��ȸ�� �����մϴ�.");
			String lectureName = this.fileName();
			if (lectureName != null) {
				OLecture oLecture = this.vLecture.show(lectureName, "���¸�");
				if (oLecture != null)
					this.vMiridamgi.miridamgi(oHwewon.getId(), oLecture);
			} else
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �õ����ּ���");
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

	// ����
//	String campusFileName = this.vIndex.show("root", "�Ҽ� ķ�۽���");
//	if (campusFileName != null) {
//		String collegeFileName = this.vIndex.show(campusFileName, "�ܰ��븦");
//		if (collegeFileName != null) {
//			String departmentFileName = this.vIndex.show(collegeFileName, "�а���");
//			if (departmentFileName != null) {
//				OLecture oLecture = this.vLecture.show(departmentFileName, "���¸�");
//				this.vMiridamgi.miridamgi(oHwewon.getId(), oLecture);
//			} else
//				System.out.println("�ش� ������ �����ϴ�.");
//		} else
//			System.out.println("�ش� ������ �����ϴ�.");
//	} else
//		System.out.println("�ش� ������ �����ϴ�.");

}
