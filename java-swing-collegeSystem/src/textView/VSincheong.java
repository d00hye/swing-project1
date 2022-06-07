package textView;

import java.util.Scanner;

import constants.Constants.EMessage;
import constants.Constants.ESincheong;
import dataAccessObject.DMiridamgi;
import dataAccessObject.DSincheong;

public class VSincheong {

	private Scanner scanner;
	private DSincheong dSincheong;
	private DMiridamgi dMiridamgi;

	public VSincheong() {
		this.scanner = new Scanner(System.in);
		this.dSincheong = new DSincheong();
		this.dMiridamgi = new DMiridamgi();
	}

	public void sincheong(String user) {

		System.out.println(EMessage.eSelect.getText());

		for (ESincheong eSincheong : ESincheong.values()) {
			System.out.print(eSincheong.getText() + "(" + eSincheong.getNum() + "), ");
		}
		System.out.println();

		int input = 0;
		while (input != 5) {
			input = scanner.nextInt();
			if (input == ESincheong.eAdd.getNum()) {
				System.out.println("추가할 강좌의 강좌번호를 입력하세요");
				String key = scanner.next();
				dSincheong.add(user, key);
			} else if (input == ESincheong.eShow.getNum()) {
				dSincheong.show(user);
			} else if (input == ESincheong.eDelete.getNum()) {
				dSincheong.show(user);
				System.out.println("삭제할 강좌의 강좌번호를 입력하세요");
				String key = scanner.next();
				dSincheong.delete(user, key);
			} else if (input == ESincheong.eMiridamgi.getNum()) {
				dMiridamgi.show(user);
			}
		}

		System.exit(0);
	}

}

