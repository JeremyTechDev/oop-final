package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logical.Component;
import Logical.HardDisk;
import Logical.Microprocessor;
import Logical.Motherboard;
import Logical.RamCard;
import Logical.Shop;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Products extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] row;
	private JTextField Serialtxt;

	public Products() {
		setTitle("Products");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 788, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 62, 756, 362);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		setLocationRelativeTo(null);

		model = new DefaultTableModel();
		String[] headers = { "Serial Number", "Product Type", "Provider", "Price", "Quantity Available" };
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		Serialtxt = new JTextField();
		Serialtxt.setBounds(115, 22, 150, 25);
		contentPanel.add(Serialtxt);
		Serialtxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Serial Number:");
		lblNewLabel.setBounds(20, 25, 85, 19);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadTable(true);
	}
	//LoadProduct table
	public void loadTable(boolean finder) {
		model.setRowCount(0);
		row = new Object[(model.getColumnCount())];
		if(finder) {
		for (Component i: Shop.getInstance().getComponents()) {
			if(i.getSerialNumber().equalsIgnoreCase(Serialtxt.getText()));
			row[0] = i.getSerialNumber();
			if(i instanceof HardDisk) {
				row[1]= ((HardDisk)i).getBrand()+"-"+((HardDisk)i).getModel()+"-"+((HardDisk)i).getCapacity()+"-"+((HardDisk)i).getConnectionType();
			}else {
				if(i instanceof Motherboard) {
					row[1]= ((Motherboard)i).getBrand()+"-"+((Motherboard)i).getModel()+"-"+((Motherboard)i).getConnectorType();
				}else {
					if(i instanceof RamCard) {
						row[1]=((RamCard)i).getBrand()+"-"+((RamCard)i).getCapacity()+"-"+((RamCard)i).getCapacity();
					}else {
						if(i instanceof Microprocessor) {
							row[1]=((Microprocessor)i).getBrand()+"-"+((Microprocessor)i).getModel()+"-"+((Microprocessor)i).getConnectorType()+"-"+((Microprocessor)i).getSpeed();
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
