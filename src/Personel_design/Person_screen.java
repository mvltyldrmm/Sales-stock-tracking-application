package Personel_design;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Product_design.Product_increase;
import Product_design.Search;
import Product_design.Product_add;
import Product_design.Product_update;
import Product_design.Product_sell;
import Product_design.Product_delete;

public class Person_screen {
	public Person_screen(String string) {
		JFrame giris= new JFrame("Personel Ekraný"); 
		JPanel panel=new JPanel(); 
        JPanel panel2 = new JPanel();
        
        
        //IKI ADET PANEL OLUSTURULDU. FARKLI BUTONLAR FARKLI PANELLERDE BULUNACAK.
        
        
        panel.setLayout(null);
        panel2.setLayout(null);
        
        
        
        JButton productAdd = new JButton("Ürün Ekle");
        JButton productStockDelete = new JButton("Ürün Sil & Stok Göster");
        //JButton arsiv = new JButton("Arþiv");
        JButton increase_stock = new JButton("Adet Arttýrma");
        JButton productSell = new JButton("Ürün Sat");
        JButton product_update = new JButton("Ürün Güncelle");
        
        //ARAYUZLERIN EKLENMESI VE RENK AYARLAMALARI. ICON GUNCELLEMEK.
        
        Icon icon_prudct_add = new ImageIcon("img/urun_ekle_icon.png");
        Icon icon_product_delete = new ImageIcon("img/urun_sil_icon.png");
        Icon icon_product_sell = new ImageIcon("img/sell.png");
        //Icon icon_arsiv = new ImageIcon("img/arsiv_icon.png");
        Icon icon_add = new ImageIcon("img/adet_arttir.png");
        Icon product_update_icon2 = new ImageIcon("img/updatesmall.png");
        
        JLabel icon_urun_ekleme = new JLabel(icon_prudct_add);
        JLabel icon_urun_silme = new JLabel(icon_product_delete);
        JLabel icon_urun_satma = new JLabel(icon_product_sell);
        //JLabel icon_arsivi = new JLabel(icon_arsiv);
        JLabel icon_addi = new JLabel(icon_add);
        JLabel prodct_update_icon = new JLabel(product_update_icon2);
        
        productAdd.setForeground(Color.white);
        productAdd.setBackground(Color.black);
        
        productStockDelete.setForeground(Color.white);
        productStockDelete.setBackground(Color.black);
      
        increase_stock.setForeground(Color.white);
        increase_stock.setBackground(Color.black);
        
        productSell.setForeground(Color.white);
        productSell.setBackground(Color.black);
        
        product_update.setForeground(Color.white);
        product_update.setBackground(Color.black);
        
        
        JLabel admin_string = new JLabel();

        admin_string.setText(string+" :ONLINE");
        admin_string.setForeground(Color.green);
        panel2.add(admin_string).setBounds(400,120,200,20);

        panel.add(icon_urun_satma).setBounds(2,60,50,40);
        panel.add(productSell).setBounds(50,60,200,40);        
        
        panel.add(icon_urun_ekleme).setBounds(10,125,25,25);
        panel.add(productAdd).setBounds(50,120,200,40);
       
        panel.add(productStockDelete).setBounds(50,180,200,40);
        panel.add(icon_urun_silme).setBounds(8,185,25,25);
        //panel.add(icon_arsivi).setBounds(10,285,25,25);
        
        //panel.add(arsiv).setBounds(50,280,200,40);
        
        panel.add(icon_addi).setBounds(10,247,25,25);
        panel.add(increase_stock).setBounds(50,240,200,40);
        
        panel.add(prodct_update_icon).setBounds(10,308,32,32);
        panel.add(product_update).setBounds(50,300,200,40);
        
        
        
        
        Icon personel_iconu_ekle = new ImageIcon("img/person-icon.png");
        JLabel personel_icon = new JLabel(personel_iconu_ekle);
        panel2.add(personel_icon).setBounds(390,50,64,64);
        
        
        panel.setBounds(0,0,300,1000);    
        panel2.setBounds(200,0,1000,1000);
        panel.setBackground(Color.gray);  
        panel2.setBackground(new Color(8,13,99));
        
        
        
        JMenuBar mb=new JMenuBar();  
		JMenu menu=new JMenu("Gelistirici"); 
		JMenuItem i1=new JMenuItem("Versiyon : 1.0");  
		JMenuItem i2=new JMenuItem("YILDIRIM software");
		JMenu menu2=new JMenu("Uygulama içi Arama"); 
		JMenuItem search=new JMenuItem("ARA");
		menu2.add(search);

		mb.add(menu2);
        menu2.setForeground(Color.white);

		menu.add(i1);menu.add(i2);
		mb.setBackground(Color.black);
	    menu.setForeground(Color.white);
		mb.add(menu);
		giris.setJMenuBar(mb);
        
		//SAYFA GECISLERI
		
		
        productAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_add();
				
			}
		});
        
        product_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_update();
				
			}
		});
        
        search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Search();
				
			}
		});
        productStockDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_delete();
				
			}
		});
      
        productSell.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_sell(string);
				
			}
		});
        
        increase_stock.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_increase();
				
			}
		});
        
        
        giris.add(panel);  
        giris.add(panel2);
        giris.setSize(1000,500);    
	    giris.setLayout(null);    
	    giris.setVisible(true);    
	    giris.setResizable(false);
	}
}
