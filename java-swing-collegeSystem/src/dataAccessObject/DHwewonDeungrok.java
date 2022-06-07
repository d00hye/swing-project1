package dataAccessObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import constants.Constants.EDAO;
import model.MHwewon;
import valueObject.OHwewon;

public class DHwewonDeungrok {
	private MHwewon mHwewon;

	public DHwewonDeungrok() {

	}

	// 기술적 관심사와 업무적 관심사
	public void save(OHwewon oHwewon) {
		// oHwewond에서 mHwewon으로 데이터를 이동
		try {
			File file = new File(EDAO.eHwewonPath.getText());
			FileWriter fileWriter = new FileWriter(file, true);

			this.mHwewon = new MHwewon();
			mHwewon.save(fileWriter, oHwewon);
			fileWriter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mHwewon을 통해서 파일에 저장
	}

	public OHwewon read(String id) {
		// file을 통해 Data read
		try {

			Scanner scanner = new Scanner(new File(EDAO.eHwewonPath.getText()));
			MHwewon mHwewon = new MHwewon();

			while (mHwewon.read(scanner)) {
				if (mHwewon.getId().equals(id)) {
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					return oHwewon;
				}

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public OHwewon readname(String name) {
		// file을 통해 Data read
		try {

			Scanner scanner = new Scanner(new File(EDAO.eHwewonPath.getText()));
			MHwewon mHwewon = new MHwewon();

			while (mHwewon.read(scanner)) {
				if (mHwewon.getName().equals(name)) {
					OHwewon oHwewon = new OHwewon();
					oHwewon.set(mHwewon);
					return oHwewon;
				}

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void set(String id) {
		try {
			@SuppressWarnings("unused")
			FileWriter fileWriter1 = new FileWriter(new File("userdata/" + id + EDAO.eMiriPath.getText()), true);
			@SuppressWarnings("unused")
			FileWriter fileWriter2 = new FileWriter(new File("userdata/" + id + EDAO.eSugangPath.getText()), true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
