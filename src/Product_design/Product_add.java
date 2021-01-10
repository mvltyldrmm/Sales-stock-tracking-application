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
import javax.swing.JTextField;

import Classes.Product;
import Functions_and_database.DataBase_and_functions;

public class Product_add {
	public Product_add() {
		JFrame giris = new JFrame("Urun Ekle :");
		JLabel l_name = new JLabel("Urun ismi :");
		JLabel l_category = new JLabel("Kategori :");
		JLabel l_purchasePrice = new JLabel("Gelis Fiyati :");
		JLabel l_sellPrice = new JLabel("Satis Fiyati :");
		JLabel l_date1 = new JLabel("Gelis Tarihi :");
		JLabel l_piece = new JLabel("Adet Sayisi  :");

		JTextField name = new JTextField();
		JTextField purcPrice = new JTextField();
		JTextField sellPrice = new JTextField();
		JTextField gelisTarih = new JTextField();
		JTextField piece = new JTextField();

		Icon icon = new ImageIcon("img/onay (1).png");
        
		JButton send = new JButton(icon);
		
		
		//COMBOBOX ÝLE KATEGORILERI SABIT, KULLANICININ SECMESINI ISTIYORUZ.
		
		
		String country[]={"Orkide","Tek Gül","Cenaze","Yýlbaþý","Sevgililer Günü","Karýþýk buket"
				,"Doðum günü"};        
	    JComboBox cb=new JComboBox(country);    
	    //cb.setBounds(150, 50,90,20);   
	    giris.getContentPane().setBackground(Color.gray);
		giris.getContentPane().add(l_name).setBounds(40,50,100,20);
		giris.getContentPane().add(name).setBounds(120,50,80,20);
		giris.getContentPane().add(l_category).setBounds(40,100,100,20);
		giris.getContentPane().add(cb).setBounds(120,100,80,20);
		giris.getContentPane().add(l_purchasePrice).setBounds(40,150,100,20);
		giris.getContentPane().add(purcPrice).setBounds(120,150,80,20);
		giris.getContentPane().add(l_sellPrice).setBounds(40,200,100,20);
		giris.getContentPane().add(sellPrice).setBounds(120,200,80,20);
		giris.getContentPane().add(l_piece).setBounds(40,250,100,20);
		giris.getContentPane().add(piece).setBounds(120,250,80,20);
		
		giris.getContentPane().add(send).setBounds(120,280,50,50);;

		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Product urun1 = new Product(name.getText(), cb.getSelectedItem().toString(), Integer.parseInt(purcPrice.getText()), Integer.parseInt(sellPrice.getText()), Integer.parseInt(piece.getText()));
					JOptionPane.showMessageDialog(null,DataBase_and_functions.UrunKaydet(urun1));
					giris.setVisible(false);
					/*
					 * GIRDILER ILE PRODUCT SINIFINDAN BIR NESNE URETIYORUZ. URUN KAYDETME FONKSIYONUMUZA GONDERIYORUZ.
					 */
				
				}
				catch(Exception e22) {
					JOptionPane.showMessageDialog(null,"Girdileri kontrol edin.");

				}
					

				
				
				
				
			}
		});
		
		giris.setSize(400,400);    
	    giris.setLayout(null);    
	    giris.setVisible(true);    
	    giris.setResizable(false);
	}
}
