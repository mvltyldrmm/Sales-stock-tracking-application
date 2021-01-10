package Personel_design;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Classes.Person;
import Functions_and_database.DataBase_and_functions;

public class Person_add {
	public Person_add() {
		JFrame giris= new JFrame("Personel Ekle");  
		giris.getContentPane().setLayout(null);

		JLabel l_name = new JLabel("AD :");
		JLabel l_surname = new JLabel("SOYAD :");
		JLabel l_gmail = new JLabel("MAIL :");
		JLabel l_password = new JLabel("SIFRE :");
		
		JTextField name = new JTextField();
		JTextField surname = new JTextField();
		JTextField gmail = new JTextField();
		JTextField password = new JTextField();
		Icon icon = new ImageIcon("img/personelekle.png");
        
		JButton gonder = new JButton(icon);
		giris.getContentPane().setBackground(Color.gray);
		giris.getContentPane().add(l_name).setBounds(40,50,50,20);
		giris.getContentPane().add(name).setBounds(100,50,80,20);
		giris.getContentPane().add(l_surname).setBounds(40,100,50,20);
		giris.getContentPane().add(surname).setBounds(100,100,80,20);
		giris.getContentPane().add(l_gmail).setBounds(40,150,50,20);
		giris.getContentPane().add(gmail).setBounds(100,150,80,20);
		giris.getContentPane().add(l_password).setBounds(40,200,50,20);
		giris.getContentPane().add(password).setBounds(100,200,80,20);
		giris.getContentPane().add(gonder).setBounds(100,250,95,95);;

		gonder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String personelName = name.getText();
				String personelSurname = surname.getText();
				String personelGmail = gmail.getText();
				String personelPassword = password.getText();

				Person person1 = new Person(personelName, personelSurname, personelGmail, personelPassword);
				//ALINAN GIRDILER ILE, PERSON SINIFINDAN OBJE URETILIP PERSONEL KAYDET FONKSIYONU CALISIYOR.
				//PERSONELKAYDET() FONKSIYONU STRING DEGER DONDUGU ICIN DIREK JOPTIONPANE OLARAK YAZDIRIYORUZ.
				
				JOptionPane.showMessageDialog(null,DataBase_and_functions.personelKaydet(person1));
				giris.setVisible(false); 
				
				
			}
		});
		
		giris.setSize(400,400);    
        giris.setLayout(null);    
        giris.setVisible(true);    
        giris.setResizable(false);
	}
}
