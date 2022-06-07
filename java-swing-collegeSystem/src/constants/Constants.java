package constants;

import java.awt.Font;

public class Constants {
	
	// symbol 의미 일정 constant, 아니면 variable
	public enum EMessage{
		eSelect("다음 기능을 선택하세요.");
		private String text;
		private EMessage(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum ETextLogin{
		eInput("아이디와 비밀번호를 입력하세요"),
		eId("ID(학번): "),
		ePassword("비밀번호: "),
		eFail("아이디와 비밀번호가 올바르지 않습니다.");
		
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
		eRepeatErr("이미 담은 강좌입니다."), 
		eReapeatSinchoeng("이미 수강신청한 강좌입니다."), 
		eMiriAdd("번강좌 미리담기에 저장되었습니다."),
		eMiriDel("번강좌 삭제되었습니다."), 
		eMiriShow("-------현재 미리담기 리스트-------"),
		eSugangAdd("수강 신청 완료되었습니다."),
		eSugangDel("번강좌 삭제되었습니다."), 
		eSugangShow("-------현재 수강신청 리스트-------");
		
		private String text;
		private EDAO(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
	}
	
	public enum EFileName{
		eCampus("소속 캠퍼스를"),
		eCollege("단과대를"),
		eHakgwa("학과를");
		
		private String text;
		private EFileName(String text) {
			this.text = text;
		}
		public String getText() {
			return this.text;
		}
		
	}
	
	public enum EMiridamgi{
		eAddM(1, "미리담기추가"),
		eShow(2, "미리담기내역보기"),
		eDelete(3, "미리담기삭제"), 
		eSincheong(4, "수강신청"),
		eAddS(5, "수강신청추가"),
		eLecture(6, "강좌번호조회"),
		eExit(7,"종료");
		
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
		eAdd(1, "수강신청 추가"),
		eShow(2, "수강신청 내역보기"),
		eDelete(3, "수강신청 삭제"), 
		eMiridamgi(4, "미리담기"),
		eExit(5,"종료");
		
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
		eLogin("로그인"),
		eSugang("수강신청 페이지"),
		eHwewon("회원 등록"),
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
		idLabel("   아이디"),
		sizeidtext("10"),
		passwordLabel("비밀번호"),
		passwordsecurity("*"),
		sizePasswordText("10"),
		okButtonLabel("ok"),
		cancelButtonLabel("cancel"),
		hwewonButtonLabel("회원등록 "),
		findButtonLabel("비밀번호찾기"),
		loginFailed("아이디나 비밀번호가 틀렸습니다."),
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
		idLabel("아이디: "),
		passwordLabel("비밀번호: "),
		nameLabel("이름: "),
		addressLabel("주소: "),
		hakgwaLabel("학과: "),
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
		idLabel("아이디: "),
		passwordLabel("비밀번호가 출력됩니다."),
		nameLabel("이름: "),
		addressLabel("주소: "),
		hakgwaLabel("학과: "),
		sizeText("12"),
		sizeaddressText("10"),
		sizehakgwaText("10"),
		idButtonLabel("id찾기"),
		passwordButtonLabel("password찾기"), findButtonLabel("Find");
		
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
		eId("강좌번호"),
		eName("강좌명"),
		eProfessor("교수명"),
		eCredit("학점"),
		eTime("시간");
		
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
		eGodick(new Font("맑은 고딕", Font.PLAIN, 13)),
		eGodickbold(new Font("맑은 고딕", Font.BOLD, 13)),
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
