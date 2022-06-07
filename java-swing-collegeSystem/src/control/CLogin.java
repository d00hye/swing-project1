package control;

import valueObject.OHwewon;
import valueObject.OLogin;
import dataAccessObject.DHwewonDeungrok;

public class CLogin {
	
	private DHwewonDeungrok dHwewonDeungrok;  
	
	public CLogin() {
		this.dHwewonDeungrok = new DHwewonDeungrok();
	}
	
	// CLogin 은 회원과 다르게 특정한 아이디 읽기
	
	public OHwewon validate(OLogin oLogin) {
		
		OHwewon oHwewon = this.dHwewonDeungrok.read(oLogin.getId());
		if(oHwewon != null) {
			if(oLogin.getPassword().contentEquals(oHwewon.getPassword())) {
				this.dHwewonDeungrok.set(oLogin.getId());
				return oHwewon;
			}
		}
		
		return null;
	}
	
	// password, id 가져오기
	
	public String getPassword(OLogin oLogin) {
		OHwewon oHwewon = this.dHwewonDeungrok.read(oLogin.getId());
		if(oHwewon != null) {
			String password =oHwewon.getPassword();
				return password;
		}
		return null;
	}
	
	public String getId(OLogin oLogin) {
		OHwewon oHwewon = this.dHwewonDeungrok.readname(oLogin.getName());
		if(oHwewon != null) {
			String id =oHwewon.getId();
				return id;
		}
		return null;
	}
}
