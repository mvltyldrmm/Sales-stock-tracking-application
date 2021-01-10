package Personel_design;

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

import Functions_and_database.DataBase_and_functions;
import net.proteanit.sql.DbUtils;

public class Person_delete {
	public Person_delete() {
		JPanel panel=new JPanel(); 
        JPanel panel2 = new JPanel();
        panel.setBounds(0,0,300,1000);    
        panel2.setBounds(300,0,1000,1000);
        panel.setLayout(null);
        panel2.setLayout(null);

        panel.setBackground(Color.gray);  
        panel2.setBackground(Color.red);
        Icon icon = new ImageIcon("img/delete.jpg");
        JComboBox combo = new JComboBox();
        
        /*
         *  COMBOBOXA YAZDIGIMIZ FONSKIYON SAYESINDE BULUNAL PERSONELLERIN IDLERI GELIYOR.
         */
        
        
        
		DataBase_and_functions.comboboxPersonel(combo);

		JButton gonder = new JButton(icon);
		JLabel l_sil = new JLabel("SILINECEK PERSONELIN ID'SINI SECIN.");
		JTextField sil = new JTextField();
		JFrame f= new JFrame("Personel Sil");    
		         
		JTable jt=new JTable();
		jt.setBounds(30,40,200,300); 
		jt.setModel(DbUtils.resultSetToTableModel(DataBase_and_functions.Personeller()));

		JScrollPane sp=new JScrollPane(jt); 
		panel2.add(sp).setBounds(300, 0, 780, 540);
		
		f.add(panel);
		panel.add(l_sil).setBounds(0,50,300,50);
		panel.add(gonder).setBounds(130,250,50,50);
		panel.add(combo).setBounds(0,170,300,50);
		f.add(panel2);
		
		gonder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//ID'LERI SILIP KULLANICIYI SILIYORUZ.
					JOptionPane.showMessageDialog(null,DataBase_and_functions.PersonelSil(Integer.parseInt(combo.getSelectedItem().toString())));
				
					jt.setModel(DbUtils.resultSetToTableModel(DataBase_and_functions.Personeller()));

					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Barkod Numarasý Integer olmalý");

				}
				
				
			}
		});
		
		f.setSize(1093,577);    
		f.setVisible(true);   
        f.setResizable(false);

	}
}
