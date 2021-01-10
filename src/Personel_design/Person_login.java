package Personel_design;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Functions_and_database.DataBase_and_functions;

public class Person_login {
	
	public Person_login() {
		JFrame jframe = new JFrame("Personel Girisi");
		jframe.getContentPane().setLayout(null);
		
		Icon login_icon = new ImageIcon("img/Login2.png");
		Icon icon = new ImageIcon("img/Login.png");

        JLabel login_icoun2 = new JLabel(login_icon);
		JLabel user_password = new JLabel("Sifre :");
		JLabel string = new JLabel("ADMINASTROR");
		JLabel user_name = new JLabel("Kullanici Maili :");

		JTextField u_name = new JTextField();
		JPasswordField password = new JPasswordField();   
		///buton tasarim
		JButton send = new JButton("GÝRÝÞ YAP",icon);	
		JCheckBox password_show =new  JCheckBox("Sifreyi Goster");
		
		send.setBorder(new LineBorder(Color.black));
		password_show.setFont(new Font(Font.SERIF,Font.BOLD,14));
		user_password.setFont(new Font(Font.SERIF,Font.BOLD,14));
		send.setFont(new Font(Font.SERIF,Font.BOLD,14));
		user_name.setFont(new Font(Font.SERIF,Font.BOLD,14));
		
		jframe.add(string).setBounds(500,20,120,20);;
		jframe.add(user_name).setBounds(100, 83, 371, 68);
		jframe.add(u_name).setBounds(200,107,100,20);
		jframe.add(user_password).setBounds(100,130,371,68);
		jframe.add(password).setBounds(200,150,100,20);
		jframe.add(password_show).setBounds(210,180,130,20);
		jframe.add(login_icoun2).setBounds(170,25,64,64);
		jframe.add(send).setBounds(100,250,200,70);

		//ARAYUZLERIN EKLENMESI

		password_show.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//PAROLA GOSTER KISMI.
				if(password_show.isSelected()) {
					password.setEchoChar((char) 0);
				}
				else {
					password.setEchoChar('*');
				}
				
			}
		});
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//EGER MAIL VE SIFRE DOGRUYSA PERSONEL EKRANINA GECIYORUZ.
				
				if(DataBase_and_functions.KullaniciVarmi(u_name.getText(), password.getText())) {
					//parola dogruysa
					
					JOptionPane.showMessageDialog(null,"Hosgeldiniz, "+ u_name.getText());
					jframe.setVisible(false);
					
					new Person_screen(u_name.getText());
					
				}
				
				else {
					//YANLIS ISE UYARI VERIYORUZ
					JOptionPane.showMessageDialog(null,"giris Bilgilerinizi kontrol edin");
				}

			}
		});
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jframe.setSize(400,400);
		jframe.setResizable(false);
	}
	

}
