package Functions_and_database;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Classes.Person;
import Classes.Sales_archive;
import Classes.Product;
import net.proteanit.sql.DbUtils;

//DESKTOP-VFD2GMF
/*
 * FONKSIYONLAR SUREKLI KULLANILACAGINDAN DOLAYI TURKCE ISIMLER KULLLANILMISTIR.
 */
public class DataBase_and_functions {
	static Connection connection;
	public static String url2 = "jdbc:sqlite:Florist.db"; //VERI TABANI BAGLANTISI SQLITE ILE, Florist.db DOSYASINDA YAPILMAKTADIR.
	
	
	public static  Connection Connect()  {  //BAGLANTININ ACILMASI.(BAGLANTI KAPANISI HER FONKSIYON SONUNDA OLMAKTADIR.)
		Connection connection = null;
		
		try {
			
			connection = DriverManager.getConnection(url2);
			System.out.println("baðlandý");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("baðlanamadý "+e.getMessage());
		}
		
		return connection; //DONEN DEGER BAGLANTI
	}
	
	
	public static String personelKaydet(Person person1){//PERSONELLERIN KAYIT EDILMESI(YALNIZCA ADMIN TARAFINDAN)
		java.sql.Statement stmt = null;

        String text_value = "";
        
        //ALTTAKI IF KOSULUNDA KAYIT EDILECEK GIRDILERIN BIR STRING VE KARAKTER SAYISININ BIRDEN BUYUK OLUP OLMADIGI KONTROL EDIYOR
        //EGER SARTLARI GECIYORSA ONA GORE BOS DEGER ATADIGIMIZ STRING DEGERIMIZI SEKILLENDIRIP DONDURUYORUZ
        //KULLANDIGIMIZ SAYFADA KULLANICIYA BILDIRIM OLARAK DONDURECEGIZ BU STRINGI.
        
        if(person1.getname().length()>0 && person1.getsurname().length()>0 &&
        		person1.getgmail().length()>0 && person1.getpassword().length()>0) {
        	 try {
                 Connection connection=Connect();
                 String query="insert into Personel(ad,soyad,eposta,sifre) values('"+person1.getname()+"','"+person1.getsurname()+"','"+person1.getgmail()+"','"+person1.getpassword()+"')";
                 //SORGU OLUSTURULDU.
                 stmt = connection.createStatement();          
                 stmt.executeUpdate(query);
                 //SORGU CALISTIRILDI
  	           stmt.close();
  	           connection.close();
  	           text_value = "Personel Baþarý ile kayýt edildi.";
       
          } catch (Exception e) {                  
                 text_value = "Ürün kayýt edilemedi. Girdileri kontrol edin.";
          }  
        }
        else {
        	text_value = "Lutfen girdileri doldurunuz.";
        }
        
        
        return text_value;
	}
	public static String UrunKaydet(Product product1){
		String text_value = "";
		java.sql.Statement stmt = null;
		
		/*
		 * BURADA DA PERSONEL KAYIT MANTIGI BULUNUYOR. HATA OLMASINDA VEYA KAYIT EDILEMEMESI DURUMUNDA BOS STRING UYARI OLARAK DONDURULUYOR.
		 */
		try {
				
	           Connection connection=Connect();
	           stmt = connection.createStatement();
	           String query="insert into Urun(isim,kategori,gelisFiyat,satisFiyat,adet) values('"+product1.getName()+"','"+product1.getCategory()+"','"+product1.getPurchase_price()+"','"+product1.getSale_price()+"','"+product1.getPiece()+"')";
	           stmt.executeUpdate(query);
	           stmt.close();
	           connection.close();
	           //SORGU YAZILMASI, CALISTIRILMASI VE BAGLANTI KAPATILMASI.
	    	
	           text_value = "Ürün baþarý ile kayýt edildi.";
	 
	    } catch (Exception e) {                  
	           text_value = "Ürün kayýt edilemedi. Girdilerin String olmasýna dikkat edin.";
	    }     
		
		return text_value;
    
	}
	public static ResultSet Urunler(){
		Connection connection=Connect();
		
		//TUM URUNLERIN RESULTSET OLARAK DONDURULMESI.
		
        String query="select * from Urun";
        ResultSet rs = null;
		try {
	           java.sql.Statement  statement = connection.createStatement();
	           rs = statement.executeQuery(query);
	    
	 
	    } catch (Exception e) {                  
	           e.printStackTrace();

	    }    
		return rs;
    
	}
	public static ResultSet Personeller(){
		Connection connection=Connect();
        String query="select * from Personel";
        
		//TUM PERSONELLERIN RESULTSET OLARAK DONDURULMESI.

        
        ResultSet rs = null;
		try {
	           java.sql.Statement  statement = connection.createStatement();
	           rs = statement.executeQuery(query);
	    
	    
	 
	    } catch (Exception e) {                  
	           e.printStackTrace();

	    }    
		return rs;
    
	}
	
	public static String UrunSil(int barkodeNo){
		String text_value = "";
		java.sql.Statement stmt = null;
		
		//BARKOD NUMARASI GIRILEN URUN SQL SORGUSU ILE DATABASEDEN SILINIYOR.
		try {
	           Connection connection=Connect();
	           String query="delete from Urun where barkodNo ='"+barkodeNo+"'";
	           stmt = connection.createStatement();
	          
	           stmt.executeUpdate(query);
	           
	           stmt.close();
	           connection.close();

	    
	    text_value = "Urun Silindi.";
	    
	    } catch (Exception e) {                  
	           e.printStackTrace();
	           text_value = "Urun Silinemedi. Barkod Numarasýný Kontrol Ediniz.";
	    } 
		return text_value;
    
	}
	
	
	public static int adetGetir(int barkodeNo) {
		int adet = -1;
		
		/*
		 * ADET GETIR ILE BARKOD NUMARASI GIRILEN URUNDEN KAC TANE DONDUGUNU GOSTEREN FONKSIYON.
		 */
		Connection connection = Connect();
		ResultSet rs = null;
		
		try {
			String query = "select adet from Urun where barkodNo = '"+barkodeNo+"' ";
			//SORGU
			java.sql.Statement  statement = connection.createStatement();
			rs = statement.executeQuery(query);
			//SORGUNUN CALISTIRILMASI
			while(rs.next()) {
				adet = rs.getInt(1);
				//ADETIN GETIRILMESI
			}
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return adet;
	}
	
	public static String mailGetir(int id) {
		
		//PERSONEL SILME VB ISLEMLERDE KULLANILMAK UZERE YAZILAN BU FONKSIYON ILE ID SI GIRILEN PERSONELIN MAILI DONDURULUYOR.
		String mail= "";
		Connection connection = Connect();
		ResultSet rs = null;
		
		try {
			String query = "select eposta from Personel where id = '"+id+"' ";
			java.sql.Statement  statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				mail = rs.getString(1);
			}
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mail;
	}
	
	
	
	
	public static String PersonelSil(int id){
		String text_value = "";
		java.sql.Statement stmt = null;
		
		
		/*
		 * PERSONEL SILME ISLEMI , GIRILEN ID NUMARASINI MAILGETIRME FONKSIYONUNA GONDERILEREK VARSA PERSONELIN MAILINE BAKILIYOR
		 * EGER PERSONELIN MAILI VARSA SILINIYOR. YOKSA ZATEN BOYLE BIR PERSONEL BULUNMADIGI ICIN UYARI DONUYOR.
		 */
		
		
		if(mailGetir(id).length()>=0) {
			try {
		           Connection connection=Connect();
		           String query="delete from Personel where id ='"+id+"'";
		           stmt = connection.createStatement();
			          
		           stmt.executeUpdate(query);
		           
		           stmt.close();
		           
		           connection.close();
		           
		    text_value = "Basarýyla Silindi.";
		 
		    } catch (Exception e) {                  
		           e.printStackTrace();
		           text_value = "Ýd numarasýný Kontrol edin.";
		    }     
		}
		else {
			text_value = "Ýd numarasýný Kontrol edin.";
		}
		return text_value;
    
	}
	
	public static String Satis(int barkodeNo) {
		Connection connection=Connect();
		
		
		/*
		 * BARKOD NUMARASI GIRILEN URUNUN ADET SAYISINA ADETGETIR FONKSIYONU ILE BAKILIYOR.
		 * EGER ADET SAYISI 0 DAN BUYUKSE SATIS GERCEKLESTIRILIYOR.
		 * 0 DAN KUCUK ISE UYARI MESAJI DONUYOR.
		 */
		
		
		if(adetGetir(barkodeNo)>0) {
			
			
			
			try {
				
	            
	            String query="update Urun set adet=adet-1 where barkodNo='"+barkodeNo+"'";
	            //SORGU
	            java.sql.Statement stmt = connection.createStatement();
		          
		        stmt.executeUpdate(query);
		          
		        stmt.close();
		        connection.close();
	     } catch (Exception e) {
	            e.printStackTrace();
	     }
		return "Urun Satildi.";
		}
		else {
			return "Bu Urun zaten yok .";
		}
	}
	
	
	public static String StokArttir(int barkodeNo) {
		String text_value = "";
		/*
		 * BARKOD NUMARASI GIRILEN URUNUN BULUNUP BULUNMADIGINA , ADET NUMARASINI KONTROL EDEREK BAKIYORUZ
		 * 0 VEYA DAHA BUYUK BIR SAYI ISE ADETI, URUN BULUNUYOR DIYEREK URUNUN MIKTARINI ARTTIRIYORUZ.
		 */
		
		if(adetGetir(barkodeNo)>=0) {
			java.sql.Statement stmt = null;

			try {
				
	            Connection connection=Connect();
	            String query="UPDATE Urun SET adet=adet+1 WHERE barkodNo='"+barkodeNo+"'";
	            //SORGU
	            stmt = connection.createStatement();
		          
		        stmt.executeUpdate(query);

		        text_value = "Urun Stoga Eklendi";
		        stmt.close();  
		        connection.close(); 
	       } catch (Exception e) {
	            e.printStackTrace();
	      }
		
		}
		else {
    	 	text_value = "Bu urun Stokda yok";

		}
		return text_value ;
	}
	
	public static JComboBox<Product> comboboxUrun(JComboBox box) {
		ResultSet resultSet = null;
		Connection connection = Connect();
		try {
			String query = "SELECT barkodNo FROM Urun";
			java.sql.Statement  statement = connection.createStatement();
			resultSet =statement.executeQuery(query);
			while(resultSet.next()) {
				
				box.addItem(resultSet.getString(1));
				

			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return box;
		
	}
	public static JComboBox<Product> comboboxPersonel(JComboBox box) {
		
		//BIR COMBOBOX DONDUREN BU FONKSIYON ILE PERSONEL IDLERINI KULLANICIYA GOSTERIYOR.
		//ARA YUZ EKRANINDA TANIMLANAN COMBOBOXU PARAMETRE OLARAK ALIYORUZ.
		ResultSet resultSet = null;
		Connection connection = Connect();
		try {
			String query = "SELECT id FROM Personel";
			java.sql.Statement  statement = connection.createStatement();
			resultSet =statement.executeQuery(query);
			while(resultSet.next()) {
				//ALDIGIMIZ PARAMETREYI RESULSET.NEXT() YARDIMIYLA PERSONEL ID'LERINDEN OLUSAN BIR COMBOBOX HALINE GETIRIYORUZ.
				box.addItem(resultSet.getString(1));
				

			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return box;
		
	}
	
	
	//satilan urun id si, satis fiyati, adeti,
	
	public static Sales_archive satisArsiv(int barkodeNo,String person_mail) {
		int sell_price = 0;
		
		//ONCE TANIMLANAN SATIS DEGERI
		
		
		Connection connection = Connect();
		ResultSet rs = null;
		
		
		
		
		
		if(adetGetir(barkodeNo)>0) {
			try {
				String query = "select satisFiyat from Urun where barkodNo = '"+barkodeNo+"' ";
				java.sql.Statement  statement = connection.createStatement();
				rs = statement.executeQuery(query);
				while(rs.next()) {
					sell_price = rs.getInt(1);
				}
				
				statement.close();
				connection.close();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("hata");
			}
			
			
			/*
			 *  PARAMETRE OLARAK ALDIGIMIZ MAIL VE BARKOD NUMARASI ILE BIRLIKTE SQL ILE SATISFIYATINI OGRENDIGIMIZ URUNU,
			 *  YARATTIGIMIZ SATIS ARSIVI SINIFINDAN BIR OBJEYE CEVIREREK RETURN YAPIYORUZ.
			 */
			
			Sales_archive SA = new Sales_archive(barkodeNo, person_mail, sell_price);
			
			return SA;
		}
		else {
			return null;
		}
		
		
		
	}
	
	public static boolean SatisKaydet(Sales_archive SA){
		java.sql.Statement stmt = null;
		/*
		 * SATIS ARSIVI FONKSIYONUNDAN ALDIGIMIZ SINIFI BURADA SQL E ARSIV OLARAK KAYIT EDIYORUZ.
		 */
		if(SA.getBarkodNo()>0) { 
			
			try {
		           Connection connection=Connect();
		           String query="INSERT INTO SatisArsiv(barkodNo,personelMail,satisFiyat) VALUES('"+SA.getBarkodNo()+"','"+SA.getperson_mail()+"','"+SA.getselling_price()+"')";
		           stmt = connection.createStatement();
			          
			       stmt.executeUpdate(query);
			       stmt.close();
			       connection.close();
		           
		    return true;
		 
		    } catch (Exception e) {                  
		           e.printStackTrace();
		           return false;
		    }     
			
		}
		else {
			return false;
		}
    
	}
	
	public static ResultSet SatisArsivleri(){
		
		//TUM SATIS ARSIVLERINI DONDUREN FONKSIYON
		
		
		Connection connection=Connect();
        String query="select * from SatisArsiv";
        ResultSet rs = null;
		try {
	           java.sql.Statement  statement = connection.createStatement();
	           rs = statement.executeQuery(query);
	    
	    
	 
	    } catch (Exception e) {                  
	           e.printStackTrace();

	    }    
		return rs;
    
	}
	
	public static boolean KullaniciVarmi(String mail, String sifre) {
		
		/*
		 * 
		 * ARAYUZDE ALDIGIMIZ MAIL VE SIFREYI PARAMETRE OLARAK ALIYORUZ
		 * 
		 */
		Connection connection=Connect();
		java.sql.Statement stmt = null;

        ResultSet rs = null;
        Boolean must = false;

		String query ="select * from Personel where eposta='"+mail+"' and Sifre='"+sifre+"'";
		//BU MAIL VE SIFRENIN DATABASE'DE BULUNUP BULUNMADIGINA BAKIYORUZ
        try{
        	   stmt = connection.createStatement();
	           rs = stmt.executeQuery(query);
	           if(rs.next()) {
	        	   must = true;
	        	   //VARSA DEGISKENIMIZ TRUE DONUYOR. TRUE 'YU RETURN YAPIP ARAYUZDE GIRIS EKRANINA GITMESINI SAGLIYORUZ.
	           }
        stmt.close();
        connection.close();
        }catch (Exception e) {
			// TODO: handle exception
        	must = false;
		}
        return must;
	
	
	
	
	}
	
	
	public static JTable Search(JTable table,JTextField search,JComboBox selection,JPanel panel2) {
		
		//ARAMA EKRANI
		
		Connection connection=Connect();
		try {
			//KULLANICI COMBOBOX ILE ARATACAGI FILTREYI SECIYOR.(ISIM,KATEGORI,FÝYAT)

			String selection1 = (String)selection.getSelectedItem();
			
			
			//SECILEN COMBOBOX ITEMI, GIRILEN HARFE DUYARI OLARAK ANLIK SQL SORGUSU YAPIYOR.
			
			
			String query4 = "select isim,kategori,satisFiyat,adet from Urun where "+selection1+" like '%"+search.getText()+"%' ";

			

			PreparedStatement ps = connection.prepareStatement(query4);
			ResultSet rs = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			

			ps.close();
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		//YAPILAN SORGU JTABLE OGESI OLARAK DONUYOR.

		return table;
	}
	
	public static void Update(int barkodNo,String isim,int gf,int sf, int adet, String kategori) {
		String text_value = "";
		
		//YENI GIRILEN URUN DEGERLERINI EKLIYORUZ
		
		if(adetGetir(barkodNo)>=0) {
			java.sql.Statement stmt = null;

			try {
				
	            Connection connection=Connect();
	        	String query = "UPDATE Urun SET isim='"+isim+"' , satisFiyat='"+sf+"'   , gelisFiyat='"+gf+"'  ,  adet='"+adet+"' , kategori='"+kategori+"' WHERE barkodNo = '"+barkodNo+"'   ";			
	            		
	            stmt = connection.createStatement();
		          
		        stmt.executeUpdate(query);

		        System.out.println("eklendi");
		        stmt.close();  
		        connection.close(); 
		        
		        
		        //BARKOD NUMARASI GIRILEN URUN YENI OZELLIKLERI ILE GUNCELLENDI.
		        
		        
		        
	       } catch (Exception e) {
	            e.printStackTrace();
	      }
		
		}
		else {
    	 	System.out.println("eklenmedi");

		}

	}
	
	
	public static Product BringProduct(int barkodNo) {
		
		//BARKOD NUMARASI GIRILEN URUNUN GUNCELLENMESI.
		
		
		Connection connection = Connect();
		ResultSet rs = null;
		Product product1 = new Product("null","null",0,0,0);
		
		//URUN SINIFINDAN BIR OBJE OLUSTURULUYOR.
		
		
		try {
			String query = "select * from Urun where barkodNo = '"+barkodNo+"' ";
			java.sql.Statement  statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				product1.setName(rs.getString(2));
				product1.setCategory(rs.getString(3));
				product1.setPurchase_price(rs.getInt(4));
				product1.setSale_price(rs.getInt(5));
				product1.setPiece(rs.getInt(6));
				
				//GUNCELLENECEK URUNUN KULLANICIYA TEXTFIELD SEKLINDE GOSTERILMESINI SAGLADIK.
				
				
			}
			
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return product1;
	}
	
	

	
}
	


