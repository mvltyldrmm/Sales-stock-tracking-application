package Classes;

public class Person {
	private String name;
	private String surname;
	private String gmail;
	private String password;
	//DEGISKENLERIN TANIMLANMASI
	
	
	public Person(String name, String surname,String gmail,String password) {
		this.name = name;
		this.surname = surname;
		this.gmail = gmail;
		this.password = password;
		//KURUCU SINIF
	}
	
	//GETTER-SETTER METODLARI
	
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getsurname() {
		return surname;
	}

	public void setsurname(String surname) {
		this.surname = surname;
	}

	public String getgmail() {
		return gmail;
	}

	public void setgmail(String gmail) {
		this.gmail = gmail;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	

	
}
