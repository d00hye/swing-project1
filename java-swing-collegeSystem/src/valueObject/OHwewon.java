package valueObject;

import model.MHwewon;

public class OHwewon {

	private String id;
	private String password;

	private String name;
	private String address;
	private String hakgwa;

	public OHwewon() {


	}
	
	public void set(MHwewon mHwewon) {
		this.id=mHwewon.getId();
		this.password=mHwewon.getPassword();
		this.name=mHwewon.getName();
		this.hakgwa=mHwewon.getHakgwa();
		this.address=mHwewon.getAddress();
		
	}

	// get, set
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setHakgwa(String hakgwa) {
		this.hakgwa = hakgwa;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getHakgwa() {
		return hakgwa;
	}


	public String getPassword() {
		return password;
	}


}
