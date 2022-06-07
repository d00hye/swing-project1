package textView;

import java.util.Scanner;

import control.CHwewonDeungrok;
import valueObject.OHwewon;

public class VHwewonDeungrok {
	
	private Scanner scanner;                   
	private CHwewonDeungrok cHwewonDeungrok;  

	public VHwewonDeungrok(Scanner scanner) {     
		this.scanner=scanner;
		this.cHwewonDeungrok = new CHwewonDeungrok();
	}
	
	public void show() { 
    	
    	OHwewon oHwewon = new OHwewon();		
    	System.out.println("회원정보를 입력하세요");   	
    	
    	
		System.out.print("ID(학번): "); 
		String id = scanner.next();
		oHwewon.setId(id);
		
		System.out.print("비밀번호: "); 
		String password = scanner.next();
		oHwewon.setPassword(password);
		
		System.out.print("이름: "); 
		String name = scanner.next();
		oHwewon.setName(name);
		
		System.out.print("주소: "); 
		String address = scanner.next();
		oHwewon.setAddress(address);
		
		System.out.print("학과: "); 
		String hakgwa = scanner.next();
		oHwewon.setHakgwa(hakgwa);
		
		
  	    this.cHwewonDeungrok.saveHwewon(oHwewon);
  	    
	}

}
