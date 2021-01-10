package Classes;

public class Product {
	private String category;
	private String name;
	private int purchase_price;
	private int sale_price;
	private int piece ;
	//DEGISKENLERIN TANIMLANMASI
	
	
	public Product(String name,String category,int purchase_price,int sale_price,int piece) {
		this.name = name;
		this.category = category;
		this.purchase_price = purchase_price;
		this.sale_price = sale_price;
		this.piece = piece;
		
		//KURUCU SINIF
	}
	
	//GETTER-SETTER METODLARI

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPurchase_price() {
		return purchase_price;
	}

	public void setPurchase_price(int purchase_price) {
		this.purchase_price = purchase_price;
	}

	public int getSale_price() {
		return sale_price;
	}

	public void setSale_price(int sale_price) {
		this.sale_price = sale_price;
	}

	public int getPiece() {
		return piece;
	}

	public void setPiece(int piece) {
		this.piece = piece;
	}

	
	
	
	
}
