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
    	System.out.println("ȸ�������� �Է��ϼ���");   	
    	
    	
		System.out.print("ID(�й�): "); 
		String id = scanner.next();
		oHwewon.setId(id);
		
		System.out.print("��й�ȣ: "); 
		String password = scanner.next();
		oHwewon.setPassword(password);
		
		System.out.print("�̸�: "); 
		String name = scanner.next();
		oHwewon.setName(name);
		
		System.out.print("�ּ�: "); 
		String address = scanner.next();
		oHwewon.setAddress(address);
		
		System.out.print("�а�: "); 
		String hakgwa = scanner.next();
		oHwewon.setHakgwa(hakgwa);
		
		
  	    this.cHwewonDeungrok.saveHwewon(oHwewon);
  	    
	}

}