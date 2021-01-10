package Product_design;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Classes.Product;
import Functions_and_database.DataBase_and_functions;
import net.proteanit.sql.DbUtils;

public class Product_update {
	public Product_update() {
		
		
		
				/*
				 * ARAYUZLERIN TANIMLANMASI.
				 */
			JFrame f= new JFrame("Ürün Güncelle");  

		
				JPanel panel=new JPanel(); 
		        JPanel panel2 = new JPanel();
		        panel.setBounds(0,0,300,1000);    
		        panel2.setBounds(300,0,1000,1000);
		        panel.setLayout(null);
		        panel2.setLayout(null);

		        JLabel l_name = new JLabel("Urun ismi :");
				JLabel l_category = new JLabel("Kategori :");
				JLabel l_purchaseprice = new JLabel("Gelis Fiyati :");
				JLabel l_sellPrice = new JLabel("Satis Fiyati :");
				JLabel l_date1 = new JLabel("Gelis Tarihi :");
				JLabel l_piece = new JLabel("piece Sayisi  :");

				JTextField name = new JTextField();
				JTextField purcPrice = new JTextField();
				JTextField sellPrice = new JTextField();
				JTextField piece = new JTextField();
				
				
				
				String country[]={"Orkide","Tek Gül","Cenaze","Yýlbaþý","Sevgililer Günü","Karýþýk buket"
						,"Doðum günü"}; 
				
				JComboBox category = new JComboBox(country);
				
				JLabel combo_kategori = new JLabel("Kategori :");
		        
				
				
				
		        panel.add(l_name).setBounds(20,310,150,20);
		        panel.add(name).setBounds(100,310,150,20);
		        
		        panel.add(l_purchaseprice).setBounds(20,340,150,20);
		        panel.add(purcPrice).setBounds(100,340,150,20);
		        
		        panel.add(l_sellPrice).setBounds(20,370,150,20);
		        panel.add(sellPrice).setBounds(100,370,150,20);
		      
		        panel.add(l_piece).setBounds(20,400,150,20);
		        panel.add(piece).setBounds(100,400,150,20);
		        
		        panel.add(combo_kategori).setBounds(20,430,150,20);
		        panel.add(category).setBounds(100,430,150,20);

		        
		        JComboBox combo = new JComboBox();
				DataBase_and_functions.comboboxUrun(combo);
		        
				
		        
		        panel.setBackground(Color.gray);  
		        panel2.setBackground(Color.red);
		        Icon icon = new ImageIcon("img/getir.png");
		        Icon icon_update = new ImageIcon("img/update.png");

				JButton send = new JButton(icon);
				JButton update_send = new JButton(icon_update);
				send.setBackground(Color.gray);
				JLabel l_updte = new JLabel("GUNCELLENECEK URUNUN SECÝN VE TIKLAYIN");
		       

				JTable jt=new JTable();    
				jt.setBounds(30,40,200,300);          
				JScrollPane sp=new JScrollPane(jt); 
				jt.setModel(DbUtils.resultSetToTableModel(DataBase_and_functions.Urunler()));
				jt.setEnabled(false);

				panel2.add(sp).setBounds(300, 0, 780, 540);
				
				f.add(panel);
				panel.add(l_updte).setBounds(0,50,300,50);
				
				panel.add(send).setBounds(130,250,48,48);
				panel.add(combo).setBounds(0,170,300,50);
				update_send.setBackground(Color.gray);
				panel.add(update_send).setBounds(130,460,64,64);
				//kateogori secme
				String ali = "asd";
				
				category.selectWithKeyChar(ali.charAt(0));
				
				f.add(panel2);
				
				
				
				send.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//al
						
						try {
							/*
							 * PRODUCT SINIFINDAN NESNE URETIP, IDSINE BAKIP GETIRILEN URUNU EKRANA YAZDIRIYORUZ.
							 */
							Product urun1 = DataBase_and_functions.BringProduct(Integer.parseInt((String)combo.getSelectedItem()));
							
							name.setText(urun1.getName());
							purcPrice.setText(String.valueOf(urun1.getPurchase_price()));
							sellPrice.setText(String.valueOf(urun1.getSale_price()));
							piece.setText(String.valueOf(urun1.getPiece()));
							
							category.selectWithKeyChar(urun1.getCategory().charAt(0));


						}catch(Exception e0) {
							JOptionPane.showMessageDialog(null,"id silinmiþ olabilir, kontrol edin.");

						}
						
						
					}
				});
				update_send.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						//gonder
						
						
						try {
							
							/*
							 * EKRANA YAZDIRDIGIMIZ URUNLERI, YENI GIRDILER ILE GUNCELLIYORUZ.
							 */
							
							DataBase_and_functions.Update(Integer.parseInt((String)combo.getSelectedItem()),name.getText(),Integer.parseInt(purcPrice.getText()),Integer.parseInt(sellPrice.getText()),Integer.parseInt(piece.getText()),String.valueOf(category.getSelectedItem()));
							
							
							JOptionPane.showMessageDialog(null,"Kayýt baþarýlý");
							jt.setModel(DbUtils.resultSetToTableModel(DataBase_and_functions.Urunler()));

							
						}catch(Exception e3) {
							JOptionPane.showMessageDialog(null,"Girdileri kontrol ediniz.");

						}
						
					}
						
				});
				f.setSize(1093,577);    
				f.setVisible(true);  
		        f.setResizable(false);

		
	}
}
