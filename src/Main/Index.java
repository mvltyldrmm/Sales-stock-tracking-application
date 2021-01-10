package Main;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Admin_design.Admin_login;
import Functions_and_database.DataBase_and_functions;
import Personel_design.Person_login;

public class Index {
	
	
	public Index(){
		//ACILIS EKRANI, ARAYUZLERIN EKLENMESI
		JFrame jframe = new JFrame("Florist APP");
		JLabel label1 = new JLabel("HOSGELDINIZ. LUTFEN GIRIS YONTEMINI SECIN");
		label1.setForeground(Color.white);
		label1.setFont(new Font(Font.SERIF,Font.BOLD,16));

		JButton admin_jframe = new JButton("ADMIN GIRISI ICIN TIKLAYIN");
		JButton personel_jframe = new JButton("PERSONEL GIRISI ICIN TIKLAYIN");
		admin_jframe.setFont(new Font(Font.SERIF,Font.BOLD,16));
		personel_jframe.setFont(new Font(Font.SERIF,Font.BOLD,16));
        Icon index_icon = new ImageIcon("img/index.png");
        JLabel index_icounu = new JLabel(index_icon);
        
		//MENUBAR
		JMenuBar mb=new JMenuBar();  
		JMenu menu=new JMenu("Gelistirici"); 
		JMenuItem i1=new JMenuItem("Versiyon : 1.0");  
		JMenuItem i2=new JMenuItem("YILDIRIM software");
        menu.setForeground(Color.white);

		menu.add(i1);menu.add(i2);
		
        mb.setBackground(Color.black);
		mb.add(menu);
		
		Icon icon = new ImageIcon("img/adminicon.png");
        
		JLabel admin = new JLabel(icon);
		Icon icon2 = new ImageIcon("img/personel2.png");
        
		JLabel personel = new JLabel(icon2);
        
		jframe.setJMenuBar(mb);
		jframe.getContentPane().setLayout(null);
		jframe.getContentPane().setBackground(new Color(8,13,99));
		jframe.getContentPane().add(label1).setBounds(340,1,500,50);
		jframe.getContentPane().add(index_icounu).setBounds(440,50,128,128);
		jframe.getContentPane().add(admin).setBounds(200,148,100,100);
		jframe.getContentPane().add(admin_jframe).setBounds(100,250,300,50);
		jframe.getContentPane().add(personel).setBounds(700,148,100,100);
		jframe.getContentPane().add(personel_jframe).setBounds(600,250,300,50);
		
		
		//RENK AYARLAMASI
		personel_jframe.setBackground(Color.black);
		admin_jframe.setBackground(Color.black);
		personel_jframe.setForeground(Color.white);
		admin_jframe.setForeground(Color.white);

		
		
		
		admin_jframe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				

				new Admin_login();
				

			}
		});
		personel_jframe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Person_login();
			
			}
		});
		
		
		
		
		
		
		
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jframe.setSize(1000,500);
		jframe.setResizable(false);

		
	}
	
	
	public static void main(String[] args) {  
		
		new Index();
	    
	}  
}
