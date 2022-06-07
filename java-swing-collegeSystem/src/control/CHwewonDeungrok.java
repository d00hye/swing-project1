package control;

import valueObject.OHwewon;

import dataAccessObject.DHwewonDeungrok;

public class CHwewonDeungrok {
	
	private DHwewonDeungrok dHwewonDeungrok;   
	public CHwewonDeungrok() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}
	
	// DHwewonDeungrok에 회원 정보 저장
	public void saveHwewon(OHwewon oHwewon) {		
		this.dHwewonDeungrok.save(oHwewon);		
	}	
	
	// 전달받은 id의 정보 읽음
	public OHwewon readHwewon(String id) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(id);
		return oHwewon;
	}
	
}
