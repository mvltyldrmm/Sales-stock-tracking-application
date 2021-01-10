package Product_design;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import Functions_and_database.DataBase_and_functions;
import net.proteanit.sql.DbUtils;

public class Stock {
	
	public Stock() {
		JFrame jframe = new JFrame("Stok");
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		
		JTable jt=new JTable();    
		jt.setBounds(30,40,200,300);          
		JScrollPane sp=new JScrollPane(jt); 
		jt.setModel(DbUtils.resultSetToTableModel(DataBase_and_functions.Urunler()));
		
		
		
		/*
		 * STOCKDAKI URUNLERIN GETIRILMESI
		 */
		
		jt.setEnabled(false);
		
		
		panel.setBackground(Color.gray);
		panel2.add(sp).setBounds(300, 0, 700, 500);
		panel.setBounds(0,0,300,1000);    
        panel2.setBounds(300,0,1000,1000);
        panel.setLayout(null);
        panel2.setLayout(null);
        panel2.add(sp).setBounds(300, 0, 780, 540);
        
        jframe.add(panel);
		jframe.add(panel2);
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jframe.setSize(1093,577);
		jframe.setResizable(false);
	}

}
