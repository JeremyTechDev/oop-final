package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logical.Component;
import Logical.HardDisk;
import Logical.Microprocessor;
import Logical.Motherboard;
import Logical.RamCard;
import Logical.Shop;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class StockProducts extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private JTextField Serialtxt;

	public StockProducts() {
		setTitle("Products In Stock");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 890, 595);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 70, 850, 441);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		model = new DefaultTableModel();
		String[] headers = { "Product Code", "Product Type", "Provider", "Price", "Quantity Available" };
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Find Products:");
		lblNewLabel.setBounds(29, 22, 113, 25);
		contentPanel.add(lblNewLabel);
		
		Serialtxt = new JTextField();
		Serialtxt.setBounds(130, 22, 140, 25);
		contentPanel.add(Serialtxt);
		Serialtxt.setColumns(10);
		setLocationRelativeTo(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("Close");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		loadTable(true);
	}
	
	public void loadTable(boolean finder) {
		model.setRowCount(0);
		row = new Object[(model.getColumnCount())];
		if(finder) {
		for (Component i: Shop.getInstance().getComponents()) {
			if(i.getSerialNumber().equalsIgnoreCase(Serialtxt.getText()));
			row[0] = i.getSerialNumber();
			if(i instanceof HardDisk) {
				row[1]= "HardDisk " +((HardDisk)i).getBrand()+" - "+((HardDisk)i).getModel()+" - "+((HardDisk)i).getCapacity()+" - "+((HardDisk)i).getConnectionType();
			}else {
				if(i instanceof Motherboard) {
					row[1]= "MotherBoard " +((Motherboard)i).getBrand()+" - "+((Motherboard)i).getModel()+" - "+((Motherboard)i).getConnectorType();
				}else {
					if(i instanceof RamCard) {
						row[1]= "RamCard " +((RamCard)i).getBrand()+" - "+((RamCard)i).getCapacity()+" - "+((RamCard)i).getType();
					}else {
						if(i instanceof Microprocessor) {
							row[1]= "MicroProcessor " +((Microprocessor)i).getBrand()+" - "+((Microprocessor)i).getModel()+" - "+((Microprocessor)i).getConnectorType()+" - "+((Microprocessor)i).getSpeed();
						}
				}
			}
			row[2] = i.getProvider().getName();
			row[3] = i.getPrice();
			row[4] = i.getQuantity().toString();

			model.addRow(row);
		}
	}
}
	}
}
