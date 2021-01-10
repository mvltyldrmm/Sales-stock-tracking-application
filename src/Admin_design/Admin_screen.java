package Admin_design;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
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

import Personel_design.Person_add;
import Personel_design.Person_delete;
import Product_design.Product_increase;
import Product_design.Search;
import Product_design.Sales_archives;
import Product_design.Stock;
import Product_design.Product_add;
import Product_design.Product_update;
import Product_design.Product_delete;

public class Admin_screen {
	public Admin_screen() {
		
		/*
		 * BU EKRAN ADMIN EKRANIDIR. RENKLER,SETBOUNDS AYARLAMALARI YAPILMISTIR.
		 */
		JFrame frame= new JFrame("Admin Ekraný");    
        JPanel panel=new JPanel(); 
        JPanel panel2 = new JPanel();
        panel.setLayout(null);
        panel2.setLayout(null);
        
        
        
        
        Icon icon_person_add = new ImageIcon("img/personel_ekle.png");
        Icon icon_person_delete = new ImageIcon("img/personel_sil.png");
        Icon icon_product_add = new ImageIcon("img/urun_ekle_icon.png");
        Icon icon_product_delete = new ImageIcon("img/urun_sil_icon.png");
        Icon icon_archive = new ImageIcon("img/arsiv_icon.png");
        Icon icon_update = new ImageIcon("img/updatesmall.png");
        Icon icon_stok = new ImageIcon("img/stok.png");

        
        JLabel icon = new JLabel();
        JLabel admin_welcome = new JLabel();
        JLabel person_add = new JLabel(icon_person_add);
        JLabel product_add = new JLabel(icon_product_add);
        JLabel product_delete = new JLabel(icon_product_delete);
        JLabel person_delete = new JLabel(icon_person_delete);
        JLabel archive = new JLabel(icon_archive);
        JLabel update = new JLabel(icon_update);
        JLabel l_stok = new JLabel(icon_stok);

        
        
        JButton prsn_add = new JButton("Personel Ekle");
        JButton prsn_delete = new JButton("Personel Sil");
        JButton prdct_add = new JButton("Ürün Ekle");
        JButton prdct_delete = new JButton("Ürün Sil");
        JButton Stok = new JButton("Satýþ Arþivi");
        JButton prdct_increase = new JButton("Ürün Güncelle");
        JButton Stok2 = new JButton("Stok");
        JButton person_operation = new JButton("Uye iþlemleri için týklayýn");
        

        admin_welcome.setText("ADMÝN :ONLINE");
        admin_welcome.setForeground(Color.green);

        
        
        panel2.add(admin_welcome).setBounds(400,10,100,20);
        panel2.add(person_operation).setBounds(350,240,200,20);
        panel2.add(icon).setBounds(320,30,600,200);
        panel2.setBackground(new Color(8,13,99));
        panel2.setBounds(200,0,1000,1000);
        
        
        panel.setBounds(0,0,300,1000);    
        panel.add(person_delete).setBounds(10,170,25,25);
        panel.add(person_add).setBounds(10,90,25,25);
        panel.add(prsn_add).setBounds(50,80,200,40);
        panel.add(prsn_delete).setBounds(50,160,200,40);
        panel.add(Stok).setBounds(50,240,200,40);
        panel.add(archive).setBounds(10,245,25,25);
        panel.add(Stok2).setBounds(50,320,200,40);
        panel.add(l_stok).setBounds(10,328,25,25);
        panel.setBackground(Color.gray);  

        

        icon.setIcon(new ImageIcon("img/admin.png"));
        
        
        prsn_add.setForeground(Color.white);
        prsn_add.setBackground(Color.black);
        prsn_delete.setForeground(Color.white);
        prsn_delete.setBackground(Color.black);
        
        prdct_add.setForeground(Color.white);
        prdct_add.setBackground(Color.black);
        

        prdct_delete.setForeground(Color.white);
        prdct_delete.setBackground(Color.black);
        
        Stok.setForeground(Color.white);
        Stok.setBackground(Color.black);
        
        prdct_increase.setForeground(Color.white);
        prdct_increase.setBackground(Color.black);
        
        Stok2.setForeground(Color.white);
        Stok2.setBackground(Color.black);
        
        
        JMenuBar mb=new JMenuBar();  
		JMenu menu=new JMenu("Gelistirici"); 
		JMenu menu2=new JMenu("Uygulama içi Arama"); 
		JMenuItem i1=new JMenuItem("Versiyon : 1.0");  
		JMenuItem i2=new JMenuItem("YILDIRIM software");  
		JMenuItem menu_search=new JMenuItem("ARA");
		
        menu.add(i1);menu.add(i2);
        
		menu2.add(menu_search);
		mb.add(menu2);
        mb.setBackground(Color.black);
        menu2.setForeground(Color.white);
        menu.setForeground(Color.white);
        mb.add(menu);
		frame.setJMenuBar(mb);
		
		/*
		 * 
		 * ASAGIDAKI TUM BUTONLAR ADMIN SAYFASINDAN BASKA SAYFALARA GECIS ICIN KULLANILMISTIR.
		 */
		
		Stok2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Stock();
				
			}
		});
		
        prsn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Person_add();

				
			}
		});
        
        person_operation.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//ADMIN PERSONEL ISLERI YAPMAK ISTEDIGINDE BUTONA TIKLAYARAK PERSONEL OZELLIKLERI GELMEKTEDIR.
				
				
		        panel2.add(prdct_add).setBounds(230,280,200,40);
		        panel2.add(product_add).setBounds(140,280,100,40);
		        
		        //
		        
		        panel2.add(product_delete).setBounds(510,288,25,25);
		        panel2.add(prdct_delete).setBounds(550,280,200,40);
		        //
		        panel2.add(prdct_increase).setBounds(390,350,200,40);
		        panel2.add(update).setBounds(355,360,30,30);
		        


				
			}
		});
        
        menu_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Search();
				
			}
		});
        prsn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Person_delete();
				
			}
		});
        prdct_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_add();
				
			}
		});
        prdct_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_delete();
				
			}
		});
        Stok.addActionListener(new ActionListener() {
	 
			@Override
			public void actionPerformed(ActionEvent e) {
				new Sales_archives();
				
			}
		});
        
        prdct_increase.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_update();
				
			}
		});


        frame.add(panel);  
        frame.add(panel2);
        frame.setSize(1000,500);    
        frame.setLayout(null);    
        frame.setVisible(true);    
        frame.setResizable(false);
	}
}
