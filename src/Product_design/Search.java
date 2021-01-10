package Product_design;

import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import Functions_and_database.DataBase_and_functions;


public class Search {
	public Search() {
		JFrame jframe = new JFrame("Uygulama Ýçi Arama");
		jframe.setLayout(null);
		
		
		
		JTextField search  = new JTextField();
	    JTable table=new JTable();    
	    Icon icon = new ImageIcon("img/arama.png");
	    JLabel arama_simge = new JLabel(icon);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		
		
		panel2.add(arama_simge).setBounds(235,0,16,16);
		panel2.add(search).setBounds(255,0,150,20);
		panel1.setBounds(0,0,300,40);    
	    panel2.setBounds(0,40,600,500);
	    panel1.setLayout(null);
	    panel2.setLayout(null);
	    
	    
	    JComboBox combo = new JComboBox();
	    combo.setModel(new DefaultComboBoxModel(new String[]{
	    		"isim","kategori","satisFiyat"
	    }));
	    
	    
	    JTable jt=new JTable();    
		jt.setBounds(30,40,200,300);          
		JScrollPane sp=new JScrollPane(jt); 
		
		jt.setEnabled(false);

		panel2.add(sp).setBounds(0, 200, 600, 300);
		
	    
	    
	    
	    
	    
	    
	    //panel1.setBackground(Color.gray);  
	    panel2.setBackground(Color.white);
	    panel2.add(combo).setBounds(150,50,320,50);
	    jframe.add(panel1);
	    jframe.add(panel2);
	    
	   
	    
	    
	    
	    search.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("aktif");

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stubz
				
				/*
				 * HER GIRDIDE TEKRAR CALISMASI ICIN KEYRELEASED EVENT KULLANILDI.
				 * SUREKLI HER HARF GIRILDIGINDE TEKRAR CALISACAK ARAMA FONKSIYONU
				 */
				
				DataBase_and_functions.Search(jt,search,combo,panel2);

			    
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
		//panel2.add(scrollPane);
		jframe.setSize(616,560);
		jframe.setVisible(true);
		jframe.setResizable(false);

		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
