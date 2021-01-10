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

import Functions_and_database.DataBase_and_functions;
import net.proteanit.sql.DbUtils;

public class Product_sell {
	public Product_sell(String string) {
		
				JPanel panel=new JPanel(); 
		        JPanel panel2 = new JPanel();
		        
		        
		        panel.setBounds(0,0,300,1000);    
		        panel2.setBounds(300,0,1000,1000);
		        panel.setLayout(null);
		        panel2.setLayout(null);
		        
		        
		        JComboBox combo = new JComboBox();
		        DataBase_and_functions.comboboxUrun(combo);
		        
		        
		        panel.setBackground(Color.gray);  
		        panel2.setBackground(Color.red);
		        
		        Icon icon = new ImageIcon("img/sell.png");
		        
				JButton send = new JButton(icon);
				JLabel l_delete = new JLabel("SATILAN URUNUN BARKOD NUMARASINI SEÇÝN VE DELETE BUTONUNA TIKLAYIN..");
				JFrame f= new JFrame("Ürün Sat");  
				
				JTable jt=new JTable();    
				jt.setBounds(30,40,200,300);          
				JScrollPane sp=new JScrollPane(jt); 
				jt.setModel(DbUtils.resultSetToTableModel(DataBase_and_functions.Urunler()));
				jt.setEnabled(false);

				panel2.add(sp).setBounds(300, 0, 780, 540);
				
				f.add(panel);
				panel.add(l_delete).setBounds(0,50,300,50);
				panel.add(send).setBounds(130,250,50,50);
				panel.add(combo).setBounds(0,170,300,50);;
				f.add(panel2);
				
				send.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							DataBase_and_functions.Satis(Integer.parseInt(combo.getSelectedItem().toString()));
							
							DataBase_and_functions.SatisKaydet(DataBase_and_functions.satisArsiv(Integer.parseInt(combo.getSelectedItem().toString()),string));
							
							jt.setModel(DbUtils.resultSetToTableModel(DataBase_and_functions.SatisArsivleri()));
									
							JOptionPane.showMessageDialog(null,"Urun Basariyla Silindi..");
							
							/*
							 * URUN SILINIRKEN AYNI ANDA 3 FONKSIYON CALISIYOR.
							 * BIRINCI SATILAN URUNU AZALTIYOR. IKINCI ARSIVE KAYIT EDIYOR. UCUNCU TABLOYU GETIRIYOR.
							 */

							f.setVisible(false);
						}catch (Exception exception) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null,"Urun Silinemedi. Barkod numarasýný kontrol edin..");

						}
						
						
					}
				});
				f.setSize(1093,577);    
				f.setVisible(true);   
		        f.setResizable(false);

	}
}

