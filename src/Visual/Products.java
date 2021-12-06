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
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Products extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	public static String productcode = null;
	private static boolean productstatus = false;
	private static Object[] row;
	private JTextField Serialtxt;
	private JSpinner SpnQuantity;
	private JButton AddToCartbtn;
	
	Component showDialog() {
		setVisible(true);
		Component product = null;
		if(productcode !=null) {
			product = Shop.getInstance().loadCart(productcode);
			product.setQuantity((int) SpnQuantity.getValue());
		}
		return product;
	}

	public Products(boolean condition) {
		
		productstatus = condition;
		
		setTitle("Products");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 788, 563);
		setLocationRelativeTo(null);
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int select = -1;
				select = table.getSelectedRow();
				productcode = table.getValueAt(select, 0).toString();
				
				if(Shop.getInstance().getComponentBySerial(productcode).getQuantity()==0 && productstatus==true) {
					AddToCartbtn.setEnabled(false);
				}else {
					AddToCartbtn.setEnabled(true);
				}
				Add();
			}
		});
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		setLocationRelativeTo(null);

		model = new DefaultTableModel();
		String[] headers = { "Product Code", "Product Type", "Provider", "Price", "Quantity Available" };
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Quantity:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(537, 444, 85, 24);
		contentPanel.add(lblNewLabel_1);
		
		SpnQuantity = new JSpinner();
		SpnQuantity.setEnabled(false);
		SpnQuantity.setBounds(610, 445, 144, 24);
		contentPanel.add(SpnQuantity);
		
		JButton Findbtn = new JButton("Find");
		Findbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Shop.getInstance().VerifyProduct(Serialtxt.getText())) {
					loadTable(true);
					}else {
						AddToCartbtn.setEnabled(false);
						JOptionPane.showMessageDialog(null, "Error: The code '"+Serialtxt.getText()+" was not found.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
		Findbtn.setBounds(275, 24, 85, 21);
		contentPanel.add(Findbtn);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				AddToCartbtn = new JButton("Add to Cart");
				AddToCartbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				AddToCartbtn.setActionCommand("OK");
				buttonPane.add(AddToCartbtn);
				getRootPane().setDefaultButton(AddToCartbtn);
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
				row[1]= "HardDisk " +((HardDisk)i).getBrand()+"-"+((HardDisk)i).getModel()+"-"+((HardDisk)i).getCapacity()+"-"+((HardDisk)i).getConnectionType();
			}else {
				if(i instanceof Motherboard) {
					row[1]= "MotherBoard " +((Motherboard)i).getBrand()+"-"+((Motherboard)i).getModel()+"-"+((Motherboard)i).getConnectorType();
				}else {
					if(i instanceof RamCard) {
						row[1]= "RamCard " +((RamCard)i).getBrand()+"-"+((RamCard)i).getCapacity()+"-"+((RamCard)i).getType();
					}else {
						if(i instanceof Microprocessor) {
							row[1]= "MicroProcessor " +((Microprocessor)i).getBrand()+"-"+((Microprocessor)i).getModel()+"-"+((Microprocessor)i).getConnectorType()+"-"+((Microprocessor)i).getSpeed();
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
	
	private void Add() {
		// TODO Auto-generated method stub
		if(productcode !=null) {
			SpnQuantity.setEnabled(true);
			if(productstatus) {
				if(Shop.getInstance().getComponentBySerial(productcode).getQuantity() > 0) {
				SpnQuantity.setModel(new SpinnerNumberModel(null, 1, Shop.getInstance().getComponentBySerial(productcode).getQuantity(), 1));
				}else {
					SpnQuantity.setModel(new SpinnerNumberModel(0, 0, 0,1));	
				}
			}
		}
		
	}
}

