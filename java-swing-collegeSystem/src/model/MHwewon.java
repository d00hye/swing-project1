package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dataAccessObject.DHwewonDeungrok;
import valueObject.OHwewon;
import windowsView.VHwewonDeungrok;

public class MHwewon {

	private String id;
	private String password;
	private String name;
	private String address;
	private String hakgwa;

	public VHwewonDeungrok vHwewonDeungrok;

	public boolean read(Scanner scanner) {
		if (scanner.hasNext()) {
			this.id = scanner.next();
			this.password = scanner.next();
			this.name = scanner.next();
			this.hakgwa = scanner.next();
			this.address = scanner.next();
			return true;
		}
		return false;
	}

	public void save(FileWriter fileWriter, OHwewon oHwewon) {
		this.set(oHwewon);

		try {
			// �ߺ� ����
			DHwewonDeungrok readHwewon = new DHwewonDeungrok();
			if (readHwewon.read(id) != null) {
				System.out.println("id�� �̹� �ֽ��ϴ�. �ٽ� �Է����ּ���");
				JOptionPane.showConfirmDialog(this.vHwewonDeungrok, "id�� �̹� �ֽ��ϴ�", "�ߺ� ID",
						JOptionPane.OK_CANCEL_OPTION);
				return;
			}
			fileWriter.write(id);
			fileWriter.write("\n");
			fileWriter.write(password);
			fileWriter.write("\n");
			fileWriter.write(name);
			fileWriter.write("\n");
			fileWriter.write(hakgwa);
			fileWriter.write("\n");
			fileWriter.write(address);
			fileWriter.write("\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void set(OHwewon oHwewon) {
		this.id = oHwewon.getId();
		this.password = oHwewon.getPassword();
		this.name = oHwewon.getName();
		this.address = oHwewon.getAddress();
		this.hakgwa = oHwewon.getHakgwa();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHakgwa() {
		return hakgwa;
	}

	public void setHakgwa(String hakgwa) {
		this.hakgwa = hakgwa;
	}

}
