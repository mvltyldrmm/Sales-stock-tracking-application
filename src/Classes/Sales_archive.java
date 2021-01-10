package Classes;


public class Sales_archive {
	private int barkodNo;
	private String person_mail;
	private int selling_price;
	
	//DEGISKENLERIN TANIMLANMASI
	
	public Sales_archive(int barkodNo, String i,int selling_price) {
		this.barkodNo = barkodNo;
		this.person_mail = i;
		this.selling_price = selling_price;
		//KURUCU SINIF
		
	}
	
	//GETTER-SETTER METODLARI
	
	public int getBarkodNo() {
		return barkodNo;
	}
	public void setBarkodNo(int barkodNo) {
		this.barkodNo = barkodNo;
	}
	
	public String getperson_mail() {
		return person_mail;
	}
	public void setperson_mail(String person_mail) {
		this.person_mail = person_mail;
	}
	public int getselling_price() {
		return selling_price;
	}
	public void setselling_price(int selling_price) {
		selling_price = selling_price;
	}
	
	
	
	
	

}
