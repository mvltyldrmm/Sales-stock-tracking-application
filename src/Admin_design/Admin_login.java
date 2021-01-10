package Admin_design;

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

public class Admin_login {
	
	public Admin_login() {
		
		//GEREKLI ARAYUZLERIN EKLENMESI.
		JFrame frame = new JFrame("Admin Giriþi");
		
		frame.getContentPane().setLayout(null);
		
		Icon icon = new ImageIcon("img/Login.png");
		Icon login_icons = new ImageIcon("img/Login2.png");

		
		JLabel administrator_text = new JLabel("ADMINISTRATOR");
		JLabel l_user_name = new JLabel("Kullanici Adi :");
		JLabel l_password = new JLabel("Sifre :");
        JLabel login_icon = new JLabel(login_icons);

        
		JTextField user_name = new JTextField();
		JPasswordField password = new JPasswordField(); 
		JCheckBox show_password = new JCheckBox("Þifreyi Göster");
		JButton send = new JButton("GÝRÝÞ YAP",icon);

		
		l_user_name.setFont(new Font(Font.SERIF,Font.BOLD,14));
		l_password.setFont(new Font(Font.SERIF,Font.BOLD,14));
		send.setFont(new Font(Font.SERIF,Font.BOLD,14));
		show_password.setFont(new Font(Font.SERIF,Font.BOLD,14));

		
		
		
		frame.add(administrator_text).setBounds(500,20,120,20);;
		frame.add(l_user_name).setBounds(100, 83, 371, 68);
		frame.add(user_name).setBounds(200,107,100,20);
		frame.add(l_password).setBounds(100,130,371,68);
		frame.add(password).setBounds(200,150,100,20);
		frame.add(show_password).setBounds(220,170,150,20);
		frame.add(login_icon).setBounds(170,25,64,64);

		frame.add(send).setBounds(100,250,200,70);
		
		
		
		
		
		
		show_password.addItemListener(new ItemListener() {
			//SIFRE GOSTERIN AKTIFLESTIRILMESI
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(show_password.isSelected()) {
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
				//ADMIN ICIN SIFRE STABILDIR. ADMIN VE ROOT ILE GIRIS YAPAR.
				String admin = "a";
				String sifre = "1";
				if(admin.equals(user_name.getText()) && sifre.equals(password.getText())) {
					
					new Admin_screen();
					
					frame.setVisible(false);
					JOptionPane.showMessageDialog(null,"Hosgeldiniz, ADMIN");
				}
				else {
					JOptionPane.showMessageDialog(null,"Giriþ Bilgilerinizi kontrol edin");
				}

			}
		});
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400,400);
		frame.setResizable(false);
	}
	

}
