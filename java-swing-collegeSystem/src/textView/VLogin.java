package textView;

import java.util.Scanner;

import constants.Constants.ETextLogin;
import control.CLogin;
import valueObject.OHwewon;
import valueObject.OLogin;

public class VLogin {
	
	private Scanner scanner;                   
	private CLogin cLogin;  

	public VLogin(Scanner scanner) {     
		this.scanner=scanner;
		this.cLogin = new CLogin();  
	}
	
	public OHwewon show() {  

    	System.out.println(ETextLogin.eInput.getText());   	
    	OLogin oLogin =new OLogin();
    	
    	
		System.out.print(ETextLogin.eId.getText()); 
		String id = scanner.next();
		oLogin.setId(id);
		
		System.out.print(ETextLogin.ePassword.getText()); 
		String password = scanner.next();
		oLogin.setPassword(password);
		
		//수강신청화면으로 들어가면 실행됨
  	    OHwewon oHwewon = this.cLogin.validate(oLogin);
  	    if(oHwewon !=null) { 	    	
  	    	return oHwewon;  	    	
  	    }else {
  	    	System.out.print(ETextLogin.eFail.getText());
  	    	System.out.println();
  	    	return this.show();
  	    }
	}

}
