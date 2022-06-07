package constants;

import java.awt.Font;

public class Constants {
	
	// symbol �ǹ� ���� constant, �ƴϸ� variable
	public enum EMessage{
		eSelect("���� ����� �����ϼ���.");
		private String text;
		private EMessage(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum ETextLogin{
		eInput("���̵�� ��й�ȣ�� �Է��ϼ���"),
		eId("ID(�й�): "),
		ePassword("��й�ȣ: "),
		eFail("���̵�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
		
		private String text;
		private ETextLogin(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EDAO{
		eHwewonPath("hwewon"),
		eMiriPath("M"),
		eSugangPath("S"),
		eRepeatErr("�̹� ���� �����Դϴ�."), 
		eReapeatSinchoeng("�̹� ������û�� �����Դϴ�."), 
		eMiriAdd("������ �̸���⿡ ����Ǿ����ϴ�."),
		eMiriDel("������ �����Ǿ����ϴ�."), 
		eMiriShow("-------���� �̸���� ����Ʈ-------"),
		eSugangAdd("���� ��û �Ϸ�Ǿ����ϴ�."),
		eSugangDel("������ �����Ǿ����ϴ�."), 
		eSugangShow("-------���� ������û ����Ʈ-------");
		
		private String text;
		private EDAO(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileName{
		eCampus("�Ҽ� ķ�۽���"),
		eCollege("�ܰ��븦"),
		eHakgwa("�а���");
		
		private String text;
		private EFileName(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		
	}
	
	public enum EMiridamgi{
		eAddM(1, "�̸�����߰�"),
		eShow(2, "�̸���⳻������"),
		eDelete(3, "�̸�������"), 
		eSincheong(4, "������û"),
		eAddS(5, "������û�߰�"),
		eLecture(6, "���¹�ȣ��ȸ"),
		eExit(7,"����");
		
		private int num;
		private String text;

		private EMiridamgi(int num, String text) {
			this.num = num;
			this.text=text;
		}
		public int getNum() {
			return this.num;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum ESincheong{
		eAdd(1, "������û �߰�"),
		eShow(2, "������û ��������"),
		eDelete(3, "������û ����"), 
		eMiridamgi(4, "�̸����"),
		eExit(5,"����");
		
		private int num;
		private String text;

		private ESincheong(int num, String text) {
			this.num = num;
			this.text=text;
		}
		public int getNum() {
			return this.num;
		}
		public String getText() {
			return this.text;
		}
	}

	public enum ESetTitle{
		eLogin("�α���"),
		eSugang("������û ������"),
		eHwewon("ȸ�� ���"),
		eFind("id/password");
		
		private String text;
		private ESetTitle(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum ELoginDialog {
		width("300"),
		height("470"),
		imgLabelPath("resources/logindialog.png"),
		idLabel("   ���̵�"),
		sizeidtext("10"),
		passwordLabel("��й�ȣ"),
		passwordsecurity("*"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		hwewonButtonLabel("ȸ����� "),
		findButtonLabel("��й�ȣã��"),
		loginFailed("���̵� ��й�ȣ�� Ʋ�Ƚ��ϴ�."),
		errormessage("Password error");
		
		private String text;
		
		private ELoginDialog(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
		public char getChar() {
			return text.charAt(0);
		}
	}
	
	public enum EHwewon{
		width("230"),
		height("300"),
		idLabel("���̵�: "),
		passwordLabel("��й�ȣ: "),
		nameLabel("�̸�: "),
		addressLabel("�ּ�: "),
		hakgwaLabel("�а�: "),
		sizeText("10"),
		sizeaddressText("10"),
		sizehakgwaText("10"),
		okButtonLabel("ok");
		
		private String text;
		
		private EHwewon(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EFind{
		width("230"),
		height("300"),
		idLabel("���̵�: "),
		passwordLabel("��й�ȣ�� ��µ˴ϴ�."),
		nameLabel("�̸�: "),
		addressLabel("�ּ�: "),
		hakgwaLabel("�а�: "),
		sizeText("12"),
		sizeaddressText("10"),
		sizehakgwaText("10"),
		idButtonLabel("idã��"),
		passwordButtonLabel("passwordã��"), findButtonLabel("Find");
		
		private String text;
		
		private EFind(String text) {
			this.text = text;
		}
		
		public String getText() {
			return this.text;
		}
		public int getInt() {
			return Integer.parseInt(text);
		}
		
	}
	
	public enum EGangjwa{
		eId("���¹�ȣ"),
		eName("���¸�"),
		eProfessor("������"),
		eCredit("����"),
		eTime("�ð�");
		
		private String text;
		private EGangjwa(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EDefault{
		eGangjwa("englishYG"),
		eCampus("yongin"),
		eCollege("generalY"),
		eRoot("root");
		
		private String text;
		private EDefault(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	
	public enum EFont{
		eGodick(new Font("���� ���", Font.PLAIN, 13)),
		eGodickbold(new Font("���� ���", Font.BOLD, 13)),
		eDialog(new Font("Dialog", Font.PLAIN, 13));
		
		private Font font;
		private EFont(Font font) {
			this.font = font;
		}
		public Font getFont() {
			return this.font;
		}
	}

}
